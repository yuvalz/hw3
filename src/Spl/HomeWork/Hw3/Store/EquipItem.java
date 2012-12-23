package Spl.HomeWork.Hw3.Store;

public class EquipItem
{
	String Name;
	int NumOfItems;
	int TotalCost;
	
	public EquipItem(String Name, int NumOfItems, int TotalCost)
	{
		this.Name=Name;
		this.NumOfItems=NumOfItems;
		this.TotalCost=TotalCost;
	}
	
	public EquipItem(String Name, int NumOfItems)
	{
		this(Name,NumOfItems, 0);
	}
}
