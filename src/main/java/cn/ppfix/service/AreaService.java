package cn.ppfix.service;

import cn.ppfix.common.dao.AreaDAO;
import cn.ppfix.dto.AreaDTO;
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

	public Area findById(Integer id) {
		return areaDAO.get(id);
	}

	public Area findArea() {
		return areaDAO.findArea();
	}

	public List<Area> getByCondition() {
		Map<String, Object> params = new HashMap<>();
		Object[] ids = {1, 2, 3};
		params.put("id", ids);
		return areaDAO.getObjectList(params);
	}

	public AreaDTO getBySQLAndTransBean() {
		return areaDAO.getByNativeSQLAndTransferBean(1);
	}

	public Area getByNativeSQL() {
		return areaDAO.getByNativeSQL(1);
	}

	public Area getByHQL() {
		return areaDAO.selectByHql(2);
	}

	//删除area，级联删除district
	public void deleteArea() {
		areaDAO.del(2);
	}


	//HQL联查
	public AreaDTO selectByHQL() {
		return areaDAO.selectByHqlTransDTO(1);
	}


	public void updateArea(Integer id) {
		Area a = areaDAO.selectByHql(id);
		a.setName("update测试");
		areaDAO.update(a);
	}

	public Area getFromSecondCache(Integer id) {
		areaDAO.monitorSecondLevelCache();  //查看二级缓存
		return areaDAO.selectFromSecondCache(id);
	}

}
