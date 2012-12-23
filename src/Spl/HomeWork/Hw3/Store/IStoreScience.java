package Spl.HomeWork.Hw3.Store;

import java.util.Vector;

public interface IStoreScience 
{
	/**
	 * parsing and creating the labs object in the Store
	 * @pre countOfLab=0
	 * @pre labsFile!=null
	 * @post countOfLab>=0
	 * @param labsFile the file that will parse
	 */
	void parseLabs(String labsFile);
	
	/**
	 * pooling a Lab from the Store according to Index and maximal Cost
	 * @pre numOflab<countOfLab
	 * @pre boundedCost>=-1
	 * @post countOfLab()=@before.countOfLab-1
	 * @post return!=null
	 * @param numOfLab the index of the lab in the Store
	 * @param boundedCost the maximum cost that want to be afford
	 * @return the Lab needed 
	 */
	Lab buyLab(int numOfLab, int boundedCost);
	
	/**
	 * check if Lab with a specialization is exist in the store
	 * @pre specName!=null
	 * @pre numOfScientists>0
	 * @post countOfLab()=@before.countOfLab()
	 * @post return>0
	 * @post return<=numOfScientists()
	 * @param specName the Scientist specialization needed
	 * @param numOfScientists the amount of Scientists needed
	 * @return the amount of scientists founded
	 */
	int labExist(String specName, int numOfScientists);
	
	/**
	 * Getter for the amount of Labs in the Store
	 * @return amount of Labs exist in the store
	 */
	int countOfLabs();
	
	/**
	 * @pre newLab!=null
	 * @post countOfLab()=@before.countOfLab()+1
	 * @param newLab the Lab that will be added to the Labs
	 */
	void addLab(Lab newLab);
	
	/**
	 * Parsing the scientists file and creating the scientists that will be added to the Store
	 * @pre scienceFile!=null
	 * @pre countOfScientists()=0
	 * @post countOfScientists()>=0
	 * @param scienceFile the file that will be parse
	 */
	void parseScientists(String scienceFile);
	
	/**
	 * pooling the Scientist required by their specialization, amount and maximum cost
	 * @pre specName!=null
	 * @pre numOfScientists>0
	 * @pre boundedCost>-1
	 * @invariant numScientistsExists(!specName)=@before.numScientistsExists(!specName)
	 * @post numScientistsExists(specName)<@begin.numScientistsExists(specName)
	 * @param specName the specialization required
	 * @param numOfScientists number of scientists required
	 * @param boundedCost the maximum cost that wanted, if it's -1 there is no bound
	 * @return vector of Scientists according to the details 
	 */
	Vector<Scientist> buyScientists(String specName, int numOfScientists, int boundedCost);
	
	/**
	 * Getter for the amount of Scientists that special in specName
	 * @pre specNum!=null
	 * @post return>=0
	 * @post return<=countOfScientist()
	 * @param specName name of specialization 
	 * @return amount of specName Scientists
	 */
	int numScientistsExists(String specName);
	
	/**
	 * Adding a Scientist to the Store
	 * @pre newScientist!=null
	 * @post countOfScientists=@before.countOfScientists()
	 * @param newScientist
	 */
	void addScientist(Scientist newScientist);
	
	/**
	 * getter for the quantity of the Scientists available at the StoreScience
	 * @return count of all Scientists
	 */
	int countOfScientists();
	
	
	/**
	 * parsing and creating the packages of the Equipment
	 * @pre countOfPackages()=0
	 * @pre equipFile!=null
	 * @post countOfPAckages()>=0
	 * @param equipFile the file that will be parsing
	 */
	void parseEquip(String equipFile);
	
	/**
	 * pooling the right packages that including all the items in the pack if the total
	 * amount is less than boundedCost or without limit if the boundedCost is -1
	 * @pre pack!=null
	 * @pre boundedCost>-1
	 * @post countOfPackages()<=@before.countOfPackages()
	 * @post return.size()<=pack.size()
	 * @param pack all the items that needed
	 * @param boundedCost the maximum cost that wanted or -1 if the cost is not limited
	 * @return the appropriate packages
	 */ 
	Vector<EquipPackage> buyPackage(EquipPackage pack, int boundedCost);
	
	/**
	 * adding a new Package to the store
	 * @pre pack!=null
	 * @post countOfPackages()=@begin.countOfPackages()+1 
	 * @param pack the pack that want to be add
	 */
	void addEquip(EquipPackage pack);

	/**
	 * Getter for the amount of Packages exist in the Lab
	 * @return amount of Packages exist in the Store
	 */
	int countOfPackages();
	
	

}
