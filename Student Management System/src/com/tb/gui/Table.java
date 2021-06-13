package com.tb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Table extends JPanel{
	private JTable table;

	public Table(String fName) throws IOException {
		this.table = new JTable();
		
		  java.util.List<String> lines=Files.readAllLines(Paths.get(fName)); 
		  String cols[]=lines.get(0).split(","); 
		  Object data[][]= new Object[lines.size()][cols.length];
		  
		  for(int i=1;i<lines.size();i++) { 
			  data[i-1]=lines.get(i).split(","); 
			  
		  }
		    this.table=new JTable(new Analysis(cols,data));
			this.table.setBackground(Color.WHITE);
			this.table.setForeground(Color.BLUE);
			this.table.setVisible(true);
			this.table.setPreferredScrollableViewportSize(new Dimension(700,70));
			this.table.setFillsViewportHeight(true);
			JPanel ButtonOpen=new JPanel(new FlowLayout(FlowLayout.CENTER));
			add(ButtonOpen,BorderLayout.SOUTH);
			JScrollPane scrollPane=new JScrollPane(table);
			add(scrollPane,BorderLayout.CENTER);
			setBorder(new EmptyBorder(5,5,5,5));
			
			System.out.println("Rows:  "+ table.getRowCount());
			System.out.println("Columns:  "+ table.getColumnCount());
			
		
	}

	

	

	
	

}



