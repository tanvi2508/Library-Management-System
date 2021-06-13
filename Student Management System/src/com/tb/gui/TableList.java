package com.tb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TableList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableList frame = new TableList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 545);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelect = new JLabel("Select File");
		lblSelect.setFont(new Font("Cambria Math", Font.BOLD, 18));
		lblSelect.setBounds(176, 422, 90, 46);
		contentPane.add(lblSelect);
		
		JButton btnOpen = new JButton("Open File");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int res = chooser.showOpenDialog(btnOpen);
				if (res == chooser.APPROVE_OPTION) {
						 
						try {
							 
							 JPanel newContentPane = new Table(chooser.getSelectedFile().getPath());
							 newContentPane.setBorder(new LineBorder(new Color(0, 128, 128)));
							 newContentPane.setBounds(0, 0, 838, 400);
						     getContentPane().add(newContentPane);
						     newContentPane.setVisible(true);
						 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  
			}
			}
		});
		btnOpen.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnOpen.setBounds(289, 422, 126, 46);
		contentPane.add(btnOpen);
	}

}
