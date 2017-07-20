package first;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		CaculatorForm form =new CaculatorForm();
		AbstractCommand command;
		command = new ConcreteCommand();
		form.setCommand(command);

		Scanner sca=new Scanner(System.in);
		int v[];
		int n;
		System.out.println("输入进行加法运算的个数");
		n=sca.nextInt();
		v=new int[n];
		System.out.println("输入进行加法运算的数值");
		for(int i=0;i<n;i++)
		{
			v[i]=sca.nextInt();
		}
		
		form.compute(v);
		form.undo();
		form.undo();
		form.undo();
		form.undo();
		form.undo();
		form.redo();
		form.redo();
		form.redo();
		form.redo();
		form.redo();
		
	}

}
