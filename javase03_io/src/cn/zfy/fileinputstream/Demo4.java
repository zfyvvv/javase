package cn.zfy.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
/**
 * 1¡¢FileUtilµÄÊ¹ÓÃ£»
 * @author DELL
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		String ystr="E:/04-java";
		String dstr="E:/05-java";
		FileUtil.filesCopy(ystr, dstr);
}

}

