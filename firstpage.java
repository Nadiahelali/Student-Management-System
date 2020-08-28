import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;


public class firstpage {
	//static firstpage window = new firstpage();

	public JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstpage window = new firstpage();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public firstpage() {
		b= studentinfo.conector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame2 = new JFrame();
		frame2.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame2.setBounds(100, 100, 835, 511);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(287, 66, 200, 50);
		frame2.getContentPane().add(lblWelcome);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(287, 93, 200, 50);
		frame2.getContentPane().add(lblTo);
		
		JLabel lblUniversityOfAsia = new JLabel("UNIVERSITY OF ASIA PACIFIC");
		lblUniversityOfAsia.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblUniversityOfAsia.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversityOfAsia.setBounds(269, 120, 254, 50);
		frame2.getContentPane().add(lblUniversityOfAsia);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				newfirstpage frame = new newfirstpage();
				frame.setVisible(true);
			}
		});
		btnEnter.setBounds(319, 356, 156, 35);
		frame2.getContentPane().add(btnEnter);
		
		JLabel lblPleasePressenter = new JLabel("Please press 'ENTER' to continue");
		lblPleasePressenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleasePressenter.setBounds(297, 377, 200, 50);
		frame2.getContentPane().add(lblPleasePressenter);
		
		JLabel label = new JLabel("");
		Image backimg=new ImageIcon(this.getClass().getResource("hat.png")).getImage();
		label.setIcon(new ImageIcon(backimg));
		label.setBounds(269, 155, 283, 176);
		frame2.getContentPane().add(label);
		
	}
}
