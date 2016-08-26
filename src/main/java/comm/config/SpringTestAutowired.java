package comm.config;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 * 描述: 测试类注入支持 .<br>
 * @author lilihao
 * @date 2016年7月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml","classpath*:mybatis.xml" ,"classpath*:spring-mvc.xml"})
public class SpringTestAutowired{}

