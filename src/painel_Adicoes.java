import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import includes.Funcoes;

public class painel_Adicoes {

	private int varProc, varQuantum;
	private boolean varEdita, Bloqueado;
	private JTextField txtField_Procs, txtField_Quantuns;
	JButton btnAdicionar = new JButton("Adicionar");

	
	public painel_Adicoes() {
		setVarProc(-1);
		setVarQuantum(-1);
	}
	public painel_Adicoes(JFrame frame) {
		setVarProc(-1);
		setVarQuantum(-1);
		inicia2(frame);
	}
	
	
	public int getVarProc() {
		return this.varProc;
	}
	public void setVarProc(int varProc) {
		this.varProc = varProc;
	}
	public boolean getVarEdita(){
		return this.varEdita;
	}
	public void setVarEdita(boolean edita){
		this.varEdita = edita;
	}
	public int getVarQuantum() {
		return this.varQuantum;
	}
	public void setVarQuantum(int varQuantum) {
		this.varQuantum = varQuantum;
	}
	public boolean getBloqueado() {
		return this.Bloqueado;
	}
	// Não pode estar no contrutor.
	public void setBloqueado(boolean bloqueado) {
		this.Bloqueado = bloqueado;
		
		boolean bl = !getBloqueado();
		txtField_Procs.setEditable(bl);
		txtField_Quantuns.setEditable(bl);
		btnAdicionar.setEnabled(bl);
	}
	
	public void inicia2(JFrame frame){

		JPanel panelAdicoes = new JPanel();
		frame.getContentPane().add(panelAdicoes, BorderLayout.SOUTH);

		GridBagConstraints gbc_lblAddProc = new GridBagConstraints();
		GridBagConstraints gbc_txtField_Procs = new GridBagConstraints();
		GridBagConstraints gbc_lblAddQuantum = new GridBagConstraints();
		GridBagConstraints gbc_txtField_Quantuns = new GridBagConstraints();
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		GridBagConstraints gbc_lblEspera = new GridBagConstraints();
		GridBagConstraints gbc_chckbxAtivo = new GridBagConstraints();
		GridBagConstraints gbc_label = new GridBagConstraints();
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{305, 101, 77, 0, 0, 0, 0, 1, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAdicoes.setLayout(gbl_panel);
		
		JLabel lblAddProc = new JLabel("  Processos:");
		gbc_lblAddProc.anchor = GridBagConstraints.EAST;
		gbc_lblAddProc.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddProc.gridx = 0;
		gbc_lblAddProc.gridy = 0;
		panelAdicoes.add(lblAddProc, gbc_lblAddProc);
		
		txtField_Procs = new JTextField();
		gbc_txtField_Procs.anchor = GridBagConstraints.NORTH;
		gbc_txtField_Procs.insets = new Insets(0, 0, 5, 5);
		gbc_txtField_Procs.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtField_Procs.gridx = 1;
		gbc_txtField_Procs.gridy = 0;
		panelAdicoes.add(txtField_Procs, gbc_txtField_Procs);
		txtField_Procs.setColumns(10);
		
		JLabel lblAddQuantum = new JLabel("  Quantum:");
		gbc_lblAddQuantum.anchor = GridBagConstraints.EAST;
		gbc_lblAddQuantum.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddQuantum.gridx = 0;
		gbc_lblAddQuantum.gridy = 1;
		panelAdicoes.add(lblAddQuantum, gbc_lblAddQuantum);
		
		txtField_Quantuns = new JTextField();
		txtField_Quantuns.setColumns(10);
		gbc_txtField_Quantuns.insets = new Insets(0, 0, 5, 5);
		gbc_txtField_Quantuns.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtField_Quantuns.gridx = 1;
		gbc_txtField_Quantuns.gridy = 1;
		panelAdicoes.add(txtField_Quantuns, gbc_txtField_Quantuns);
		
		gbc_btnAdicionar.gridheight = 2;
		gbc_btnAdicionar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAdicionar.anchor = GridBagConstraints.WEST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 2;
		gbc_btnAdicionar.gridy = 0;
		panelAdicoes.add(btnAdicionar, gbc_btnAdicionar);
		
		JLabel lblEspera = new JLabel("  Espera:");
		gbc_lblEspera.anchor = GridBagConstraints.EAST;
		gbc_lblEspera.insets = new Insets(0, 0, 0, 5);
		gbc_lblEspera.gridx = 0;
		gbc_lblEspera.gridy = 2;
		panelAdicoes.add(lblEspera, gbc_lblEspera);
		
		JCheckBox chckbxAtivo = new JCheckBox("Ativo");
		gbc_chckbxAtivo.anchor = GridBagConstraints.WEST;
		gbc_chckbxAtivo.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAtivo.gridx = 1;
		gbc_chckbxAtivo.gridy = 2;
		panelAdicoes.add(chckbxAtivo, gbc_chckbxAtivo);
		
		
		JLabel label = new JLabel("");
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.gridx = 7;
		gbc_label.gridy = 2;
		panelAdicoes.add(label, gbc_label);
		
		// Máscara somente numero
		txtField_Procs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
			}
		});
		// Máscara somente numero
		txtField_Quantuns.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
			}
		});
		

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Funcoes f = new Funcoes();
				String procs, quantuns;
				
				procs = txtField_Procs.getText();
				quantuns = txtField_Quantuns.getText();
				boolean edita  = chckbxAtivo.isSelected();
				
				boolean ok = true;
				if (ok) ok = f.validaForm(procs, "Nº Processos");
				if (ok) ok = f.validaForm(quantuns, "Quantuns");
				
				if (ok){
					setVarProc(f.string2int(procs));
					setVarQuantum(f.string2int(quantuns));
					setVarEdita(edita);
					
					JOptionPane.showMessageDialog(null, "Informações capturadas.");
					
					//setBloqueado(true);
				}
				
				// System.exit(0);
			}
		});
	}

}
