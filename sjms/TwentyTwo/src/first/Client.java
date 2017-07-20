package first;

public class Client
{
	public static void main(String args[])
	{
		Account account=new Account("张三",1000);
		account.withdraw(1000);
		System.out.println("--------------------------------------");
		account.withdraw(1000);
		System.out.println("--------------------------------------");
		account.withdraw(100);
		System.out.println("--------------------------------------");
		account.withdraw(100);
		System.out.println("--------------------------------------");
		account.deposit(80);
		System.out.println("--------------------------------------");
		account.deposit(150);
		System.out.println("--------------------------------------");
		account.deposit(1000);
		System.out.println("--------------------------------------");
		account.deposit(80);
		System.out.println("--------------------------------------");
	}
}
