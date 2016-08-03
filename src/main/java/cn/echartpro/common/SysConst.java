package cn.echartpro.common;

/**
 * @author zhangjinci
 * @version 2016/7/28 9:32
 * @function 系统变量
 */
public class SysConst {

    /**
     * Echarts图表类型
     */
    public enum EchartsType {

        /* 中国地图 */
        CHINA_MAP_CHART("1"),
        /*玫瑰图*/
        ROSE_CHART("2"),
        /*条形图*/
        BAR_CHART("3"),
        /*线图*/
        LINE_CHART("4");

        private final String value;

        public String getValue() {
            return value;
        }

        EchartsType(String value) {
            this.value = value;
        }
    }

    /**
     * 订单类型
     */
    public enum OrderType {
        /*发布*/
        PUBLISH(1),
        /*处理中*/
        HANDLING(2),
        /*完成*/
        FINISH(3);


        private final Integer value;

        OrderType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }


}
