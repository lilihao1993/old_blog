package system.controller.admin;

import comm.bean.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import system.model.Resource;
import system.service.IResourceService;

import java.util.List;

/**
 * 描述：资源控制器
 */
@Controller
@RequestMapping("/admin")
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
    @RequestMapping(value = "/getresource", method = RequestMethod.GET)
    public AjaxResponse<Resource> getResource(@RequestParam(name = "id") String id) throws Exception {
        return new AjaxResponse<>(resourceService.get(id));
    }


    /**
     * 描述：保存资源类
     *
     * @param resource 资源对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addresource", method = RequestMethod.POST)
    public AjaxResponse<Boolean> addResource(Resource resource) throws Exception {
        return new AjaxResponse<>(resourceService.save(resource));
    }



}
