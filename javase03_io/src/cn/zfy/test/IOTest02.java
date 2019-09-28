package cn.zfy.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**字节数组流；字节流的一种多态；方式是字节数组，目的地是字节数组和程序；
 * 1、字节数组输入流：（指定的）byteArray->（ByteArrayInputStream）->程序；
 *   创建源：字节数组不要太大；
 *   选择流；
 *   操作；
 *   释放资源；可以不用处理；
 *   
 *2、字节数组输出流：程序->（ByteArrayOutputStream）->（内存里面的）byteArray
 *   创建源：内部维护；
 *   选择流；不关联源；
 *   操作；写出内容；
 *   释放资源；可以不用；
 *   
 *   获取数据；从内存导出，通过ByteArrayOutputStream.toByteArray()拿取字节数组；
 *   
 *   
 * 3、所有的东西都可以读到字符数组中；  
 * @author DELL
 *
 */
public class IOTest02 {

	public static void main(String[] args) {
		test1();
	}
	
	//字符串->通过字节数组（flush）进行传递，通过new String(flush,0,len)方法将内容显示出来；
	public static void test1() {
        //创建源；字符串->字节数组；
		byte[] src="i believe you can!".getBytes();
		//选择流；
		InputStream is=null;
		try {
			//多态；
			is=new ByteArrayInputStream(src);
			//操作，分段读取；
			//缓冲容器；
			byte[] flush=new byte[5];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				//字节数组->字符串；
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//字节数组->字符串；
	public static void test2() {
        //创建源；由内存自己控制；
		byte[] dest=null;
		//选择流（新增方法，不能使用多态）；
		ByteArrayOutputStream baos=null;
		try {
			//不能使用多态；
			baos=new ByteArrayOutputStream();
			//操作，分段读取；
			//需要传递的信息；
			String msg="show me the able!";
			byte[] datas=msg.getBytes();
			baos.write(datas, 0, datas.length);
			baos.flush();
			
			//如何获取写出的字节数组；
			dest=baos.toByteArray();
			System.out.println(dest.length+"-->"+dest.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}

