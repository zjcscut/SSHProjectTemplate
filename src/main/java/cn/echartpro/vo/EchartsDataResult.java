package cn.echartpro.vo;


/**
 * @author zhangjinci
 * @version 2016/7/20 20:41
 * @function
 */
public class EchartsDataResult{

    private String name;
    private Long num;

    public EchartsDataResult() {
    }

    public EchartsDataResult(String name, Long num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "EchartsDataResult{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
