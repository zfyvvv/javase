import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Dome1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		//String str="";
		Deque stack=new LinkedList();//��һ��ջ
		int t=n;
		while(t>0) {
			int mod=t%2;
			stack.push(mod);//��ջ
			//System.out.println(mod);
			//str=mod+str;//����µ���ֵ����ǰ�棻�ȵõ�����ֵ���� ��ʾ������
			t=t/2;
		}
		System.out.print(n+"-->");
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());//��ջ
		}
		
	}
}
