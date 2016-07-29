package cn.pp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangjinci
 * @version 2016/7/20 19:56
 * @function
 */
public class OrderInfo implements Serializable{
    private Integer id;
    private String account;
    private Date date;
    private Integer provinceId;
    private Integer isDelete;


    public OrderInfo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
