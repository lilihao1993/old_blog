package comm.aspect;


import java.lang.annotation.*;

/**
 * 描述：自定义客户端登录注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClientLogin {
    String description()  default "";
}
