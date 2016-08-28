package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;
import system.mapper.UserMapper;
import system.model.User;
import system.service.IUserService;

/**
 * 描述：用户service
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    /**
     * 描述：根据id获取用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User getUser(String id) throws Exception {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 描述：插入一个用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean insertUser(User user) throws Exception {
        int flg = userMapper.insert(user);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：根据id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUser(String id) throws Exception {
        int flg = userMapper.deleteByPrimaryKey(id);
        return flg == 0 ? false : true;
    }

    /**
     * 描述： 修改用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean modifyUser(User user) throws Exception {
        int flg = userMapper.updateByPrimaryKey(user);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：用户名密码验证
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean loginValidate(User user) throws Exception {
        User result = userDao.getUser(user);
        return result != null ? true : false;
    }


}
