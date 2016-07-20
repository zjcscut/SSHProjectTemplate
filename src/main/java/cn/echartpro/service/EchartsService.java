package cn.echartpro.service;

import cn.echartpro.dao.EchartsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangjinci
 * @version 2016/7/20 20:36
 * @function
 */
@Service
public class EchartsService {
    @Autowired
    private EchartsDAO echartsDAO;

    public Object getData(){
        return echartsDAO.selectAll();
    }
}
