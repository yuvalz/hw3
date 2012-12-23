package Spl.HomeWork.Hw3;

import Spl.HomeWork.Hw3.Store.*;

import java.util.Vector;

public class Experiement 
{
	int ID;
	String Spec;
	Vector<Integer> PreRequierments;
	Vector<EquipItem> Items;
	int RunTime;
	int Reward;
	

	
	public Experiement(int iD, String spec, Vector<Integer> preRequierments,
			Vector<EquipItem> items, int runTime, int reward) {
		ID = iD;
		Spec = spec;
		PreRequierments = preRequierments;
		Items = items;
		RunTime = runTime;
		Reward = reward;
	}



	@Override
	public String toString() {
		String toString="Experiement: ID is-"+ ID+", Specialization is "+Spec+", PreRequirements are:";
		for(int i=0; i<PreRequierments.size();i++)
		{
			
		}
		return toString;
	}
	

	
}