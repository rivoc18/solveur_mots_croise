package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces  {
	List<Emplacement> places;
	int nbHorizontal;
	int nbVertical;
	Grille grille;
	public GrillePlaces(Grille grille) {
		this.grille=grille;
		this.nbHorizontal=0;
		this.nbVertical=0;
		places= new ArrayList<Emplacement>();
		
		//cherche mots horizontaux
		for(int i=0; i<grille.nbLig(); i++) {
			for(int j=0; j<grille.nbCol(); j++) {
				if(!grille.getCase(i,j).isPleine()
						&& j+1<grille.nbCol()
						&& !grille.getCase(i,j+1).isPleine()){
					Emplacement e=new Emplacement();
					// si la case suivantes est une lettre alors la taillle
						//du mots est >2 donc ont le stock dans la liste
					while (	j<grille.nbCol()
							&& !grille.getCase(i,j).isPleine()
							) {
						e.getL().add(grille.getCase(i, j));

						j++;
					}

					places.add(e);
					nbHorizontal++;
				}
			}
		}
		
		// cherche mots verticaux
		for(int j=0; j<grille.nbCol(); j++) {
			for(int i=0; i<grille.nbLig(); i++) {


				if(!grille.getCase(i,j).isPleine()
						&& i+1<grille.nbLig()
						&& !grille.getCase(i+1,j).isPleine()){

					Emplacement e=new Emplacement();
					// si la case suivantes est une lettre alors la taillle
					//du mots est >2 donc ont le stock dans la liste
					while (	i<grille.nbLig()
							&& !grille.getCase(i,j).isPleine()
							) {
						e.getL().add(grille.getCase(i, j));

						i++;
					}

					places.add(e);
					nbVertical++;
				}
			}
		}
		
	}
	public List<Emplacement> getPlaces() {
		return places;
	}
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	public int getNbVertical() {
		return places.size()-nbHorizontal;
	}
	public String toString() {
		String s="";
		for (Emplacement elt:places) {
			for(Case elt2:elt.getL()) {
				s=s+" "+elt2.getChar();
			}
			s=s+"\n";
		}
		return s;
	}
	public GrillePlaces fixer(int m, String soluce) {
		Grille g=this.grille.copy();					//copie de grille
		GrillePlaces gp = new GrillePlaces(g);			//nouvelle grillepot a partir de la copie
		Emplacement e = gp.getPlaces().get(m);			//mot où la place est utilisée
		for (int i=0; i<e.getL().size();i++) {		
			e.getL().get(i).setChar(soluce.charAt(i));
		}
		return gp;
	}
	
	
}

