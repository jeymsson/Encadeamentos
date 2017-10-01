package includes;

import java.util.Random;

public class No {

	private No Back, Next;
	private int tempExecTotal, tempExec, Priori, ID, Relogio, DeadLineTotal, contadorIrrisorio, Quantum;
	private int Estado; // 1- pronto, 2- Esperando, 3- Executando;
	private int DadoComplementar = -1; // 1- pronto, 2- Esperando, 3- Executando;
	
	public int getTempExec() {
		return this.tempExec;
	}
	public void setTempExec(int tempExec) {
		this.tempExec = tempExec;
	}
	
	public int getPriori() {
		return this.Priori;
	}
	public void setPriori(int priori) {
		this.Priori = priori;
	}
	
	public int getTempExecTotal() {
		return this.tempExecTotal;
	}
	public void setTempExecTotal(int quantum) {
		this.tempExecTotal = quantum;
	}

	public int getQuantum() {
		return Quantum;
	}
	public void setQuantum(int quantum) {
		Quantum = quantum;
	}
	public No getBack() {
		return this.Back;
	}
	public void setBack(No back) {
		this.Back = back;
	}
	public No getNext() {
		return this.Next;
	}
	public void setNext(No next) {
		this.Next = next;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getRelogio() {
		return Relogio;
	}
	public void setRelogio(int relogio) {
		Relogio = relogio;
	}
	public int getContadorIrrisorio() {
		return contadorIrrisorio;
	}
	public void setContadorIrrisorio(int contadorIrrisorio) {
		this.contadorIrrisorio = contadorIrrisorio;
	}
	public int generateID() {
		Random random = new Random();
		int valor = random.nextInt(1001);
		this.ID = valor;
		return this.ID;
	}
	public int generateQuantum() {
		Random random = new Random();
		int valor = random.nextInt(21);
		setQuantum(valor);;
		return getQuantum();
	}
	public int generateDeadline() {
		Random random = new Random();
		int valor = random.nextInt(21);
		setDeadLineTotal(valor);;
		return getDeadLineTotal();
	}
	
	
	
	public No(int Quantum) {
		// TODO Auto-generated constructor stub
		setTempExecTotal(Quantum);
		setTempExec(Quantum);
		setPriori(0);
		setDadoComplementar(getPriori());
		setBack(null);
		setNext(null);
		generateID();
		generateQuantum();
		setEstado(1);
		setRelogio(0);
		generateDeadline();
	}
	public No(boolean b, int rel) {
		// TODO Auto-generated constructor stub
		setTempExecTotal(0);
		setTempExec(0);
		setPriori(0);
		setDadoComplementar(getPriori());
		setBack(null);
		setNext(null);
		generateID();
		generateQuantum();
		setEstado(1);
		setRelogio(rel);
		setDeadLineTotal(rel);
	}
	public No(int Quantum, int Priori) {
		// TODO Auto-generated constructor stub
		setTempExecTotal(Quantum);
		setTempExec(Quantum);
		setPriori(Priori);
		setDadoComplementar(getPriori());
		setBack(null);
		setNext(null);
		generateID();
		generateQuantum();
		setEstado(1);
		setRelogio(0);
		generateDeadline();
	}
	public No(int Quantum, int TempExec, int Priori) {
		// TODO Auto-generated constructor stub
		setTempExecTotal(Quantum);
		setTempExec(TempExec);
		setPriori(Priori);
		setDadoComplementar(getPriori());
		setBack(null);
		setNext(null);
		generateID();
		generateQuantum();
		setEstado(1);
		setRelogio(0);
		generateDeadline();
	}
	public No() {
		// TODO Auto-generated constructor stub
		setTempExecTotal(999999);
		setTempExec(999999);
		setPriori(999999);
		setDadoComplementar(getPriori());
		setBack(null);
		setNext(null);
		generateID();
		generateQuantum();
		setEstado(1);
		setRelogio(0);
		generateDeadline();
	}
	public void Recebe(No node) {
		// TODO Auto-generated method stub
		setTempExecTotal(node.getTempExecTotal());
		setTempExec(node.getTempExec());
		setPriori(node.getPriori());
		//Não recebe DadoComplementar
//		setBack(null);
//		setNext(null);
		setID(node.getID());
		setQuantum(node.getQuantum());
		setEstado(node.getEstado());
		setRelogio(node.getRelogio());
		setDeadLineTotal(node.getDeadLineTotal());
	}
	public No Entrega() {
		// TODO Auto-generated method stub
		No node = new No();
		node.setTempExecTotal(getTempExecTotal());
		node.setTempExec(getTempExec());
		node.setPriori(getPriori());
		//Não entrega DadoComplementar
//		setBack(null);
//		setNext(null);
		node.setID(getID());
		node.setQuantum(getQuantum());
		node.setEstado(getEstado());
		node.setRelogio(getRelogio());
		node.setDeadLineTotal(getDeadLineTotal());
		return node;
	}
	public No getHead() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getDadoComplementar() {
		return DadoComplementar;
	}
	public void setDadoComplementar(int dadoComplementar) {
		DadoComplementar = dadoComplementar;
	}
	public int getDeadLineTotal() {
		return DeadLineTotal;
	}
	public void setDeadLineTotal(int deadLineTotal) {
		DeadLineTotal = deadLineTotal;
	}


}
