package cn.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zjc
 * @version 2016/7/15 23:17
 * @function
 */
public class ClassUtils {

	private final static String CLASS_REGEX = "class\\s+([\\w\\d$_]+)s*";

	private final static String PACKAGE_REGEX = "package\\s+([\\w\\d$.]+)s*";

	public static String getClassNameFromSourceCode(String code) {
		Pattern pattern = Pattern.compile(CLASS_REGEX);
		Matcher matcher = pattern.matcher(code);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	public static String getPachageNameFromSourceCode(String code) {
		Pattern pattern = Pattern.compile(PACKAGE_REGEX);
		Matcher matcher = pattern.matcher(code);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	public static boolean instanceOf(Class source,Class target){
		if(source == null) {
			return false;
		} else if(source == target) {
			return true;
		} else {
			Class[] classList;
			int var3;
			int var4;
			Class aClass;
			if(target.isInterface()) {
				classList = source.getInterfaces();
				var3 = classList.length;

				for(var4 = 0; var4 < var3; ++var4) {
					aClass = classList[var4];
					if(aClass == target) {
						return true;
					}
				}
			}

			if(source.getSuperclass() == target) {
				return true;
			} else {
				if(source.isInterface()) {
					classList = source.getInterfaces();
					var3 = classList.length;

					for(var4 = 0; var4 < var3; ++var4) {
						aClass = classList[var4];
						if(instanceOf(aClass, target)) {
							return true;
						}
					}
				}

				return instanceOf(source.getSuperclass(), target);
			}
		}
	}
}

