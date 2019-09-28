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
	
	//通过脚本修改JS对象，通过JS修改java内容；
	public static void test1() throws Exception {
		//获取脚本引擎对象；
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//定义变量，储存到引擎上下文中；
		engine.put("msg", "now is changing!");
		String str="var user= {name:'zhoufangyang',age:30};";
		str += "print(user.name);";
		
		//执行脚本；
		//zhoufangyang
		engine.eval(str);
		
		//在脚本中改变msg的值，然后在java中打印出来；
		//changing is now!
		engine.eval("msg='changing is now!'");
		System.out.println(engine.get("msg"));
	}
	//函数的定义；
	public static void test2() throws Exception { 
		//获取脚本引擎对象；
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
		//定义函数；
		engine.eval("function add(a,b){var sum=a+b; return sum;}");
		//执行JS函数；实现Invocable接口；
		Invocable jsInvoke=(Invocable) engine;
		//传递参数；
		Object result=jsInvoke.invokeFunction("add", new Object[]{3,2});
		//5.0
		System.out.println(result);
	}
	//导入其他java包，使用其他包中java类；有点小问题;
	//也可以调用指定位置的js文件；
	public static void test3() throws Exception { 
		//获取脚本引擎对象；
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
