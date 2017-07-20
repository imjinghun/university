package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SFFX {

	public static void main(String[] args) {
		SFFX sf=new SFFX();
		Scanner sca=new Scanner(System.in);
		
		System.out.println("输入文法规则数");
		int gzs=Integer.parseInt(sca.nextLine());
		
		System.out.println("输入文法规则");
		String gz[]=new String[gzs];
		
		for(int i=0;i<gzs;i++)
		{
			gz[i]=sca.nextLine();
			//判断是否是算符优先文法
			if(!sf.pdwf(gz[i]))
			{
				System.out.println("不是算符优先文法");
				return;
			}
		}
		System.out.println("是算符优先文法");
		//转换文法
		String gznew[]=sf.zhwf(gz);
		if(gznew.length>gz.length)
		{
			System.out.println("转换后的文法");
			for(int i=0;i<gznew.length;i++)
			{
				System.out.println(gznew[i]);
			}
		}
		//把文法数组换为二维
		String arrNT[]=new String[gzs];//非终结符数组  
        String arrT[]=new String[gzs];//终结符号数组  
		for(int i=0;i<gzs;i++){  
            String[] temp1;  
            temp1=gz[i].split("->");  
            arrNT[i]=temp1[0];  
            arrT[i]=temp1[1];  
        }
		
		 String[][] ll=new String[2][gzs];  
	        for(int i=0;i<gzs;i++){  
	            ll[0][i]=arrNT[i];  
	            ll[1][i]=arrT[i];  
	        }  
	        Suanfa fl=new Suanfa(ll);  
	       //求非终结符集
	        String[]NT = fl.getNT();  
	        System.out.println();  
	         System.out.print("非终结符集：");System.out.print("{");  
	         for(int i=0;i<NT.length;i++){   
	            if(NT.length-1==i)  
	                System.out.print(NT[i]);  
	            else  
	             System.out.print(NT[i]+",");  
	             }  
	         System.out.println("}");  
	       //求终结符集
	       String[]T = fl.getT();  
	       System.out.print("终结符集：");System.out.print("{");  
	        for(int i=0;i<T.length;i++){  
	           if(T.length-1 ==i)  
	               System.out.print(T[i]);  
	           else  
	        System.out.print(T[i]+",");     
	        }  
	        System.out.println("}");  
	        System.out.println(" ");  
	          
	          
	        //FIRSTVT求解过程  
	        String[][] FirstVT = fl.getFirstVT();  
	        System.out.println("FIRSTVT集：");  
	        //System.out.println(" LASTVT("+FirstVT[0][0]+"'"+")"+"="+"{"+"#"+"}");  
	        for(int i=0;i<FirstVT[0].length;i++){  
	             System.out.print(FirstVT[0][i]+":");  
	             char[] ch=FirstVT[1][i].toCharArray();  
	           for(int j=0;j<ch.length;j++){  
	               if(ch.length-1 ==j)  
	                   System.out.print(ch[j]);  
	               else System.out.print(ch[j]+" ");  
	           }  
	          System.out.println();  
	        }  
	        System.out.println(" ");  
	        //LASTVT求解过程  
	        String[][] LastVT = fl.getLastVT();  
	          
	        System.out.println("LASTVT集：");  
	       // System.out.println(LastVT[0][0]+"'"+")"+"="+"{"+"#"+"}");  
	        for(int i=0;i<LastVT[0].length;i++){  
	             System.out.print(LastVT[0][i]+":");  
	             char[] ch=LastVT[1][i].toCharArray();  
	           for(int j=0;j<ch.length;j++){  
	               if(ch.length-1 ==j)  
	                   System.out.print(ch[j]);  
	               else System.out.print(ch[j]+" ");  
	           }  
	          System.out.println();  
	        }  
	        System.out.println();  
	      //求解算符优先矩阵  
	        System.out.println("算符优先关系矩阵");  
	        System.out.println("-------------------------------------------------------------------");  
	        System.out.print("\t");  
	           for(int i=0;i<T.length;i++){  
	            System.out.print(T[i]+"\t");  
	            }  
	           System.out.println();  
	           System.out.println("-------------------------------------------------------------------");  
	  
	        String[][] Op=fl.getMatrix();  
	        for(int i=0;i<Op[0].length;i++){  
	            System.out.print(" "+T[i]);  
	            for(int j=0;j<Op[0].length;j++){  
	                System.out.print("\t"+Op[i][j]);  
	            }  
	            System.out.println();  
	            System.out.println("-------------------------------------------------------------------");  
	        }  
	        if(fl.isOP==false)System.out.print("此文法非算符优先文法");  
	        //分析句子  
	        Scanner sc=new Scanner(System.in);  
	        System.out.print("输入符号串以#结束");
	        String sentence =sc.next();  
	        char[] ch=sentence.toCharArray();  
	        //用于存放读入的语句  
	        ArrayList<String>  s=new ArrayList<String>();  
	        for(int i=0;i<ch.length;i++){  
	           s.add(String.valueOf(ch[i]));  
	        }  
	        //判断输入的符号串是否是本文法的终结符  
	        boolean isExisted=true;  
	        String NotExist="";  
	        String stringT="";  
	        for(int i=0;i<T.length;i++){  
	            stringT=stringT.concat(T[i]);  
	        }  
	      
	               for(int i=0;i<ch.length;i++){  
	                   if(!stringT.contains(String.valueOf(ch[i])))  
	                   { if(ch[i]!='#')  
	                       {isExisted=false;  
	                       NotExist= String.valueOf(ch[i]);  
	                       }  
	                   }  
	               }  
	        if(isExisted==false){  
	            System.out.print(NotExist+"不是此文法的的终极符");  
	        }  
	        else{  
	        ArrayList<String>  stack=new ArrayList<String>();  
	        stack.add("#");  
	        String temp =s.remove(0);  
	        ArrayList<String>  sentence_result=new ArrayList<String>();  
	        String s_result=new String();  
	        s_result=s_result.concat(stack+"\t"+temp+"\t"+s+"\t");  
	       boolean isSuccess=false;  
	       boolean isFailed=false;  
	        for(int k=0;k<ch.length;k++){  
	          for(int i=0;i<T.length;i++){  
	           if(T[i].equals(stack.get(stack.size()-1))){  
	               for(int j=0;j<T.length;j++){  
	                   if(T[j].equals(temp)){  
	                       if(Op[i][j].equals("<")){  
	                          s_result=s_result.concat("移近"); sentence_result.add(s_result);s_result="";  
	                          stack.add(temp);temp=s.remove(0);  
	                          s_result=s_result.concat(stack+"\t"+temp+"\t"+s+" \t");  
	                           
	                       }  
	                       else if(Op[i][j].equals(">")){  
	                          s_result=s_result.concat("规约"); sentence_result.add(s_result);s_result="";  
	                          if(stack.size()>1)  
	                          stack.remove(stack.get(stack.size()-1));  
	                          s_result=s_result.concat(stack+"\t"+temp+"\t"+s+"\t");  
	                       }  
	                       else if(stack.get(stack.size()-1)=="#"&&isSuccess==false){  
	                          s_result=s_result.concat("分析成功");isSuccess=true; sentence_result.add(s_result);  
	                       }  
	                       else if(isSuccess!=true&&isFailed==false){  
	                          s_result=s_result.concat("分析失败");isFailed=true; sentence_result.add(s_result);  
	                       }  
	                   }  
	               }  
	           }  
	             
	      }   
	    }   
	        for(int i=0;i<sentence_result.size();i++){  
	           System.out.print("("+(i+1)+")");  
	           System.out.print("\t");  
	           System.out.println(sentence_result.get(i));  
	        }  
	        }  
		
	}
	//判断是否是算符优先文法 是true 否false
	public boolean pdwf(String str)
	{
		String str1[]=str.split("->");
		char []ch=str1[1].toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(i>0&&i<ch.length-1)
			{
				if((ch[i]>'A'&&ch[i]<'Z')&&((ch[i-1]>'A'&&ch[i-1]<'Z')||(ch[i+1]>'A'&&ch[i+1]<'Z')))
				{
					return false;
				}
			}
		}
		return true;
	}
	//转换文法 返回文法数组
	public String[] zhwf(String str[])
	{
		List<String> list=new ArrayList<String>();  
		
		String temp[];
		for(int i=0;i<str.length;i++)
		{
			if(str[i].contains("|"))//当包含 | 时， 分割产生式
			{
				temp=str[i].split("[-> |]");//以->和|分割
				for(int k=2;k<temp.length;k++)
				{
					list.add(temp[0]+"->"+temp[k]);
				}
			}
		}
		String gz[]=new String[list.size()];
		for(int i=0;i<gz.length;i++)
		{
			gz[i]=(String)list.get(i);
		}
		//当不需要转换时 返回原文法
		if(gz.length==str.length||gz.length<str.length)
		{
			return str;
		}
		else
		{
			return gz;
		}
	}
}
