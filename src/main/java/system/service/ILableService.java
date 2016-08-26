package system.service;


import system.model.Label;
import system.model.LabelExample;

import java.util.List;

/**
 * 描述：标签service
 */
public interface ILableService {

    /**
     * 描述：获取标签列表
     *
     * @return
     * @throws Exception
     */
    List<Label> getLableList(LabelExample labelExample) throws Exception;

    /**
     * 描述：插入标签
     *
     * @param label
     * @return
     * @throws Exception
     */
    boolean insertLable(Label label) throws Exception;

    /**
     * 描述：删除标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLable(String id) throws Exception;


    /**
     * 描述：修改标签
     *
     * @param label
     * @return
     * @throws Exception
     */
    boolean modifyLable(Label label) throws Exception;
}
