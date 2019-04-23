package pobj.motx.tme1;

public class Grille   {
	private Case[][] tabcase;
	private int hauteur;
	private int largeur;
	public Grille(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		tabcase= new Case[hauteur][largeur];
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				tabcase[i][j]=new Case(i,j,' ');
			}
		}
	}
	
	public Case getCase(int lig, int col) {
		if(lig<hauteur && col<largeur
				&& lig>=0 && col >=0) {
			return tabcase[lig][col];
		}
		return null;
		
	}
	public String toString() {
		return GrilleLoader.serialize(this,false);
			
	}
	public int nbLig() {
		return hauteur;
	}
	
	public int nbCol() {
		return largeur;
	}
	
	public Grille copy() {
		Grille t = new Grille(this.nbLig(),this.nbCol());
		for (int i=0; i<this.nbLig(); i++) {
			for (int j=0; j<this.nbCol(); j++) {
				t.getCase(i,j).setChar(tabcase[i][j].getChar());
			}
		}
		return t;
	}
	
}
	
