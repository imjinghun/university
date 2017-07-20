package first;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CiFaSMQ {
	
	public static void main(String[] args)
	{
		
		String strS="";
		File file = new File("src/1.txt");
        Reader reader = null;
        try {
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                	strS+=(char) tempchar;
                }
            }
            reader.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        int index=0;
        strS=strS.trim();
		int length=strS.length();
		char ch1=strS.charAt(index);
		
		while(index<length)
		{
			if(ch1==' ')
			{
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
			if((ch1>='a'&&ch1<='z')||(ch1>='A'&&ch1<='Z'))
			{
				String sp="";
				while((ch1>='a'&&ch1<='z')||(ch1>='A'&&ch1<='Z')||(ch1>='0'&&ch1<='9'))
				{
					sp+=ch1;
					index++;
					if(index<length)
					{
						ch1=strS.charAt(index);
					}
				}
				if(sp.equals("if")||sp.equals("int")||sp.equals("for")||sp.equals("while")||sp.equals("do")||
						sp.equals("return")||sp.equals("break")||sp.equals("continue"))
				{
					System.out.println("(1 , "+sp+")");
				}
				else
				{
					System.out.println("(2 , "+sp+")");
				}
			}
			if(ch1==' ')
			{
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
			if(ch1>='0'&&ch1<='9')
			{
				String sp="";
				while(ch1>='0'&&ch1<='9')
				{
					sp+=ch1;
					index++;
					if(index<length)
					{
						ch1=strS.charAt(index);
					}
				}
				System.out.println("(3 , "+sp+")");
			}
			if(ch1==' ')
			{
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
			if(ch1=='+'||ch1=='-'||ch1=='*'||ch1=='/'||ch1=='=')
			{
				System.out.println("(4 , "+ch1+")");
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
			if(ch1==' ')
			{
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
			if(ch1==','||ch1==':'||ch1=='{'||ch1=='}'||ch1=='('||ch1==')')
			{
				System.out.println("(5 , "+ch1+")");
				index++;
				if(index<length)
				{
					ch1=strS.charAt(index);
				}
			}
		}
	}
}
