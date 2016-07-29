package cn.pp.common.annotation.impl;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjc
 * @version 2016/7/25 1:26
 * @description
 */
public class CustomSimplePropertyPreFilter implements PropertyPreFilter {

	private final Class<?>    clazz;
    private Set<String> includes = new HashSet<>();
	private Set<String> excludes = new HashSet<>();

	public CustomSimplePropertyPreFilter(String... properties){
		this(null, properties);
	}

	public CustomSimplePropertyPreFilter(Class<?> clazz, String... properties){
		super();
		this.clazz = clazz;
		for (String item : properties) {
			if (item != null) {
				this.includes.add(item);
			}
		}
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public boolean apply(JSONSerializer serializer, Object source, String name) {
		System.out.println("sssss");
		if (source == null) {
			System.out.println("source");
			return true;
		}

		if (clazz != null && !clazz.isInstance(source)) {
			System.out.println("clazz");
			return true;
		}

		if (this.excludes.contains(name)) {
			System.out.println("exclude");
			return false;
		}

		if (includes.size() == 0 || includes.contains(name)) {
			System.out.println("输出");
			return true;
		}

		System.out.println("false");
		return false;
	}

	public Set<String> getIncludes() {
		return includes;
	}

	public Set<String> getExcludes() {
		return excludes;
	}

   public void setIncludes(Set<String> includes) {
		this.includes = includes;
	}

	public void setExcludes(Set<String> excludes) {
		this.excludes = excludes;
	}
}
