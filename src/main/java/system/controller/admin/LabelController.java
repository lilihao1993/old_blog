package system.controller.admin;

import com.github.pagehelper.PageInfo;
import comm.bean.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.Label;
import system.service.ILabelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param name 类别名称
     * @return
     * @throws Exception
     */
    @ResponseBody()
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResponse<Boolean> add(String name) throws Exception {
        boolean flag = labelService.save(name);
        return new AjaxResponse<>(flag);
    }


    /**
     * 描述：获取分页列表
     *
     * @param pageNum  页数
     * @param pageSize 大小
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tolist", method = RequestMethod.GET)
    public String getList(@RequestParam(value = "pageNum", required = false) int pageNum,
                          @RequestParam(value = "pageSize", required = false) int pageSize,
                          Model model) throws Exception {
        PageInfo<Label> pageInfo = labelService.getList(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "page/system/admin/label/list";
    }
}
