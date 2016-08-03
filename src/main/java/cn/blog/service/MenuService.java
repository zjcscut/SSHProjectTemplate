package cn.blog.service;

import cn.blog.dao.MenuDAO;
import cn.blog.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjc
 * @version 2016/7/30 23:18
 * @description
 */
@Service
public class MenuService {

	@Autowired
	private MenuDAO menuDAO;

	public List<Menu> getMainMenus(){
		return menuDAO.selectAllMainMenus();
	}

	public List<Menu> getMenuItems(Integer id){
		return menuDAO.selectMenuByPid(id);
	}
}
