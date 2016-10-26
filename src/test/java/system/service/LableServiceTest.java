package system.service;

import comm.config.SpringTestAutowired;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.model.Label;
import system.model.LabelExample;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class LableServiceTest extends SpringTestAutowired{

    @Autowired
    private ILableService lableService;

    /**
     * 描述：分页获取类别列表
     * @throws Exception
     */
    @Test
    public void testGetLableList()throws Exception{
       List<Label> labelList = lableService.getLableList(new LabelExample());
        for (Label label:labelList) {
            System.out.println(label.toString());
        }
    }
}
