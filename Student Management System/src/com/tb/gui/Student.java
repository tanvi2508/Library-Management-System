package com.tb.gui;

import java.awt.EventQueue;
import com.tb.model.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.lang.model.element.Name;
import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student {

	public JFrame frame;
	private JTextField txtName;
	private JTextField txtContact;
	private JTextField txtAddress;
	private JTextField txtEmail_id;
	private JTextField txtAge;
	private List<Student>student=new ArrayList<Student>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public  Student() {
		
		initialize();
	}
 
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(199, 21, 133));
		frame.setBounds(100, 100, 555, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblsms = new JLabel("Student Management System");
		lblsms.setForeground(Color.BLACK);
		lblsms.setFont(new Font("Cambria Math", Font.BOLD, 25));
		lblsms.setBounds(88, 42, 347, 36);
		frame.getContentPane().add(lblsms);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblName.setBounds(36, 135, 56, 16);
		frame.getContentPane().add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblAge.setBounds(36, 170, 56, 16);
		frame.getContentPane().add(lblAge);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblContact.setBounds(36, 205, 66, 16);
		frame.getContentPane().add(lblContact);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblAddress.setBounds(36, 242, 76, 16);
		frame.getContentPane().add(lblAddress);

		JLabel lblEmail = new JLabel("Email-Id");
		lblEmail.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblEmail.setBounds(36, 282, 76, 16);
		frame.getContentPane().add(lblEmail);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value=txtName.getText();
				int l=value.length();
				JLabel label=new JLabel();
				if(e.getKeyChar()>='A'&& e.getKeyChar()<='Z'||e.getKeyChar()>='a'&&e.getKeyChar()<='z'||e.getKeyChar()==KeyEvent.VK_BACK_SPACE||e.getKeyChar()==KeyEvent.VK_SPACE) {
					txtName.setEditable(true);
					label.setText("");
				}
				else {
					txtName.setEditable(false);
					label.setText("* enter only character value((A-Z,a-z))");
				}
			}
		});
		txtName.setFont(new Font("Cambria Math", Font.BOLD, 18));
		txtName.setBounds(185, 132, 263, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtContact = new JTextField();
		txtContact.setFont(new Font("Cambria Math", Font.BOLD, 18));
		txtContact.setColumns(10);
		txtContact.setBounds(185, 202, 263, 22);
		frame.getContentPane().add(txtContact);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Cambria Math", Font.BOLD, 18));
		txtAddress.setColumns(10);
		txtAddress.setBounds(185, 239, 263, 22);
		frame.getContentPane().add(txtAddress);

		txtEmail_id = new JTextField();
		txtEmail_id.setFont(new Font("Cambria Math", Font.BOLD, 18));
		txtEmail_id.setColumns(10);
		txtEmail_id.setBounds(185, 279, 263, 22);
		frame.getContentPane().add(txtEmail_id);

		txtAge = new JTextField();
		txtAge.setFont(new Font("Cambria Math", Font.BOLD, 18));
		txtAge.setColumns(10);
		txtAge.setBounds(185, 167, 263, 22);
		frame.getContentPane().add(txtAge);

		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				com.tb.model.Student student = new com.tb.model.Student();
				student.setName(txtName.getText());
		student.setAge(Integer.parseInt(txtAge.getText()));
				student.setContact(txtContact.getText());
				student.setAddress(txtAddress.getText());
				student.setEmail(txtEmail_id.getText());
				File file = new File(UiConstants.SAVE_FILE_CSV_PATH);
				try {
					if (!file.exists()) {

						Files.write(Paths.get(file.getPath()), "ID, Name,Age,Contact,Address,Email\n".getBytes(),
								StandardOpenOption.CREATE);
						Files.write(Paths.get(file.getPath()), student.getCSVData().getBytes(),
								StandardOpenOption.APPEND);
					} else {
						
					//read the file and aget the max ID
//						inceremnet that and update in that bean
			        student.setId();
						Files.write(Paths.get(file.getPath()), student.getCSVData().getBytes(),
								StandardOpenOption.APPEND);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(btnsave, e.getMessage());
				}
				txtName.setText("");
				txtAge.setText("");
				txtContact.setText("");	
				txtAddress.setText("");
				txtEmail_id.setText("");
				
				Refresh();
				
				
				
				
//				String filename="F:\\student1.csv";
//				try {
//					FileWriter filewriter=new FileWriter(filename,true);
//					BufferedWriter bufferedwriter=new BufferedWriter(filewriter);
//				  String [] header= {"Name","Age","Contact","Address","Email"};
//			     bufferedwriter.write("Name");
//			     bufferedwriter.write("Age");
//			     bufferedwriter.write("Contact");
//			     bufferedwriter.write("Address");
//			     bufferedwriter.write("Email");
//			     bufferedwriter.close();
//			     
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
			}

			private void Refresh() {
				
				
			}
		});
		btnsave.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnsave.setBounds(12, 361, 97, 25);
		frame.getContentPane().add(btnsave);

		JButton btnnext = new JButton("Next");
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Iterator<Student> iter=student.iterator();
			while(iter.hasNext()) {
				Student student=iter.next();
				txtName.setText(student.toString());
				txtAge.setText(student.toString());
				txtAddress.setText(student.toString());
				txtContact.setText(student.toString());
				txtEmail_id.setText(student.toString());
				
			}
			
			}		
		});
		
		
		btnnext.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnnext.setBounds(130, 361, 97, 25);
		frame.getContentPane().add(btnnext);

		JButton btnshow = new JButton("Show");
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableList obj=new TableList();
				obj.setVisible(true);
			}
		});
		btnshow.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnshow.setBounds(252, 361, 97, 25);
		frame.getContentPane().add(btnshow);

		JButton btnprevious = new JButton("Previous");	
		btnprevious.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnprevious.setBounds(375, 361, 125, 25);
		frame.getContentPane().add(btnprevious);
		}


	


	



	
}
