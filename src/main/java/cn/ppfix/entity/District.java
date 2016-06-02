package cn.ppfix.entity;

/**
 * @author zjc
 * @version 2016/5/22 11:15
 */
public class District {

    private Integer id;
    private String name;
    private Integer areaId;

    public District() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
