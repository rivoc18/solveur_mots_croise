package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;

public class CroixContrainte implements IContrainte {
	private int m1;
	private int c1;
	private int m2;
	private int c2;
	List<Character> c;
	
	

	public CroixContrainte(int m1, int c1, int m2, int c2) {
		c=new ArrayList<>();
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	
	@Override
	public int reduce(GrillePotentiel grille) {
		// TODO Auto-generated method stub
		EnsembleLettre l1=new EnsembleLettre();
		EnsembleLettre l2=new EnsembleLettre();
		EnsembleLettre s=new EnsembleLettre();
		
		//creation mots potentielle de l'emplacement m1/m2
		Dictionnaire dic1=grille.getMotsPot().get(m1);
		Dictionnaire dic2=grille.getMotsPot().get(m2);
		
		//creation des ensembles lettres à c1/c2
		
		for (String mots:dic1.getMots()) {
			l1.add(mots.charAt(c1));
		}
		for (String mots:dic2.getMots()) {
			l2.add(mots.charAt(c2));
		}
		

		s=l1.intersection(l2);
		//System.out.println("l1:"+l1.size()+" l2:"+l2.size()+" s:"+s.size());
		int nbmotsFiltre=0;
		//if(l1.size() > s.size()) {		
			nbmotsFiltre+=dic1.filtrerParEnsemble(c1, s);
		//}
		
		//if(l2.size() > s.size()) {		
			nbmotsFiltre+=dic2.filtrerParEnsemble(c2, s);
		//}


		//System.out.println("j'ai filter"+nbmotsFiltre+" mots");
		return nbmotsFiltre;
		
		


	}



	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CroixContrainte other = (CroixContrainte) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (c1 != other.c1)
			return false;
		if (c2 != other.c2)
			return false;
		if (m1 != other.m1)
			return false;
		if (m2 != other.m2)
			return false;
		return true;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

	public int getC1() {
		return c1;
	}

	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}

	public List<Character> getC() {
		return c;
	}

	public void setC(List<Character> c) {
		this.c = c;
	}

	
	

}
