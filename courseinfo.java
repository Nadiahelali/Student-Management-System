import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.SystemColor;


public class courseinfo extends JFrame {
	static courseinfo frame = new courseinfo(0);

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//courseinfo frame = new courseinfo(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//static int s;


	Connection b=null;
	private JTable table;
	private JComboBox comboBoxsub1;
	private JComboBox comboBoxsub2;
	private JComboBox comboBoxsub3;
	private JComboBox comboBoxsub4;
	private JComboBox comboBoxsub5;
	private JButton btnAdd;
	private JButton btnBack;
	private JLabel lblCourses;
	private JLabel lblChooseYourSubjects;
	private JLabel labelimgcourse;

	/**
	 * Create the frame.
	 */
	public void refreshtable(int id){
		try{
			//String s="English";
			int x=id;
			//int x=setString(s);
			String query="select * from course where id='"+x+"'";
			PreparedStatement pst=b.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		}catch(Exception es){
			es.printStackTrace();
		}
		
	}
	
	public courseinfo(int id) {
		b= studentinfo.conector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(334, 72, 452, 69);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBoxsub1 = new JComboBox();
		comboBoxsub1.setModel(new DefaultComboBoxModel(new String[] {"English", "Math", "Physics", "Cse101", "Cse102", "Cse103", "Cse104", "History", "Sociology", "Economics"}));
		comboBoxsub1.setBounds(140, 83, 134, 31);
		contentPane.add(comboBoxsub1);
		
		comboBoxsub2 = new JComboBox();
		comboBoxsub2.setModel(new DefaultComboBoxModel(new String[] {"English", "Math", "Physics", "Cse101", "Cse102", "Cse103", "Cse104", "History", "Sociology", "Economics"}));
		comboBoxsub2.setBounds(140, 125, 134, 31);
		contentPane.add(comboBoxsub2);
		
		comboBoxsub3 = new JComboBox();
		comboBoxsub3.setModel(new DefaultComboBoxModel(new String[] {"English", "Math", "Physics", "Cse101", "Cse102", "Cse103", "Cse104", "History", "Sociology", "Economics"}));
		comboBoxsub3.setBounds(140, 167, 134, 31);
		contentPane.add(comboBoxsub3);
		
		comboBoxsub4 = new JComboBox();
		comboBoxsub4.setModel(new DefaultComboBoxModel(new String[] {"English", "Math", "Physics", "Cse101", "Cse102", "Cse103", "Cse104", "History", "Sociology", "Economics"}));
		comboBoxsub4.setBounds(140, 209, 134, 31);
		contentPane.add(comboBoxsub4);
		
		comboBoxsub5 = new JComboBox();
		comboBoxsub5.setModel(new DefaultComboBoxModel(new String[] {"English", "Math", "Physics", "Cse101", "Cse102", "Cse103", "Cse104", "History", "Sociology", "Economics"}));
		comboBoxsub5.setBounds(140, 251, 134, 31);
		contentPane.add(comboBoxsub5);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into course (Subject Code 1,Subject Code 2,Subject Code 3,Subject Code 4,Subject Code 5) values (?,?,?,?,?)";
				     PreparedStatement pst=b.prepareStatement(query);
				     
				     String s1=comboBoxsub1.getSelectedItem().toString();
				     String s2=comboBoxsub2.getSelectedItem().toString();
				     String s3=comboBoxsub3.getSelectedItem().toString();
				     String s4=comboBoxsub4.getSelectedItem().toString();
				     String s5=comboBoxsub5.getSelectedItem().toString();
				     if(s1.equals(s2) || s1.equals(s3) || s1.equals(s4) || s1.equals(s5) || s2.equals(s1) || s2.equals(s3) || s2.equals(s4) || s2.equals(s5) || s3.equals(s2) || s3.equals(s1) || s3.equals(s4) || s3.equals(s5) || s4.equals(s2) || s4.equals(s3) || s4.equals(s1) || s4.equals(s5) || s5.equals(s2) || s5.equals(s3) || s5.equals(s4) || s5.equals(s1))
				     {
				    	 JOptionPane.showMessageDialog(null, "Same Subjects Selected more than one time");
				     }
				     else{
				     pst.setString(1, comboBoxsub1.getSelectedItem().toString());
				     pst.setString(2, comboBoxsub2.getSelectedItem().toString());
				     pst.setString(3, comboBoxsub3.getSelectedItem().toString());
				     pst.setString(4, comboBoxsub4.getSelectedItem().toString());
				     pst.setString(5, comboBoxsub5.getSelectedItem().toString());
				     pst.execute();
			    	 JOptionPane.showMessageDialog(null, "Subjects Added Succesfully");
			    	 

				     }
				     pst.close();
				     
				} catch (Exception ed) {
					//JOptionPane.showMessageDialog(null, "Subjects are Already Added");
					ed.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(98, 350, 100, 23);
		contentPane.add(btnAdd);
		refreshtable(id);
		JLabel lblSubject = new JLabel("Subject Code : 1");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setBounds(30, 91, 100, 14);
		contentPane.add(lblSubject);
		
		JLabel lblSubject_1 = new JLabel("Subject Code : 2");
		lblSubject_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_1.setBounds(30, 133, 100, 14);
		contentPane.add(lblSubject_1);
		
		JLabel lblSubject_2 = new JLabel("Subject Code : 3");
		lblSubject_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_2.setBounds(30, 175, 100, 14);
		contentPane.add(lblSubject_2);
		
		JLabel lblSubject_3 = new JLabel("Subject Code : 4");
		lblSubject_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_3.setBounds(30, 217, 100, 14);
		contentPane.add(lblSubject_3);
		
		JLabel lblSubject_4 = new JLabel("Subject Code : 5");
		lblSubject_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_4.setBounds(30, 259, 100, 14);
		contentPane.add(lblSubject_4);
		
		btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		Image backimg=new ImageIcon(this.getClass().getResource("bigger.png")).getImage();
		btnBack.setIcon(new ImageIcon(backimg));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				studentframe c = new studentframe(id);
				c.setVisible(true);
			}
		});
		btnBack.setBounds(98, 384, 100, 23);
		contentPane.add(btnBack);
		
		lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourses.setBounds(512, 39, 70, 14);
		contentPane.add(lblCourses);
		
		lblChooseYourSubjects = new JLabel("Choose your Subjects");
		lblChooseYourSubjects.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblChooseYourSubjects.setBounds(75, 31, 269, 31);
		contentPane.add(lblChooseYourSubjects);
		
		labelimgcourse = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/Courses.png")).getImage();
		labelimgcourse.setIcon(new ImageIcon(img));
		labelimgcourse.setBounds(435, 176, 278, 243);
		contentPane.add(labelimgcourse);
	}
}
