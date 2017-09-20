package includes;
public class No {

	private No Back, Next;
	private int Quantum, tempExec, Priori;
	
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

	
	public No(int Quantum) {
		// TODO Auto-generated constructor stub
		setQuantum(Quantum);
		setTempExec(Quantum);
		setPriori(0);
		setBack(null);
		setNext(null);
	}
	public No(int Quantum, int Priori) {
		// TODO Auto-generated constructor stub
		setQuantum(Quantum);
		setTempExec(Quantum);
		setPriori(Priori);
		setBack(null);
		setNext(null);
	}


}
