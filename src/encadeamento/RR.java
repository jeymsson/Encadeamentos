package encadeamento;

import includes.Funcoes;
import includes.Lista;
import includes.No;

public class RR {

	static private Funcoes func;
	static private Lista cores;

	static private Lista Priori0;
	static private Lista Priori1;
	static private Lista Priori2;
	static private Lista Priori3;
	static private int numCores = 0, numProcs;
	
	public Funcoes getFunc() {
		return func;
	}
	public static Lista getCores() {
		return cores;
	}
	public static Lista getPrioridade(int pri) {
		if (pri == 0) {
			return Priori0;
		} else if (pri == 1) {
			return Priori1;
		} else if (pri == 2) {
			return Priori2;
		} else if (pri == 3) {
			return Priori3;
		}
		return null;
	}
	public static Lista getPriori0() {
		return Priori0;
	}
	public static Lista getPriori1() {
		return Priori1;
	}
	public static Lista getPriori2() {
		return Priori2;
	}
	public static Lista getPriori3() {
		return Priori3;
	}
	
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
		cores.setNomeLista("Cores");
		
		
		cores.setDeadline(3);
		
		setNumCores(numCores);
		setNumProcs(numProcs);
		
		Lista temp = new Lista();
		temp.populaLista(getNumProcs(), true);
		System.out.println("-Processos iniciais-");
		temp.imprime();
		Priori0 = temp.retornaPriori(0);
		Priori1 = temp.retornaPriori(1);
		Priori2 = temp.retornaPriori(2);
		Priori3 = temp.retornaPriori(3);

		Priori0.setNomeLista("Prioridade 0");
		Priori1.setNomeLista("Prioridade 1");
		Priori2.setNomeLista("Prioridade 2");
		Priori3.setNomeLista("Prioridade 3");
		
		getPriori0().imprime();
		
		
		iniciaRoundRobin();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RR r = new RR(4, 48);
	}

	private static void iniciaRoundRobin() {
		// TODO Auto-generated method stub
		Lista pri;
		getCores().setAtivaLogs(false);
		// Inicializa cores
		if(0==0) {
			//System.out.println("Pri: "+Pri.getHead().getPriori());
			pri = getPriori0();
			Funcoes.repassaFila(getPriori0(), getCores(), 0);
			pri = getPriori1();
			Funcoes.repassaFila(getPriori1(), getCores(), 1);
			pri = getPriori2();
			Funcoes.repassaFila(getPriori2(), getCores(), 2);
			pri = getPriori3();
			Funcoes.repassaFila(getPriori3(), getCores(), 3);
		}
		
//		System.out.println("-><-");
//		System.out.println("Pri: "+ pri.getHead().getPriori());
//		System.out.println("-==-");
//		getCores().imprime();
//		System.out.println("----");
		
		
		No temp;
		getCores().imprime();
		Funcoes.waitSec(1);
		System.out.println("----------------");
		
		while (	!getCores().isEmpty() &&
				(
					!getPriori0().isEmpty() ||
					!getPriori1().isEmpty() ||
					!getPriori2().isEmpty() ||
					!getPriori3().isEmpty()
				)
		) {
			Funcoes.waitSec(1);
			System.out.println("----------------");
			getCores().imprime();
			//tem novo proceço?
			getCores().removeTempoExec(1);
			getCores().adicionaRelogio(1);
			
			
			for (int i = 0; i < getNumCores(); i++) {
//				System.out.println("-->-");
//				Funcoes.waitSec(1);
				temp = getCores().returnPos(i);
				if(temp!= null && (	temp.getTempExec() <= 0
									|| temp.getRelogio() == getCores().getDeadline()
								  )
				) {
//					System.out.println("Pri: "+ temp.getPriori());
					Funcoes.repassaFila(getPrioridade(i), getCores(), i);
				}
			}
			while(getCores().returnPos(getNumCores()) != null) {
				getCores().pop_fim();
			}

		}/**/
		System.out.println("Saiu");
	}
	public static void setPriori0(Lista priori0) {
		Priori0 = priori0;
	}

}
