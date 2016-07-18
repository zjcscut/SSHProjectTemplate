package cn.framework.entity;

/**
 * @author zjc
 * @version 2016/7/14 0:05
 * @function 脚本提交回调结果
 */
public class ExecuteResult {

    private boolean success;
    private Object result;
    private String msg;
    private transient Throwable exception;
    private long costTime;

    public ExecuteResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        if (msg == null && exception != null) {
            msg = exception.getMessage();
        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "ExecuteResult{" +
                "success=" + isSuccess() +
                ", result=" + getResult() +
                ", msg=" + getMsg() +
                ", costTime=" + getCostTime() + " ms" +
                '}';
    }
}
