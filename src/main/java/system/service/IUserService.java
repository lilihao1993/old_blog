package system.service;

import system.model.User;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface IUserService {

    /**
     * 描述：验证登录是否成功
     * @return true：成功  false：失败
     * @throws Exception
     */
    boolean loginValidate(User user)throws Exception;
}
