package Spl.HomeWork.Hw3;

import java.io.*;
import java.util.*;
import java.util.Vector;

import Spl.HomeWork.Hw3.Store.EquipItem;
import Spl.HomeWork.Hw3.Store.EquipPackage;

public class Driver {
	
	final static int MAX_PREREQUIRE= 10;
	final static int MAX_ITEMS=10;
	final static int MAX_EXPERIEMENTS=10;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		try{
			Vector<Experiement> experiements= storeParsing("ExperimentsList.txt");	
			for(int i=0; i<4;i++)
				System.out.println(experiements.elementAt(i));
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		

	}
	

	
	  public static final Vector<Experiement> storeParsing(String fFile) throws FileNotFoundException {
		Vector<Experiement> storeExperiements= new Vector<Experiement>(10);
	    Scanner scanner = new Scanner(new FileReader(fFile));
	    try {
	      //first use a Scanner to get each line
	      while ( scanner.hasNextLine() ){
	        Vector<String> storeVector= processLine( scanner.nextLine(), "\t", 6 );
	        
	        Vector<String> preRequireVector= processLine(storeVector.elementAt(1), " ", MAX_PREREQUIRE);
	        Vector<Integer> preRequireIntVector= new Vector<Integer>(preRequireVector.size());
	        for(Iterator<String> preIt= preRequireVector.iterator(); preIt.hasNext();)
	        {
	        	preRequireIntVector.add(new Integer(Integer.parseInt(preIt.next())));
	        }
	        
	        Vector<String> itemsVector= processLine(storeVector.elementAt(3)," ", MAX_ITEMS);
	        Vector<EquipItem> storeItems= new Vector<EquipItem>(itemsVector.size());
	        for(Iterator<String> itemsIt= itemsVector.iterator(); itemsIt.hasNext();)
	        {
	        	Vector<String> item=processLine(itemsIt.next(),",",2);
	        	storeItems.add(new EquipItem(item.elementAt(0).toString(),Integer.parseInt(item.elementAt(1))));
	        }
	        
	        storeExperiements.add(new Experiement(Integer.parseInt(storeVector.elementAt(0)), storeVector.elementAt(2), preRequireIntVector,
	        		storeItems, Integer.parseInt(storeVector.elementAt(4)), Integer.parseInt(storeVector.elementAt(5)) ));
	      }
	    }
	    finally {
	      scanner.close();
	    }
	    
	      return storeExperiements;
	  }
	  
	
	  private static Vector<String> processLine(String line, String delimiter, int size){
	    //use a second Scanner to parse the content of each line 
	    Scanner scanner = new Scanner(line);
	    scanner.useDelimiter(delimiter);
	    Vector<String> container=new Vector<String>(size);
	    while ( scanner.hasNext() ){
	      String name = scanner.next();
	      container.add(name);
	    }
	    return container;
	  }
	  

}
