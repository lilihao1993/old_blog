package system.service;

import comm.config.SpringTestAutowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.model.User;


/**
 * 描述：测试用户service
 */
public class UserServiceTest extends SpringTestAutowired {

    @Autowired
    private IUserService userService;


    /**
     * 描述：获取用户测试
     *
     * @throws Exception
     */
    @Test
    public void testGetUser() throws Exception {
        User user = userService.getUser("486a0fbe690011e682adfcaa14e16be9");
        if (user != null) {
            System.out.println(user.getUsername() + "：" + user.getPassword());
        } else {
            System.out.println("获取用户失败");
        }
    }

    /**
     * 描述：插入一个用户
     *
     * @throws Exception
     */
    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("llh1993");
        boolean fig = userService.insertUser(user);
        System.out.println(fig ? "插入成功" : "插入失败");
    }

    /**
     * 描述：修改用户信息
     *
     * @throws Exception
     */
    @Test
    public void testModifyUser() throws Exception {
        User user = new User();
        user.setId("486a0fbe690011e682adfcaa14e16be9");
        user.setUsername("李斯");
        user.setPassword("llhWang");
        boolean flg = userService.modifyUser(user);
        System.out.println(flg ? "修改信息成功" : "修改失败");
    }

    /**
     * 描述：删除用户
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        boolean flg = userService.deleteUser("486a0fbe690011e682adfcaa14e16be9");
        System.out.println(flg ? "删除成功" : "删除失败");
    }

    /**
     * 描述：登录验证
     *
     * @throws Exception
     */
    @Test
    public void testValidate() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("llh1993");
        boolean flg = userService.loginValidate(user);
        System.out.println(flg ? "登录成功" : "登录失败");
    }

}
