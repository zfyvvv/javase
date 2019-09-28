package cn.zhoufy.reflection.b;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test02 {
	public static void main(String[] args)throws Exception  {
		test3();
	}
	
	//ͨ���ű��޸�JS����ͨ��JS�޸�java���ݣ�
	public static void test1() throws Exception {
		//��ȡ�ű��������
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//������������浽�����������У�
		engine.put("msg", "now is changing!");
		String str="var user= {name:'zhoufangyang',age:30};";
		str += "print(user.name);";
		
		//ִ�нű���
		//zhoufangyang
		engine.eval(str);
		
		//�ڽű��иı�msg��ֵ��Ȼ����java�д�ӡ������
		//changing is now!
		engine.eval("msg='changing is now!'");
		System.out.println(engine.get("msg"));
	}
	//�����Ķ��壻
	public static void test2() throws Exception { 
		//��ȡ�ű��������
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//���庯����
		engine.eval("function add(a,b){var sum=a+b; return sum;}");
		//ִ��JS������ʵ��Invocable�ӿڣ�
		Invocable jsInvoke=(Invocable) engine;
		//���ݲ�����
		Object result=jsInvoke.invokeFunction("add", new Object[]{3,2});
		//5.0
		System.out.println(result);
	}
	//��������java����ʹ����������java�ࣻ�е�С����;
	//Ҳ���Ե���ָ��λ�õ�js�ļ���
	public static void test3() throws Exception { 
		//��ȡ�ű��������
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		
		String jscode="import Package(java.util); var list=Arrays.asList([\"mm\",\"hh\",\"ii\"])";
		engine.eval(jscode);
		List<String> list=(List<String>) engine.get("list");
		for(String temp:list) {
			System.out.println(temp);
		}
	}
}
