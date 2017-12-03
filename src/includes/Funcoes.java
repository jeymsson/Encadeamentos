package includes;

import javax.swing.JOptionPane;

import encadeamento.RR;

public class Funcoes {

	public Funcoes() {
		// TODO Auto-generated constructor stub
	}
	
	public static int string2int(String str){
		return Integer.parseInt(str);
	}
	public static String int2string(int i){
		return Integer.toString(i);
	}
	
	//public boolean empty(int value){	
	//}
	
   // generic method printArray
   public static < E > void printGenericsArray( E[] inputArray ) {
      // Display array elements
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
   }
   
   public boolean emptyI(int value){
	   return (value != 0 ? false : true);
   }
   
   public boolean emptyS(String value){
	   return (value.isEmpty() ? true : false);
   }
   
   public static boolean validaForm(String value, String Texto){
	   if(value.isEmpty()){
		   JOptionPane.showMessageDialog(null, "O campo " +Texto+ " deve ser utilizado.");
		   return false;
	   } else {
		   return true;
	   }
   }

   public static void waitSec(int i) {
		// TODO Auto-generated method stub
		try {
			new Thread();
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   public static void repassaFila(Lista removeHead, Lista insereCore, int indexCore) {
		// TODO Auto-generated method stub
		if(removeHead.isEmpty()) {
			System.out.println("repassaFila: lista removeHead vazia.");
		} else {
			No head = new No(removeHead.getHead().getTempExecTotal(), 
							 removeHead.getHead().getTempExec(), 
							 removeHead.getHead().getPriori() );
			head.setEstado(3);
			
			removeHead.pop_ini();
			// No insereCore.getPosition();
			if (insereCore.returnPos(indexCore) != null) {
//				insereCore.pop_pos(indexCore);
			}
			insereCore.push_pos_no(indexCore, head);
			
			removeHead.up_estados();
			insereCore.up_estados_all(3);;
//			System.out.println("----");
//			insereCore.imprime();
//			System.out.println("repassaFila: " + head.getQuantum());;
		}
	}
   public static void repassaFila2(Lista removeHead, Lista insereCore, int indexCore) {
		// TODO Auto-generated method stub
		if(removeHead.isEmpty()) {
			System.out.println("repassaFila: lista removeHead vazia.");
		} else {
			No inicioFila = new No(removeHead.getHead().getTempExecTotal(), 
							 removeHead.getHead().getTempExec(), 
							 removeHead.getHead().getPriori() );
			inicioFila.setEstado(3);
			
			removeHead.pop_ini();
			
			No remo = insereCore.returnPos(indexCore);
			
			if (remo != null) {
				if(remo.getBack() != null) {
					inicioFila.setBack(remo.getBack());
					remo.getBack().setNext(inicioFila);
				}
				if(remo.getNext() != null) {
					inicioFila.setNext(remo.getNext());
					remo.getNext().setBack(inicioFila);
				}
				remo.setBack(null);
				remo.setNext(null);
			}
			
			
			removeHead.up_estados();
			insereCore.up_estados_all(3);;
//			System.out.println("----");
//			insereCore.imprime();
//			System.out.println("repassaFila: " + head.getQuantum());;
		}
	}
	
   public static void main(String[] args) {
		
		Lista l = new Lista();
		
		
//		Lista r = new Lista();
//		l.setAtivaLogs(true);
//		
		l.push_fim(10, 0, 0);
		l.push_fim(20, 0, 1);
		l.push_fim(30, 0, 3);
		System.out.println(l.temNoTempoZerado().getTempExecTotal());
		
		
//		r.push_fim(40, 2);
//		r.push_fim(50, 1);
//		
//		l.imprime();
//		repassaFila(l, r, 0);
//		System.out.println("----");
//		l.imprime();
		
	}
    // dump() - 3 funcoes genericas
	public static <G> int dump(G[] valor){
		int ret = 0;
		int cont=0;
		for (G m : valor) {
			System.out.print(m+" ");
			cont++;
		}
		System.out.println();
		if(cont >0){
			ret = 1;
		}
		return ret;
	}
	public static <G> int dump(G valor){
		int ret = 0;
		int cont=0;
		//for (G m : valor) {
			System.out.print(valor+" ");
			//cont++;
		//}
		System.out.println();
		//if(cont >0){
			ret = 1;
		//}
		return ret;
	}



}
