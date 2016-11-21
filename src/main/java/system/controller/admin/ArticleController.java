package system.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import system.model.Article;
import system.service.IArticleService;
import system.service.ILabelService;

/**
 * 描述：文章控制器
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    /**
     * 描述：文章service
     */
    @Autowired
    private IArticleService articleService;

    /**
     * 描述：类别service
     */
    @Autowired
    private ILabelService labelService;

    /**
     * 描述:跳转至文章列表页
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        return "page/system/admin/article/list";
    }

    /**
     * 描述：跳转至文章 新增或修改
     *
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toaddoredit")
    public String toAddOrEdit(@RequestParam(value = "id", required = false) String id, Model model) throws Exception {

        //1.获取类别列表，
        model.addAttribute("labels", labelService.getAll());

        //2.id不为空，获取其文章信息
        if (!StringUtils.isEmpty(id)) {
            model.addAttribute("article", articleService.get(id));
        }
        return "page/system/admin/article/article";
    }


    /**
     * 新增/保存文章
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addorEdit", method = RequestMethod.POST)
    public String addorEdit(Article article) throws Exception {
        articleService.saveOrModify(article);
        return "redirect:list";
    }


}
