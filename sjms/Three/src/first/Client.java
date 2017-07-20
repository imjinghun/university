package first;

public class Client {

	public static void main(String[] args) {
		try
        {
        	Human human;
        	NvWa sex;
        	sex=(NvWa)XMLUtil.getBean();
        	human=sex.MakePeople();
        	human.make();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}

}
