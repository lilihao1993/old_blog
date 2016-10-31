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
     * @return true: 保存成功  false :保存失败
     * @throws Exception
     */
    boolean save(String name) throws Exception;


    /**
     * 描述：分页获取列表
     *
     * @return 类别分页 数据
     * @throws Exception
     */
    PageInfo<Label> getList(int pageNum, int pageSize) throws Exception;
}
