package system.service;

import system.model.User;

/**
 * 描述：用户service
 */
public interface IUserService {

    /**
     * 描述：根据id获取用户
     *
     * @return
     * @throws Exception
     */
    User getUser(String id) throws Exception;

    /**
     * 描述：插入一个用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    boolean insertUser(User user) throws Exception;

    /**
     * 描述：根据id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUser(String id) throws Exception;

    /**
     * 描述：修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    boolean modifyUser(User user) throws Exception;

    /**
     * 描述：用户名密码验证
     * @param user
     * @return
     * @throws Exception
     */
    boolean loginValidate(User user) throws Exception;
}
