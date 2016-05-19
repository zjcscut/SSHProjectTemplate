package cn.ppfix.entity;

import javax.persistence.Transient;
import java.util.Set;

/**
 * @author zjc
 * @version 2016/5/19 1:32
 */
public class Area implements java.io.Serializable {

    private Integer id;
    private String name;
    private Area parent;  //父节点
    private Set<Area> nodes; //子节点

    public Area() {
    }

    public Area(Integer id, String name, Area parent, Set<Area> nodes) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.nodes = nodes;
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

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public Set<Area> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Area> nodes) {
        this.nodes = nodes;
    }
}
