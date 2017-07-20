package first;

public class Client {
	
	public static void main(String[] args) {
		Mainframe mf=new Mainframe();
		try	
		{
			mf.on();
			System.out.println("启动成功");
		}
		catch(Exception e)
		{
			System.out.println("某一环节出错，启动失败");
		}
		
		
	}
}
