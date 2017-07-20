package first;

import java.util.HashMap;  

public class Suanfa {  
  public String [][]str;  
   static String FIRSRVTstring="";  
   static String LASTVTstring="";  
     boolean isOP=true;  
     Suanfa(String[][] ll){  
       str=ll;  
   }  
   //求FIRSTVT  
   String [][] getFirstVT(){  
       String[][] FirstVT = new String[2][str[0].length];  
           for(int i=0;i<str[0].length;i++){  
           FirstVT[0][i]=str[0][i];  
           getFVT(str[0][i],str[1][i]);  
           FirstVT[1][i]=FIRSRVTstring;  
           FIRSRVTstring="";  
       }  
       return FirstVT;  
   }  
   //获取非终结符放到NT数组中  
       String[] getNT(){  
       //String [][] Follow=getFollow();  
           String[] NT=new String[str[0].length];  
           for(int i=0;i<str[0].length;i++){  
               NT[i]=str[0][i];  
           }  
           return NT;  
       }  
   //获取终结符  放到T数组中  
   String[] getT(){  
       String[] NT1 = getNT();  
       String temp=new String();  
       for(int i=0;i<str[1].length;i++){  
           temp=temp+str[1][i];  
       }  
       for(int i=0;i<NT1.length;i++){  
           temp=temp.replaceAll(NT1[i],"");  
       }  
       temp=temp.replaceAll("\\|","");  
       temp=temp.replaceAll("\\'","");   
       char[] ch=new char[temp.length()];  
       ch=temp.toCharArray();  
         
       String resultString = new String();  
       for(int i=0;i<ch.length;i++){  
           if(!resultString.contains(String.valueOf(ch[i])))  
                   resultString=resultString.concat(String.valueOf(ch[i]));  
       }  
       String[] T=new String[resultString.length()+1];  
       T[resultString.length()]="#";  
       for(int i=0;i<resultString.length();i++){  
       T[i]=(String)String.valueOf(resultString.charAt(i));  
       }  
       return T;  
   }  
   //递归  
   void getFVT(String str3 ,String str4){  
       String[] s =null;  
       if(str4.contains("|")){  
            s=str4.split("\\|");  
        for(int j=0;j<s.length;j++){  
           getFVT(str3,s[j]);  
         }  
       }  
        else{  
   //*str4的长度为1  
        if(str4.length()==1){//*str4的长度为1且为终结符的时候直接加入  
            if(!('A'<=str4.charAt(0)&&str4.charAt(0)<='Z')){  
                if(!FIRSRVTstring.contains(String.valueOf(str4.charAt(0))))  
               FIRSRVTstring=FIRSRVTstring.concat(String.valueOf(str4.charAt(0)));  
            }  
   //*str4的长度为1且为非终结符，此时应查找其str[2][]中str[0][i]为str4的右边表达式getFVT(str[1][i])  
            else{        
                   for(int i=0;i<str[0].length;i++){  
                      if(str[0][i].equals(String.valueOf(str4.charAt(0)))){  
                       if(!str3.equals(String.valueOf(str4.charAt(0))))  
                       getFVT(str[0][i],str[1][i]);  
                      }  
                   }  
               }  
        }  
   //*str4的长度大于2  
       if(str4.length()>=2){  
           //第一个为终结符时  
             if(!('A'<=str4.charAt(0)&&str4.charAt(0)<='Z')){  
                 if(!FIRSRVTstring.contains(String.valueOf(str4.charAt(0))))  
                   FIRSRVTstring=FIRSRVTstring.concat(String.valueOf(str4.charAt(0)));  
               }  
           //第一个非终结符且第二个为终结符  
             if('A'<=str4.charAt(0)&&str4.charAt(0)<='Z'&&!('A'<=str4.charAt(1)&&str4.charAt(1)<='Z')){  
                 //先加入这个终结符号  
                 if(!FIRSRVTstring.contains(String.valueOf(str4.charAt(1))))  
                 FIRSRVTstring=FIRSRVTstring.concat(String.valueOf(str4.charAt(1)));  
                 //再循环查找这个非终极符的情况  
               //**找到第一个为终结符  
                  for(int i=0;i<str[0].length;i++){  
                      //if条件用于消除自身进行循环  
                       if(str[0][i].equals(String.valueOf(str4.charAt(0))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!str3.equals(String.valueOf(str4.charAt(0))))  
                           getFVT(str[0][i],str[1][i]);  
                       }  
             }  
           //第一个非终结符且第二个也为非终结符  
             if('A'<=str4.charAt(0)&&str4.charAt(0)<='Z'&&'A'<=str4.charAt(1)&&str4.charAt(1)<='Z'){  
                 for(int i=0;i<str[0].length;i++){  
                      //if条件用于消除自身进行循环  
                       if(str[0][i].equals(String.valueOf(str4.charAt(0))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!str3.equals(String.valueOf(str4.charAt(0))))  
                           getFVT(str[0][i],str[1][i]);  
                       if(str[0][i].equals(String.valueOf(str4.charAt(1))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!str3.equals(String.valueOf(str4.charAt(1))))  
                           getFVT(str[0][i],str[1][i]);  
                     
                       }  
                  }  
          }    
      }  
 }  
     
   //求LASTVT  
   String [][] getLastVT(){  
       String[][] LastVT = new String[2][str[0].length];  
           for(int i=0;i<str[0].length;i++){  
           LastVT[0][i]=str[0][i];  
           getLVT(str[0][i],str[1][i]);  
           LastVT[1][i]=LASTVTstring;  
           LASTVTstring="";  
       }  
       return LastVT;  
   }  
   //递归  
   private void getLVT(String string1, String string2) {  
       String[] s=null;  
       if(string2.contains("|")){  
            s=string2.split("\\|");  
         for(int j=0;j<s.length;j++){  
           getLVT(string1,s[j]);  
         }  
       }  
       else{  
       //*string2的长度为1  
            if(string2.length()==1){//*string2的长度为1且为终结符的时候直接加入  
                if(!('A'<=string2.charAt(0)&&string2.charAt(0)<='Z')){  
                    if(!LASTVTstring.contains(String.valueOf(string2.charAt(string2.length()-1))))  
                        LASTVTstring=LASTVTstring.concat(String.valueOf(string2.charAt(string2.length()-1)));  
                }  
       //*string2的长度为1且为非终结符，此时应查找其str[2][]中str[0][i]为string2的右边表达式getLVT(str[1][i])  
                else{        
                       for(int i=0;i<str[0].length;i++){  
                          if(str[0][i].equals(String.valueOf(string2.charAt(string2.length()-1)))){  
                           if(!string1.equals(String.valueOf(string2.charAt(string2.length()-1))))  
                           getLVT(str[0][i],str[1][i]);  
                          }  
                       }  
                   }  
            }  
       //*string2的长度大2      
   if(string2.length()>=2){  
           //当string2最后一个为终结符时  
           if(!('A'<=string2.charAt(string2.length()-1) && string2.charAt(string2.length()-1)<='Z')){  
               if(!LASTVTstring.contains(String.valueOf(string2.charAt(string2.length()-1))))  
                   LASTVTstring=LASTVTstring.concat(String.valueOf(string2.charAt(string2.length()-1)));  
           }  
             
           //当string2倒数第二个为终结符时且最后一个为非终结符时  
           if(('A'<=string2.charAt(string2.length()-1) && string2.charAt(string2.length()-1)<='Z')&&(!('A'<=string2.charAt(string2.length()-2) && string2.charAt(string2.length()-2)<='Z'))){    
               //将终结符加入  
               if(!LASTVTstring.contains(String.valueOf(string2.charAt(string2.length()-2))))  
                   LASTVTstring=LASTVTstring.concat(String.valueOf(string2.charAt(string2.length()-2)));  
               //循环中后一个非终结符加入  
                for(int i=0;i<str[0].length;i++){  
                      //if条件用于消除自身进行循环  
                       if(str[0][i].equals(String.valueOf(string2.charAt(string2.length()-1))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!string1.equals(String.valueOf(string2.charAt(string2.length()-1))))  
                           getLVT(str[0][i],str[1][i]);  
                       }  
           }  
           ////当string2倒数第二个为终结符时且最后一个也为终结符时  
            if(('A'<=string2.charAt(string2.length()-1) && string2.charAt(string2.length()-1)<='Z')&&('A'<=string2.charAt(string2.length()-2) && string2.charAt(string2.length()-2)<='Z')){  
                 for(int i=0;i<str[0].length;i++){  
                      //if条件用于消除自身进行循环  
                       if(str[0][i].equals(String.valueOf(string2.charAt(string2.length()-1))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!string1.equals(String.valueOf(string2.charAt(string2.length()-1))))  
                           getLVT(str[0][i],str[1][i]);  
                       if(str[0][i].equals(String.valueOf(string2.charAt(string2.length()-2))))//&&!str[0][i].equals(String.valueOf(str[1][i].charAt(0))))  
                           if(!string1.equals(String.valueOf(string2.charAt(string2.length()-2))))  
                           getLVT(str[0][i],str[1][i]);  
                       }  
               }  
           }  
       }     
   }  
   String[][] getMatrix(){  
        String[][] LastVT = getLastVT();  
        String[][] FirstVT = getFirstVT();  
        String[] T=getT();  
       String[][] op_matrix=new String[T.length][T.length];  
       //先找到形如A—>…ab…和A->…aBb…  相等关系 放入equal[][]数组中  
       HashMap<String,String> equal= new HashMap<String,String>();  
       equal.put("#","#");  
       for(int i=0;i<str[0].length;i++){  
           if(str[1][i].length()==2){  
               for(int j=0;j<str[1][i].length()-1;j++){  
                   if(!('A'<=str[1][i].charAt(j)&&str[1][i].charAt(j)<'Z')&&(str[1][i].charAt(j)!='|'&&str[1][i].charAt(j+1)!='|')&&!('A'<=str[1][i].charAt(j+1)&&str[1][i].charAt(j+1)<'Z')){  
                       equal.put(String.valueOf(str[1][i].charAt(j)),String.valueOf(str[1][i].charAt(j+1)));  
                   }     
               }  
           }  
           if(str[1][i].length()>=3){  
               for(int j=0;j<str[1][i].length()-2;j++){  
                   if((str[1][i].charAt(j+2)!='|'&&str[1][i].charAt(j+1)!='|'&&str[1][i].charAt(j)!='|')&&!('A'<=str[1][i].charAt(j+2)&&str[1][i].charAt(j+2)<'Z')&&!('A'<=str[1][i].charAt(j)&&str[1][i].charAt(j)<'Z')&&('A'<=str[1][i].charAt(j+1)&&str[1][i].charAt(j+1)<'Z')){  
                       equal.put(String.valueOf(str[1][i].charAt(j)),String.valueOf(str[1][i].charAt(j+2)));  
                   }     
               }  
           }  
        }  
       //再找到形如A->…aB…       小于关系   放入lessthan<String><String> HashTable中  
       HashMap<String,String> lessthan= new HashMap<String,String>();  
       lessthan.put("#",FirstVT[1][0]);  
       for(int i=0;i<str[0].length;i++){  
           if(str[1][i].length()>=2){  
               for(int j=0;j<str[1][i].length()-1;j++){  
               if(!('A'<=str[1][i].charAt(j)&&str[1][i].charAt(j)<='Z')&&str[1][i].charAt(j)!='|'&&('A'<=str[1][i].charAt(j+1)&&str[1][i].charAt(j+1)<='Z')){  
                   for(int k=0;k<str[1].length;k++){  
                       if(str[0][k].equals(String.valueOf(str[1][i].charAt(j+1))))  
                         lessthan.put(String.valueOf(str[1][i].charAt(j)),FirstVT[1][k]);  
                   }  
               }  
           }  
        }  
       }  
       //最后找到形如A->…Bb…    大于关系   放入 morethan[][]数组中  
       HashMap<String,String> morethan= new HashMap<String,String>();  
       morethan.put("#",LastVT[1][0]);  
       for(int i=0;i<str[0].length;i++){  
           if(str[1][i].length()>=2){  
               for(int j=0;j<str[1][i].length()-1;j++){  
               if(('A'<=str[1][i].charAt(j)&&str[1][i].charAt(j)<='Z')&&!('A'<=str[1][i].charAt(j+1)&&str[1][i].charAt(j+1)<='Z')&&str[1][i].charAt(j+1)!='|'){  
                   for(int k=0;k<str[1].length;k++){  
                       if(str[0][k].equals(String.valueOf(str[1][i].charAt(j))))  
                         morethan.put(String.valueOf(str[1][i].charAt(j+1)),LastVT[1][k]);  
                   }  
               }  
           }  
        }  
       }//将morethan转化为数组more中便于以下操作  
         Object[] str=morethan.keySet().toArray();  
         Object[] str1=morethan.values().toArray();  
         String[][] more=new String[2][morethan.size()];  
         for(int i=0;i<str.length;i++){  
             more[0][i]=str[i].toString();  
             more[1][i]=str1[i].toString();  
         }  
       //给二维数组赋初值-1,尚未发生关系  
       for(int i=0;i<T.length;i++){  
           for(int j=0;j<T.length;j++){  
               op_matrix[i][j]="\f";  
           }  
       }  
       //进行逻辑赋值       
       for(int i=0;i<T.length;i++){  
                 //查找eaual中两个相等关系符号在T中的位置  
                 if(equal.containsKey(T[i])){  
                     for(int j=0;j<T.length;j++){  
                     if(equal.get(T[i]).contains(T[j]))  
                         if (op_matrix[i][j]!=">"&&op_matrix[i][j]!="<")  
                         op_matrix[i][j]="=";  
                         else isOP=false;  
                    }    
               }     
         
               //查找lessthan中两个小于关系符号在T中的位置    
                     if(lessthan.containsKey(T[i])){  
                         for(int j=0;j<T.length;j++){  
                         if(lessthan.get(T[i]).contains(T[j]))  
                             if (op_matrix[i][j]!=">"&&op_matrix[i][j]!="=")  
                             op_matrix[i][j]="<";  
                             else isOP=false;  
                       }     
                     }  
                 // }    
              
               //查找morethan中两个小于关系符号在T中的位置        
            for(int k=0;k<more[0].length;k++){  
                   String temp=more[1][k];  
                         if(temp.contains(T[i])){  
                             for(int j=0;j<T.length;j++){  
                               if(more[0][k].contains(T[j]))  
                                   if (op_matrix[i][j]!="<"&&op_matrix[i][j]!="=")  
                                   op_matrix[i][j]=">";  
                                   else isOP=false;  
                            }    
                         }   
                       }  
                       
       }  
       return op_matrix;  
   }      
}  