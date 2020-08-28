import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class logiin extends JFrame {
	static logiin frame = new logiin();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				   // logiin frame = new logiin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;
	private JTextField textFieldusername;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public logiin() {
		b= studentinfo.conector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(86, 161, 73, 23);
		contentPane.add(lblUsername);
		
		textFieldusername = new JTextField();
		textFieldusername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldusername.setBounds(230, 155, 144, 38);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(86, 248, 73, 23);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(230, 242, 144, 38);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setHorizontalAlignment(SwingConstants.LEADING);
		Image logimg=new ImageIcon(this.getClass().getResource("/tik.png")).getImage();
		btnLogIn.setIcon(new ImageIcon(logimg));
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					String query="select * from information where username=? and password=? ";
					PreparedStatement pst=b.prepareStatement(query);
					pst.setString(1,textFieldusername.getText() );
					pst.setString(2,passwordField.getText() );
					ResultSet rs=pst.executeQuery();
				
				
			      int x;
					int count=0;
					while(rs.next()){
						count=count+1;
					}
					if(count==1)
					{
						String q="select id from information where username='"+textFieldusername.getText()+"'";
					       PreparedStatement us=b.prepareStatement(q);
					       ResultSet res=us.executeQuery();
					       int s=res.getInt("id");
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
						studentframe c = new studentframe(s);
						c.setVisible(true);
						us.close();
						res.close();
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, " Duplicate Username and Password");
					}
					else{JOptionPane.showMessageDialog(null, "Username and Password is not correct");}
				
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				

			}
		});
		btnLogIn.setBounds(539, 336, 117, 38);
		contentPane.add(btnLogIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		Image backimg=new ImageIcon(this.getClass().getResource("bigger.png")).getImage();
		btnBack.setIcon(new ImageIcon(backimg));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				newfirstpage frame = new newfirstpage();
				frame.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(539, 381, 117, 23);
		contentPane.add(btnBack);
		
		JLabel labelimglogin = new JLabel("");
		labelimglogin.setBackground(SystemColor.inactiveCaption);
		Image img=new ImageIcon(this.getClass().getResource("/kk.png")).getImage();
		labelimglogin.setIcon(new ImageIcon(img));
		labelimglogin.setBounds(472, 38, 267, 287);
		contentPane.add(labelimglogin);
	}
}
