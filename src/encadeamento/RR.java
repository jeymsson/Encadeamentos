package encadeamento;

import includes.Funcoes;
import includes.Lista;

public class RR {

	Funcoes func;
	Lista cores;
	Lista Priori0;
	Lista Priori1;
	Lista Priori2;
	Lista Priori3;
	static int numCores = 0, numProcs;
	
	public static int getNumCores() {
		return numCores;
	}
	public void setNumCores(int numCores) {
		this.numCores = numCores;
	}
	public static int getNumProcs() {
		return numProcs;
	}
	public static void setNumProcs(int numProcs) {
		RR.numProcs = numProcs;
	}
	
	public RR(int numCores, int numProcs) {
		// TODO Auto-generated constructor stub
		func = new Funcoes();
		cores = new Lista();
		
		setNumCores(numCores);
		setNumProcs(numProcs);
		
		Lista temp = new Lista();
		temp.populaLista(getNumProcs(), true);
		Priori0 = temp.retornaPriori(0);
		Priori1 = temp.retornaPriori(1);
		Priori2 = temp.retornaPriori(2);
		Priori3 = temp.retornaPriori(3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciaRoundRobin();
	}

	private static void iniciaRoundRobin() {
		// TODO Auto-generated method stub
		
		
		
	}

}
