package first;

public class Main {

	public static void main(String[] args) {
		
		String TextLine = "a*a*a+a#";
		Inital init = new Inital();
		String Stack = "#S";
		
		String yishibie = "";
		int i = 0;
		while(true)
		{
			String StackTop = Stack.substring(Stack.length() - 1);
			String PresentChar = TextLine.substring(i,i+1);
			
			String Result = init.getResult(StackTop,PresentChar);
			if(i==0)
			{
				System.out.println("栈		输入		输出");
				System.out.println(Stack +"		"+TextLine.substring(yishibie.length())+"	"+StackTop+"→"+Result);
			}
			Stack = Stack.substring(0,Stack.length() - 1);
			
			for(int j = Result.length() - 1;j >= 0 ;j--)
			{
				Stack += Result.charAt(j);
			}
			if(Stack.substring(Stack.length() - 1).equals("ε"))
			{
				Stack = Stack.substring(0,Stack.length() - 1);
				System.out.println(Stack +"		"+TextLine.substring(yishibie.length())+"		"+StackTop+"→"+Result);
			}
			while(Stack.substring(Stack.length() - 1).equals(PresentChar))
			{
				Stack = Stack.substring(0,Stack.length() - 1);
				yishibie += PresentChar;
				i++;
				if(i<TextLine.length())
					PresentChar = TextLine.substring(i,i+1);
				if(Stack.length() - 1<0)
				{
					break;
				}
				System.out.println(Stack +"		"+TextLine.substring(yishibie.length())+"		"+StackTop+"→"+Result);
			}
			if(Stack.equals(""))
			{
				break;
			}
		}
	}
}
class Inital{
	String t[][]=new String[3][4];
	public Inital()
	{
		//初始化预测分析表
		for(int i=0;i<3;i++)
			for(int j=0;j<4;j++)
			{
				t[i][j]="";
			}
		t[0][2]="aTR";	
		t[1][0]="*aTR";
		t[1][3]="ε";
		t[2][0]="ε";
		t[2][1]="+aT";
		t[2][3]="ε";
	}
	public String getResult(String row,String col)
	{
		if(row.equals("S") && col.equals("a"))
		{
			return t[0][2];
		}
		else if(row.equals("R") && col.equals("*"))
		{
			return t[1][0];
		}
		else if(row.equals("R") && col.equals("#"))
		{
			return t[1][3];
		}
		else if(row.equals("T") && col.equals("*"))
		{
			return t[2][0];
		}
		else if(row.equals("T") && col.equals("+"))
		{
			return t[2][1];
		}
		else if(row.equals("T") && col.equals("#"))
		{
			return t[2][3];
		}
		System.out.print("不能匹配");
		System.exit(0);
		return "";
	}
}