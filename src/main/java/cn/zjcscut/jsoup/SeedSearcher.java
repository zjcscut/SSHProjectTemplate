//package cn.zjcscut.jsoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.util.*;
//
///**
// * @author zjc
// * @version 2016/7/23 13:02
// * @description 注意http请求超时的问题
// */
//public class SeedSearcher {
//	private static final String HOST = "https://www.torrentkitty.tv/search/";
//
//	private static Map<String, String> getDoc(String searchSymbol) throws Exception {
//		StringBuffer buffer = new StringBuffer(HOST);
//		buffer.append(searchSymbol).append("/");
//		Document doc = Jsoup.connect(buffer.toString())
//				.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36")
//				.referrer("https://www.torrentkitty.tv/search/")
//				.timeout(3000)
//				.get();
//		Element result = doc.getElementById("archiveResult");
//		Elements links = result.getElementsByTag("a");
//		Map<String, String> pa = new HashMap<>();
//		for (Element link : links) {
//			String href = link.attr("href");
//			if (href.startsWith("magnet:")) {
////				System.out.println(href);
//				String[] arry = href.split("&");
//				String ma = arry[0];
//				String name = arry[1].replace("dn=", "");
//				pa.put(name, ma);
//			}
//		}
//		return pa;
//	}
//
//	public static void main(String[] args) throws Exception {
//         Map<String,String> re = getDoc("heyzo");
//		for (Map.Entry<String,String> entry:re.entrySet()){
//			System.out.println("name : " + entry.getKey() + " url : " + entry.getValue());
//		}
//	}
//}
