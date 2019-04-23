package pobj.motx.tme1.test;
import static org.junit.Assert.*;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
public class Test {

	public static void main(String[] args) {
		Grille gr = GrilleLoader.loadGrille("data/enonce.grl");
		System.out.println(gr.toString());
		GrillePlaces gp= new GrillePlaces(gr);
		System.out.println(gp.toString());
		System.out.println("nb de mots horizon "+gp.getNbHorizontal());
		System.out.println("nb de mots vertitaux "+gp.getNbVertical());
		for (int i = 0; i < gp.getPlaces().size(); i++) {
			System.out.println(gp.getPlaces().get(i).toString()+" "+gp.getPlaces().get(i).size());
		}
		
	}

}
