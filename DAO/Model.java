package DAO;

public class Model {
	private String name,password;
	private int rollno;
	public Model(int rollno,String name,String password)
	{
		this.rollno=rollno;
		this.name=name;
		this.password=password;
	}
	public int getrollno()
	{
		return rollno;
	}
	public String getname()
	{
		return name;
	}
	public String getpass()
	{
		return password;
	}
}
