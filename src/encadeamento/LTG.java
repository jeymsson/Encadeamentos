package encadeamento;

import includes.Funcoes;
import includes.Lista;
import includes.No;

public class LTG {


	static private Funcoes func;
	static private Lista cores;

	static private Lista Priori0;
	static private Lista Priori1;
	static private Lista Priori2;
	static private Lista Priori3;
	static private int numCores = 0, numProcs;
	static private boolean morreu = false;
	
	public static boolean getMorreu() {
		return morreu;
	}
	private void setMorreu(boolean b) {
		this.morreu  = b;
	}
	public Funcoes getFunc() {
		return func;
	}
	public static Lista getCores() {
		return cores;
	}
	public static Lista getPrioridade(int pri) {
		if (pri == 0) {
			return getPriori0();
		} else if (pri == 1) {
			return Priori1;
		} else if (pri == 2) {
			return Priori2;
		} else if (pri == 3) {
			return Priori3;
		}
		return getCores();
	}
	public static Lista getPriori0() {
		return Priori0;
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
	public void setNumProcs(int numProcs) {
		this.numProcs = numProcs;
	}
	
	public boolean checkUp() {
		int cores = getNumCores(),
			processos = getPriori0().getQtdNos();
		boolean ret = true;
		
		if(ret) ret = cores <= 0 ? false : true;
		if(ret) ret = processos <= 0 ? false : true;
		
		System.out.println(".CheckUp  : " + (ret == true ? "OK" : "Vazio")
					  + "\n .Num Cores: " + cores
					  + "\n .Num Procs: " + processos);
		return ret;
	}
	
	public LTG(int numCores, int numProcs) {
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
//		temp.imprime();
		Priori0 = temp;
		
//		getPriori0().imprime();
		System.out.println("----");
		getPriori0().quickSort();
//		getPriori0().imprime();

		getPriori0().setNomeLista("Aptos");
		iniciaCores();
		iniciaLTG();
//		iniciaLTG_teste();
	}

	private void iniciaCores() {
		// TODO Auto-generated method stub
		No temp = null;
		for (int i = 0; i < getNumCores(); i++) {
			temp = getPriori0().pop_ini();
			getCores().push_fim(temp);
//			getPriori0().quickSort();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LTG ltg = new LTG(4, 10);
	}
	public void iniciaLTG() {
		
		No temp = null, aux_aptos = null;
		
		if (	!getCores().isEmpty() && !getPriori0().isEmpty()
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
//				if(temp != null)
//					System.out.println("Nao nulo");
//				temp = getCores().returnPos(i);
//				if(temp.getRelogio() == getCores().getDeadline())
//					System.out.println("Igual");
//				System.out.println("Relogio: " + temp.getRelogio()
//								   + " e Deadline: " + getCores().getDeadline());
				if(temp!= null && (	temp.getTempExec() <= 0
									|| temp.getRelogio() == getCores().getDeadline()
								  )
				) {
//					System.out.println("Pri: "+ temp.getPriori());
					aux_aptos = temp.Entrega();
					Funcoes.repassaFila(getPriori0(), getCores(), i);
					if(temp.getRelogio() == getCores().getDeadline()) {
//						getPriori0().push_fim(aux_aptos);
					}
					getPriori0().removeTempoExecIgualZero();
				}
			}
			while(getCores().returnPos(getNumCores()) != null) {
				getCores().pop_fim();
			}
		}/**/
		System.out.println("Saiu");
		
	}

	private void iniciaLTG_teste() {
		
		iniciaCores();
		No temp = null, aux_aptos = null;
		
		while (	!getCores().isEmpty() && !getPriori0().isEmpty()
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
//				if(temp != null)
//					System.out.println("Nao nulo");
//				temp = getCores().returnPos(i);
//				if(temp.getRelogio() == getCores().getDeadline())
//					System.out.println("Igual");
//				System.out.println("Relogio: " + temp.getRelogio()
//								   + " e Deadline: " + getCores().getDeadline());
				if(temp!= null && (	temp.getTempExec() <= 0
									|| temp.getRelogio() == getCores().getDeadline()
								  )
				) {
					if(temp.getRelogio() == getCores().getDeadline()) {
						temp.setTempExec(0);
					}
//					System.out.println("Pri: "+ temp.getPriori());
					aux_aptos = temp.Entrega();
					Funcoes.repassaFila(getPriori0(), getCores(), i);
					if(temp.getRelogio() == getCores().getDeadline()) {
//						getPriori0().push_fim(aux_aptos);
					}
					getPriori0().removeTempoExecIgualZero();
				}
			}
			while(getCores().returnPos(getNumCores()) != null) {
				getCores().pop_fim();
			}
		}/**/
		
		if(getCores().isEmpty() && getPriori0().isEmpty()) {
			setMorreu(true);
		}
		System.out.println("Saiu");
		
	}

}
