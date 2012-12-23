package Spl.HomeWork.Hw3;

public class SyncItem
{
	String Name;
	int amount;
	
	public SyncItem(String Name, int amount)
	{
		this.Name=Name;
		this.amount=amount;
	}
	
	
	
	/**
	 * Getter for the Name of the Equipment
	 * @return the name of the equipment
	 */
	public final String getName()
	{
		return Name;
	}


	/**
	 * Adding couple of items with the same name
	 * @param quantity the amount of items were add
	 */
	public synchronized void addQuantity(int quantity)
	{
		if(quantity>=0)
			amount+=quantity;
	}



	@Override
	public String toString() {
		return "SyncItem [Name=" + Name + ", amount=" + amount + "]";
	}
	
	
	
}