package cn.ppfix.service;

import cn.ppfix.common.dao.AreaDAO;
import cn.ppfix.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjc
 * @version 2016/5/16 22:10
 */
@Service
public class AreaService {

    @Autowired
    private AreaDAO areaDAO;

    public Area findArea() {
        return areaDAO.findArea();
    }

    public List<Area> getByCondition() {
        Map<String, Object> params = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        params.put("id", ids);
        return areaDAO.getObjectList(params);
    }
}
