package pobj.motx.tme2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) throws FileNotFoundException, IOException {
		this.grille=grille;
		this.dico=dicoComplet;
		motsPot= new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<IContrainte>();
		
		for (int i=0;i<grille.getPlaces().size();i++) {			//list emplacement
			int taille_motsI=grille.getPlaces().get(i).size();  //emplacement i taille(taille du mot)

			Dictionnaire dic=dicoComplet.copy();
			dic.filtreLongueur(taille_motsI);
			for (int j=0;j<taille_motsI;j++) {    
				Case c=grille.getPlaces().get(i).getL().get(j);	//emplacement i. lettre j
				if (!(c.isPleine() || c.isVide())) 
				   dic.filtreParLettre(c.getChar(), j);
			
			}
			motsPot.add(dic);
		}
		DetectContraintes();
		this.propage();
		System.out.println(contraintes);

		
	}
	public void enleverMots() {
	for (IContrainte c: contraintes) {
			
		}
	}
	public GrillePlaces getGrille() {
		return grille;
	}


	public void setGrille(GrillePlaces grille) {
		this.grille = grille;
	}

	public Dictionnaire getDico() {
		return dico;
	}

	public void setDico(Dictionnaire dico) {
		this.dico = dico;
	}

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public void setMotsPot(List<Dictionnaire> motsPot) {
		this.motsPot = motsPot;
	}

	public boolean isDead() {
		for (int i=0; i<motsPot.size(); i++){
			if(motsPot.get(i).size()==0) {
				return true;
			}
		}
		return false;
	}
	public void DetectContraintes() {

		int cpt1=0;
		int cpt2=0;
		for (int i=0;i<grille.getNbHorizontal();i++ ) {
			Emplacement mot1=grille.getPlaces().get(i);
			for( int j = grille.getNbHorizontal() ; j < grille.getPlaces().size() ; j++ ){
				Emplacement	mot2= grille.getPlaces().get(j);
				// on parcour les deux emplacemnet
				for( Case c1:mot1.getL()) {
					
					for( Case c2:mot2.getL()) {
						
						if (c1.getLig()==c2.getLig() && c1.getCol()==c2.getCol()
								&& c1.isVide() && c2.isVide()) {
							contraintes.add(new CroixContrainte(i,cpt1,j,cpt2));

						}
						cpt2++;
					}
					cpt1++;
					cpt2=0;
				}
				cpt1=0;
			}
			
		}
	}
	public GrillePotentiel fixer(int m, String soluce) throws FileNotFoundException, IOException {
		GrillePlaces g = this.grille.fixer(m, soluce);
		GrillePotentiel gp=new GrillePotentiel(g,this.getDico());
		return gp;
	}

	public List<IContrainte> getContraintes() {
		return contraintes;
	}

	public void setContraintes(List<IContrainte> contraintes) {
		this.contraintes = contraintes;
	}
	private boolean propage() {
		int mE;
		while(true){
			mE=0;
			System.out.println(mE);
			for(int i=0;i<contraintes.size();i++){
				mE+=contraintes.get(i).reduce(this);
			}
			if(this.isDead()) 
				return false;
			if(mE==0) 
				return true;
		}
		
	}


}
