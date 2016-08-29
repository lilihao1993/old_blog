package system.controller.client;

import com.alibaba.druid.support.json.JSONUtils;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system.model.User;
import system.service.IUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:管理员登录
 */
@Controller
@RequestMapping("/client")
public class LoginController {

    /**
     * 描述：注入
     */
    @Autowired
    private IUserService userService;

    /**
     * 描述：管理登录
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody()
    @RequestMapping("/login")
    public Map<String,String> login(User user)throws Exception{
        boolean flg = userService.loginValidate(user);
        Map<String,String> map = new HashMap();
        if(flg){
            map.put("error","0");
        }else{
            map.put("error","您的用户名或密码错误");
        }
        return map;
    }
}
