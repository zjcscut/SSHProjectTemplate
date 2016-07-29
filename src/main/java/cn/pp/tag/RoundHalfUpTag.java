package cn.pp.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * jsp标签：实现四舍五入,传入参数为原值以及需要保留的小数位数
 * @author zhangjinci
 * @version 2016/6/23 15:14
 */
public class RoundHalfUpTag extends SimpleTagSupport {

    private double value;

    public void setValue(double value) {
        this.value = value;
    }

    private int leaveBits;

    public void setLeaveBits(int leaveBits) {
        this.leaveBits = leaveBits;
    }

    @Override
    public void doTag() throws JspException, IOException {
        BigDecimal bigDecimal = new BigDecimal(value);
        double result = bigDecimal.setScale(leaveBits, BigDecimal.ROUND_HALF_UP).doubleValue();
        JspWriter jspWriter = this.getJspContext().getOut();
        jspWriter.write(String.valueOf(result));
        jspWriter.close();
        super.doTag();
    }
}
