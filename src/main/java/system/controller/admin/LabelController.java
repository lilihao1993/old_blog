package system.controller.admin;

import com.github.pagehelper.PageInfo;
import comm.bean.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Label;
import system.service.ILabelService;

import java.text.SimpleDateFormat;


/**
 * 描述：类别 控制器
 */
@Controller
@RequestMapping(value = "/admin/label")
public class LabelController {

    /**
     * 描述：service 注入
     */
    @Autowired
    private ILabelService labelService;


    /**
     * 描述：保存类别
     *
     * @param label 类别对象
     * @return
     * @throws Exception
     */
    @ResponseBody()
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResponse<Boolean> add(@ModelAttribute("label") Label label) throws Exception {
        boolean flag = labelService.save(label);
        return new AjaxResponse<>(flag);
    }


    /**
     * 描述：跳转到类别列表页
     *
     * @param pageNum  页数
     * @param pageSize 大小
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String getList(@RequestParam(name = "pageNum", required = true) Integer pageNum,
                          @RequestParam(name = "pageSize", required = true) Integer pageSize,
                          Model model) throws Exception {
        PageInfo<Label> pageInfo = labelService.getList(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "page/system/admin/label/list";
    }

    /**
     * 描述：分页获取列表
     *
     * @param pageNum  页数
     * @param pageSize 大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public AjaxResponse<PageInfo<Label>> page(@RequestParam(value = "pageNum", required = false) int pageNum,
                                              @RequestParam(value = "pageSize", required = false) int pageSize) throws Exception {
        PageInfo<Label> pageInfo = labelService.getList(pageNum, pageSize);
        return new AjaxResponse<>(pageInfo);
    }

    /**
     * 描述：删除类别
     *
     * @param id 类别唯一表示
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public AjaxResponse<Boolean> delete(@RequestParam(value = "id", required = true) String id) throws Exception {
        return new AjaxResponse<>(labelService.remove(id));
    }

    /**
     * 描述：跳转类别修改页
     *
     * @param id 类别唯一标识
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "toedit/{id}", method = RequestMethod.GET)
    public String toEdit(@PathVariable("id") String id, Model model) throws Exception {
        System.out.println("--" + id);
        Label label = labelService.getLabel(id);
        model.addAttribute("label", label);
        return "page/system/admin/label/add";
    }
}
