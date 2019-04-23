package pobj.motx.tme1;

public class Case {
	private int ligne;
	private int colonne;
	private char c;
	
	public Case(int lig, int col, char c){
		ligne=lig;
		colonne=col;
		this.c=c;
	}

	public int getLig() {
		return ligne;
	}

	public int getCol() {
		return colonne;
	}

	public char getChar() {
		return c;
	}

	public void setChar(char c) {
		this.c = c;
	}
	
	public boolean isVide() {
		return(this.c==' ');
	}
	
	public boolean isPleine() {
		return(this.c=='*');
	}
	
	
	
}
