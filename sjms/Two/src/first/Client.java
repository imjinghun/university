package first;

public class Client {

	public static void main(String[] args) {
		try
        {
        	Human human;
        	String sex=XMLUtilHuman.getSex();
        	human=NvWa.MakePeople(sex);
        	human.make();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}

}
