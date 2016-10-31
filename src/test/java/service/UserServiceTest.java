package service;

import comm.config.SpringTestAutowired;
import comm.util.EncryptUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import system.mapper.UserMapper;
import system.model.User;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/28.
 */
public class UserServiceTest extends SpringTestAutowired {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 描述：测试保存user
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setName("llh");
        user.setUserName("admin");
        user.setPassword("123456");
        user.setSex("1");
        user.setAddress("江西");
        user.setMail("18166043874@163.com");
        user.setCreateTime(new Date());
        user.setOperateTime(user.getCreateTime());
        EncryptUtils.encryptPassword(user);
        userMapper.insert(user);
        logger.info("插入成功");
    }
}
