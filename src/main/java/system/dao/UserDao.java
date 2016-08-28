package system.dao;

import system.mapper.UserMapper;
import system.model.User;

/**
 * 描述：UserDao
 */
public interface UserDao extends UserMapper{
    /**
     * 描述：获取User
     * @return
     * @throws Exception
     */
     User getUser(User user) throws Exception;
}
