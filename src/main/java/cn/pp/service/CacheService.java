package cn.pp.service;

import cn.pp.common.dao.LogDAO;
import cn.pp.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjc
 * @version 2016/6/2 20:36
 */
@Service
public class CacheService {

	@Autowired
	private LogDAO logDAO;

	//	@CacheEvict(value = "myCache", key = "0", beforeInvocation = true)
	public Integer insertLog(Log log) {
		return logDAO.saveInt(log);
	}


	//	@Cacheable(value = "myCache", key = "0")
	public Long count() {
		return logDAO.selectCount();
	}

}
