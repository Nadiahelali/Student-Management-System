import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

public class studentframe extends JFrame {
	static studentframe frame = new studentframe(0);
	private JPanel contentPane;
	//public String s=new String();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//studentframe frame = new studentframe(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;
	private JTable table;
	private JTextField textFieldusername;
	private JPasswordField passwordField;
	private JButton btnUpdate;
	private JLabel lblMyInformations;
	private JButton btnBack;

	/**
	 * Create the frame.
	 */
	public void refresh(int id){
		try{
			int x=id;
			String query="select * from information where id='"+x+"' ";
			PreparedStatement pst=b.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			rs.close();
			pst.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public studentframe(int s) {
		int x=s;
		b= studentinfo.conector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 52, 657, 330);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 101, 104, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 147, 104, 30);
		contentPane.add(lblPassword);
		
		textFieldusername = new JTextField();
		textFieldusername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldusername.setBounds(124, 103, 148, 32);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 146, 147, 32);
		contentPane.add(passwordField);
		refresh(x);
		btnUpdate = new JButton("Update");
		Image upimg=new ImageIcon(this.getClass().getResource("update.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(upimg));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            try{
					   // int x=s;
					   // System.out.print(x);
						String query="Update information set username='"+textFieldusername.getText()+"',password='"+passwordField.getText()+"' where id='"+x+"' ";
						
						PreparedStatement pst=b.prepareStatement(query);
						
						if(textFieldusername.getText().equals("")||passwordField.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Data Can not be Updated");
						}
						else
						{
							pst.execute();
							JOptionPane.showMessageDialog(null, "Data  Update");
						}
						
						pst.close();
					}catch(Exception e){
						e.printStackTrace();
						
					}
	            refresh(x);
	            
			}
		});
		btnUpdate.setBounds(110, 250, 104, 30);
		contentPane.add(btnUpdate);
		
		JButton btnCourseRegistration = new JButton("Course registration");
		btnCourseRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int x= s;
				//s=Integer.parseInt(textFieldid.getText());
				frame.dispose();
				courseinfo frame = new courseinfo(x);
				//courseinfo cc=new courseinfo(x);
				//cc.setString(s);
				frame.setVisible(true);
			}
		});
		btnCourseRegistration.setBounds(83, 291, 148, 23);
		contentPane.add(btnCourseRegistration);
		
		lblMyInformations = new JLabel("My Informations");
		lblMyInformations.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblMyInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyInformations.setBounds(596, 27, 162, 14);
		contentPane.add(lblMyInformations);
		
		btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEADING);
		Image backimg=new ImageIcon(this.getClass().getResource("bigger.png")).getImage();
		btnBack.setIcon(new ImageIcon(backimg));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				logiin c = new logiin();
				c.setVisible(true);
			}
		});
		btnBack.setBounds(105, 325, 104, 31);
		contentPane.add(btnBack);
	}
	
}
