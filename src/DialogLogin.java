import java.awt.Frame;

import javax.swing.JDialog;

public class DialogLogin extends JDialog{

    public DialogLogin(Frame frame){
        //O true do super impedir� de acessar o framePrincipal enquanto esta tela estiver visible
        super(frame,true);
       //Aqui impedir� de usar o button de fechar a tela
       setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    //Esse m�todo vai no bot�o para confirmar login
    private void login(){
        //regras para login
//       if(loginOk){
           this.dispose();
//       }
    }

    //Este m�todo vai no bot�o de cancelar
    private void cancel(){
       System.exit(0);
    }

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	}

}
