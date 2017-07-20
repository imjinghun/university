package first;
public class Client
{
	public static void main(String args[])
	{
		AbstractChatroom happyChat=new ChatGroup();
		
		Member m[]=new Member[5];
		m[0]=new DiamondMember("张三");
		m[1]=new DiamondMember("李四");
		m[2]=new DiamondMember("王五");
		m[3]=new CommonMember("小芳");	
		m[4]=new CommonMember("小红");
		
		for(int i=0;i<5;i++)
		{
			happyChat.register(m[i]);
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(i!=j&&i==0)
				{
					m[i].sendText(m[j].name, m[j].name+"，你好");
				}
				if(i!=j&&i==1)
				{
					m[i].sendImage(m[j].name,"一个很大很大的太阳");
				}
				if(i!=j&&i==2)
				{
					m[i].sendImage(m[j].name,"太阳");
				}
				if(i!=j&&i==3)
				{
					m[i].sendText(m[j].name,"今天天气不错，有日！");
				}
				if(i!=j&&i==4)
				{
					m[i].sendImage(m[j].name,"谢谢");
				}
			}
			System.out.println();
		}
		
	}
}