/*
 * Copyright (c) 2012-2015 zjc@ppfix.cn
 * May you do good and not evil.
 * May you find forgiveness for yourself and forgive others.
 * May you share freely,never taking more than you give.
 * Please do not del these words when you share or copy this file
 */

package cn.ppfix;

import cn.ppfix.entity.Area;
import cn.ppfix.service.AreaService;
import cn.ppfix.service.CategoryService;
import cn.ppfix.utils.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @version 2016/1/7-16:26
 */
public class TestScope extends BasicTest {

	private static final String XX = "(1,2)";
	@Autowired
	private AreaService areaService;
	@Autowired
	private CategoryService categoryService;

//	@Autowired
//	private SqlDao sqlDao;
//
//    @Autowired
//    private AreaDAO areaDAO;

	@Test
	public void Test1() {
		Area a = areaService.findArea();
		System.out.println("id--" + a.getId());
		System.out.println("name--" + a.getName());
//        System.out.println("parant--" + a.getParent());
//        System.out.println("nodes--" + a.getNodes());
		System.out.println("json--" + JsonUtil.toJson(a));
	}

	@Test
	public void Test2() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from OrderInfo o where o.isDelete = '0' ")
				.append("and o.customerId = :userId ")
				.append("and o.orderStatus in ")
				.append(XX);
		System.out.println(stringBuilder.toString());
	}

	@Test
	public void Test3() {
//        categoryService.saveCategoryWithCascade();
		categoryService.modifyCategoryAssociation();
	}

	@Test
	public void Test4() {
		System.out.println(JsonUtil.toJson(areaService.getByCondition()));
	}

	@Test
	public void Test5() {
		System.out.println(JsonUtil.toJson(areaService.getBySQLAndTransBean()));
	}

	@Test
	public void Test6() {
		System.out.println(JsonUtil.toJson(areaService.getByNativeSQL()));
	}

	@Test
	public void Test7() {
		areaService.deleteArea();
		System.out.println(JsonUtil.toJson(areaService.getByHQL()));
	}

	//
	@Test
	public void Test8() {
		System.out.println(JsonUtil.toJson(areaService.selectByHQL()));
	}

	@Test
	public void Test9() {
		Map<String,Object> params = new HashMap<>();
		params.put("id","1,2,3");
		params.put("pid",2);
		params.put("name","天河");
		Map<String,String> filter = new HashMap<>();
		filter.put("id","INTEGERIN");
		filter.put("name","LIKE");
        List<Area> list = areaService.selectBySqlContext(params,filter);
		System.out.println("list--> " + JsonUtil.toJson(list));
	}
}
