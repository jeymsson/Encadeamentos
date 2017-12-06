package Aplicativo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import Testes.Peach;
import encadeamento.LTG;
import encadeamento.RR;
import encadeamento.SJF;
import includes.Funcoes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class Aplicativo {

	private JFrame frame;
	private JTextField txtNumCores;
	private JTextField txtNumProcessos;
	private boolean ativaLogs = false;
	private int intNumCores, intNumProcessos;
	private JTextField txtDeadline;
	private JTextField txtMemoriaTam;

	public boolean getAtivaLogs() {
		return ativaLogs;
	}
	public void setAtivaLogs(boolean ativaLogs) {
		this.ativaLogs = ativaLogs;
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicativo window = new Aplicativo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Aplicativo() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		// Grids
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		GridBagConstraints gbc_lblEscalonamento = new GridBagConstraints();
		GridBagConstraints gbc_comboEscalonamento = new GridBagConstraints();
		GridBagConstraints gbc_lblNumCores = new GridBagConstraints();
		GridBagConstraints gbc_txtNumCores = new GridBagConstraints();
		GridBagConstraints gbc_lblNumProcessos = new GridBagConstraints();
		GridBagConstraints gbc_txtNumProcessos = new GridBagConstraints();
		GridBagConstraints gbc_lblDeadline = new GridBagConstraints();
		GridBagConstraints gbc_txtDeadline = new GridBagConstraints();


		JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);

		JLabel lblInicio = new JLabel("Inicio");
			gbc_lblInicio.gridwidth = 3;
			gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lblInicio.gridx = 0;
			gbc_lblInicio.gridy = 0;
			panel.add(lblInicio, gbc_lblInicio);

		JLabel lblEscalonamento = new JLabel("Escalonamento:");
			gbc_lblEscalonamento.insets = new Insets(0, 0, 5, 5);
			gbc_lblEscalonamento.anchor = GridBagConstraints.EAST;
			gbc_lblEscalonamento.gridx = 1;
			gbc_lblEscalonamento.gridy = 1;
			panel.add(lblEscalonamento, gbc_lblEscalonamento);

		JComboBox comboEscalonamento = new JComboBox();
			comboEscalonamento.setModel(new DefaultComboBoxModel(new String[] {"0 - Escolha uma op\u00E7\u00E3o", "1 - SJF", "2 - Round Robin", "3 - LTG"}));
			gbc_comboEscalonamento.insets = new Insets(0, 0, 5, 5);
			gbc_comboEscalonamento.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboEscalonamento.gridx = 2;
			gbc_comboEscalonamento.gridy = 1;
			panel.add(comboEscalonamento, gbc_comboEscalonamento);

		JLabel lblNumCores = new JLabel("Num Cores:");
			gbc_lblNumCores.anchor = GridBagConstraints.EAST;
			gbc_lblNumCores.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumCores.gridx = 1;
			gbc_lblNumCores.gridy = 2;
			panel.add(lblNumCores, gbc_lblNumCores);

		txtNumCores = new JTextField();
		txtNumCores.setText("4");
		gbc_txtNumCores.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumCores.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumCores.gridx = 2;
		gbc_txtNumCores.gridy = 2;
		panel.add(txtNumCores, gbc_txtNumCores);
		txtNumCores.setColumns(10);

		JLabel lblNumProcessos = new JLabel("Num Processos:");
			gbc_lblNumProcessos.anchor = GridBagConstraints.EAST;
			gbc_lblNumProcessos.insets = new Insets(0, 0, 5, 5);
			gbc_lblNumProcessos.gridx = 1;
			gbc_lblNumProcessos.gridy = 3;
			panel.add(lblNumProcessos, gbc_lblNumProcessos);

		txtNumProcessos = new JTextField();
		txtNumProcessos.setText("10");
		gbc_txtNumProcessos.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumProcessos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumProcessos.gridx = 2;
		gbc_txtNumProcessos.gridy = 3;
		panel.add(txtNumProcessos, gbc_txtNumProcessos);
		txtNumProcessos.setColumns(10);

		JLabel lblDeadline = new JLabel("Deadline:");
			gbc_lblDeadline.anchor = GridBagConstraints.EAST;
			gbc_lblDeadline.insets = new Insets(0, 0, 5, 5);
			gbc_lblDeadline.gridx = 1;
			gbc_lblDeadline.gridy = 4;
			panel.add(lblDeadline, gbc_lblDeadline);

		txtDeadline = new JTextField();
		txtDeadline.setEditable(false);
		gbc_txtDeadline.insets = new Insets(0, 0, 5, 5);
		gbc_txtDeadline.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDeadline.gridx = 2;
		gbc_txtDeadline.gridy = 4;
		panel.add(txtDeadline, gbc_txtDeadline);
		txtDeadline.setColumns(10);
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();


		// Máscara somente numero
		txtNumCores.addKeyListener(new KeyAdapter() {
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
		txtNumProcessos.addKeyListener(new KeyAdapter() {
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
		txtDeadline.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
			}
		});
		
		JLabel lblAlocadorDeMemoria = new JLabel("Alocador de Memoria");
			GridBagConstraints gbc_lblAlocadorDeMemoria = new GridBagConstraints();
			gbc_lblAlocadorDeMemoria.anchor = GridBagConstraints.EAST;
			gbc_lblAlocadorDeMemoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblAlocadorDeMemoria.gridx = 1;
			gbc_lblAlocadorDeMemoria.gridy = 5;
			panel.add(lblAlocadorDeMemoria, gbc_lblAlocadorDeMemoria);
		
		JComboBox comboMem = new JComboBox();
			comboMem.setModel(new DefaultComboBoxModel(new String[] {"1 - Best-Fit", "2 - Quick-Fit", "3 - Merge-Fit"}));
			GridBagConstraints gbc_comboMem = new GridBagConstraints();
			gbc_comboMem.insets = new Insets(0, 0, 5, 5);
			gbc_comboMem.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboMem.gridx = 2;
			gbc_comboMem.gridy = 5;
			panel.add(comboMem, gbc_comboMem);
		
		JLabel lblTamMem = new JLabel("Tamanho Mem\u00F3ria");
			GridBagConstraints gbc_lblTamMem = new GridBagConstraints();
			gbc_lblTamMem.anchor = GridBagConstraints.EAST;
			gbc_lblTamMem.insets = new Insets(0, 0, 5, 5);
			gbc_lblTamMem.gridx = 1;
			gbc_lblTamMem.gridy = 6;
			panel.add(lblTamMem, gbc_lblTamMem);
		
		txtMemoriaTam = new JTextField();
		txtMemoriaTam.setText("2048");
		txtMemoriaTam.setColumns(10);
		GridBagConstraints gbc_txtMemoriaTam = new GridBagConstraints();
		gbc_txtMemoriaTam.insets = new Insets(0, 0, 5, 5);
		gbc_txtMemoriaTam.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMemoriaTam.gridx = 2;
		gbc_txtMemoriaTam.gridy = 6;
		panel.add(txtMemoriaTam, gbc_txtMemoriaTam);


		JButton btnIniciar = new JButton("INICIAR");
			gbc_btnIniciar.gridwidth = 5;
			gbc_btnIniciar.gridx = 0;
			gbc_btnIniciar.gridy = 8;
			panel.add(btnIniciar, gbc_btnIniciar);

		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Funcoes f = new Funcoes();
				String NumCores, NumProcessos, comboEsc, Deadline, txtMemoria;
				int escl = comboEscalonamento.getSelectedIndex();
				int escl_Mem = comboMem.getSelectedIndex() +1;

//				
				escl = 1;
				NumCores = txtNumCores.getText();
				NumProcessos = txtNumProcessos.getText();
				Deadline = txtDeadline.getText();
				txtMemoria = txtMemoriaTam.getText();
				comboEsc = (escl != 0) ? f.int2string(escl) : "" ;
				// boolean edita  = chckbxAtivo.isSelected();

				// f.dump("Escolha bruta " + escl);
				// f.dump(slider.);
				
				int tam_mem = 1024 *2;
				if(true) {
					
					// Validacoes
					boolean ok = true;
					if (ok) ok = f.validaForm(comboEsc, "Escalonamento");
					if (ok) ok = f.validaForm(NumCores, "Nº Cores");
					if (ok) ok = f.validaForm(NumProcessos, "Nº Processos");
					if (ok) ok = f.validaForm(txtMemoria, "Tam Memoria");
					if(escl == 3) {
						if (ok) ok = f.validaForm(Deadline, "Deadline");
					}
					// Mensagem do tipo Alocamento
					if (ok) {
						String tx_escl_Mem
							= escl_Mem == 1 ? "Foi selecionado Alocamento Best-Fit"
							  : escl_Mem == 2 ? "Foi selecionado Alocamento Quick-Fit"
							  : escl_Mem == 3 ? "Foi selecionado Alocamento Merge-Fit"
							  : escl_Mem == 0 ? "Não foi selecionado alocamento de memoria."
							  : "Não foi selecionado alocamento de memoria.";
//						JOptionPane.showMessageDialog(null, tx_escl_Mem);
					}
					
					if (ok) {
						// JOptionPane.showMessageDialog(null, "Informações capturadas.");
						JFrame frame = new JFrame("Exibição");
						int Cores = f.string2int(NumCores)
								, Processos = f.string2int(NumProcessos);
						
						// SJF
						if (escl == 1) {
							if (getAtivaLogs()) {
								JOptionPane.showMessageDialog(null, "Cores: " + Cores
										+ ", Processos: " + Processos
										+ ", Shortest Job First");
							}
							
							Desenhos desenho = new Desenhos(1, Cores, Processos, escl_Mem, false, f.string2int(txtMemoria));
							frame.getContentPane().add(desenho);
							frame.setSize(800, 600);
							frame.setVisible(true);
						} 
						// Round Robin
						else if (escl == 2) {
							if (getAtivaLogs()) {
								JOptionPane.showMessageDialog(null, "Cores: " + Cores
										+ ", Processos: " + Processos
										+ ", Round Robin com lista de prioridade");
							}
							
							Desenhos desenho = new Desenhos(2, Cores, Processos, true);
							frame.getContentPane().add(desenho);
							// frame.getContentPane().add(new Button("Texto"));
							frame.setSize(800, 600);
							frame.setVisible(true);
						} 
						// LTG
						else if (escl == 3) {
							if (getAtivaLogs()) {
								JOptionPane.showMessageDialog(null, "Cores: " + Cores
										+ ", Processos: " + Processos
										+ ", Least Time to Go");
							}
							
							Desenhos desenho = new Desenhos(3, Cores, Processos, f.string2int(Deadline), 1);
							frame.getContentPane().add(desenho);
							frame.setSize(800, 600);
							frame.setVisible(true);
						} 
						// Erro
						else {
							JOptionPane.showMessageDialog(null, "Opção não configurada.");
						}
						
						
						// Desenhos login = new Desenhos();
						// login.setVisible(true);
					}
				}
			}
		});

	}



}





















