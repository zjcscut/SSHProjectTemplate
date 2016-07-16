package cn.zjcscut.compile.cmd;

import cn.zjcscut.compile.cmd.util.ClassUtils;
import cn.zjcscut.freemarker.classUtils.ClassLoader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author zjc
 * @version 2016/7/15 23:09
 * @function
 */
public class DynamicCompileWithCmd {

	private static final Logger log = LoggerFactory.getLogger(DynamicCompileWithCmd.class);

	private static final String SAVEPATH = ClassLoader.getUserDir() + "/bin/source/";

	private static final String CLASSSUFFIX = ".java";

	private static final String BATSUFFIX = ".bat";

	private String className;

	private String result;

	public void save(String content) {
		className = ClassUtils.getClassNameFromSourceCode(content);
		if (StringUtils.isEmpty(className)) {
			log.error("获取类名失败，估计是类的结构出现异常");
			throw new RuntimeException("class format error,please check it!");
		}

		String realFile = SAVEPATH + className + CLASSSUFFIX;
		File file = new File(realFile);
		if (!file.exists()) {
			file.getParentFile().mkdirs();  //不存在就创建
		}

		BufferedWriter bf = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			bf = new BufferedWriter(fw);
			bf.write(content);

			bf.close();
			fw.close();
		} catch (Exception e) {
			log.error("写入源代码生成.java文件失败");
			throw new RuntimeException("create java file failed");
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

   //构建bat文件
	private String createBatFile(String className) {
		String realFile = SAVEPATH + className + BATSUFFIX;
		File file = new File(realFile);
		if (!file.exists()) {
			file.getParentFile().mkdirs();  //不存在就创建
		}
		String compile = "javac " + className + CLASSSUFFIX + " \n";
		String cd = "cd " + SAVEPATH + " \n";
		String run = "java " + className + " \n";
		BufferedWriter bf = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			bf = new BufferedWriter(fw);
			bf.write(cd + compile + run);
			bf.close();
			fw.close();
			return realFile;
		} catch (Exception e) {
			log.error("写入bat文件失败");
			throw new RuntimeException("create bat file failed");
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	private static Process process;//执行子进程

	public String execute(String content) {
		save(content);
		String batName = createBatFile(className);
		Runtime runtime = Runtime.getRuntime();
		BufferedWriter bw = null;
		try {


//			Thread.sleep(1000);  //防止cmd.exe程序未启动，当然也可以直接使用javac命令
//			bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
//			String compile = "javac " + SAVEPATH + className + CLASSSUFFIX + " \n";
//			String run ="java " + SAVEPATH + className + " \n";


			long startFreeMemory = runtime.freeMemory();  //记录开始执行命令前的空闲内存
			long startCurrentTime = System.currentTimeMillis();
//			bw.write("java " + SAVEPATH + className + " \n");
//			bw.write(compile + " & " + run);
//			bw.flush();
//			bw.close();
//			"cmd.exe /C start /b "
			process = runtime.exec("cmd.exe /C start /b " + batName);

			//合并流
			SequenceInputStream sis = new SequenceInputStream(process.getInputStream(),process.getErrorStream());
			InputStreamReader isr = new InputStreamReader (sis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while (null != ( line = br.readLine () ))
			{
				System.out.println (line);
			}
			process.destroy ();
			br.close ();
			isr.close ();

			process.waitFor();
			int sign = process.exitValue();
			if (sign == 0) {
				System.out.println("执行成功");
			} else {
				System.out.println("执行失败");
			}

//			StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
//			Thread thread1 = new Thread(outGobbler);
//			thread1.start();

//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//
//						String s = null;
//						BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//						while ((s = br.readLine()) != null) {
//							System.out.println(s);
//							result += s;
//						}
//					} catch (java.lang.Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}).start();
//
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//
//						String s = null;
//						BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//						while ((s = br.readLine()) != null) {
//							System.out.println("error -- " + s);
//						}
//					} catch (java.lang.Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}).start();


//			StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");
//			Thread thread = new Thread(errorGobbler);
//			thread.start();
//			Thread thread = new Thread(new RuntimeResultThread());
//			thread.start();

//			String s = null;
//			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			while ((s = br.readLine()) != null) {
//				System.out.println(s);
//				result += s;
//			}
//
//			br.close();
//			System.out.println(batName);
//			InputStream in =  process.getInputStream();
//
//			int c;
//			while ((c = in.read()) != -1) {
//				System.out.print("输出---" + c);//如果你不需要看输出，这行可以注销掉
//			}
//			in.close();



			//获取控制台输出结果
//			Thread thread = new Thread(new RuntimeResultThread());
//			thread.start();
			long endCurrentTime = System.currentTimeMillis();
			long endFreeMemory = runtime.freeMemory();
			double useMemory = (startFreeMemory - endFreeMemory) / 1024;
			long useTime = endCurrentTime - startCurrentTime;

			result += "\n\ncost time : " + useTime + " ms" + ", cost memory : " + useMemory + " mb";
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private class RuntimeResultThread implements Runnable {

		@Override
		public void run() {
			BufferedReader br = null;
			String content = null;
			try {
				br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
				while ((content = br.readLine()) != null) {
					System.out.println("content" + content);
					result += content;
				}
				br.close();
			} catch (Exception e) {
				log.error("获取控制台输出失败");
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
