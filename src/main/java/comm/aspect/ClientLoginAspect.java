package comm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import system.controller.comm.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：客户端是否登录切面拦截
 */
@Aspect
@Component
public class ClientLoginAspect {

    //Controller层切点
    @Pointcut("@annotation(comm.aspect.ClientLogin)")
    public void controllerAspect() {
    }

    /**
     * 判断用户是否已经登录
     *
     * @throws Exception
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        System.out.println("-----------已进入---------");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request.getSession().getAttribute(Constant.USER_LOGIN) != null) {
            System.out.println("---------用户已登录-----------");
        }else {
         HttpServletResponse response =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            System.out.println("---------用户未登录进入登录页--------------------");
            request.getRequestDispatcher("/").forward(request, response);
        }

    }

}
