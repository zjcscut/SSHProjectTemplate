package cn.zjcscut.compile.cmd.util;

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
}

