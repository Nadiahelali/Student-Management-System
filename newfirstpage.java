import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;


public class newfirstpage extends JFrame {
	public static newfirstpage framen = new newfirstpage();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//newfirstpage frame = new newfirstpage();
					framen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;

	/**
	 * Create the frame.
	 */
	public newfirstpage() {
		b= studentinfo.conector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudent = new JButton("Student");
		Image image=new ImageIcon(this.getClass().getResource("Gradghat.png")).getImage();
		btnStudent.setIcon(new ImageIcon(image));
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framen.dispose();
				 logiin framen = new logiin();
					framen.setVisible(true);
			}
		});
		btnStudent.setBounds(240, 260, 148, 34);
		contentPane.add(btnStudent);
		
		JButton btnAdministration = new JButton("Administration");
		Image imge=new ImageIcon(this.getClass().getResource("Settings.png")).getImage();
		 btnAdministration.setIcon(new ImageIcon(imge));
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framen.dispose();
				admin frame = new admin();
				frame.setVisible(true);
			}
		});
		btnAdministration.setBounds(419, 260, 148, 34);
		contentPane.add(btnAdministration);
		
		JLabel labelimgstudent = new JLabel("");
		labelimgstudent.setHorizontalAlignment(SwingConstants.CENTER);
		Image img=new ImageIcon(this.getClass().getResource("2student.png")).getImage();
		labelimgstudent.setIcon(new ImageIcon(img));
		labelimgstudent.setBounds(219, 141, 185, 121);
		contentPane.add(labelimgstudent);
		
		JLabel labelimgadmin = new JLabel("");
		Image imag=new ImageIcon(this.getClass().getResource("1admin.png")).getImage();
		labelimgadmin.setIcon(new ImageIcon(imag));
		labelimgadmin.setHorizontalAlignment(SwingConstants.CENTER);
		labelimgadmin.setBounds(398, 116, 200, 151);
		contentPane.add(labelimgadmin);
	}

}
