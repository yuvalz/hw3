package Spl.HomeWork.Hw3.Store;

import java.util.Vector;

public class EquipPackage 
{
	Vector<EquipItem> Items;
	
	/**
	 * Contructor
	 * @param size the size of the vector
 	 */
	public EquipPackage(int size)
	{
		Items= new Vector<EquipItem>(size);
	}
	
	/**
	 * Adding Item to the end of the vector
	 * @param item the item we want to add
	 */
	public void addItem(EquipItem item)
	{
		if(item!=null)
			Items.add(item);
	}
	
}
