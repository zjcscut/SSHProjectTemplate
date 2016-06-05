package cn.ppfix.service;

import cn.ppfix.common.dao.LogDAO;
import cn.ppfix.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
