package demo;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
/**
 文件相关的操作：

 1.创建

 createFile()：不会覆盖已有文件
 mkdir()：创建单级目录，只能创建一级目录
 mkdirs()：创建多级目，可以创建多级目录

 renameTo()：带重命名的移动功能

 2.删除

 delete()：删除失败返回false
 deleteOnExit()：程序退出时删除指定文件


 3.判断

 canExecute()：文件是否可以操作
 exists()：文件是否存在

 // 操作前必须先判断对象是否存在
 isDirectory()：是否为目录
 isFile：是否为文件
 isHidden()：是否隐藏
 isAbsolute()：是否为绝对路径，与文件是否存在无关

 endsWith()/startWith()：以指定字符串作为文件开头或这末尾





 4.查看信息

 getName()：只获取文件名
 getPath()：封装的文件名
 getParent()：未明确指定父目录，总返回null

 getAbsolutePath()：总获取绝对路径
 lastModified():
 length():文件长度

 listRoots()：列出全部盘符
 list()：列出指定存在的目录下(传入文件会报空指针异常)的所有下级目录及文件(包括隐藏)
 listFiles()：返回文件数组




 Properties：Hashstable的子类

 具备Map的特点，里面的键值对全部为字符串

 是集合中和IO技术相结合的集合容器




 */
public class FILE {
	public static void main(String[] args) throws Exception {
//		fileDemo01();

//		showDir(new File("H:/文件夹1"), 0);

//		toBinary(3);

//		System.out.println(getSum(10000));



//		rmDir(new File("H:/文件夹1"));

//		ArrayList<File> list = new ArrayList<File>();
//		listDir(new File("H:/文件夹1"), list);
//		writeToFile(list, new File("H:/z.txt"));


//		propertiesDemo01();

//		readProperties(new File("H:/z.txt"), new File("H:/zz.txt"));

//		loadDemo01(new FileInputStream("H:/z.txt"));

		multiDemo01(9);
	}



	/**
	 * 99乘法表
	 */

	private static void multiDemo01(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " * " + i + " = " + i*j + "   ");
			}
			System.out.println();
		}
	}


	/**
	 * 将流中的数据加载进Properties中
	 * @throws IOException
	 */
	private static void loadDemo01(FileInputStream fis) throws IOException {
		Properties properties = new Properties();
		properties.load(fis);

		properties.setProperty("name", "wangwu"); // 仅修改流中数据

		properties.store(new FileOutputStream("H:/z.txt"), "eee"); // 修改并保存流数据，添加注解和修改时间


		System.out.println(properties);
		properties.list(System.out);

	}





	/**
	 * 读取文件中properties键值对
	 */
	private static void readProperties(File srcFile, File desFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(srcFile));

		Properties properties = new Properties();
		String line = null;
		while((line = br.readLine()) != null) {
			String str[] = line.split("=");
			properties.setProperty(str[0], str[1]);
			System.out.println(properties);
		}

		br.close();


	}



	/**
	 * properties文件的操作
	 */
	private static void propertiesDemo01() {
		Properties properties = new Properties();
		properties.setProperty("name", "wang");
		properties.setProperty("age", "18");
		properties.setProperty("sex", "male");
		properties.setProperty("addr", "hefei");

		Set<String> propertyNames = properties.stringPropertyNames();
		for(String nameString : propertyNames) {
			System.out.println("key: " + nameString + " -- value: " + properties.getProperty(nameString));
		}

	}








	/************************************************************
	 * 将指定目录下的.java文件的绝对路径存储到文本文件中
	 */
	private static void listDir(File dir, ArrayList<File> list) {
		File[] files = dir.listFiles();
		for(File file : files) {
			if (file.isDirectory()) {
				listDir(file, list);
			} else {
				if (file.getName().endsWith(".java")) {
					list.add(file);
				}
			}
		}
	}

	private static void writeToFile(ArrayList<File> list, File listFile) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(listFile));

		for(File file : list) {
			String path = file.getAbsolutePath();
			bw.write(path);
			bw.newLine();
			bw.flush();
		}

		bw.close();
	}



	/**
	 * 递归删除指定目录下所有子目录及文件
	 */
	private static void rmDir(File dir) {
		File[] list = dir.listFiles();
		for(File file : list) {
			if (file.isDirectory()) {
				rmDir(file);
			} else {
				System.out.println(file.delete());
			}
		}

		dir.delete();
	}



	/**
	 * 递归--求和
	 */
	private static int getSum(int num) {
		if (num < 0) {
			return 0;
		}
		return getSum(num - 1) + num;
	}




	/**
	 * 递归--十进制转换二进制
	 */
	private static void toBinary(int num) {
		StringBuffer sb = new StringBuffer();
		if(num > 0) {
			sb.append(num % 2);
			toBinary(num / 2);
			System.err.println(sb.toString());
		}
		System.out.println(sb.toString());
	}




	/**
	 * 递归--列出指定目录下所有子目录及文件
	 *
	 * 切记避免内存溢出！
	 */
	public static String getLevel(int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("|---");
		for(int x=0; x<level; x++)
		{
			sb.insert(0,"|   ");

		}
		return sb.toString();
	}

	public static void showDir(File dir,int level)
	{

		System.out.println(getLevel(level)+dir.getName());

		level++;
		File[] files = dir.listFiles();
		for(int x=0; x<files.length; x++)
		{
			if(files[x].isDirectory())
				showDir(files[x],level);
			else
				System.out.println(getLevel(level)+files[x]);
		}
	}



	// 目录分隔符三个写法：/ || \\ || file.separator(跨平台)
	private static void fileDemo01() throws IOException, InterruptedException {



	}
}











































