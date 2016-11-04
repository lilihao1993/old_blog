package system.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import system.dto.HomeResourceDto;
import system.model.Resource;

import java.util.List;

/**
 * 描述：资源类service接口
 */
public interface IResourceService {

    /**
     * 描述：保存资源
     *
     * @param resource 资源实体类
     * @return true：保存成功 false：保存失败
     * @throws Exception
     */
    boolean save(Resource resource) throws Exception;

    /**
     * 描述：分页获取资源列表
     *
     * @return 分页资源信息
     * @throws Exception
     */
    PageInfo<Resource> resourcePage(int pageNum, int pageSize) throws Exception;

    /**
     * 描述：获取资源列表
     *
     * @return 资源列表
     * @throws Exception
     */
    List<Resource> getResourceList() throws Exception;

    /**
     * 描述：获取跟资源列表
     *
     * @return 资源列表
     * @throws Exception
     */
    List<Resource> getRootResourceList() throws Exception;

    /**
     * 描述：根据id获取资源地址（注：只有底层资源才会获取地址）
     *
     * @param id 资源唯一标识
     * @return 资源对象
     * @throws Exception
     */
    Resource get(String id) throws Exception;

    /**
     * 描述：根据id删除资源
     *
     * @param id 资源唯一标识
     * @return
     * @throws Exception
     */
    boolean remove(String id) throws Exception;

    /**
     * 描述：修改资源
     *
     * @param resource 资源类
     * @return
     * @throws Exception
     */
    boolean modify(Resource resource) throws Exception;

    /**
     * 描述：获取主页资源列表
     *
     * @return 资源列表
     * @throws Exception
     */
    List<HomeResourceDto> getHomeResources() throws Exception;

}
