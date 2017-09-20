import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import includes.Funcoes;

public class painel_Inicial {

	private int varProc, varCores, varQuantum;
	private boolean Bloqueado;
	private JTextField txtF_NProcIni, txtF_NCores, txtF_Quantum;
	JButton btnIniciaSimu = new JButton("Iniciar");
	
	
	public painel_Inicial() {
		setVarProc(-1);
		setVarCores(-1);
		setVarQuantum(-1);
	}
	public painel_Inicial(JFrame frame) {
		setVarProc(-1);
		setVarCores(-1);
		setVarQuantum(-1);
		inicia(frame);
	}
	
	public int getVarProc() {
		return varProc;
	}
	public void setVarProc(int varProc) {
		this.varProc = varProc;
	}
	public int getVarCores() {
		return varCores;
	}
	public void setVarCores(int varCores) {
		this.varCores = varCores;
	}
	public int getVarQuantum() {
		return varQuantum;
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
		txtF_NProcIni.setEditable(bl);
		txtF_NCores.setEditable(bl);
		txtF_Quantum.setEditable(bl);
		btnIniciaSimu.setEnabled(bl);
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
					setVarProc(f.string2int(procs));
					setVarCores(f.string2int(cores));
					setVarQuantum(f.string2int(quantuns));
					
					JOptionPane.showMessageDialog(null, "Informações capturadas.");

					setBloqueado(true);
				}
				
				// System.exit(0);
			}
		});
	}
	
	
	
}
