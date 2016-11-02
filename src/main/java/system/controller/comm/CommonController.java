package system.controller.comm;

import comm.aspect.ClientLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangxiao on 2016/8/24.
 */
@Controller
public class CommonController {

    @RequestMapping("/page/{path}/{file}")
    @ClientLogin
    public String page(@PathVariable("path") String path, @PathVariable("file") String file) throws Exception{
        return StringUtils.assemblyString("page/",path,"/",file);
    }


    @RequestMapping("/page/{path}/{path1}/{file}")
    @ClientLogin
    public String page(@PathVariable("path") String path,@PathVariable("path1") String path1, @PathVariable("file") String file) throws Exception{
        return StringUtils.assemblyString("page/",path,"/",path1,"/",file);
    }

    @RequestMapping("/page/{path}/{path1}/{path2}/{file}")
    @ClientLogin
    public String page(@PathVariable("path") String path,@PathVariable("path1") String path1,@PathVariable("path2") String path2, @PathVariable("file") String file) throws Exception{
        return StringUtils.assemblyString("page/",path,"/",path1,"/",path2,"/",file);
    }

}
