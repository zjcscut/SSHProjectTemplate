//package cn.zjcscut.jsoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.File;
//
///**
// * @author zjc
// * @version 2016/7/23 10:39
// * @description
// */
//public class ParseHtml {
//
//	//解析html字符串
//	public static void parseHtml() {
//		String html = "<html><head><title>First parse</title></head>"
//				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
//		Document doc = Jsoup.parse(html);
//
//		Elements content = doc.getElementsByTag("p");
//		for (Element e : content) {
//			System.out.println(e.text());
//		}
//	}
//
//	//解析html body的内容
//	private static void parseBody() {
//		String html = "<div><p>Lorem ipsum.</p></div>";
//		Document doc = Jsoup.parseBodyFragment(html);
//		Element body = doc.body();
//		//相当于
////		Elements elements = doc.getElementsByTag("body");
//		Elements elements = body.getAllElements();
//		for (Element e : elements) {
//			System.out.println(e.text());
//		}
//	}
//
//
//	//通过一个url获取和解析一个HTML文档，并查找其中的相关数据
//	//支持http和https
//	private static void parseUrl() throws Exception {
//		Document doc = Jsoup.connect("http://www.open-open.com/jsoup/load-document-from-url.htm").get();
//
//		//提供特殊链式方法抓取html文档
////		Document doc = Jsoup.connect("http://example.com")
////				.data("query", "Java")
////				.userAgent("Mozilla")
////				.cookie("auth", "token")
////				.timeout(3000)
////				.post();
//
//		String title = doc.title();
//		System.out.println(title);
//	}
//
//	//在本机硬盘上有一个HTML文件，需要对它进行解析从中抽取数据或进行修改。
//	//静态 Jsoup.parse(File in, String charsetName, String baseUri) 方法
//	//baseUri参数可选，用于修正相对路径
//	private static void parseFile() throws Exception {
//		File input = new File("/tmp/input.html");
//		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
//	}
//
//	public static void main(String[] args) throws Exception {
//		parseUrl();
//	}
//}
