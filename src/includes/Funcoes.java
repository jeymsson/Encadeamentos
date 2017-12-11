package includes;

import java.util.Arrays;

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
	   int[] values = {1,2,2,3,3,5,5,5,7,7,7,7};
		int[] ignorar = {5, 7};
//		System.out.println(mostPopular(values));
//		System.out.println(mostPopular(values, 7));
//		System.out.println(mostPopular(values, ignorar));
		int ret[] = mostPopular(values);
		for (int i : ret) {
			System.out.println(i);
		}
		
	}
   public static int[] mostPopular(int[] populares) {
		int[] ret = new int[4];
		for (int i = 0; i < 4; i++) {
			ret[i] = mostPopularr(populares, ret);
		}
//		Arrays.sort(ret);
		return ret;
	}
	private static int mostPopularr(int[] a, int[] ignorar){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		
		int len = ignorar.length; boolean passa = true;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			for (int k = 0; k < len; k++) {
				passa = existeEm(ignorar, temp);
				if(!passa) {
					tempCount = 0;
					for (int j = 1; j < a.length; j++)
					{
						if (temp == a[j])
							tempCount++;
					}
					if (tempCount > count)
					{
						popular = temp;
						count = tempCount;
					}
				}
			}
		}
		return popular;
	}
	private static int mostPopularr(int[] a, int ignorar){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		
		int len = 1; boolean passa = true;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			for (int k = 0; k < len; k++) {
				passa = ignorar == temp;
				if(!passa) {
					tempCount = 0;
					for (int j = 1; j < a.length; j++)
					{
						if (temp == a[j])
							tempCount++;
					}
					if (tempCount > count)
					{
						popular = temp;
						count = tempCount;
					}
				}
			}
		}
		return popular;
	}
	private static int mostPopularr(int[] a){
		int count = 1, tempCount;
		int popular = a[0];
		int temp = 0;
		for (int i = 0; i < (a.length - 1); i++)
		{
			temp = a[i];
			tempCount = 0;
			for (int j = 1; j < a.length; j++)
			{
				if (temp == a[j])
					tempCount++;
			}
			if (tempCount > count)
			{
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}
	private static boolean existeEm(int[] array, int valor) {
		boolean ret = false;
		for (int i : array) {
			if (i == valor) {
				return true;
			}
		}
		return ret;
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
