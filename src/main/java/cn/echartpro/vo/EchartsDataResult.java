package cn.echartpro.vo;


/**
 * @author zhangjinci
 * @version 2016/7/20 20:41
 * @function
 */
public class EchartsDataResult{

    private String name;
    private Integer num;

    public EchartsDataResult() {
    }

    public EchartsDataResult(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
