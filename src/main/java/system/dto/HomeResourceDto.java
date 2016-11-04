package system.dto;

import system.model.Resource;

import java.util.List;

/**
 * 后台主页资源Dto
 */
public class HomeResourceDto {

    /**
     * 描述：根路劲名称
     */
    private String rootName;

    /**
     * 描述：子路劲集合
     */
    private List<Resource> list;

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public List<Resource> getList() {
        return list;
    }

    public void setList(List<Resource> list) {
        this.list = list;
    }
}
