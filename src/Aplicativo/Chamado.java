package Aplicativo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Chamado extends JDialog {

	private final int largY= 600, largX= 800;
	private final JPanel contentPanel = new JPanel();
	
	public int getLargY() {
		return largY;
	}
	public int getLargX() {
		return largX;
	}


	
	
	public static void main(String[] args) {
			Chamado dialog = new Chamado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}

	
	
	private void monta_Contrutor() {

		setBounds(80*4, 80*2, getLargX(), getLargY());
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Chamado(JFrame frame) {
		//O true do super impedirá de acessar o framePrincipal enquanto esta tela estiver visible
		super(frame,true);
		//Aqui impedirá de usar o button de fechar a tela
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		monta_Contrutor();

		inicia_Programa();
	}
	public Chamado() {
		monta_Contrutor();
		
		inicia_Programa();
	}

	private void inicia_Programa() {
		// TODO Auto-generated method stub

		getContentPane().setBackground(SystemColor.activeCaption);
		
		JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        flowLayout.setHgap(10);
        flowLayout.setAlignOnBaseline(true);
 
        
        Desenhos p = new Desenhos();
		this.add(p);
		this.setSize(getLargX(), getLargY());
//		this.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
}












