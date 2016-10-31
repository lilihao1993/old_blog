package system.service.impl;

import comm.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.mapper.UserMapper;
import system.model.User;
import system.model.UserExample;
import system.service.IUserService;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 描述:登录验证
     *
     * @return true:成功 false:失败
     * @throws Exception
     */
    @Override
    public boolean loginValidate(User user) throws Exception {
        //1.根据用户名找到用户
        boolean flag = false;
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userMapper.selectByExample(userExample);
        //2.若查找到个数大于0 则判断密码是否相等
        if (users.size() != 0) {
            flag = EncryptUtils.encryptPassword(user.getPassword(), users.get(0).getEncryptSalt()).equals(users.get(0).getPassword()) ? true : false;
        }
        return flag;
    }
}
