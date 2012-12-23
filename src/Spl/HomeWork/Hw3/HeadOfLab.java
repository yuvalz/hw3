package Spl.HomeWork.Hw3;

import Spl.HomeWork.Hw3.Store.*;

import java.util.ArrayList;

public class HeadOfLab {
	Lab lab;
	ArrayList<Experiement> experiements;
	
	
	public HeadOfLab(Lab lab) {
		this.lab = lab;
		this.experiements = new ArrayList<Experiement>();
	}


	@Override
	public String toString() {
		return "HeadOfLab [lab=" + lab + "]";
	}
	
	
	
}
