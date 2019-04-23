package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

public class MotX implements ICSP{
	List<DicoVariable> l_dv;
	public MotX(GrillePotentiel gp) {
		l_dv= new ArrayList<>();
	}
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
