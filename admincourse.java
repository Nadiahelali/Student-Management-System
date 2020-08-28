import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import java.awt.Font;
import java.awt.SystemColor;


public class admincourse extends JFrame {
	static admincourse frame = new admincourse();
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//admincourse frame = new admincourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection b=null;
	private JButton btnBack;
	private JLabel lblCourses;
	private JLabel labelimgadcourse;

	/**
	 * Create the frame.
	 */
	public void refreshtable(){
		try{
			String query="select * from course ";
			PreparedStatement pst=b.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		}catch(Exception es){
			es.printStackTrace();
		}
		
	}

	public admincourse() {
		b=studentinfo.conector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 525);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 66, 590, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		refreshtable();
		
		btnBack = new JButton("Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		Image backimg=new ImageIcon(this.getClass().getResource("bigger.png")).getImage();
		btnBack.setIcon(new ImageIcon(backimg));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				admin c = new admin();
				c.setVisible(true);
			}
		});
		btnBack.setBounds(712, 381, 104, 23);
		contentPane.add(btnBack);
		
		lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourses.setBounds(259, 41, 123, 14);
		contentPane.add(lblCourses);
		
		labelimgadcourse = new JLabel("");
		labelimgadcourse.setHorizontalAlignment(SwingConstants.CENTER);
		Image img=new ImageIcon(this.getClass().getResource("/Admin.png")).getImage();
		labelimgadcourse.setIcon(new ImageIcon(img));
		labelimgadcourse.setBounds(626, 96, 260, 274);
		contentPane.add(labelimgadcourse);
	}
}
