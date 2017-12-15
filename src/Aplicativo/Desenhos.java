package Aplicativo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import encadeamento.LTG;
import includes.Funcoes;
import includes.Lista;
import includes.No;

//
// 393, 396, 741, 788
//

@SuppressWarnings("serial")
public class Desenhos extends JPanel {

	private int tipo, tipo_mem;
	private int pulaNo = 0, largNo= 104, alturaNo= 80;
	int numCores, numProcs;
	private boolean iniciou = false, ativaDeadLine = false, ativaRoundRobin = false, boolAdicionar = false, log = false;
	private boolean iniciouEstatisticas = false, filtraListaEstatisticas = true;
	JButton btnAdicionar;
	int auto_increment = 0;
	double auto_increment_dec = 0, controle_dec = 0.0001;
	int memUsada = 0;
	int TamanhoTotal = 0, TamanhoDeselocado = 0;
	int botaoAdd = 0;
	int outOfMem = 0;
	int[] estatisticasTam;
	int[] estatisticasFinal;
	int estatisticasQtdVetor, estatisticasCount = 0;
	int reset = 0;
	

	public int[] getEstatisticasFinal() {
		return estatisticasFinal;
	}

	LTG LTG;

	public LTG getLTG() {
		return LTG;
	}
	public void setLTG(LTG lTG) {
		LTG = lTG;
	}

	private static Lista Cores;
	private static Lista priori0;
	private static Lista priori1;
	private static Lista priori2;
	private static Lista priori3;
	private static Lista abortados = new Lista();
	private static Lista MemoriaLG = new Lista();
	private static Lista MemoriaEst0 = new Lista();
	private static Lista MemoriaEst1 = new Lista();
	private static Lista MemoriaEst2 = new Lista();
	private static Lista MemoriaEst3 = new Lista();
	private static Lista Memoria = new Lista();

	@SuppressWarnings("unused")
	private static Funcoes func;

	public static Lista getCores() {
		return Cores;
	}
	public void setCores(Lista cores) {
		Cores = cores;
	}
	public static Lista getPriori0() {
		return priori0;
	}
	@SuppressWarnings("static-access")
	public void setPriori0(Lista priori0) {
		this.priori0 = priori0;
	}
	public static Lista getPriori1() {
		return priori1;
	}
	@SuppressWarnings("static-access")
	public void setPriori1(Lista priori1) {
		this.priori1 = priori1;
	}
	public static Lista getPriori2() {
		return priori2;
	}
	@SuppressWarnings("static-access")
	public void setPriori2(Lista priori2) {
		this.priori2 = priori2;
	}
	public static Lista getPriori3() {
		return priori3;
	}
	@SuppressWarnings("static-access")
	public void setPriori3(Lista priori3) {
		this.priori3 = priori3;
	}
	public int getTamanhoTotal() {
		return TamanhoTotal;
	}
	public void setTamanhoTotal(int tamanhoTotal) {
		TamanhoTotal = tamanhoTotal;
	}
	public int getTamanhoDeselocado() {
		return TamanhoDeselocado;
	}
	public void setTamanhoDeselocado(int tamanhoDeselocado) {
		tamanhoDeselocado = tamanhoDeselocado < 0 
							? 0 
							: tamanhoDeselocado > getTamanhoTotal()
								? getTamanhoTotal()
								: tamanhoDeselocado;
		TamanhoDeselocado = tamanhoDeselocado;
	}
	public int[] getEstatisticasTam() {
		return estatisticasTam;
	}
	public void setEstatisticasTam(int valor) {
		if(estatisticasCount < getEstatisticasQtdVetor()) {
			this.estatisticasTam[estatisticasCount] = valor;
		}
		estatisticasCount++;
	}
	public boolean getFiltraListaEstatisticas() {
		return filtraListaEstatisticas;
	}
	public void setFiltraListaEstatisticas(boolean filtraListaEstatisticas) {
		this.filtraListaEstatisticas = filtraListaEstatisticas;
	}
	public int getEstatisticasQtdVetor() {
		return estatisticasQtdVetor;
	}
	public void setEstatisticasQtdVetor(int estatisticasQtdVetor) {
		this.estatisticasQtdVetor = estatisticasQtdVetor;
		this.estatisticasTam = new int[getEstatisticasQtdVetor()];
	}
	public double getAuto_increment_dec() {
		return auto_increment_dec;
	}
	public void setAuto_increment_dec() {
		this.auto_increment_dec = getAuto_increment_dec()+getControle_dec();
	}
	public double getControle_dec() {
		return controle_dec;
	}
	public int getTipo() {
		return tipo;
	}
	public int getTipo_mem() {
		return tipo_mem;
	}
	public void setTipo_mem(int tipo_mem) {
		this.tipo_mem = tipo_mem;
	}
	public int getPulaNo() {
		return pulaNo;
	}
	public void setPulaNo(int pulaNo) {
		this.pulaNo = pulaNo;
	}
	public int getLargNo() {
		return largNo;
	}
	public void setLargNo(int largNo) {
		this.largNo = largNo;
	}
	public int getAlturaNo() {
		return alturaNo;
	}
	public void setAlturaNo(int alturaNo) {
		this.alturaNo = alturaNo;
	}
	public int getBotaoAdd() {
		return botaoAdd;
	}
	public void setBotaoAdd(int botaoAdd) {
		this.botaoAdd = botaoAdd;
	}
	public int getNumCores() {
		return numCores;
	}
	public void setNumCores(int numCores) {
		this.numCores = numCores;
	}
	public int getNumProcs() {
		return numProcs;
	}
	public void setNumProcs(int numProcs) {
		this.numProcs = numProcs;
	}
	public static Lista getPrioridade(int pri) {
		if (pri == 0) {
			return getPriori0();
		} else if (pri == 1) {
			return getPriori1();
		} else if (pri == 2) {
			return getPriori2();
		} else if (pri == 3) {
			return getPriori3();
		}
		return null;
	}
	public boolean getIniciou() {
		return iniciou;
	}
	public void setIniciou(boolean iniciou) {
		this.iniciou = iniciou;
	}
	public boolean getAtivaDeadLine() {
		return ativaDeadLine;
	}
	public void setAtivaDeadLine(boolean ativaDeadLine) {
		this.ativaDeadLine = ativaDeadLine;
	}
	public boolean getIniciouEstatisticas() {
		return iniciouEstatisticas;
	}
	public void setIniciouEstatisticas(boolean iniciouEstatisticas) {
		this.iniciouEstatisticas = iniciouEstatisticas;
	}
	public static Lista getAbortados() {
		return abortados;
	}
	public static void setAbortados(Lista abortados) {
		Desenhos.abortados = abortados;
	}
	public boolean getAtivaRoundRobin() {
		return ativaRoundRobin;
	}
	public void setAtivaRoundRobin(boolean ativaRoundRobin) {
		this.ativaRoundRobin = ativaRoundRobin;
	}
	JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}
	public boolean getBoolAdicionar() {
		return boolAdicionar;
	}
	public void setBoolAdicionar(boolean boolAdicionar) {
		this.boolAdicionar = boolAdicionar;
	}


	// ------------------

	public boolean getLog() {
		return log;
	}
	public void setLog(boolean log) {
		this.log = log;
	}
	public static Lista getMemoria() {
		return Memoria;
	}
	public static void setMemoria(Lista memoria) {
		Memoria = memoria;
	}
	public static Lista getMemoriaLG() {
		return MemoriaLG;
	}
	public static void setMemoriaLG(Lista memoriaLG) {
		MemoriaLG = memoriaLG;
	}
	public static Lista getMemoriaEst0() {
		return MemoriaEst0;
	}
	public static void setMemoriaEst0(Lista memoriaEst0) {
		MemoriaEst0 = memoriaEst0;
	}
	public static Lista getMemoriaEst1() {
		return MemoriaEst1;
	}
	public static void setMemoriaEst1(Lista memoriaEst1) {
		MemoriaEst1 = memoriaEst1;
	}
	public static Lista getMemoriaEst2() {
		return MemoriaEst2;
	}
	public static void setMemoriaEst2(Lista memoriaEst2) {
		MemoriaEst2 = memoriaEst2;
	}
	public static Lista getMemoriaEst3() {
		return MemoriaEst3;
	}
	public static void setMemoriaEst3(Lista memoriaEst3) {
		MemoriaEst3 = memoriaEst3;
	}
	public static Lista getMemoriaEst(int Est) {
		if (Est == 0) {
			return getMemoriaEst0();
		} else if (Est == 1) {
			return getMemoriaEst1();
		} else if (Est == 2) {
			return getMemoriaEst2();
		} else if (Est == 3) {
			return getMemoriaEst3();
		}
		return getMemoriaLG();
	}
	public Desenhos() {
		this.tipo = 0;
	}

	@SuppressWarnings("static-access")
	public Desenhos(int tipo, int numCores, int numProcs, int Deadline, int org) {
		this.tipo = tipo;

		func = new Funcoes();
		this.Cores = new Lista();
		getCores().setNomeLista("Cores");
		getCores().setDeadline(Deadline);

		setAtivaDeadLine(true);

		setNumCores(numCores);
		setNumProcs(numProcs);

		Lista temp = new Lista();
		temp.populaLista(getNumProcs());
		setPriori0(temp);
		if(org == 0) {
			getPriori0().quickSort();
		} else {
			getPriori0().quickSort2();
		}
		System.out.println("----");
		if (getLog()){
			getPriori0().imprime();
			System.out.println("----");
		}
		getPriori0().setNomeLista("Aptos");

		iniciaCores(false);
	}
	@SuppressWarnings("static-access")
	public Desenhos(int tipo, int numCores, int numProcs, boolean prioridade) {
		this.tipo = tipo;

		func = new Funcoes();
		this.Cores = new Lista();
		this.priori0 = new Lista();
		this.priori1 = new Lista();
		this.priori2 = new Lista();
		this.priori3 = new Lista();
		getCores().setNomeLista("Cores");
		getCores().setDeadline(9999);

		setAtivaDeadLine(false);
		setAtivaRoundRobin(true);

		setNumCores(numCores);
		setNumProcs(numProcs);

		Lista temp = new Lista();
		Lista aux;
		temp.populaLista(getNumProcs(), true, auto_increment+1);

		int priori = 0;
		while(priori < 4) {
			aux = getPrioridade(priori);
			for (int i = 0; i < temp.getQtdNos(); i++) {
				if(temp.returnPos(i).getPriori() == priori) {
					if (temp.returnPos(i) != null) {
						temp.returnPos(i).Entrega();
						aux.push_fim_no(temp.returnPos(i).Entrega());
					}
				}
			}
			aux.setNomeLista("Prioridade " + priori);
			aux.setNomeLista("Prioridade " + priori);
			priori++;
		}

		System.out.println("-Populada-");
		// temp.imprime();
		System.out.println("-0-");
		if (getLog()){
			getPrioridade(0).imprime();
			System.out.println("-1-");
			getPrioridade(1).imprime();
			System.out.println("-2-");
			getPrioridade(2).imprime();
			System.out.println("-3-");
			getPrioridade(3).imprime();
		}


		if (getLog()){
			getPriori0().imprime();
			System.out.println("----");
		}
		// getPriori0().setNomeLista("Aptos");

		iniciaCores(true);
	}

	@SuppressWarnings("static-access")
	public Desenhos(int tipo, int numCores, int numProcs, int escl_Mem, boolean fazNada, int tamMemoria) {
		if (getLog())
			System.out.println("Inicia construtr 'Desenhos'3 .");
		this.tipo = tipo;
		setTipo_mem(escl_Mem);

		func = new Funcoes();
		this.Cores = new Lista();
		getCores().setNomeLista("Cores");
		getCores().setDeadline(9999);

		setAtivaDeadLine(false);

		setNumCores(numCores);
		setNumProcs(numProcs);

		Lista temp = new Lista();
		this.auto_increment = temp.populaLista(getNumProcs(), false);
		setPriori0(temp);
		getPriori0().quickSort();
		System.out.println("----");
		// getPriori0().imprime();
		System.out.println("----");
		getPriori0().setNomeLista("Aptos");

		getMemoriaLG().setNomeLista("Memoria Lista Generica");
		getMemoria().setNomeLista("Memoria Final");
		
		getMemoriaLG().setTamanho(tamMemoria);
		getMemoria().setTamanho(tamMemoria);
		// Head
		getMemoriaLG().setTamanho(tamMemoria);
		
		setTamanhoTotal(tamMemoria);
		setTamanhoDeselocado(tamMemoria);
		
		getMemoriaEst(0).setNomeLista("Memoria Lista Est 1");
		getMemoriaEst(1).setNomeLista("Memoria Lista Est 2");
		getMemoriaEst(2).setNomeLista("Memoria Lista Est 3");
		getMemoriaEst(3).setNomeLista("Memoria Lista Est 4");
		
		setEstatisticasQtdVetor(5);
		

		iniciaCores(false);
	}


	@SuppressWarnings("unused")
	private void iniciaLTG() {
		if (getLog())
			System.out.println("Inicia 'iniciaLTG()' .");
		// TODO Auto-generated method stub
		Lista core = getCores();
		Lista pri = null;

		if (	!getCores().isEmpty()
			) {
			// Funcoes.waitSec(1);
			System.out.println("----------------");
			if (getLog()) {
				getCores().imprime(); // <-------------------------------------
			}
			// tem novo proceço?
			// getCores().removeTempoExec(1);

//			verificaExistencia();
			 
			No temp = new No();
			No pri_temp = null;
			int priori = 0;
			int id_limpar;

			if (!getAtivaRoundRobin()) {
				temp = getCores().getHead();
				No novo;
				
				while (temp != null) {
					
					if(temp.getTempExec() <= 0 || temp.getRelogio() >= temp.getDeadLineTotal() +1) {
						if (getPriori0().getHead() != null) {
							novo = getPriori0().getHead().Entrega();
							novo.setCor(1);
								MemDesaloca2(temp);
							temp.Recebe(novo);
						} else {
								MemDesaloca2(temp);
							temp.Recebe(new No());
							temp.setTempExec(0);
							temp.setTamanhoUsado(0);
						}
						temp.setRelogio(0);
						getPriori0().pop_ini();
					}
					
					if (temp.getNext() != null) {
						temp = temp.getNext();
					} else {
						break;
					}
				}
			} else if(false) {

				temp = getCores().getHead();
				Lista temp2 = null;
				while (temp != null && temp.getNext() != null) {

					// priori = (getTipo() == 2)? temp.getPriori() : 0;
					// pri = getPrioridade(priori);

					if( temp.getTempExec() <= 0 ) {
						System.out.println("-->-" + priori);
						// if (pri != null && pri.getHead() != null) {
							// temp.Recebe(pri.getHead().Entrega());
						// } else {
							for (int i = 0; i < 4; i++) {
								temp2 = getPrioridade(i);
								if(temp2.getHead() != null) {
									break;
								}
							}
							if(temp2 != null && temp2.getHead() != null) {
								temp.Recebe(temp2.getHead().Entrega());
								temp2.pop_ini();
							} else {
								temp.Recebe(new No());
								temp.setTempExec(0);
							}
						// }
						// if(pri != null) {
							// pri.pop_ini();
						// }
					}

					temp = temp.getNext();
				}
			}


			priori = 0;
			No aux = new No();
			pri_temp = null;


			while(getCores().returnPos(getNumCores()) != null) {
				getCores().pop_fim();
			}
		}

		getBtnAdicionar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setBotaoAdd(getBotaoAdd()+1);
				if (getBotaoAdd() == 1) {
					Thread thread = new Thread(){
						public void run(){
//							JOptionPane.showMessageDialog(null, "Adicionando Processos, para cancelar clique no 'X' para parar.");
							
							Lista list = new Lista();
							auto_increment = list.populaLista(1, (getTipo() == 2) ? true : false, auto_increment+1);
							
							No temp = list.getHead();
							temp.setCor(1); //-------------------------------------
							temp.setTamanhoUsado(100);
							temp.setTamanhoOrig(100);
							System.out.println(" ---------> ID"+temp.getID() + "tam:"+temp.getTamanhoOrig());
							if (temp.getTamanhoOrig() <= getTamanhoDeselocado()) {
								int priori = (getTipo() == 2)? temp.getPriori() : 0;
								
								
								if ((getTipo() == 2) ? true : false) {
									getPrioridade(priori).push_fim_no(temp.Entrega());
								} else {
									getPriori0().push_fim_no(temp.Entrega());
								}
								if(getTipo() == 3) {
									getPriori0().quickSort2();
								}
							}
							boolean excluir = false;
							setBotaoAdd(0);
						}
					};
					thread.start();
				}
			}
		});
	}
	private void iniciaCores(boolean Prioris) {
		if (getLog())
			System.out.println("Inicia 'iniciaCores()' .");
		if(!getIniciou()) {

			getAbortados().setNomeLista("Abortados");

			Lista pri;
			No temp = null;
			for (int i = 0; i < getNumCores(); i++) {

				if (Prioris) {
					pri = getPrioridade(i);
				} else {
					pri = getPriori0();
				}
				temp = pri.pop_ini();
				getCores().push_fim(temp);
			// getPriori0().quickSort();
			}

//			iniciaGerencMemoria(getCores().getTail(), temp);


			setBtnAdicionar(new JButton("ADICIONA PROC"));
			btnAdicionar.setBounds(20, 20, 100, 420);
			this.add(getBtnAdicionar());
		}

		if (getLog()){
			getCores().imprime();
		}
	}


	public Desenhos(int tipo, Lista cores, Lista aptos) {
		this.tipo = 1;
	}
	public Desenhos(int tipo, Lista cores, Lista pri0, Lista pri1, Lista pri2, Lista pri3) {
		this.tipo = 2;
	}


	@SuppressWarnings("unused")
	public void paintComponent(Graphics g) {
		if (getLog())
			System.out.println("Inicia 'paintComponent()' .");
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		int posTemp;
		int aumentaPos_Y = 32;
		int posY_Core = 25 + aumentaPos_Y;
		int posY_Priori0 = 100 + aumentaPos_Y;
		int posY_Priori1 = 155 + aumentaPos_Y;
		int posY_Priori2 = 210 + aumentaPos_Y;
		int posY_Priori3 = 265 + aumentaPos_Y;
		int posY_Abortados = 365 + aumentaPos_Y;
		Lista listTemp;


		// iniciaLTG();
		if(getPriori0() == null) {

		} else {
			Lista cores = getCores();
			Lista pri = getPriori0();
			getCores().removeTempoExec(1);
			getCores().adicionaRelogio(1);

		}

		Funcoes.waitSec(1);
		iniciaLTG();

		String text;
		int dist_y = 30;
		if(getTipo() >= 1 || getTipo() <= 3) {

			// Cores
			listTemp = getCores();
			posTemp = posY_Core;
			text = "Cores";
			if (listTemp != null) {
				text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
			}
			desenhaLista(g, listTemp, text, posTemp, false, getTipo());
			// Aptos/Prioridade0
			listTemp = getPriori0();
			posTemp = posY_Priori0 + dist_y;
			text = getTipo() != 2 ? "Aptos" : "Priodidade 0";
			if (listTemp != null) {
				text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
			}

			desenhaLista(g, listTemp, text, posTemp, true, getTipo());
			if(getTipo() == 2) {
				dist_y = 60;
				// Priodidade 1
				listTemp = getPriori1();
				posTemp = posY_Priori1 + dist_y + 20;
				text = "Priodidade 1";
				if (listTemp != null) {
					text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
				}
				desenhaLista(g, listTemp, text, posTemp, true, getTipo());
				// Priodidade 2
				listTemp = getPriori2();
				posTemp = posY_Priori2 + dist_y + 70;
				text = "Priodidade 2";
				if (listTemp != null) {
					text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
				}
				desenhaLista(g, listTemp, text, posTemp, true, getTipo());
				// Priodidade 3
				listTemp = getPriori3();
				posTemp = posY_Priori3 + dist_y*2 + 60;
				text = "Priodidade 3";
				if (listTemp != null) {
					text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
				}
				desenhaLista(g, listTemp, text, posTemp, true, getTipo());
			}
			// Abortados
			listTemp = getAbortados();
			posTemp = posY_Abortados + dist_y;
			text = "Abortados";
			if (listTemp != null) {
				text = listTemp.getNomeLista().isEmpty() ? text : listTemp.getNomeLista();
			}
			desenhaLista(g, listTemp, text, posTemp, true, getTipo());


		}
		// Memoria
		listTemp = getMemoria();
		posTemp = posY_Priori3 + dist_y*2 + 60;
		text = "Memoria Total " + getTamanhoTotal() + "/Desalocado= " + getTamanhoDeselocado();
		text = "Memoria Total " + getTamanhoTotal();

		// Caixa Mem
		Graphics2D g2 = (Graphics2D) g;
		 // g2.setColor(new Color(86, 146, 246));
		g2.setColor(new Color(194, 194, 194));
		 // g2.draw( new Rectangle2D.Double(25, posTemp - 40, getLargNo() *7, getAlturaNo()));
		g.fillRect(25, posTemp - 40, getLargNo() *7, getAlturaNo());


		desenhaListaMem(g, listTemp, text, posTemp, true, getTipo());


//		getMemoriaLG().imprime();
		
		
		
		

		// g.setColor(Color.BLUE);;
		// g.fillRect(25, 425, getLargNo(), getAlturaNo());

		// g.setColor(new Color(190, 81, 215));
		// g.fillRect(25, 465, getLargNo(), getAlturaNo());

		// g.setColor(Color.RED);
		// g.drawString("Algum texto.", 25, 520);;
		repaint();
	}
	private Lista verificaIgualdade() {
		//System.out.println("in");
		Lista[] novosProcs = getCores().inexistentesEm(getMemoria());
		//System.out.println("out");
		
		novosProcs[0] = novosProcs[0];
		
		if (novosProcs[0] != null) {
			System.out.print("Entrando: "); novosProcs[0].imprimeID();
		}
		if (novosProcs[1] != null) {
			System.out.print("Saindo: "); novosProcs[1].imprimeID();
		}
		
		return novosProcs[0];
	}
	
	private void administraMemoria() {
		if(getTipo_mem() == 1) {
			//administraMemoriaBF();
			administraMemoriaBF_new();
		} else if(getTipo_mem() == 2) {
			//administraMemoriaBF();
			administraMemoriaBF_new();
		} else if(getTipo_mem() == 3) {
			//administraMemoriaBF();
			verificaVazio();
			administraMemoriaBF_new();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void verificaVazio() {
		// TODO Auto-generated method stub
		No Temp = getMemoriaLG().getHead()
				, tmpMem = null;
		
		MemJoin();
		
	}
	private Lista adjacentesApontados(No livres) {
		Lista adjs = null;
		if (livres != null) {
			if (livres.getApontando() != null) {
				adjs = new Lista();
				adj(livres.getApontando(), adjs);
			}
		}
		return (adjs.getQtdNos()> 1 ? adjs : null);
	}
	private void adj(No apontando, Lista l) {
		if(apontando != null) {
			l.push_fim(apontando.Entrega());
			if(apontando.getBack() != null) {
				if(apontando.getBack().getCor() == 0) {
					adj(apontando, l);
					apontando = apontando.getNext();
				}
			}
			if(apontando.getNext() != null) {
				if(apontando.getNext().getCor() == 0) {
					adj(apontando, l);
				}
			}
		}
	}
	public void iterativePreorder(No node, Lista ret) {
		if (node != null) {
			if (node.getBack() != null) {
				if(node.getBack().getCor() == 0) {
					iterativePreorder(node.getBack(), ret);
				}
			}
			ret.push_fim(node);
			if (node.getNext() != null) {
				if(node.getNext().getCor() == 0){
					iterativePreorder(node.getNext(), ret);
				}
			}
		}
//		return ret;
	}
	
	public Lista adjts(No livre) {
		Lista l = new Lista();
		if(livre!= null) {
			if (livre.getCor() == 0) {
				
				boolean esq = true, continua = true;
				if (continua) {
					if (livre.getBack() != null && esq) {
						if(livre.getBack().getCor() == 0) {
							livre = livre.getBack();
						} else {
							
						}
					} else {
						esq = !esq;
					}
					
					if(!esq) {
						l.push_fim(livre.Entrega());
						if (livre.getNext() != null && !esq) 
						{
							if(livre.getNext().getCor() == 0) {
								livre = livre.getNext();
							} else {
								
							}
						} else {
							continua = !continua;
						}
					}
					
					
				}
				
			}
		}
		return l;
	}
	public void MemJoin() {
		if(!getMemoriaLG().isEmpty()) {
			
			
			No temp = getMemoria().buscaCor(0);
			No tempAnt = null;
			double id = temp.getID();
			No novo = new No();
			int tamNovo = 0;
			int cont = 0, qtd = 0;
			System.out.print("Removendo ");
			while(temp != null && temp.getCor() == 0) {
				if (cont != 0) {
					tamNovo = tamNovo + tempAnt.getTamanhoOrig();
					novo.Recebe(temp.Entrega());
					getMemoria().pop_ID(tempAnt.getID());
					getMemoriaLG().pop_ID(tempAnt.getID());
					System.out.print(", " + tempAnt.getID());
					tempAnt = novo;
					qtd++;
				} else {
					tempAnt = temp;
				}
				
				if (temp.getNext() != null) {
					temp = temp.getNext();
				} else {
					break;
				}
				cont++;
			}
			System.out.println();
			
			if (tempAnt.getCor() == 0 && qtd >1) {
				
				temp = getMemoria().buscaID(tempAnt.getID());
				if (temp != null) {
					tamNovo = tamNovo + tempAnt.getTamanhoOrig();
					int tam = getMemoriaLG().getTamanho() + tempAnt.getTamanhoOrig();
					
					getMemoria().imprimeID();;
					getMemoriaLG().imprimeID();;
					No tempLg = getMemoriaLG().buscaID(tempAnt.getID());
					tempAnt.setID(id);
					
					temp.Recebe(tempAnt.Entrega());
					
					temp.setTamanhoUsado(tam);
					temp.setTamanhoOrig(tam);
					
					tempLg.setTamanhoUsado(tam);
					tempLg.setTamanhoOrig(tam);
					
					tempLg.Recebe(tempAnt.Entrega());
					tempLg.setAponta(tempLg);
				}
			} else {
				temp = getMemoria().getTail();
				No temp_Lg = getMemoriaLG().buscaID(temp.getID());
				if (reset == 200) {
					temp.setTamanhoOrig(getTamanhoTotal());
					temp.setTamanhoUsado(getTamanhoTotal());
					temp_Lg.setTamanhoOrig(getTamanhoTotal());
					temp_Lg.setTamanhoUsado(getTamanhoTotal());
					reset = 0;
				} else {
					reset++;
				}
			}
			
			
			
			
			
		}
	}
	
	
	private void administraMemoriaBF_new() {
		Lista[] novosProcs = getCores().inexistentesEm(getMemoria());
		
		if (novosProcs[0] != null) {
			System.out.print("Entrando na mem: "); novosProcs[0].imprimeID();
		}
		if (novosProcs[1] != null) {
			System.out.print("Saindo da mem: "); novosProcs[1].imprimeID();
		}
		
		
		//Desalocando
		if (novosProcs[1] != null) {

			No temp = novosProcs[1].getHead();
			while(temp!= null) {
//				MemDesaloca2(temp);
				
				if (temp.getNext() != null) {
					temp = temp.getNext();
				} else {
					break;
				}
			}
		}
		//Alocando
		if (novosProcs[0] != null) {
			
			No temp = novosProcs[0].getHead();
			while(temp!= null) {
				MemAloca(temp);
				
				if (temp.getNext() != null) {
					temp = temp.getNext();
				} else {
					break;
				}
			}
		}
		
	}
	
	
	
	
	@SuppressWarnings({ "unused", "null" })
	private void MemDesaloca2(No proc) {
		No temp = getMemoria().buscaID(proc.getID());
		System.out.println(" -- "+getTamanhoDeselocado());
		if (temp != null) {
			temp.setCor(0);
			
			if(getTipo_mem() == 2 && getIniciouEstatisticas()) {
				int[] populares = Funcoes.mostPopular(getEstatisticasTam());
				boolean pass = false;
				for (int i = 0; i < 4; i++) {
					if(proc.getTamanhoUsado() == populares[i]) {
						getMemoriaEst(i).push_fim(proc);
						getMemoriaEst(i).getTail().setAponta(proc);
						pass = true;
						break;
					}
				}
				if(!pass) {
					getMemoriaLG().push_fim(proc);
					getMemoriaLG().getTail().setAponta(proc);
				}
			} else {
				getMemoriaLG().push_fim(proc);
				getMemoriaLG().getTail().setAponta(proc);
			}
			
			setTamanhoDeselocado(getTamanhoDeselocado() + proc.getTamanhoOrig());
		} else {
//			int id_rem = 7777;
//			temp.setCor(0);
			//getMemoriaLG().push_ini_no(new No());
//			proc.setID(id_rem);
			//getMemoriaLG().getHead().Recebe(proc.Entrega());
			//getMemoriaLG().getHead().setAponta(proc);
//			setTamanhoDeselocado(getTamanhoDeselocado() + proc.getTamanhoOrig());
			boolean excluir = true;
		}
		System.out.println(getTamanhoDeselocado());
	}
	private void MemAloca(No Entrando) {
		
		// Tamanho fora do permitido
		if (Entrando.getTamanhoOrig() > getTamanhoDeselocado()) {
			System.out.println("---- OFM ----");
			this.outOfMem++;
			Thread threadOFM = new Thread(){
				public void run(){
					JOptionPane.showMessageDialog(null, "OUT OF MEMORY.");
					outOfMem = 0;
				}
			};
			threadOFM.start();
		} 
		// Novo processo tem tamanho diferente de 0.
		else if(Entrando.getTamanhoOrig() != 0){
			
			// Refaz listas genericas
			if(getTipo_mem() == 2 && getIniciouEstatisticas() && getFiltraListaEstatisticas()) {
				// Re-analiza apena uma vez.
				setFiltraListaEstatisticas(false);
				int[] populares = Funcoes.mostPopular(getEstatisticasTam());
				this.estatisticasFinal = populares;
				int cont = 0;
				No temp;
				for (int i : populares) {
					if (!getMemoriaLG().isEmpty()) {
						temp = getMemoriaLG().getHead();
						if (temp != null) {
							if (temp.getTamanhoOrig() == i) {
								getMemoriaEst(cont).push_fim(temp.Entrega());
								getMemoriaLG().pop_ID(temp.getID());
							}
							
							if (temp.getNext() != null) {
								temp = temp.getNext();
							} else {
								break;
							}
						}
						cont++;
					}
				}
				
				for (int i = 0; i < 4; i++) {
					getMemoriaEst(i).imprime();
				}
				getMemoriaLG().imprime();
				boolean ret = false;
			}
			
			
			
			// Começa alocação
			
			No bf_ret = null;
			boolean procura = true;
			
			System.out.println("----");
			for (int i = 0; i < 4; i++) {
				getMemoriaEst(i).imprime();
			}
			getMemoriaLG().imprime();
			getMemoria().imprime();
			// Tiver espaço na lista livre
			if (getIniciouEstatisticas()) {
				for (int i = 0; i < 4; i++) {
					System.out.println(i);
					if(!getMemoriaEst(i).isEmpty() && procura) {
						// procura
						bf_ret = getMemoriaEst(i).BuscaBestFit(Entrando.getTamanhoOrig());
		 				if (getTipo_mem() == 3) {
							if (bf_ret != null) {
								if (bf_ret.getTamanhoOrig()!= Entrando.getTamanhoOrig()) {
									MemSplit(bf_ret, Entrando);
								}
							}
						}
						if (bf_ret != null) {
							No novo = Entrando.Entrega();
							novo.setCor(i+2);
							
							No busca = getMemoria().buscaID(bf_ret.getID());
							if (busca != null) {
								busca.Recebe(novo.Entrega());
							} else {
								Entrando.setTamanhoOrig(Entrando.getTamanhoUsado());
								getMemoria().push_fim(Entrando.Entrega());
							}
							
							setTamanhoDeselocado(getTamanhoDeselocado() - Entrando.getTamanhoOrig());
							
							getMemoriaEst(i).pop_ID(bf_ret.getID());
							procura = false;
						}
					}
				}
			}
			if(!getMemoriaLG().isEmpty() && procura) {
				// procura
 				bf_ret = getMemoriaLG().BuscaBestFit(Entrando.getTamanhoOrig());
 				if (getTipo_mem() == 3) {
					if (bf_ret != null) {
						if (bf_ret.getTamanhoOrig()!= Entrando.getTamanhoOrig()) {
							MemSplit(bf_ret, Entrando);
						}
					}
				}
				if (bf_ret != null) {
					No novo = Entrando.Entrega();
					novo.setCor(1);
					
					No busca = getMemoria().buscaID(bf_ret.getID());
					if (busca != null) {
						busca.Recebe(novo.Entrega());
					} else {
						Entrando.setTamanhoOrig(Entrando.getTamanhoUsado());
						getMemoria().push_fim(Entrando.Entrega());
					}
					
					setTamanhoDeselocado(getTamanhoDeselocado() - Entrando.getTamanhoOrig());
					
					getMemoriaLG().pop_ID(bf_ret.getID());
					procura = false;
				}
			} 
			if(procura){
				No novo = Entrando.Entrega();
				novo.setCor(1);
				getMemoria().push_fim(novo);
				setTamanhoDeselocado(getTamanhoDeselocado() - Entrando.getTamanhoOrig());
				procura = false;
			}
			

			
			
			if (estatisticasCount < getEstatisticasQtdVetor() && procura == false) {
				setEstatisticasTam(Entrando.getTamanhoUsado());
			} else {
				setIniciouEstatisticas(true);
				System.out.println("Inicia Quick-fit");
				
				System.out.println("----");
				for (int i : estatisticasTam) {
					System.out.println(i);
				}
			}
			
			getMemoriaLG().imprime();
			getMemoria().imprime();
			procura = false;
		}
	}
	@SuppressWarnings("unused")
	private void TesteCorMem() {
		if (!getMemoria().isEmpty()) {
			boolean pass = true;
			
			
			
			No temp = getMemoria().getHead();
			while (temp != null) {

				if (temp.getCor() == 0) {
					if(getAbortados().buscaID(temp.getID()) == null) {
						getAbortados().push_fim(temp.Entrega());
					} else {
						pass = false;
					}
					
					if (pass) {
						setTamanhoDeselocado(getTamanhoDeselocado() + temp.getTamanhoOrig());
					}
				}
				
				// Passando
				if (temp.getNext() != null) {
					temp = temp.getNext();
				} else {
					break;
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void administraMemoriaBF() {
		Lista novosProcs = verificaIgualdade();
		
		if (novosProcs != null) {
			
			No temp = novosProcs.getHead();
			for (int i = 0; i < novosProcs.getQtdNos(); i++) {
				if(temp.getTamanhoUsado() > getMemoriaLG().getDesalocado()) {
					System.out.println("------------------------ OUT OF MEMORY ------------------------");
					this.outOfMem++;
					Thread threadOFM = new Thread(){
						public void run(){
							JOptionPane.showMessageDialog(null, "OUT OF MEMORY.");
							outOfMem = 0;
						}
					};
					threadOFM.start();
				} else if (temp.getTamanhoOrig() != 0 || true){
					No T = getMemoriaLG().BuscaBestFit(temp.getTamanhoUsado());
					if (T == null) {
						System.out.println("------------------------ OUT OF MEMORY ------------------------");
						this.outOfMem++;
						Thread threadOFM = new Thread(){
							public void run(){
								JOptionPane.showMessageDialog(null, "OUT OF MEMORY.");
								outOfMem = 0;
							}
						};
						threadOFM.start();
					} else if(T == getMemoriaLG().getTail()) {
						T = MemSplit(getMemoriaLG().getTail(), temp);
						if (T == null) {
							System.out.println("------------------------ OUT OF MEMORY ------------------------");
							this.outOfMem++;
							Thread threadOFM = new Thread(){
								public void run(){
									JOptionPane.showMessageDialog(null, "OUT OF MEMORY.");
									outOfMem = 0;
								}
							};
							threadOFM.start();
						}
					} else {
//						T = T;
					}
					
					if (T != null) {
						temp.setCor(1);
						No apont = T.getApontando();
						int temOri = T.getTamanhoOrig();
						apont.Recebe(temp.Entrega());
						T.getApontando().setTamanhoOrig(temOri);
						getMemoriaLG().setDesalocado(getMemoriaLG().getDesalocado() - temOri);
						getMemoriaLG().pop_ID(T.getID());
					}
				}
				temp = temp.getNext();
			}
		}
		
	}
	private No MemSplit(No tail, No novoProc) {
		No ret = null;
		if (novoProc.getTamanhoOrig() > tail.getTamanhoOrig()) {
			System.out.println("------------------------ OUT OF MEMORY ------------------------");
			this.outOfMem++;
			Thread threadOFM = new Thread(){
				public void run(){
					JOptionPane.showMessageDialog(null, "OUT OF MEMORY.");
					outOfMem = 0;
				}
			};
			threadOFM.start();
			return null;
		} else {
			No novo = new No();
			novo.setID(9999);
			novo.setTamanhoOrig(novoProc.getTamanhoOrig());
			getMemoria().push_fim(novo);
			getMemoriaLG().push_ini_no(novo.Entrega());
			getMemoriaLG().getHead().setAponta(getMemoria().getTail());
			int tam = getMemoriaLG().getTamanho() - novoProc.getTamanhoOrig();
			getMemoriaLG().setTamanho(tam);
			
			getMemoria().buscaID(novo.getID()).setTamanhoOrig(tam);
			getMemoria().buscaID(novo.getID()).setTamanhoUsado(tam);
			ret = getMemoriaLG().getHead();
			No prox = getMemoria().buscaID(ret.getID()).getNext();
			if(prox != null) {
				if (prox.getCor() ==0) {
					prox.setTamanhoUsado(tam);
				}
			}
		}
		return ret;
	}
	@SuppressWarnings("unused")
	private void MemDesaloca(No proc, int id_rem) {
		// TODO Auto-generated method stub
		No temp = getMemoria().buscaID(proc.getID());
		if (temp != null) {
			temp.setCor(0);
//			getMemoriaLG().push_ini_no(new No());
			proc.setID(id_rem);
//			getMemoriaLG().getHead().Recebe(proc.Entrega());
//			getMemoriaLG().getHead().setAponta(proc);
			getMemoria().setDesalocado(getMemoria().getDesalocado() + proc.getTamanhoOrig());
		}
	}
	
	@SuppressWarnings("unused")
	private void desenhaLista(Graphics g, Lista listTemp, String text, int posY, boolean cortaFila, int tipo) {
		if (getLog())
			System.out.println("Inicia 'desenhaLista()' .");
		if(listTemp == null || listTemp.isEmpty()) {
			// System.out.println("desenhaLista: Lista não desenhada, lista vazia."); // <-------------------------------------
		} else {

			No atu = null;

			Graphics2D g2 = (Graphics2D) g;
			int posTemp = posY;
			setPulaNo(25);

			g2.setColor(Color.BLACK);
			g2.setFont(new Font("default", Font.BOLD, 16));
			g2.drawString(text, 10*30, posTemp	 -5);; //
			g2.setFont(new Font("default", Font.BOLD, 12));


			No temp = listTemp.getHead();
			int cont = 1;
			String sub_texto = "";
			while (temp != null  && temp.getNext() != null && cont < 6) {

				g2.setColor(new Color(86, 146, 246));;
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				g2.setColor(Color.RED);
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("TempExec= "+ temp.getTempExec(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("TempExc Tot= "+ temp.getTempExecTotal(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
					g2.drawString("Quantum= "+ temp.getQuantum(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 34);
				}

				// Mensagem diferenciada
				if ((tipo >= 1 || tipo <= 3) && false) {
					if (tipo == 1) {
						sub_texto = "";
					} else if (tipo == 2) {
						sub_texto = "Priori= " + temp.getPriori();
					} else if (tipo == 3) {
						sub_texto = "Deadline= " + temp.getDeadLineTotal() + "/" + temp.getRelogio();
					}
					if(temp.getTempExecTotal() < 999999) {
						g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
					}
				} else {
					sub_texto = "Tamanho= " + temp.getTamanhoUsado();
					g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
				}

				//Distancia de um no a outro
				temp = temp.getNext();
				int dist = 20;
				setPulaNo(getPulaNo() + getLargNo() + 20);

				//Desenah linha
				g2.setColor(Color.BLACK);
				g2.drawLine(getPulaNo() - dist, posTemp + getAlturaNo()/2, getPulaNo(), posTemp + getAlturaNo()/2);

				if (cortaFila) {
					cont++;
				}
			}

			// Ultimo no
			if(temp != null) {
				g2.setColor(new Color(86, 146, 246));;
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				g2.setColor(Color.RED);
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("TempExec= "+ temp.getTempExec(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("TempExc Tot= "+ temp.getTempExecTotal(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
					g2.drawString("Quantum= "+ temp.getQuantum(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 34);
				}
				// Mensagem diferenciada
				if ((tipo >= 1 || tipo <= 3) && false) {
					if (tipo == 1) {
						sub_texto = "Quantum7= " + temp.getTempExecTotal();
					} else if (tipo == 2) {
						sub_texto = "Priori= " + temp.getPriori();
					} else if (tipo == 3) {
						sub_texto = "Deadline= " + temp.getDeadLineTotal() + "/" + temp.getRelogio();
					}
					if(temp.getTempExecTotal() < 999999) {
						g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
					}
				} else {
					sub_texto = "Tamanho= " + temp.getTamanhoUsado();
					g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
				}

				//Distancia de um no a outro
				int dist = 20;
				setPulaNo(getPulaNo() + getLargNo() + 20);
			}

			// Desenha 3 pontos
			if(cont < listTemp.getQtdNos() && cortaFila) {
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("default", Font.BOLD, 18));
				g2.drawString("... ", getPulaNo() -10, posTemp + getAlturaNo()/2 +5);;
			}
		}
		this.repaint();
	}
	@SuppressWarnings("unused")
	private void desenhaListaMem(Graphics g, Lista listTemp, String text, int posY, boolean cortaFila, int tipo) {
		if (getLog())
			System.out.println("Inicia 'desenhaListaMem()' .");
		administraMemoria();

		if (getTipo_mem() == 3) {
			getMemoria().updTamanho();
			getMemoriaLG().updTamanho();
		}
		Color cor_letra = Color.RED;
		cor_letra = Color.BLACK;
		
		System.out.println(text);
		int posTemp = posY;
		setPulaNo(25);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("default", Font.BOLD, 16));
		g2.drawString(text, 10*30, posTemp	 -5);; //
		
		if(getIniciouEstatisticas() && getEstatisticasFinal() != null) {
			String estatisticas ="Estatisticas:";
			for (int i : getEstatisticasFinal()) {
				estatisticas = estatisticas + " / " + i;
			}
			g2.drawString(estatisticas, 10*30, posTemp	 -20);; //
		}
		g2.setFont(new Font("default", Font.BOLD, 12));
		
		if (getLog()) {
			getMemoriaLG().imprimeMem();
			getMemoria().imprimeMem();
		}
		if(listTemp == null || listTemp.isEmpty()) {
			System.out.println("desenhaLista: Lista não desenhada, lista vazia.");
		} else {

			No atu = null;

			No temp = listTemp.getHead();
			int cont = 1;
			String sub_texto = "";

			boolean exibeProcs = true;
			while (temp != null  && cont < 8  && exibeProcs) {
				
				if(temp.getCor() == 0) // Cinza
					g2.setColor(new Color(194, 194, 194));
				else if(temp.getCor() == 1) // Azul
					g2.setColor(new Color(86, 146, 246));
				else if(temp.getCor() == 2) // Verde
					g2.setColor(new Color(184, 244, 68));
				else if(temp.getCor() == 3) // Roxo
					g2.setColor(new Color(202, 164, 226));
				else if(temp.getCor() == 4) // Laranja
					g2.setColor(new Color(244, 212, 64));
				else if(temp.getCor() == 5) // rosa
					g2.setColor(new Color(234, 140, 214));
				
				g.fillRect(getPulaNo(), posTemp, getLargNo(), getAlturaNo());
				g2.setColor(Color.BLACK);
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				
				g2.setColor(cor_letra );
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
//					g2.drawString("Tamanho= "+ temp.getTamanhoUsado(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("Quantum= "+ temp.getQuantum(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
					g2.drawString("Tam Ori= "+ temp.getTamanhoOrig(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 34);
				} else if(temp.getTamanhoUsado() ==0) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
				}

				// Mensagem diferenciada
				if ((tipo >= 1 || tipo <= 3) && false) {
					if (tipo == 1) {
						sub_texto = "";
					} else if (tipo == 2) {
						sub_texto = "Priori= " + temp.getPriori();
					} else if (tipo == 3) {
						sub_texto = "Deadline= " + temp.getDeadLineTotal() + "/" + temp.getRelogio();
					}
					if(temp.getTempExecTotal() < 999999) {
						g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
					}
				} else {
					sub_texto = "Tamanho= " + temp.getTamanhoUsado();
					g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
				}

				//Distancia de um no a outro
				if (temp.getNext() != null) {
					temp = temp.getNext();
				} else {
					break;
				}
				int dist = 20;
				dist = 0;
				setPulaNo(getPulaNo() + getLargNo() + dist);

				g2.setColor(Color.BLACK);
				g2.drawLine(getPulaNo(), posTemp, getPulaNo() + 20, posTemp + getAlturaNo()/2);

				//Desenah linha
				// g2.setColor(Color.BLACK);
				// g2.drawLine(getPulaNo() - dist, posTemp + getAlturaNo()/2, getPulaNo(), posTemp + getAlturaNo()/2);

				if (cortaFila) {
					cont++;
				}
			}

			// Ultimo no
			/*if(temp != null && exibeProcs) {
				if(temp.getCor() == 0)
					g2.setColor(new Color(194, 194, 194));
				else if(temp.getCor() == 1)
					g2.setColor(new Color(86, 146, 246));;
				
				g.fillRect(getPulaNo(), posTemp, getLargNo(), getAlturaNo());
				g2.setColor(Color.BLACK);
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				g2.setColor(cor_letra);
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("Tamanho= "+ temp.getTamanhoUsado(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("Tamanho Ori= "+ temp.getTamanhoOrig(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
					g2.drawString("Quantum= "+ temp.getQuantum(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 34);
				} else if(temp.getTamanhoUsado() ==0) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
				}
				// Mensagem diferenciada
				if ((tipo >= 1 || tipo <= 3) && false) {
					if (tipo == 1) {
						sub_texto = "Quantum3= " + temp.getTempExecTotal();
					} else if (tipo == 2) {
						sub_texto = "Priori= " + temp.getPriori();
					} else if (tipo == 3) {
						sub_texto = "Deadline= " + temp.getDeadLineTotal() + "/" + temp.getRelogio();
					}
					if(temp.getTempExecTotal() < 999999) {
						g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
					}
				} else {
					sub_texto = "Tamanho= " + temp.getTamanhoUsado();
					g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 46);
				}
			}*/


			// Memoria Total
			// g2.setColor(Color.BLACK);
			// sub_texto = "Mem Total= " + temp.getTempExecTotal();
			// g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/3+ 70); // Baixo
				// g2.drawString(sub_texto, getPulaNo() +4, posTemp + getAlturaNo()/4- 26); // Cima
			//Distancia de um no a outro
			int dist = 20;
			setPulaNo(getPulaNo() + getLargNo() + 20);

			// Desenha 3 pontos
			if(cont < listTemp.getQtdNos() && cortaFila) {
				g2.setColor(Color.BLACK);
				g2.setFont(new Font("default", Font.BOLD, 18));
				g2.drawString("... ", getPulaNo() -10, posTemp + getAlturaNo()/2 +5);;
			}
		}
		this.repaint();
	}
	
	
}