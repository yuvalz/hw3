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
	
	@Override
	public String toString()
	{
		return Name+ "\tQuantitiy: "+ NumOfItems+ "\tin Total Cost Of "+ TotalCost+ " NIS";
	}
	
	/**
	 * Getter for the Name of the Equipment
	 * @return the name of the equipment
	 */
	public String getName()
	{
		return Name;
	}


	/**
	 * Adding couple of items with the same name
	 * @param quantity the amount of items were add
	 */
	public void addQuantity(int quantity)
	{
		if(quantity>=0)
			NumOfItems+=quantity;
	}
	
}