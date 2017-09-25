package Testes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Peach extends JPanel {

	private JPanel contentPane;


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		
		g.setColor(Color.BLUE);;
		g.fillRect(25, 425, 100, 30);
		
		g.setColor(new Color(190, 81, 215));
		g.fillRect(25, 465, 100, 30);
		
		g.setColor(Color.RED);
		g.drawString("Algum texto.", 25, 520);;
		repaint();
	}
	
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Peach frame = new Peach();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}



	
	public Peach() {
	}

}
