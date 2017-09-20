import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import includes.Funcoes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Aplication {

	// -------------------------------------------
	private int varProc, varCores, varQuantum;
	private JTextField txtF_NProcIni;
	private JTextField txtF_NCores;
	private JTextField txtF_Quantum;
	// -------------------------------------------
	private JFrame frame;
	private JTextField txtField_Procs, txtField_Quantuns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplication window = new Aplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -------------------------------------------
		//painel_Inicial inicial = new painel_Inicial();
		//inicial.inicia(frame);
		
		
		 inicia(frame);
		// -------------------------------------------
		//painel_Adicoes adicao = new painel_Adicoes();
		//adicao.inicia2(frame);
		 inicia2(frame);
		// -------------------------------------------
		
		
	}
	
	
	
	public void inicia(JFrame frame){
		
		JPanel PainelInicial = new JPanel();
		
		GridBagLayout gbl_PainelInicial = new GridBagLayout();
		GridBagConstraints gbc_lblIniciarSimulao = new GridBagConstraints();
		GridBagConstraints gbc_lblNProcIni = new GridBagConstraints();
		GridBagConstraints gbc_lblNCores = new GridBagConstraints();
		GridBagConstraints gbc_lblQuantum = new GridBagConstraints();
		GridBagConstraints gbc_txtF_NProcIni = new GridBagConstraints();
		GridBagConstraints gbc_txtF_NCores = new GridBagConstraints();
		GridBagConstraints gbc_txtF_Quantum = new GridBagConstraints();
		GridBagConstraints gbc_btnIniciaSimu = new GridBagConstraints();
		
		Funcoes f = new Funcoes();
		
		frame.getContentPane().add(PainelInicial, BorderLayout.NORTH);
		gbl_PainelInicial.columnWidths = new int[]{355, 89, 0, 0, 0, 0, 0, 0};
		gbl_PainelInicial.rowHeights = new int[]{0, 0, 0, 0, 23, 0};
		gbl_PainelInicial.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_PainelInicial.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		PainelInicial.setLayout(gbl_PainelInicial);
		
		JLabel lblIniciarSimulao = new JLabel("Iniciar Simula\u00E7\u00E3o");
		gbc_lblIniciarSimulao.gridwidth = 2;
		gbc_lblIniciarSimulao.insets = new Insets(0, 0, 5, 5);
		gbc_lblIniciarSimulao.gridx = 0;
		gbc_lblIniciarSimulao.gridy = 0;
		PainelInicial.add(lblIniciarSimulao, gbc_lblIniciarSimulao);
		
		JLabel lblNProcIni = new JLabel("  N\u00BA Processos Iniciais:");
		gbc_lblNProcIni.insets = new Insets(0, 0, 5, 5);
		gbc_lblNProcIni.gridx = 0;
		gbc_lblNProcIni.gridy = 1;
		PainelInicial.add(lblNProcIni, gbc_lblNProcIni);
		
		txtF_NProcIni = new JTextField();
		gbc_txtF_NProcIni.insets = new Insets(0, 0, 5, 5);
		gbc_txtF_NProcIni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtF_NProcIni.gridx = 1;
		gbc_txtF_NProcIni.gridy = 1;
		PainelInicial.add(txtF_NProcIni, gbc_txtF_NProcIni);
		txtF_NProcIni.setColumns(10);
		
		
		JLabel lblNCores = new JLabel("  N\u00BA Cores:");
		gbc_lblNCores.insets = new Insets(0, 0, 5, 5);
		gbc_lblNCores.gridx = 0;
		gbc_lblNCores.gridy = 2;
		PainelInicial.add(lblNCores, gbc_lblNCores);
		
		txtF_NCores = new JTextField();
		txtF_NCores.setColumns(10);
		gbc_txtF_NCores.insets = new Insets(0, 0, 5, 5);
		gbc_txtF_NCores.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtF_NCores.gridx = 1;
		gbc_txtF_NCores.gridy = 2;
		PainelInicial.add(txtF_NCores, gbc_txtF_NCores);

		
		JLabel lblQuantum = new JLabel("  Quantum");
		gbc_lblQuantum.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantum.gridx = 0;
		gbc_lblQuantum.gridy = 3;
		PainelInicial.add(lblQuantum, gbc_lblQuantum);
		
		txtF_Quantum = new JTextField();
		txtF_Quantum.setColumns(10);
		gbc_txtF_Quantum.insets = new Insets(0, 0, 5, 5);
		gbc_txtF_Quantum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtF_Quantum.gridx = 1;
		gbc_txtF_Quantum.gridy = 3;
		PainelInicial.add(txtF_Quantum, gbc_txtF_Quantum);
		
		
		JButton btnIniciaSimu = new JButton("Iniciar");
		gbc_btnIniciaSimu.gridwidth = 2;
		gbc_btnIniciaSimu.insets = new Insets(0, 0, 0, 5);
		gbc_btnIniciaSimu.anchor = GridBagConstraints.NORTH;
		gbc_btnIniciaSimu.gridx = 0;
		gbc_btnIniciaSimu.gridy = 4;
		PainelInicial.add(btnIniciaSimu, gbc_btnIniciaSimu);
		

		// Máscara somente numero
		txtF_NProcIni.addKeyListener(new KeyAdapter() {
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
		txtF_NCores.addKeyListener(new KeyAdapter() {
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
		txtF_Quantum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
			}
		});
		
		
		btnIniciaSimu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String procs, cores, quantuns;
				
				procs = txtF_NProcIni.getText();
				cores = txtF_NCores.getText();
				quantuns = txtF_Quantum.getText();
				
				boolean ok = true;
				if (ok) ok = f.validaForm(procs, "Nº Processos Iniciais");
				if (ok) ok = f.validaForm(cores, "Nº Cores Iniciais");
				if (ok) ok = f.validaForm(quantuns, "Quantuns");
				
				if (ok){
					JOptionPane.showMessageDialog(null, "Informações capturadas.");
					
					txtF_NProcIni.setEditable(false);
					txtF_NCores.setEditable(false);
					txtF_Quantum.setEditable(false);
					btnIniciaSimu.setEnabled(false);
				}
				
				// System.exit(0);
			}
		});
		
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
		
		JButton btnAdicionar = new JButton("Adicionar");
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
				String procs, cores, quantuns;
				
				procs = txtField_Procs.getText();
				quantuns = txtField_Quantuns.getText();
				boolean edita  = chckbxAtivo.isSelected();
				
				boolean ok = true;
				if (ok) ok = f.validaForm(procs, "Nº Processos");
				if (ok) ok = f.validaForm(quantuns, "Quantuns");
				
				if (ok){
					JOptionPane.showMessageDialog(null, "Informações capturadas.");
					
					// txtField_Procs.setEditable(false);
					// txtField_Quantuns.setEditable(false);
					// btnAdicionar.setEnabled(false);
				}
				
				// System.exit(0);
			}
		});
	}

}
