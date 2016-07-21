package cn.echartpro.service;

import cn.echartpro.dao.EchartsDAO;
import cn.echartpro.vo.EchartsDataResult;
import cn.echartpro.vo.EchartsDataVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/7/20 20:36
 * @function
 */
@Service
public class EchartsService {
    @Autowired
    private EchartsDAO echartsDAO;

    public List<JSONObject> getData() {
        List<EchartsDataResult> resultList = echartsDAO.selectAll();
        List<JSONObject> jsonObjectList = new LinkedList<>();
        for (EchartsDataResult result : resultList) {
            EchartsDataVO vo = new EchartsDataVO();
            vo.setName(result.getName());
            vo.setNum(result.getNum());
            jsonObjectList.add(vo);
        }
        return jsonObjectList;
    }
}
