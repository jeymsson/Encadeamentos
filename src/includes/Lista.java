package includes;

import java.util.Random;

public class Lista {

	No head, tail;
	int qtdNos;
	boolean ativaLogs = false;

	public Lista() {
		// TODO Auto-generated constructor stub
		setHead(null);
		setTail(null);
		setQtdNos(0);
	}
	
	public int getQtdNos() {
		return this.qtdNos;
	}
	public void setQtdNos(int qtdNos) {
		this.qtdNos = qtdNos;
	}
	
	public boolean getAtivaLogs() {
		return this.ativaLogs;
	}
	public void setAtivaLogs(boolean ativaLogs) {
		this.ativaLogs = ativaLogs;
	}
	
	public No getHead() {
		return this.head;
	}
	public void setHead(No head) {
		this.head = head;
	}

	public No getTail() {
		return this.tail;
	}
	public void setTail(No tail) {
		this.tail = tail;
	}

	public boolean isEmpty() {
		boolean temp = true;
		if (getHead() !=  null) {
			temp = false;
		}
		return temp;
	}

	void imprime() {
		if (isEmpty()) {
			System.out.println("Lista Vazia");
		} else {
			No temp = getHead();
			while (temp.getNext() != null) {
				System.out.println("Temp exec.: " + temp.getTempExec());
				
				temp = temp.getNext();
			}
			System.out.println("Temp exec.: " + temp.getTempExec());
		}
	}
	
	
	public void push_fim(int Quantum) {
		No novo = new No(Quantum);
		if (isEmpty()) {
			if (getAtivaLogs()) {
				System.out.println("Lista Vazia, adicionando inicio.");
			}
			setHead(novo);
			setTail(novo);
		} else {
			No temp = getTail();

			temp.setNext(novo);;
			novo.setBack(temp);
			setTail(novo);
		}
		setQtdNos(getQtdNos() +1);
	}
	public void push_ini(int Quantum) {
		No novo = new No(Quantum);
		if (isEmpty()) {
			if (getAtivaLogs()) {
				System.out.println("Lista Vazia, adicionando inicio.");
			}
			setHead(novo);
			setTail(novo);
		} else {
			No temp = getHead();

			novo.setNext(temp);;
			temp.setBack(novo);
			setHead(novo);;
		}
		setQtdNos(getQtdNos() +1);
	}
	public void push_pos(int index, int Quantum) {
		No novo = new No(Quantum);
		if (isEmpty()) {
			if (getAtivaLogs()) {
				System.out.println("Lista Vazia, adicionando inicio.");
			}
			setHead(novo);
			setTail(novo);
		} else {
			No temp = getHead();
			
			int cont = 0;
			while (temp.getNext() != null && cont != index) {
				temp = temp.getNext();
				cont++;
			}
			
			if(cont != index) {
				if (getAtivaLogs()) {
					System.out.println("Adicionando no fim");
				}
				temp.setNext(novo);;
				novo.setBack(temp);
				setTail(novo);
			} else {
				if (getAtivaLogs()) {
					System.out.println("Chegou ao indice, adicionando na posição");
				}
				novo.setBack(temp.getBack());
				if (temp.getBack() != null) {
					temp.getBack().setNext(novo);
				} else {
					setHead(novo);
				}
				temp.setBack(novo);
				novo.setNext(temp);
			}
		}
		setQtdNos(getQtdNos() +1);
	}
/*
	public void organiza() {
		if (isEmpty()) {
			if (getAtivaLogs()) {
				System.out.println("Lista Vazia, adicionando inicio.");
			}
		} else if (getHead().getNext() == getTail()) {
			if(getHead().getTempExec() > getTail().getTempExec()) {
				No atual = getHead();
				No prox = getTail();
				atual.setBack(prox);
				prox.setNext(atual);
				prox.setBack(null);
				atual.setNext(null);
				setHead(prox);
				setTail(atual);
			}
		} else {
			No atual = getHead();
			No prox = null;
			
			while (atual.getNext() != null) {
				prox = atual.getNext();
				
				System.out.println("Atual a: " + atual.getBack().getTempExec());
				System.out.println("Atual p: " + prox.getNext().getTempExec());
				System.out.println("Prox a: " + atual.getBack().getTempExec());
				System.out.println("Prox p: " + prox.getNext().getTempExec());
				
				
				if (atual.getTempExec() > prox.getTempExec()) {
					
					atual.setNext(prox.getNext());
					if (atual == getHead()) {
						setHead(prox);
					} else {
						prox.setBack(atual.getBack());
					}
					if (prox == getTail()) {
						setTail(atual);
					} else {
						prox.getNext().setBack(atual);
					}
					
					prox.setNext(atual);
				}
				atual = atual.getNext();
			}
		}
	}
*/
	
	public No pop_fim() {
		No retorno  = null;
		if (isEmpty()) {
			System.out.println("Não removido, lista vazia.");
		} else if (getHead() == getTail()) {
			retorno = getHead();
			setHead(null);
			setTail(null);

			setQtdNos(getQtdNos() -1);
		} else {
			retorno = getTail();
			
			setTail(getTail().getBack());
			getTail().setNext(null);
			setQtdNos(getQtdNos() -1);
		}
		return retorno;
	}
	public No pop_ini() {
		No retorno  = null;
		if (isEmpty()) {
			System.out.println("Não removido, lista vazia.");
		} else if (getHead() == getTail()) {
			retorno = getHead();
			setHead(null);
			setTail(null);

			setQtdNos(getQtdNos() -1);
		} else {
			retorno = getHead();
			
			setHead(getHead().getNext());
			getHead().setBack(null);

			setQtdNos(getQtdNos() -1);
		}
		return retorno;
	}
	public No pop_pos(int index) {
		No retorno  = null;
		if (isEmpty()) {
			System.out.println("Não removido, lista vazia.");
		} else if (getHead() == getTail()) {
			System.out.println("Removendo primeiro.");
			retorno = getHead();
			setHead(null);
			setTail(null);

			setQtdNos(getQtdNos() -1);
		} else {
			No temp = getHead();
			
			int cont = 0;
			while (temp.getNext() != null && cont != index) {
				temp = temp.getNext();
				cont++;
			}
			
			if(cont != index) {
				if (getAtivaLogs()) {
					System.out.println("Removendo fim");
				}
				retorno = getTail();
				setTail(getTail().getBack());
				getTail().setNext(null);
				setQtdNos(getQtdNos() -1);
			} else {
				if (getAtivaLogs()) {
					System.out.println("Chegou ao indice, removendo na posição");
				}
				retorno = temp;
				
				if (temp == getHead()) {
					retorno = getHead();
					setHead(null);
					setTail(null);
				} else if(temp == getTail()) {
					retorno = getTail();
					setTail(getTail().getBack());
					getTail().setNext(null);
				} else {
					retorno = temp;
					temp.getNext().setBack(temp.getBack().getBack());
					temp.getBack().setNext(temp.getNext().getNext());
				}
				setQtdNos(getQtdNos() -1);
			}
		}
		return retorno;
	}

	
	
	
	public void populaLista(int numNos) {
		if(!isEmpty()) {
			System.out.println("Já existe algo na arvore");
		} else {
			Random random = new Random();
			int valor;
			for (int i = 0; i < numNos; i++) {
				valor = random.nextInt(21);
				valor = valor < 4 ? 4 : valor;
				
				push_fim(valor);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Funcoes f = new Funcoes();
		Lista l = new Lista();
		l.setAtivaLogs(true);;
		l.push_fim(3);
		l.push_fim(2);
		l.push_fim(4);
		l.push_fim(5);
		l.push_fim(4);
//		l.organiza();
		l.imprime();
//		System.out.println("Ult: " + l.getTail().getTempExec());
//		System.out.println("Qtd: " + l.getQtdNos());
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i + 1);
			f.waitSec(1);
		}
	}

}
