import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.SystemColor;


public class admin extends JFrame {
	static admin frame = new admin();
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;
	private JTextField textFieldname;
	private JTextField textFieldsurname;
	private JTextField textFieldid;
	private JTextField textFieldage;
	private JTextField textFieldaddress;
	private JTextField textFieldemail;
	private JTextField textFieldusername;
	private JTextField textFieldpassword;

	/**
	 * Create the frame.
	 */
	
	public void refreshtable(){
		try{
			String query="select id,name,surname,age,address,email from information";
			PreparedStatement pst=b.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public admin() {
		b= studentinfo.conector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 632);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 77, 919, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 59, 104, 28);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 137, 104, 28);
		contentPane.add(lblId);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(10, 176, 104, 28);
		contentPane.add(lblAge);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setBounds(10, 98, 104, 28);
		contentPane.add(lblSurname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(10, 215, 104, 28);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(10, 254, 104, 28);
		contentPane.add(lblEmail);
		
		textFieldname = new JTextField();
		textFieldname.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldname.setBounds(124, 59, 144, 28);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldsurname = new JTextField();
		textFieldsurname.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldsurname.setBounds(124, 98, 144, 28);
		contentPane.add(textFieldsurname);
		textFieldsurname.setColumns(10);
		
		textFieldid = new JTextField();
		textFieldid.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldid.setBounds(124, 137, 144, 28);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		textFieldage = new JTextField();
		textFieldage.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldage.setBounds(124, 176, 144, 28);
		contentPane.add(textFieldage);
		textFieldage.setColumns(10);
		
		textFieldaddress = new JTextField();
		textFieldaddress.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldaddress.setBounds(124, 215, 144, 28);
		contentPane.add(textFieldaddress);
		textFieldaddress.setColumns(10);
		
		textFieldemail = new JTextField();
		textFieldemail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldemail.setBounds(124, 254, 144, 28);
		contentPane.add(textFieldemail);
		textFieldemail.setColumns(10);
		refreshtable();
		JButton btnAdd = new JButton("Add");
		Image addimg=new ImageIcon(this.getClass().getResource("Actiadd.png")).getImage();
		btnAdd.setIcon(new ImageIcon(addimg));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	           try{
					
					String query="insert into information (id,name,age,surname,address,email,username,password) values (?,?,?,?,?,?,?,?)";
					PreparedStatement pst=b.prepareStatement(query);
					pst.setString(1,textFieldid.getText());
					pst.setString(2,textFieldname.getText());
					pst.setString(3,textFieldage.getText());
					pst.setString(4,textFieldsurname.getText());
					pst.setString(5,textFieldaddress.getText());
					pst.setString(6,textFieldemail.getText());
					pst.setString(7,textFieldusername.getText());
					pst.setString(8,textFieldpassword.getText());
					
					if(textFieldid.getText().equals("")||textFieldname.getText().equals("")||textFieldage.getText().equals("")||textFieldsurname.getText().equals("")||textFieldaddress.getText().equals("")||textFieldemail.getText().equals("")||textFieldusername.getText().equals("")||textFieldpassword.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Fill Every Fields");
					}
					else
					{
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data  Added");
					}
					pst.close();
				}catch(Exception e){
					e.printStackTrace();
					
				}
	           refreshtable();
			}
		});
		btnAdd.setBounds(6, 401, 89, 28);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		Image upimg=new ImageIcon(this.getClass().getResource("update.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(upimg));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		          try{
						
						String query="Update information set id='"+textFieldid.getText()+"' ,name='"+textFieldname.getText()+"',age='"+textFieldage.getText()+"',surname='"+textFieldsurname.getText()+"',address='"+textFieldaddress.getText()+"',email='"+textFieldemail.getText()+"' where id='"+textFieldid.getText()+"' ";
						PreparedStatement pst=b.prepareStatement(query);
						
						if(textFieldid.getText().equals("")||textFieldname.getText().equals("")||textFieldage.getText().equals("")||textFieldsurname.getText().equals("")||textFieldaddress.getText().equals("")||textFieldemail.getText().equals(""))
						{
							
							JOptionPane.showMessageDialog(null, "Data Can not be Updated");
						}
						else
						{   pst.execute();
							JOptionPane.showMessageDialog(null, "Data  Update");
						}
						
						pst.close();
					}catch(Exception e){
						e.printStackTrace();
						
					}
		          refreshtable();
				
			}
		});
		btnUpdate.setBounds(99, 401, 104, 28);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		Image delimg=new ImageIcon(this.getClass().getResource("delete.png")).getImage();
		btnDelete.setIcon(new ImageIcon(delimg));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   try{
						
						String query="Delete from information where id='"+textFieldid.getText()+"' ";
						PreparedStatement pst=b.prepareStatement(query);
						pst.execute();
						String q="Delete from course where id='"+textFieldid.getText()+"' ";
						PreparedStatement st=b.prepareStatement(q);
						st.execute();
						if(textFieldid.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Data Can not be Deleted");

						}else {
						JOptionPane.showMessageDialog(null, "Data Deleted");
						}
						pst.close();
						st.execute();
					}catch(Exception ex){
						ex.printStackTrace();
						
					}
				   refreshtable();
			}
		});
		btnDelete.setBounds(208, 401, 100, 28);
		contentPane.add(btnDelete);
		
		JButton btnCourseRegistration = new JButton("Course Registration");
		btnCourseRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admincourse frame = new admincourse();
				frame.setVisible(true);
			}
		});
		btnCourseRegistration.setBounds(78, 449, 155, 28);
		contentPane.add(btnCourseRegistration);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(30, 304, 65, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(23, 345, 76, 14);
		contentPane.add(lblPassword);
		
		textFieldusername = new JTextField();
		textFieldusername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldusername.setBounds(124, 297, 144, 28);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		textFieldpassword = new JTextField();
		textFieldpassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldpassword.setBounds(124, 338, 144, 28);
		contentPane.add(textFieldpassword);
		textFieldpassword.setColumns(10);
		
		JLabel lblStudentInformation = new JLabel("Student Informations");
		lblStudentInformation.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblStudentInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentInformation.setBounds(693, 41, 193, 25);
		contentPane.add(lblStudentInformation);
		
		JButton btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEADING);
		Image backimg=new ImageIcon(this.getClass().getResource("bigger.png")).getImage();
		btnBack.setIcon(new ImageIcon(backimg));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newfirstpage Go = new newfirstpage();
				Go.framen.setVisible(true);
			}
		});
		btnBack.setBounds(105, 504, 104, 23);
		contentPane.add(btnBack);
	}
}
