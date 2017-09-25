package includes;

import java.util.Random;

public class No {

	private No Back, Next;
	private int Quantum, tempExec, Priori, ID, Relogio, contadorIrrisorio;
	private int Estado; // 1- pronto, 2- Esperando, 3- Executando;
	
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
	
	public int getQuantum() {
		return this.Quantum;
	}
	public void setQuantum(int quantum) {
		this.Quantum = quantum;
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
		int valor = Funcoes.string2int("0" + random.nextInt(10001));
		this.ID = valor;
		return this.ID;
	}
	
	
	
	public No(int Quantum) {
		// TODO Auto-generated constructor stub
		setQuantum(Quantum);
		setTempExec(Quantum);
		setPriori(0);
		setBack(null);
		setNext(null);
		generateID();
		setEstado(1);
		setRelogio(0);
	}
	public No(int Quantum, int Priori) {
		// TODO Auto-generated constructor stub
		setQuantum(Quantum);
		setTempExec(Quantum);
		setPriori(Priori);
		setBack(null);
		setNext(null);
		generateID();
		setEstado(1);
		setRelogio(0);
	}
	public No(int Quantum, int TempExec, int Priori) {
		// TODO Auto-generated constructor stub
		setQuantum(Quantum);
		setTempExec(TempExec);
		setPriori(Priori);
		setBack(null);
		setNext(null);
		generateID();
		setEstado(1);
		setRelogio(0);
	}
	public No() {
		// TODO Auto-generated constructor stub
		setQuantum(999999);
		setTempExec(999999);
		setPriori(999999);
		setBack(null);
		setNext(null);
		generateID();
		setEstado(1);
		setRelogio(0);
	}
	public void Recebe(No node) {
		// TODO Auto-generated method stub
		setQuantum(node.getQuantum());
		setTempExec(node.getTempExec());
		setPriori(node.getPriori());
//		setBack(null);
//		setNext(null);
		setID(node.getID());
		setEstado(node.getEstado());
		setRelogio(node.getRelogio());
	}
	public No Entrega() {
		// TODO Auto-generated method stub
		No node = new No();
		node.setQuantum(getQuantum());
		node.setTempExec(getTempExec());
		node.setPriori(getPriori());
//		setBack(null);
//		setNext(null);
		node.setID(getID());
		node.setEstado(getEstado());
		node.setRelogio(getRelogio());
		return node;
	}
	public No getHead() {
		// TODO Auto-generated method stub
		return null;
	}


}
