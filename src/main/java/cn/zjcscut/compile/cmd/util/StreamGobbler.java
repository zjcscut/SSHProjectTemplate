package cn.zjcscut.compile.cmd.util;

/**
 * @author zjc
 * @version 2016/7/16 11:31
 * @function
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


/**
 * 用于处理Runtime.getRuntime().exec产生的错误流及输出流
 */
public class StreamGobbler implements Runnable {

	private InputStream is;
	private String type;
	private OutputStream os;

	public StreamGobbler(InputStream is, String type) {
		this(is, type, null);
	}

	public StreamGobbler(InputStream is, String type, OutputStream redirect) {
		this.is = is;
		this.type = type;
		this.os = redirect;
	}

	@Override
	public void run() {
		InputStreamReader isr = null;
		BufferedReader br = null;
//		PrintWriter pw = null;
		try {

			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("line --- "  + line);
				  stringBuffer.append(line).append("\n");
			}
			System.out.println(stringBuffer  + "-0---------");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
//				if (pw != null) {
//					pw.close();
//				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}