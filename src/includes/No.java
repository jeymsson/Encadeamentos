package includes;

import java.util.Random;

public class No {

	private No Back, Next;
	private int tempExecTotal, tempExec, Priori, _ID, Relogio, DeadLineTotal, contadorIrrisorio, Quantum;
	private int Estado; // 1- pronto, 2- Esperando, 3- Executando, 4-Removido;
	private int Cor = 0; // 0- cinza, 1- azul;
	private int DadoComplementar = -1; // 1- pronto, 2- Esperando, 3- Executando;
	private int tamanhoUsado = 0, tamanhoOrig = 0;
	private No apontando = null;

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
	public No getApontando() {
		return apontando;
	}
	public void setAponta(No apontando) {
		this.apontando = apontando;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public int getID() {
		return _ID;
	}
	public void setID(int iD) {
		_ID = iD;
	}
	public int getRelogio() {
		return Relogio;
	}
	public void setRelogio(int relogio) {
		Relogio = relogio;
	}
	public int getCor() {
		return Cor;
	}
	public void setCor(int cor) {
		Cor = cor;
	}
	public int getContadorIrrisorio() {
		return contadorIrrisorio;
	}
	public void setContadorIrrisorio(int contadorIrrisorio) {
		this.contadorIrrisorio = contadorIrrisorio;
	}
	public int getTamanhoUsado() {
		return tamanhoUsado;
	}
	public void setTamanhoUsado(int tamanho) {
		this.tamanhoUsado = tamanho;
		if(getTamanhoOrig() == 0)
			setTamanhoOrig(tamanho);
	}
	public int getTamanhoOrig() {
		return tamanhoOrig;
	}
	public void setTamanhoOrig(int tamanhoOrig) {
		this.tamanhoOrig = tamanhoOrig;
	}
	public int generateID() {
		Random random = new Random();
		int valor = random.nextInt(1001);
		this._ID = valor;
		return this._ID;
	}
	public int generateQuantum() {
		Random random = new Random();
		int valor = random.nextInt(21)+10;
		valor = valor + 10;
		setQuantum(valor);
		return getQuantum();
	}
	public int generateDeadline() {
		Random random = new Random();
		int valor = random.nextInt(21);
		setDeadLineTotal(valor);;
		return getDeadLineTotal();
	}
	public int generateTamanho() {
		Random random = new Random();
		int valor = random.nextInt(1057);
		this.tamanhoUsado = valor;
		return this.tamanhoUsado;
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
		generateTamanho();
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
		generateTamanho();
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
		generateTamanho();
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
		generateTamanho();
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
		generateTamanho();
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
		setTamanhoUsado(node.getTamanhoUsado());
		setAponta(node.getApontando());
		setCor(node.getCor());
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
		node.setTamanhoUsado(getTamanhoUsado());
		node.setAponta(getApontando());
		node.setCor(getCor());
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
	public void imprimeT() {
		// TODO Auto-generated method stub
		System.out.println("TempExecTotal: " +getTempExecTotal());
		System.out.println("TempExec: " +getTempExec());
		System.out.println("Priori: " +getPriori());
		System.out.println("DadoComplementar: " +getDadoComplementar());
		System.out.println("ID: " +getID());
		System.out.println("Quantum: " +getQuantum());
		System.out.println("Estado: " +getEstado());
		System.out.println("Relogio: " +getRelogio());
		System.out.println("DeadLineTotal: " +getDeadLineTotal());
		System.out.println("TamanhoUsado: " +getTamanhoUsado());
		System.out.println("Cor: " +getCor());
	}
	public void imprime() {
		// TODO Auto-generated method stub
		System.out.print("ID: " +getID());
		System.out.print(" - TamanhoUsado: " +getTamanhoUsado());
		System.out.print(" - TamanhoOriginal: " +getTamanhoOrig());
		System.out.println(" - Cor: " +getCor());
	}


}
