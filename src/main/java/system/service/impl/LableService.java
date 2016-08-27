package system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.mapper.LabelMapper;
import system.model.Label;
import system.model.LabelExample;
import system.service.ILableService;

import java.util.List;

/**
 * 描述：标签service
 */
@Service
public class LableService implements ILableService {

    /**
     * 注入mapper
     */
    @Autowired
    private LabelMapper labelMapper;


    /**
     * 描述：获取标签列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Label> getLableList(LabelExample labelExample) throws Exception {
        List<Label> labels = labelMapper.selectByExample(labelExample);
        return labels;
    }

    /**
     * 描述：插入标签
     *
     * @param label
     * @return
     * @throws Exception
     */
    @Override
    public boolean insertLable(Label label) throws Exception {
        int flg = labelMapper.insert(label);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：删除标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteLable(String id) throws Exception {
        int flg = labelMapper.deleteByPrimaryKey(id);
        return flg == 0 ? false : true;
    }

    /**
     * 描述：修改标签
     *
     * @param label
     * @return
     * @throws Exception
     */
    @Override
    public boolean modifyLable(Label label) throws Exception {
        int flg = labelMapper.updateByPrimaryKey(label);
        return flg == 0 ? false : true;
    }
}
