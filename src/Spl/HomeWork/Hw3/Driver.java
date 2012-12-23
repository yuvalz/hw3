package Spl.HomeWork.Hw3;

import java.io.*;
import java.util.*;

import Spl.HomeWork.Hw3.Store.EquipItem;
import Spl.HomeWork.Hw3.Store.EquipPackage;
import Spl.HomeWork.Hw3.Store.Lab;
import Spl.HomeWork.Hw3.Store.Scientist;
import Spl.HomeWork.Hw3.Store.StoreScience;

public class Driver {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//To-DO change the name of the files to args[1]
		try{
			ArrayList<Experiement> experiements= experimentsParsing("ExperimentsList.txt");	
			ArrayList<EquipItem> equipForSale= equipParsing("EquipmentForSale.txt");
			ArrayList<Scientist> scientistsForSale= scientistsParsing("ScientistsForPurchase.txt");
			ArrayList<Lab> labForSale= labsParsing("LaboratoriesForSale.txt");
			//I need to change all of the aboce to the interface of the store
			StoreScience store= new StoreScience();//////////////////////////
			
			ArrayList<HeadOfLab> headOfLabs=new ArrayList<HeadOfLab>();
			ArrayList<SyncItem> repoItems=new ArrayList<SyncItem>();
			int budget=0;
			Repository repo= new Repository();
			initParsing("InitialData.txt", budget, repo, headOfLabs);
			Statistics stat= new Statistics(budget);
			
			
			ChiefScientist chief=new ChiefScientist(experiements, headOfLabs, stat, store, repo );
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		

	}
	
	/**
	 * Parsing the initial file
	 * @param fFile the file that will be parse
	 * @param budget will be the init budget
	 * @param repo wiil be all the repository Items
	 * @param headOfLabs will be all the Head of Labs
	 * @throws FileNotFoundException
	 */
	private static void initParsing(String fFile, int budget, Repository repo, ArrayList<HeadOfLab> headOfLabs ) throws FileNotFoundException
	{
		 Scanner scanner = new Scanner(new BufferedReader (new FileReader(fFile)));
		 String str;
		 boolean firstLoop=true;
		 try{
			 scanner.nextLine();
			 budget=Integer.parseInt(scanner.nextLine());
			 scanner.nextLine();
			 while(scanner.hasNext()&& firstLoop)
			 {
				 str=scanner.nextLine();
				 if(!str.equals("Laboratories")){
					ArrayList<String> tempList= processLine(str, "\t");
				 	repo.addItem(tempList.get(0),Integer.parseInt(tempList.get(1)));
				 }
				 else{
					 firstLoop=false;
				 }
			 }
			 while(scanner.hasNext())
			 {
					ArrayList<String> tempList= processLine(scanner.nextLine(), "\t");
				 	headOfLabs.add(new HeadOfLab(new Lab(tempList.get(0), tempList.get(1),Integer.parseInt(tempList.get(2)), 0) ));
			 }
		 }
		 finally{
			 scanner.close();
		 }
	}
	

	/**
	 * Parsing the Lab File
	 * @param fFile the lab file
	 * @return ArrayList of all the Labs
	 * @throws FileNotFoundException
	 */
	private static ArrayList<Lab> labsParsing(String fFile) throws FileNotFoundException
	{
		ArrayList<Lab> labs= new ArrayList<Lab>();
	    Scanner scanner = new Scanner(new BufferedReader (new FileReader(fFile)));
	    try{
	    	while (scanner.hasNextLine())
	    	{
	    		ArrayList<String> tempList= processLine(scanner.nextLine(),	"\t");
	    		labs.add(new Lab(tempList.get(0), tempList.get(1), Integer.parseInt(tempList.get(2)), Integer.parseInt(tempList.get(3)) ) );
	    	}
	    }
	    finally{
	    	scanner.close();
	    }
	    return labs;
	}
	
	/**
	 * Parsing the Equipment File
	 * @param fFile the equipment file
	 * @return ArrayList of all the Equipments
	 * @throws FileNotFoundException
	 */
	private static ArrayList<Scientist> scientistsParsing(String fFile) throws FileNotFoundException
	{
		ArrayList<Scientist> scientists= new ArrayList<Scientist>();
	    Scanner scanner = new Scanner(new BufferedReader (new FileReader(fFile)));
	    try{
	    	while (scanner.hasNextLine())
	    	{
	    		ArrayList<String> tempList= processLine(scanner.nextLine(),	"\t");
	    		scientists.add(new Scientist(tempList.get(0), tempList.get(1), Integer.parseInt(tempList.get(2)) ) );
	    	}
	    }
	    finally{
	    	scanner.close();
	    }
	    return scientists;
	}
	
	/**
	 * Parsing the Equipment File
	 * @param fFile the equipment file
	 * @return ArrayList of all the Equipments
	 * @throws FileNotFoundException
	 */
	private static ArrayList<EquipItem> equipParsing(String fFile) throws FileNotFoundException
	{
		ArrayList<EquipItem> equip= new ArrayList<EquipItem>();
	    Scanner scanner = new Scanner(new BufferedReader (new FileReader(fFile)));
	    try{
	    	while (scanner.hasNextLine())
	    	{
	    		ArrayList<String> tempList= processLine(scanner.nextLine(),	"\t");
	    		equip.add(new EquipItem(tempList.get(0),Integer.parseInt(tempList.get(1)), Integer.parseInt(tempList.get(2))));
	    	}
	    }
	    finally{
	    	scanner.close();
	    }
	    return equip;
	}
	
	/**
	 * Parsing the experiments file
	 * @param fFile the experiments file
	 * @return ArrayList of all the Experiments
	 * @throws FileNotFoundException 
	 */
	  private static ArrayList<Experiement> experimentsParsing(String fFile) throws FileNotFoundException 
	  {
		ArrayList<Experiement> storeExperiements= new ArrayList<Experiement>();
	    Scanner scanner = new Scanner(new BufferedReader (new FileReader(fFile)));
	    try {
	      while ( scanner.hasNextLine() ){
	    	ArrayList<String> storeList= processLine( scanner.nextLine(), "\t" );
	        
	    	ArrayList<String> preRequireList= processLine(storeList.get(1), " ");
	    	ArrayList<Integer> preRequireIntList= new ArrayList<Integer>();
	        for(String str: preRequireList)
	        {
	        	preRequireIntList.add(new Integer(Integer.parseInt(str)));
	        }
	        
	        ArrayList<String> itemsList= processLine(storeList.get(3)," ");
	        ArrayList<EquipItem> equipList= new ArrayList<EquipItem>();
	        for(String str: itemsList)
	        {
	        	ArrayList<String> item=processLine(str,",");
	        	equipList.add(new EquipItem(item.get(0).toString(),Integer.parseInt(item.get(1))));
	        }
	        
	        storeExperiements.add(new Experiement(Integer.parseInt(storeList.get(0)), storeList.get(2), preRequireIntList,
	        		equipList, Integer.parseInt(storeList.get(4)), Integer.parseInt(storeList.get(5)) ));
	      }
	    }
	    finally {
	      scanner.close();
	    }
	    
	      return storeExperiements;
	  }
	  
	/**
	 * parsing the given line by the delimiter
	 * @param line the line that will be parsing
	 * @param delimiter the parse will be according this delimiter
	 * @return the parsed Vector of Strings
	 */
	  private static ArrayList<String> processLine(String line, String delimiter){
	    //use a second Scanner to parse the content of each line 
	    Scanner scanner = new Scanner(line);
	    scanner.useDelimiter(delimiter);
	    ArrayList<String> container=new ArrayList<String>();
	    while ( scanner.hasNext() ){
	      String name = scanner.next();
	      container.add(name);
	    }
	    scanner.close();
	    return container;
	  }
	  

}
