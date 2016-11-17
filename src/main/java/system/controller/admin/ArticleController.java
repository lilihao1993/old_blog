package system.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.service.IArticleService;

/**
 * 描述：文章控制器
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;


    /**
     * 描述:跳转至文章列表页
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        return "page/system/admin/article/article";
    }


}
