package cn.zhoufy.tsorm.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zhoufy.tsorm.core.DBManager;
import cn.zhoufy.tsorm.core.MysqlTypeConvertor;
import cn.zhoufy.tsorm.core.TableContext;
import cn.zhoufy.tsorm.core.TypeConvertor;
import cn.zhoufy.tsorm.javabean.ColumnInfo;
import cn.zhoufy.tsorm.javabean.JavaFileSetGet;
import cn.zhoufy.tsorm.javabean.TableInfo;

/**
 * ��װJavaFiles���õĲ�����������javaԴ�룡��
 * @author DELL
 *
 */
public class JavaFilesUtils {
	/**
	 * �����ֶ���Ϣ����Java���������Ϣ��varchar  username-->private String usernamey
	 * �Լ���Ӧ��set��get����
	 * 
	 * @param culumn
	 * @param convertor
	 * @return
	 */
	public static JavaFileSetGet creatJavaFileSetGetSRC(ColumnInfo column,TypeConvertor convertor) {
		JavaFileSetGet jfsg=new JavaFileSetGet();
		String javaFileType=convertor.databaseType2JavaType(column.getDataType());
		//�������Ե�Դ�룻
		jfsg.setFileInfo("\tprivate "+javaFileType+" "+column.getName()+";\n");//-->private int id;
		//����get()��Դ�룻
		StringBuilder getSrc=new StringBuilder();//public String getUsername(){return username;}
		getSrc.append("\tpublic "+javaFileType+" get"+StringUtils.fistChar2UpCase(column.getName()+"(){\n"));
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n");
		jfsg.setGetInfo(getSrc.toString());
		//public void setUsername(String username){this.username=username;}
		//����set()��Դ�룻
		StringBuilder setSrc=new StringBuilder();
		setSrc.append("\tpublic void"+" set"+StringUtils.fistChar2UpCase(column.getName()+"("));
		setSrc.append(javaFileType+" "+column.getName()+"){\n")	;
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n");
		jfsg.setSetInfo(setSrc.toString());
		return jfsg;
	}
	
	
	/**
	 * �������ݿ������java����Ϣ��
	 * @param table
	 * @param convertor
	 * @return
	 */
	public static String creatJavaSRC(TableInfo table,TypeConvertor convertor) {
		Map<String,ColumnInfo> columns=table.getColums();
		List<JavaFileSetGet> javaFiles=new ArrayList<JavaFileSetGet>();
		for(ColumnInfo c:columns.values()) {
			javaFiles.add(creatJavaFileSetGetSRC(c,convertor));
		}
		StringBuilder src=new StringBuilder();
		//package���
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//import���
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//���������
		src.append("public class "+StringUtils.fistChar2UpCase(table.getTname())+" {\n\n");
		//�����б�
		for(JavaFileSetGet f:javaFiles) {
			src.append(f.getFileInfo());
		}
		src.append("\n\n");
		//get()
		for(JavaFileSetGet f:javaFiles) {
			src.append(f.getGetInfo());
		}
		//set()
		for(JavaFileSetGet f:javaFiles) {
			src.append(f.getSetInfo());
		}
		
		//������
		src.append("\n}\n");
		//System.out.println(src);
		//System.out.println(javaFiles.size());
		
		return src.toString();
	}
	
	
	/**
	 * ��Java�ļ������ھ����PO�У���ʵ���ǰ�������java�ļ��ŵ�������ļ�·�����棩
	 * @param table
	 * @param convertor
	 */
	public static void creatJavaPOFile(TableInfo table,TypeConvertor convertor) {
		String src=creatJavaSRC(table,convertor);
		String srcPath=DBManager.getConf().getSrcPath()+"\\";//����src·����
		String packagePath=DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		
		File f=new File(srcPath+packagePath);
		if(!f.exists()) {//����û�û�н��ļ��У������Լ���һ����
			f.mkdirs();
		}
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(f.getAbsolutePath()+"/"+StringUtils.fistChar2UpCase(table.getTname())+".java"));
			bw.write(src);
			System.out.println("������"+table.getTname()+"��Ӧ��Java�ࣺ"+StringUtils.fistChar2UpCase(table.getTname())+" class!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		/*ColumnInfo ci=new ColumnInfo("id","int",0);
		JavaFileSetGet jfsg=creatJavaFileSetGetSRC(ci,new MysqlTypeConvertor());
		System.out.println(jfsg);
		*/
		Map<String,TableInfo> map=TableContext.getTableInfos();
		for(TableInfo t:map.values()) {
		creatJavaPOFile(t,new MysqlTypeConvertor());
		}
	}

}
