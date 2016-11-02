package system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.mapper.LabelMapper;
import system.model.Label;
import system.model.LabelExample;
import system.service.ILabelService;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by Administrator on 2016/10/28.
 */
@Service
public class LabelServiceImpl implements ILabelService {

    @Autowired
    private LabelMapper labelMapper;

    /**
     * 描述：保存类别
     *
     * @param label 类别对象
     * @return true：保存成功 false：保存失败
     * @throws Exception
     */
    @Override
    public boolean save(Label label) throws Exception {
        boolean flag = true;
        label.setOperateTime(new Date());
        if (label.getId().isEmpty()) {
            label.setCreateTime(label.getOperateTime());
            flag = labelMapper.insert(label) > 0 ? true : false;
        } else {
            flag = labelMapper.updateByPrimaryKeySelective(label) > 0 ? true : false;
        }
        return flag;
    }

    /**
     * 描述：分页获取类别 列表
     *
     * @return 分页列表数据
     * @throws Exception
     */
    @Override
    public PageInfo<Label> getList(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        Page<Label> page = (Page<Label>) labelMapper.selectByExample(new LabelExample());
        return page.toPageInfo();
    }


    /**
     * 描述：删除类别
     *
     * @param id 类别唯一标识
     * @return true： 删除成功 false：删除失败
     * @throws Exception
     */
    @Override
    public boolean remove(String id) throws Exception {
        int flag = labelMapper.deleteByPrimaryKey(id);
        return flag > 0 ? true : false;
    }

    /**
     * 描述：获取类别
     *
     * @param id 类别唯一标识
     * @return 类别
     * @throws Exception
     */
    @Override
    public Label getLabel(String id) throws Exception {
        return labelMapper.selectByPrimaryKey(id);
    }
}
