package Spl.HomeWork.Hw3;

import Spl.HomeWork.Hw3.Store.*;

import java.util.ArrayList;

public class Repository {
	private ArrayList<SyncItem> items;
	
	public Repository()
	{
		items= new ArrayList<SyncItem>();
	}
	
	/**
	 * Adding an item to the repository, if already exists- adding the quantity to the exist item 
	 * @param name the name of the item
	 * @param quantity the amount of items
	 */
	public void addItem(String name, int quantity)
	{
		for(SyncItem item: items)
		{
			if(item.getName()==name){
				item.addQuantity(quantity);
				return;
			}
		}
		items.add(new SyncItem(name, quantity));
	}
}
