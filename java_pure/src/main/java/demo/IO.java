package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 IO流用来处理设备之间的数据传输
 Java对数据的操作是通过流的方式
 Java用于操作流的对象都在IO包中
 流按操作数据分为两种：字节流和字符流
 流按方向分为：输入流和输出流

 --

 字节流和字符流

 字节流两个基类：InputStream和OutputStream

 字符流两个基类：Reader和Writer

 ---------------------------------------

 字符流的缓冲区

 缓冲区提高了对流数据的读写效率 --> 创建缓冲区对象前必须先有流对象
 对应类：BufferedWriter和BufferedWriter
 缓冲区要结合流才可以使用
 在流的基础上对流的功能进行了增强


 readLine()
 无论是读一行还是读多个字符，最终都是read()一次读一个

 abc\r\n  --> 读到最后换行符，将前面已读取字符构成字符串返回
 cde\r\n


 =======================================以下字节流--直接对字节操作，不需要刷新


 字节流的缓冲区

 对应类：BufferedOutputStream和BufferedInputStream


 =======================================☆☆☆流操作基本规律☆☆☆

 两个明确

 源和目的
 源>输入流：InputStream和Reader
 目的>输出流：OutputStream和Writer

 是否提高效率
 BufferedReader
 BufferedWriter

 操作的数据是否为纯文本
 是：字符流
 否：字节流

 当体系明确后再明确具体对象

 通过设备进行区分
 源设备：内存、硬盘、键盘
 目的设备：内存、硬盘、控制台



 */

/**
 * 模拟BufferedReader类中的特有方法readLine()：
 *
 * 装饰设计模式(优化原有继承体系，并增强扩展性)：将已有对象传入自定义类中，基于已有的功能，并提供增强功能--自定义的该类为装饰类
 *
 * 装饰类通常通过构造接收被装饰的对象，并基于被装饰的对象的功能，提供更强的功能--避免继承体系的臃肿 | 降低类间的耦合性--装饰类及被装饰类同属同一体系
 */

class MyBufferedReader {

	private FileReader mFileReader;
	MyBufferedReader(FileReader fileReader) {
		mFileReader = fileReader;
	}


	// 模拟readLine()：一次读一行的方法
	public String  myReadLine() throws IOException { // 异常交给调用者处理
		// 定义临时容器StringBuilder
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = mFileReader.read()) != -1) {
			if (ch == '\r') {
				continue;
			}
			if (ch == '\n') {
				return sb.toString();
			}
			sb.append((char) ch);
		}
		// 解决文本最后没有换行符，最后一行文本未添加至sb缓冲区问题
		if (sb.length() != 0) {
			return sb.toString();
		}
		return null;
	}

	public void myClose() throws IOException { // 异常交给调用者处理
		mFileReader.close();
	}
}


@SuppressWarnings("all")
public class IO {

	public static final String ROOT_PATH = "H:/";

	public static void main(String[] args) throws IOException {



//		FileWriterDemo01();

//		IOHandle();

//		continueWrite();

//		FileReaderDemo01();

//		FileReaderDemo02();

//		ReadJava();

//		copy01();

//		copy02();

		// -------------------------

//		BufferedWriterDemo01();

//		BufferedReaderDemo01();

//		copyByBuffer();

//		testMyBufferedReader();

//		lineNumberReaderDemo();

//		writeFile01();

//		readFile01();

//		readFile02();

//		readFile03();

//		copyPic01();

//		copyPic02();

//		readKeyboard01();

//		inputStreamReaderDemo01();

//		exceptionDemo01();

		showProperties01();


	}



	/**
	 * 系统信息
	 */
	private static void showProperties01() throws FileNotFoundException {
		Properties properties = System.getProperties();
		System.out.println(properties);

		properties.list(new PrintStream(ROOT_PATH + "systemPro.properties"));
	}




	/**
	 * 记录异常信息日志
	 */
	private static void exceptionDemo01() throws IOException {

		try {
			int[] arr = new int[2];
			System.out.println(arr[3]);
		} catch (Exception e) {
			try {
				String data =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

				PrintStream ps = new PrintStream(ROOT_PATH + "exception.d");
				ps.println(data);
				System.setOut(ps);
			} catch (Exception e1) {
				throw new RuntimeException("日志文件创建失败"	);
			}
			e.printStackTrace(System.out);
		}
	}




	/**
	 * 自行改变源和目的文件
	 */
	private static void outputStreamWriterDemo01() throws IOException {
		// 获取键盘录入对象
		InputStream is = System.in;

		// 将字节流对象转换成字符流对象--字节通向字符的桥梁
		InputStreamReader isr = new InputStreamReader(is);

		// 添加缓冲技术BufferedReader
		BufferedReader br = new BufferedReader(isr);

		OutputStream os = System.out;

		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		// 注意！上述代码优化写法如下
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ROOT_PATH + "test.java")));

		String line = null;

		while((line = br.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
		}

		br.close();
	}



	/**
	 * 键盘录入：通过字节流转换成字符流，再通过字符流缓冲区的readLine()
	 */
	private static void inputStreamReaderDemo01() throws IOException {
		// 获取键盘录入对象
		InputStream is = System.in;

		// 将字节流对象转换成字符流对象--字节通向字符的桥梁
		InputStreamReader isr = new InputStreamReader(is);

		// 添加缓冲技术BufferedReader
		BufferedReader br = new BufferedReader(isr);

		// 注意！上述代码优化写法如下：键盘录入规定写法
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while((line = br.readLine()) != null) {
			if ("over".equals(line)) {
				break;
			}
			System.out.println(line.toUpperCase());
		}

		br.close();
	}




	/**
	 * 读取键盘录入
	 * 		System.in：标准输入设备(键盘)
	 * 		System.out：标准输出设备(控制台)
	 */
	private static void readKeyboard01() throws IOException {
		InputStream is = System.in;

		int ch = is.read();

		System.out.println(ch);
	}




	/*********************************************************************
	 * 通过字节流缓冲区复制图片
	 */
	private static void copyPic02() throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ROOT_PATH + "ali_copy.jpg"));
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ROOT_PATH + "ali.jpg"));

		int ch = 0;
		while((ch = bis.read()) != -1) {
			bos.write((char) ch);
		}

		bos.close();
		bis.close();


	}




	/**
	 * 通过字节流复制图片
	 */
	private static void copyPic01() throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(ROOT_PATH + "ali_copy.jpg");
			fis = new FileInputStream(ROOT_PATH + "ali.jpg");

			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}


		} catch (Exception e) {
			throw new RuntimeException("拷贝错误！");
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				fis.close();
			}
		}
	}




	/**
	 * 字节流读操作3：字节流特有读方式
	 */
	private static void readFile03() throws IOException {
		FileInputStream fis = new FileInputStream(ROOT_PATH + "test.java");

		int num = fis.available(); // 确定中间站长度. 注意！避免内存过大
		byte[] buffer = new byte[num]; // 定义一个长度刚好的缓冲区
		fis.read(buffer);

		System.out.println(num + " :: \r\n" + new String(buffer));
		fis.close();
	}




	/**
	 * 字节流读操作2：按字节数组读
	 */
	private static void readFile02() throws IOException {
		FileInputStream fis = new FileInputStream(ROOT_PATH + "test.java");

		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = fis.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0, len));
		}
		fis.close();
	}




	/**
	 * 字节流读操作1：一个一个读
	 */
	private static void readFile01() throws IOException {
		FileInputStream fis = new FileInputStream(ROOT_PATH + "test.java");

		int ch = 0;

		while((ch = fis.read()) != -1) {
			System.out.print((char) ch);
		}
		fis.close();
	}



	/**
	 * 字节流写操作
	 */
	private static void writeFile01() throws IOException {
		FileOutputStream fos = new FileOutputStream(ROOT_PATH + "pic_copy.jpg");
		fos.write("abcdefg..".getBytes()); // 字符串转字节数组
		fos.close();
	}





	/*********************************************************************
	 * 带行号读文件
	 */
	private static void lineNumberReaderDemo() throws IOException {
		LineNumberReader numReader = new LineNumberReader(new FileReader(ROOT_PATH + "test.java"));

		String line = null;
		numReader.setLineNumber(100);
		while((line = numReader.readLine()) != null) {
			System.out.println(numReader.getLineNumber() + " :: " + line);
		}

		numReader.close();
	}


	/**
	 * 测试MyBufferedReader
	 */
	private static void testMyBufferedReader() throws IOException {
		FileReader fr = new FileReader(ROOT_PATH + "test.java");
		MyBufferedReader mybr = new MyBufferedReader(fr);

		String line = null;
		while((line = mybr.myReadLine()) != null) {
			System.out.println(line);
		}

		mybr.myClose();
	}


	/**
	 * 通过缓冲区复制文件
	 */
	private static void copyByBuffer() {
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter(new FileWriter(ROOT_PATH + "test_copy_buffer.java"));
			br = new BufferedReader(new FileReader(ROOT_PATH + "test.java"));

			// 流数据的中转站
			String line;
			// readLine()只返回回车符之前的数据，并不返回回车符↑↑↑
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}

		} catch(IOException e) {
			throw new RuntimeException("复制失败！");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * 缓冲区读文件：缓冲去提供了一次读一行的方法readLine()
	 * 		方便按行读取数据，当读到文件末尾时返回null
	 */
	private static void BufferedReaderDemo01() throws IOException {
		FileReader fileReader = new FileReader(ROOT_PATH + "test.java");
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		/** 普通按字节数组读 */
//		char[] buffer = new char[1024];
//		int len = 0;
//		while((len = bufferedReader.read(buffer)) != -1) {
//			System.out.print(new String(buffer, 0 ,len));
//		}

		/** 缓冲区特有方法：按行读 */
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

	}



	/**
	 * 缓冲区写文件
	 */
	private static void BufferedWriterDemo01() throws IOException {
		// 创建写入流对象
		FileWriter fileWriter = new FileWriter(ROOT_PATH + "test.java");

		// 加入缓冲，提高效率
		// 将需要提高效率的流对象作为参数传入
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		// \r\n 换行 | 缓冲区对象提供了：newLine()--跨平台换行符
		bufferedWriter.write("abcdefghijklmn \r\n next line...");
		bufferedWriter.newLine();
		bufferedWriter.write(" again next line......");

		// 注意！只要用到缓冲区，就一定记得要刷新！
		bufferedWriter.flush();
//		bufferedWriter.close();
	}



	/*************************************************************
	 * 拷贝文件，方式二：按字节数组
	 */
	private static void copy02() {
		FileWriter fileWriter = null;
		FileReader fileReader = null;
		try {
			fileWriter = new FileWriter(ROOT_PATH + "test_cop02.java");
			fileReader = new FileReader(ROOT_PATH + "test.java");

			// 字符数组充当中转站，将源文件读取的流数据写入目标文件的流中
			char[] buffer = new char[1024];
			int len = 0;
			while((len = fileReader.read(buffer)) != -1) {
				fileWriter.write(buffer, 0, len);
			}

		} catch (IOException e) {
			throw new RuntimeException("读写失败！");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * 拷贝文件，方式一：按字符
	 */
	private static void copy01() throws IOException {
		// 创建目的文件
		FileWriter fileWriter = new FileWriter(ROOT_PATH + "test_copy.java");

		// 关联源文件
		FileReader fileReader = new FileReader(ROOT_PATH + "test.java");

		int ch = 0;
		while((ch = fileReader.read()) != -1) {
			fileWriter.write(ch);
		}

		fileWriter.close();
		fileReader.close();
	}


	/**
	 * 读取.java文件
	 */
	private static void ReadJava() throws IOException {
		FileReader fileReader = new FileReader(ROOT_PATH + "test.java");

		char[] buffer = new char[1024];
		int len = 0;
		while((len = fileReader.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0 ,len));
		}
	}



	/**
	 * 通过字符数组进行读取
	 */
	private static void FileReaderDemo02() throws IOException {
		FileReader fileReader = new FileReader(ROOT_PATH + "text01.txt");

		char[] buffer = new char[1024];
		int len = 0;
		while((len = fileReader.read(buffer)) != -1) {
			System.out.println(new String(buffer, 0 , len));
		}
	}



	/**
	 * 按字符读取文件数据
	 */
	private static void FileReaderDemo01() throws IOException {
		FileReader fileReader = new FileReader(ROOT_PATH + "text01.txt");
		// 一次读一个字符，并且会自动往下读，直到末尾为-1 --> 可作循环条件
		int ch = fileReader.read();
		// int ch1 = fileReader.read();

		while((ch = fileReader.read()) != -1) {
			System.out.println((char) ch);
		}
	}



	/**
	 * 对已有文件的数据续写
	 */
	private static void continueWrite() throws IOException {
		// true为续写
		FileWriter fileWriter = new FileWriter(ROOT_PATH + "text01.txt", true);
		fileWriter.write("...continue");
		fileWriter.flush();
		fileWriter.write("next line\r\nsuccess?");
		fileWriter.close();
	}



	/**
	 * 处理IO异常
	 */
	private static void IOHandle() {
		// 外面声明，块内初始化
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(ROOT_PATH + "text01.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				// 必须判空
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	/**
	 * 创建文件并写入文字数据
	 */
	private static void FileWriterDemo01() throws IOException {
		// 创建FileWriter对象，传入明确的操作文件对象
		// 目录下已有重名文件将被覆盖
		// 明确数据存放的目的地
		FileWriter fileWriter = new FileWriter(ROOT_PATH + "text01.txt");
		// 将数据写入流中(内存中)
		fileWriter.write("abcde");
		// 刷新流重缓冲的数据
		fileWriter.flush(); // 流未关闭，可以继续向流中写数据
		fileWriter.write("...wangyehan");
		fileWriter.close(); // 流关闭，不可以继续向流中写数据
	}
}




























