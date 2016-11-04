package system.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import system.dto.HomeResourceDto;
import system.model.Resource;
import system.service.IResourceService;

import java.util.List;

/**
 * 描述：管理controller
 */
@Controller
@RequestMapping("/admin")
public class adminController {

    /**
     * 描述：注入资源service
     */
    @Autowired
    private IResourceService resourceService;

    /**
     * 描述：跳转后台主页
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/system")
    public String toSystem(Model model) throws Exception {
        List<HomeResourceDto> homeResourceDtos = resourceService.getHomeResources();
        model.addAttribute("homeResourceDtos", homeResourceDtos);
        return "page/system/client/system";
    }

}
