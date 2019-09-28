import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Dome1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		//String str="";
		Deque stack=new LinkedList();//第一个栈
		int t=n;
		while(t>0) {
			int mod=t%2;
			stack.push(mod);//入栈
			//System.out.println(mod);
			//str=mod+str;//后更新的数值放在前面；先得到的数值，后 显示出来；
			t=t/2;
		}
		System.out.print(n+"-->");
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());//出栈
		}
		
	}
}
