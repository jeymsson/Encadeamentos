package Aplicativo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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

public class Aplicativo {

	private JFrame frame;
	private JTextField txtNumCores;
	private JTextField txtNumProcessos;
	private boolean ativaLogs = false;
	private int intNumCores, intNumProcessos;
	private JTextField txtDeadline;

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
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		comboEscalonamento.setModel(new DefaultComboBoxModel(new String[] {"Escolha uma op\u00E7\u00E3o", "SJF", "Round Robin", "LTG"}));
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
		
		
		JButton btnIniciar = new JButton("INICIAR");
		gbc_btnIniciar.gridwidth = 5;
		gbc_btnIniciar.gridx = 0;
		gbc_btnIniciar.gridy = 6;
		panel.add(btnIniciar, gbc_btnIniciar);
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Funcoes f = new Funcoes();
				String NumCores, NumProcessos, comboEsc, Deadline;
				int escl = comboEscalonamento.getSelectedIndex();
				
				NumCores = txtNumCores.getText();
				NumProcessos = txtNumProcessos.getText();
				Deadline = txtDeadline.getText();
				comboEsc = (escl != 0) ? f.int2string(escl) : "" ;
//				boolean edita  = chckbxAtivo.isSelected();
				
				
				boolean ok = true;
				if (ok) ok = f.validaForm(comboEsc, "Escalonamento");
				if (ok) ok = f.validaForm(NumCores, "Nº Cores");
				if (ok) ok = f.validaForm(NumProcessos, "Nº Processos");
				if(escl == 3) {
					if (ok) ok = f.validaForm(Deadline, "Deadline");
				}
				
				if (ok) {
//					JOptionPane.showMessageDialog(null, "Informações capturadas.");
					JFrame frame = new JFrame("Exibição");
					int Cores = f.string2int(NumCores)
							, Processos = f.string2int(NumProcessos);
					
					if (escl == 1) {
						if (getAtivaLogs()) {
							JOptionPane.showMessageDialog(null, "Cores: " + Cores
									+ ", Processos: " + Processos
									+ ", Shortest Job First");
						}
						
						Desenhos desenho = new Desenhos(1, Cores, Processos);
						frame.getContentPane().add(desenho);
						frame.setSize(800, 600);
						frame.setVisible(true);
					} else if (escl == 2) {
						if (getAtivaLogs()) {
							JOptionPane.showMessageDialog(null, "Cores: " + Cores
									+ ", Processos: " + Processos
									+ ", Round Robin com lista de prioridade");
						}
						RR robin = new RR(Cores, Processos);
					} else if (escl == 3) {
						if (getAtivaLogs()) {
							JOptionPane.showMessageDialog(null, "Cores: " + Cores
									+ ", Processos: " + Processos
									+ ", Least Time to Go");
						}
						
						Desenhos desenho = new Desenhos(3, Cores, Processos, f.string2int(Deadline));
						frame.getContentPane().add(desenho);
						frame.setSize(800, 600);
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Opção não configurada.");
					}
					
//					Desenhos login = new Desenhos();
//					login.setVisible(true);
				}
			}
		});
		
	}



}





















