package system.controller.client;

import com.alibaba.druid.support.json.JSONUtils;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import system.controller.comm.Constant;
import system.model.User;
import system.service.IUserService;

import javax.servlet.http.HttpServletRequest;
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
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody()
    @RequestMapping("/login")
    public Map<String, String> login(User user, HttpServletRequest request) throws Exception {
        boolean flg = userService.loginValidate(user);
        Map<String, String> map = new HashMap();
        if (flg) {
            map.put("error", "0");
            //添加session
            request.getSession().setAttribute(Constant.USER_LOGIN, user);
        } else {
            map.put("error", "您的用户名或密码错误");
        }
        return map;
    }

    /**
     * 描述：退出后台管理系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/singout")
    public ModelAndView singOut(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/index");
        //删除session
        request.getSession().removeAttribute(Constant.USER_LOGIN);
        return modelAndView;
    }
}
