package Spl.HomeWork.Hw3;

import Spl.HomeWork.Hw3.Store.*;

import java.util.ArrayList;

public class Experiement 
{
	private int ID;
	private String Spec;
	private ArrayList<Integer> PreRequierments;
	private ArrayList<EquipItem> Items;
	private int RunTime;
	private int Reward;
	
	private int state;
	public static final int INCOMPLETE=356;
	public static final int INPROGRESS=666;
	public static final int COMPLETE=999;
	
	

	public Experiement(int iD, String spec, ArrayList<Integer> preRequierments,
			ArrayList<EquipItem> items, int runTime, int reward) {
		ID = iD;
		Spec = spec;
		PreRequierments = preRequierments;
		Items = items;
		RunTime = runTime;
		Reward = reward;
		state=0;
	}



	@Override
	public String toString() {
		String toString="Experiement: ID is-"+ ID+", Specialization is "+Spec+",\t PreRequirements are:";
		for(int i=0; i<PreRequierments.size();i++)
		{
			toString+= PreRequierments.get(i).toString()+" ";
		}
		
		toString+="\tItems Are: ";
		for(int i=0;i<Items.size();i++)
		{
			toString+=Items.get(i).getName()+ " ";
		}
		
		toString+= "\t Runtime: "+ RunTime+ " Reward: "+ Reward;
		
		return toString;
	}
	

	
}