package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class DicoVariable implements IVariable{
	private int indice;
	GrillePotentiel gp;
	public DicoVariable(int index,GrillePotentiel gp) {
		indice=index;
		this.gp=gp;
	}
	public List<String> getDomain() {
		// TODO Auto-generated method stub
		return null;
	}

}
