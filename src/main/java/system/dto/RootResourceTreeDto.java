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
    private boolean spread = true;
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

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<SubsetResourceTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<SubsetResourceTreeDto> children) {
        this.children = children;
    }
}
