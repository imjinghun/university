package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
	String id,name;
	int age;
	public Student(){}
	public Student(String name,String id,int age)
	{
		this.name=name;
		this.id=id;
		this.age=age;
	}
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public ArrayList<Student> sSortup()
	{
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(new Student("张三","20142803",22));
		list.add(new Student("李四","20142802",20));
		list.add(new Student("王五","20142801",21));
		list.add(new Student("赵六","20142804",21));
		
		System.out.println("原排列");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getName()+" "+list.get(i).getId()+" "+list.get(i).getAge());
		}
		System.out.println("-----------------------------------------------------");
		Collections.sort(list, new Comparator<Student>(){
			public int compare(Student o1, Student o2){
				Student stu1=o1;
				Student stu2=o2;
	            return stu1.getId().compareTo(stu2.getId());
			}
		}) ; 
		return list;
	}
}
