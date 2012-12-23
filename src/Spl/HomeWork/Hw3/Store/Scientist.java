package Spl.HomeWork.Hw3.Store;

public class Scientist 
{
	String Name;
	String Spec;
	int Cost;
	
	
	
	public Scientist(String name, String spec, int cost) 
	{
		Name = name;
		Spec = spec;
		Cost = cost;
	}



	@Override
	public String toString() {
		return "Scientist [Name=" + Name + ", Spec=" + Spec + ", Cost=" + Cost
				+ "]";
	}

}
