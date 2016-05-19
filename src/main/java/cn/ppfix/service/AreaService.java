package cn.ppfix.service;

import cn.ppfix.common.dao.AreaDAO;
import cn.ppfix.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
