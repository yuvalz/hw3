package Spl.HomeWork.Hw3.Store;

public class Lab 
{
	String HeadOfLab;
	String Spec;
	int NumOFScientist;
	int Cost;
	
	
	public Lab(String headOfLab, String spec, int numOFScientist, int cost) 
	{
		HeadOfLab = headOfLab;
		Spec = spec;
		NumOFScientist = numOFScientist;
		Cost = cost;
	}

	/**
	 * Add scientists to the Lab
	 * @param amount the amount of scientists will be add
	 */
	public void addScientists(int amount)
	{
		if(amount>0)
		{
			NumOFScientist+=amount;
		}
	}

	@Override
	public String toString() {
		return "Lab [HeadOfLab=" + HeadOfLab + ", Spec=" + Spec
				+ ", NumOFScientist=" + NumOFScientist + ", Cost=" + Cost + "]";
	}
}
