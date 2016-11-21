package system.service;

import com.github.pagehelper.PageInfo;
import system.model.Label;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface ILabelService {

    /**
     * 描述：保存类别
     *
     * @param label 类别对象
     * @return true: 保存成功  false :保存失败
     * @throws Exception
     */
    boolean save(Label label) throws Exception;

    /**
     * 描述：分页获取列表
     *
     * @return 类别分页 数据
     * @throws Exception
     */
    PageInfo<Label> getList(int pageNum, int pageSize) throws Exception;

    /**
     * 描述：删除类别
     *
     * @param id 类别唯一标识
     * @return true：删除成功  false：删除失败
     * @throws Exception
     */
    boolean remove(String id) throws Exception;

    /**
     * 描述：获取类别
     *
     * @param id 类别唯一标识
     * @return 类别对象
     * @throws Exception
     */
    Label getLabel(String id) throws Exception;

    /**
     * 描述：获取所有类别
     *
     * @return
     * @throws Exception
     */
    List<Label> getAll() throws Exception;
}
