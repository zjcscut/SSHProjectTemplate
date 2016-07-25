//package cn.zjcscut.jsoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URL;
//import java.net.URLConnection;
//
///**
// * @author zjc
// * @version 2016/7/23 12:01
// * @description
// */
//public class FetchPic {
//
//	private static void getPic(String targetUrl) throws Exception {
//		String path = System.getProperty("user.dir") + "/bin/img/";
//		File file = new File(path);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//
//		Document doc = Jsoup.connect(targetUrl).get();
//		Elements pics = doc.select("img[src~=(?i)\\.(png|jpeg)]");
//		System.out.println(pics.size());
//		for (Element e : pics) {
//			String src = e.attr("src");//获取img中的src路径
//			System.out.println(src);
//			if (!src.startsWith("http") ||!src.startsWith("https")){
//				src = targetUrl + src;
//			}
//			//获取后缀名
//			String subffix = src.substring(src.lastIndexOf(".") + 1, src.length());
//			String fileName = System.currentTimeMillis() + "." + subffix;
//			System.out.println(fileName);
//			URL url = new URL(src);
//			URLConnection uri = url.openConnection();
//			//获取数据流
//			InputStream is = uri.getInputStream();
//			//写入数据流
//			OutputStream os = new FileOutputStream(new File(path, fileName));
//
//			byte[] buf = new byte[is.available()];
//			int len = 0;
//			while ((len = is.read(buf)) != -1) {
//				os.write(buf);
//			}
//
//			is.close();
//			os.close();
//		}
//	}
//
//	public static void main(String[] args) throws Exception{
//	       getPic("http://www.ppfix.cn/");
//	}
//}
