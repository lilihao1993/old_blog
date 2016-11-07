package system.dto;


import java.util.List;

/**
 * 描述：跟资源树
 */
public class RootResourceTreeDto {

    /**
     * 描述：根名称
     */
    private String name;
    /**
     * 描述：根id
     */
    private String id;
    /**
     * 描述：子资源列表
     */
    private List<SubsetResourceTreeDto> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SubsetResourceTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<SubsetResourceTreeDto> children) {
        this.children = children;
    }
}
