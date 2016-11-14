package system.controller.admin;

import comm.bean.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import system.dto.HomeResourceDto;
import system.dto.RootResourceTreeDto;
import system.model.Resource;
import system.service.IResourceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：资源控制器
 */
@Controller
@RequestMapping("/admin/resource")
public class ResourceController {

    /**
     * 描述：资源service
     */
    @Autowired
    private IResourceService resourceService;

    /**
     * 描述：获取资源路径
     *
     * @param id 资源类唯一标识
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public AjaxResponse<Resource> getResource(@RequestParam(name = "id") String id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("resource", resourceService.get(id));
        map.put("list", resourceService.getRootResourceList());
        return new AjaxResponse<>(resourceService.get(id));
    }

    /**
     * 描述：跳转到资源新增页面
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAddResource(Model model) throws Exception {
        model.addAttribute("list", resourceService.getRootResourceList());
        return "page/system/admin/resources/add";
    }

    /**
     * 描述：保存资源类
     *
     * @param resource 资源对象
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResponse<Boolean> addResource(Resource resource) throws Exception {
        return new AjaxResponse<>(resourceService.save(resource));
    }

    /**
     * 描述：获取列表
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/gethomelist", method = RequestMethod.GET)
    public AjaxResponse<List<RootResourceTreeDto>> getHomeResourceList() throws Exception {
        return new AjaxResponse<>(resourceService.getRootResources());
    }

}
