package service;

import comm.config.SpringTestAutowired;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import system.dto.HomeResourceDto;
import system.mapper.ResourceMapper;

import java.util.List;

/**
 * 描述：资源测试类
 */
public class ResourceTest extends SpringTestAutowired {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ResourceTest.class);


    /**
     * 描述：注入
     */
    @Autowired
    private ResourceMapper resourceMapper;


    /**
     * 描述：获取主页资源列表测试
     *
     * @throws Exception
     */
    @Test
    public void TestResourceMapper() throws Exception {
        List<HomeResourceDto> homeResourceDtos = resourceMapper.selectHomeResources();
        for (HomeResourceDto homeResource:homeResourceDtos) {
            logger.info(homeResource.getRootName());
            logger.info(homeResource.getList().toString());
        }

    }
}
