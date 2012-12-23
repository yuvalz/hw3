package Spl.HomeWork.Hw3;

import Spl.HomeWork.Hw3.Store.*;

import java.util.ArrayList;

public class Statistics {
	
	private int Budget;
	private int moneyGained;
	private int moneySpent;
	private ArrayList<Scientist> purchasedScientists;
	private ArrayList<EquipPackage> purchasedEquipPackage;
	private ArrayList<Lab> labsPurchased;
	private ArrayList<Experiement> completedExperiements;
	
	public Statistics(int budget) {
		super();
		Budget = budget;
		this.moneyGained = 0;
		this.moneySpent = 0;
		this.purchasedScientists=new ArrayList<Scientist>();
		this.labsPurchased=new ArrayList<Lab>(0);
		this.completedExperiements=new ArrayList<Experiement>(0);
	}
	
	
}
