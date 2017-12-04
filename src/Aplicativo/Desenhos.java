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

@SuppressWarnings("serial")
public class Desenhos extends JPanel {

	private int tipo;
	private int pulaNo = 0, largNo= 104, alturaNo= 80;
	int numCores, numProcs;
	private boolean iniciou = false, ativaDeadLine = false, ativaRoundRobin = false, boolAdicionar = false;
	private boolean iniciouEstatisticas = false;
	JButton btnAdicionar;
	int auto_increment = 0;
	int memUsada = 0;

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
	public int getTipo() {
		return tipo;
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
		getPriori0().imprime();
		System.out.println("----");
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
		getPrioridade(0).imprime();
		System.out.println("-1-");
		getPrioridade(1).imprime();
		System.out.println("-2-");
		getPrioridade(2).imprime();
		System.out.println("-3-");
		getPrioridade(3).imprime();


		// getPriori0().quickSort();
		// System.out.println("----");
		getPriori0().imprime();
		System.out.println("----");
		// getPriori0().setNomeLista("Aptos");

		iniciaCores(true);
	}

	@SuppressWarnings("static-access")
	public Desenhos(int tipo, int numCores, int numProcs, int escl_Mem, boolean fazNada, int tamMemoria) {
		this.tipo = tipo;

		func = new Funcoes();
		this.Cores = new Lista();
		getCores().setNomeLista("Cores");
		getCores().setDeadline(9999);

		setAtivaDeadLine(false);

		setNumCores(numCores);
		setNumProcs(numProcs);

		Lista temp = new Lista();
		this.auto_increment = temp.populaLista(getNumProcs());
		setPriori0(temp);
		getPriori0().quickSort();
		System.out.println("----");
		// getPriori0().imprime();
		System.out.println("----");
		getPriori0().setNomeLista("Aptos");

		getMemoriaLG().setTamanho(tamMemoria);
		getMemoria().setTamanho(tamMemoria);
		// Head
		getMemoriaLG().push_fim_no(new No());
		// Tail
		getMemoriaLG().push_fim_no(new No());
		getMemoriaLG().getHead().setID(777777);;
		getMemoriaLG().getTail().setID(888888);;

		getMemoriaLG().setTamanho(tamMemoria);



		iniciaCores(false);
	}


	@SuppressWarnings("unused")
	private void iniciaLTG() {
		// TODO Auto-generated method stub
		Lista core = getCores();
		Lista pri = null;

		if (	!getCores().isEmpty()
			) {
			// Funcoes.waitSec(1);
			System.out.println("----------------");
			// getCores().imprime(); // <-------------------------------------
			// tem novo proceço?
			// getCores().removeTempoExec(1);


			No temp = new No();
			No pri_temp = null;
			int priori = 0;

			if (!getAtivaRoundRobin()) {
				temp = getCores().getHead();
				while (temp != null && temp.getNext() != null) {

					if(temp.getTempExec() <= 0 || temp.getRelogio() >= temp.getDeadLineTotal() +1) {
						if (getPriori0().getHead() != null) {
							iniciaGerencMemoria(temp, getPriori0().getHead().Entrega());
						} else {
							MemoriaDesaloca(temp);
						}
						temp.setRelogio(0);
						getPriori0().pop_ini();
					}
					temp = temp.getNext();
				}


				if(temp.getTempExec() <= 0 || temp.getRelogio() >= temp.getDeadLineTotal()    +1) {
					if (getPriori0().getHead() != null) {
						iniciaGerencMemoria(temp, getPriori0().getHead().Entrega());
					} else {
						MemoriaDesaloca(temp);
					}
					temp.setRelogio(0);
					getPriori0().pop_ini();
				}
			} else {

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
			}


			priori = 0;
			No aux = new No();
			pri_temp = null;

			//aBORTADOS
			/*
			if(temp.getTempExec() <= 0 || (temp.getRelogio() >= getCores().getDeadline() +1 && getAtivaDeadLine()) ) {
				aux = getCores().getHead().Entrega();
				aux.setTempExec(aux.getQuantum());;
				priori = (getTipo() == 2)? temp.getPriori() : 0;
				pri_temp = (getPrioridade(priori)
								.getHead()
									!= null) ?
											getPrioridade(priori).
												getHead() :
													null;

				if (pri_temp != null) {

					temp.Recebe(pri_temp.Entrega());
				} else {
					temp.Recebe(new No());
					temp.setTempExec(0);
				}
				temp.setRelogio(0);
				// if (aux.getTempExec() <= 0) {
					if(aux != getAbortados().getTail()) {
						getAbortados().push_fim_no(aux);
					}
				// }
			}
			*/


			while(getCores().returnPos(getNumCores()) != null) {
				getCores().pop_fim();
			}
		}

		getBtnAdicionar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Adicionando Processos, para cancelar clique no 'X' para parar.");

				Lista list = new Lista();
				auto_increment = list.populaLista(1, (getTipo() == 2) ? true : false, auto_increment+1);

				No temp = list.getHead();
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
		});
	}
	private void iniciaCores(boolean Prioris) {
		// TODO Auto-generated method stub
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


			setBtnAdicionar(new JButton("BIBI"));
			btnAdicionar.setBounds(20, 20, 100, 420);
			this.add(getBtnAdicionar());
		}

		getCores().imprime();
	}


	public Desenhos(int tipo, Lista cores, Lista aptos) {
		this.tipo = 1;
	}
	public Desenhos(int tipo, Lista cores, Lista pri0, Lista pri1, Lista pri2, Lista pri3) {
		this.tipo = 2;
	}


	@SuppressWarnings("unused")
	public void paintComponent(Graphics g) {
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
		text = "Memoria Total " + listTemp.getTamanho() + "/Desalocado= " + (listTemp.getDesalocado());

		// Caixa Mem
		Graphics2D g2 = (Graphics2D) g;
		 // g2.setColor(new Color(86, 146, 246));
		g2.setColor(new Color(194, 194, 194));
		 // g2.draw( new Rectangle2D.Double(25, posTemp - 40, getLargNo() *7, getAlturaNo()));
		g.fillRect(25, posTemp - 40, getLargNo() *7, getAlturaNo());


		desenhaListaMem(g, listTemp, text, posTemp, true, getTipo());




		// g.setColor(Color.BLUE);;
		// g.fillRect(25, 425, getLargNo(), getAlturaNo());

		// g.setColor(new Color(190, 81, 215));
		// g.fillRect(25, 465, getLargNo(), getAlturaNo());

		// g.setColor(Color.RED);
		// g.drawString("Algum texto.", 25, 520);;
		repaint();
	}
	@SuppressWarnings("unused")
	private void desenhaLista(Graphics g, Lista listTemp, String text, int posY, boolean cortaFila, int tipo) {
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
					g2.drawString("TempExc Tot= "+ temp.getTempExecTotal(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("TempExec= "+ temp.getTempExec(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
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
					g2.drawString("TempExc Tot= "+ temp.getTempExecTotal(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("TempExec= "+ temp.getTempExec(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
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




	private boolean iniciaGerencMemoria(No algumCore, No novoProcesso) {
		boolean ret = false;

		ret = MemoriaAlocar(novoProcesso);
		
		System.out.println("Entrou");

		ret = true;
		if(ret) {
			algumCore.Recebe(novoProcesso);

		} else {
			algumCore.Recebe(new No());
			algumCore.setTempExec(0);
		}
		return ret;
	}


	@SuppressWarnings("unused")
	private boolean MemoriaAlocar(No novoProcesso) {
		
		
		if (getMemoria().getDesalocado() > novoProcesso.getTamanhoUsado()) {
			getMemoria().push_fim_no(novoProcesso.Entrega());
			this.memUsada = memUsada + novoProcesso.getTamanhoUsado();
			getMemoria().setDesalocado(getMemoria().getDesalocado() - novoProcesso.getTamanhoUsado());
		} else {
			No temp = BuscaBestFit(getMemoria(), novoProcesso.getTamanhoOrig());
			
			if(temp == null) {
				System.out.println("Out of Memory");
			} else {
				System.out.println("Encontrado " + 
						temp.getTamanhoOrig() + " tam nec "+ 
						novoProcesso.getTamanhoOrig());
				temp.Recebe(novoProcesso.Entrega());
				this.memUsada = memUsada + novoProcesso.getTamanhoUsado();
			}
		}
		return true;
	}
	@SuppressWarnings("unused")
	private boolean MemoriaAlocar3(No novoProcesso) {
		Lista ListGen = getMemoriaLG();
		Lista Memoria = getMemoria();
		boolean ret = false;
		No alocavel = null;

		ListGen.imprimeID(); boolean passa = false;
		//BestFit
		if (!getIniciouEstatisticas() && passa) {
			if(novoProcesso.getTamanhoUsado() < ListGen.getTamanho()) {
				//Permite alocação
				//  Aloca posicao na memoria
				// Memoria.push_fim_no(new No());
				//  Remove represetanção de espaço sobressalente
				ListGen.pop_fim();
				// Adiciona posição na lista de blocos livres.
				// ListGen.push_fim_no(new No());
				// Aponta fim ao novo espaço alocado na memoria.
				// ListGen.getTail().setAponta(Memoria.getTail());
			}
		}

		return true;
	}
	@SuppressWarnings("unused")
	private boolean MemoriaAlocar2(No novoProcesso) {
		Lista ListGen = getMemoriaLG();
		Lista Memoria = getMemoria();
		boolean ret = false;
		No alocavel = null;

		ListGen.imprimeID(); boolean passa = false;
		//BestFit
		if (!getIniciouEstatisticas() && passa) {
			if(novoProcesso.getTamanhoUsado() < ListGen.getTamanho()) {
				//Permite alocação
				//  Aloca posicao na memoria
				Memoria.push_fim_no(new No());
				//  Remove represetanção de espaço sobressalente
				ListGen.pop_fim();
				// Adiciona posição na lista de blocos livres.
				ListGen.push_fim_no(new No());
				// Aponta fim ao novo espaço alocado na memoria.
				ListGen.getTail().setAponta(Memoria.getTail());

				ListGen.setTamanho(ListGen.getTamanho() -novoProcesso.getTamanhoUsado());
				ListGen.push_fim(new No());
				ListGen.getTail().setTamanhoUsado(novoProcesso.getTamanhoUsado());

				alocavel = BuscaBestFit(ListGen, novoProcesso.getTamanhoUsado());

			}

			if(alocavel != null){
				ListGen.imprimeID();
				alocavel.getApontando().Recebe(novoProcesso.Entrega());
				ret = true;
			}
		}
		return ret;
	}

	private No BuscaBestFit(Lista List, int tamanho) {
		No ret = null;

		if(List.getHead() != List.getTail() && !List.isEmpty()){
			No temp = List.getHead().getNext(); //Ignora head

			int diff = temp.getTamanhoOrig() - tamanho;
			diff = diff < 0 ? diff*(-1) : diff;

			// Tamanho exato
			if(diff == 0) {
				ret = temp;
			}
			// Ignora Tail
			else if (temp.getNext() != null){
				ret = BuscaBestFit_recursive(temp.getNext(), tamanho, diff);
			}
		}

		return ret;
	}
	private No BuscaBestFit_recursive(No temp, int tamRequerido, int diff_ant) {
		No ret = null;
		int diff = temp.getTamanhoOrig() - tamRequerido;
		diff = diff < 0 ? diff*(-1) : diff;

		// TamRequerido exato
		if(diff == 0) {
			ret = temp;
		}
		// Ignora Tail
		else if (temp.getNext() != null){
			ret = BuscaBestFit_recursive(temp.getNext(), tamRequerido, diff);
		}
		if(diff_ant < diff){
			ret = temp;
		}

		return ret;
	}
	@SuppressWarnings("unused")
	private void desenhaListaMem(Graphics g, Lista listTemp, String text, int posY, boolean cortaFila, int tipo) {
		// TODO Auto-generated method stub

		if(listTemp == null || listTemp.isEmpty()) {
			System.out.println("desenhaLista: Lista não desenhada, lista vazia.");
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

			boolean exibeProcs = true;
			while (temp != null  && temp.getNext() != null && cont < 7  && exibeProcs) {

				g2.setColor(new Color(86, 146, 246));;
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				g2.setColor(Color.RED);
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("Tamanho= "+ temp.getTamanhoUsado(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("Tamanho Ori= "+ temp.getTamanhoOrig(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
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
			if(temp != null && exibeProcs) {
				g2.setColor(new Color(86, 146, 246));;
				g2.draw( new Rectangle2D.Double(getPulaNo(), posTemp, getLargNo(), getAlturaNo()));

				g2.setColor(Color.RED);
				if(temp.getTempExecTotal() < 999999) {
					// Texto
					g2.drawString("ID= "+ temp.getID(), getPulaNo() +4, posTemp + getAlturaNo()/4);
					g2.drawString("Tamanho= "+ temp.getTamanhoUsado(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 8);
					g2.drawString("Tamanho Ori= "+ temp.getTamanhoOrig(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 22);
					g2.drawString("Quantum= "+ temp.getQuantum(), getPulaNo() +4, posTemp + getAlturaNo()/3+ 34);
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
			}


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

	private void MemoriaDesaloca(No procLiberar) {
		// TODO Auto-generated method stub
		int id = procLiberar.getID();
		
		No removivel = getMemoria().buscaID(id);
		int tam = procLiberar.getTamanhoUsado();
		No limpo = new No();
		limpo.setTamanhoUsado(0);
		if(removivel != null) {
			removivel.Recebe(limpo.Entrega());
		}
		procLiberar.Recebe(limpo.Entrega());
		procLiberar.setTempExec(0);
		
	}

}


