package Spl.HomeWork.Hw3;


import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

import Spl.HomeWork.Hw3.Store.StoreScience;

public class ChiefScientist implements Observer  {
	ArrayList<Experiement> Experiements;
	ArrayList<HeadOfLab> headsOfLab;
	Statistics stat;
	StoreScience scienceStore;
	Repository repo;
	ChiefScientistAssistant assitant;
	
	
	@Override
	public void update(Observable obj, Object arg){
		
	}


	public ChiefScientist(ArrayList<Experiement> experiements,
			ArrayList<HeadOfLab> headsOfLab, Statistics stat,
			StoreScience scienceStore, Repository repo)
		{
		Experiements = experiements;
		this.headsOfLab = headsOfLab;
		this.stat = stat;
		this.scienceStore = scienceStore;
		this.repo = repo;
		this.assitant = new ChiefScientistAssistant();
	}
	
	
}
