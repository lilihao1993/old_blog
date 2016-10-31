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
     * @param name 类别名称
     * @return true：保存成功 false：保存失败
     * @throws Exception
     */
    @Override
    public boolean save(String name) throws Exception {
        Label label = new Label();
        label.setName(name);
        label.setCreateTime(new Date());
        label.setOperateTime(label.getCreateTime());
        return labelMapper.insert(label) > 0 ? true : false;
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
}
