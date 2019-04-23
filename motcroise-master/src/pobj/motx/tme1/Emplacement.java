package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement  {
	private ArrayList<Case> l;
	public Emplacement() {
		this.l = new ArrayList<Case>();
	}
	
	public String toString() {
		String s= "";
		for (Case elt:l) {
			s+=elt.getChar();
			
		}
		return s;
	}
	
	public int size() {
		return l.size();
	}
	public ArrayList<Case> getL() {
		return l;
	}

	public void setL(ArrayList<Case> l) {
		this.l = l;
	}


	
	
	
}
