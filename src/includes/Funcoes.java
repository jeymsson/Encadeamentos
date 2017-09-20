package includes;

import javax.swing.JOptionPane;

public class Funcoes {

	public Funcoes() {
		// TODO Auto-generated constructor stub
	}
	
	public int string2int(String str){
		return Integer.parseInt(str);
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

	public void waitSec(int i) {
		// TODO Auto-generated method stub
		try {
			new Thread().sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
