package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	List<Character> l;

	public EnsembleLettre() {
		l=new ArrayList<Character>();
	}
	public EnsembleLettre(List<Character> l) {
		this.l=l;
	}
	public void add(char c) {
		l.add(c);
	}
	public int size(){
		return l.size();
	}

	public boolean contains(Object o) {
		return l.contains(o);
	}
	public EnsembleLettre intersection(EnsembleLettre e2){
		List<Character> liste = new ArrayList<Character>();
		
		for(Character c1: l){
			if(e2.contains(c1)){
				liste.add(c1);
			}
		}
		return new EnsembleLettre(liste);
}

	

}
