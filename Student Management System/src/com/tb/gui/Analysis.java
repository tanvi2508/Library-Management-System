package com.tb.gui;

import javax.swing.table.AbstractTableModel;

public class Analysis extends AbstractTableModel {
	String [] cols=null;
	Object data[][]=null;
	
	public Analysis(String[] cols, Object[][] data) {
		super();
		this.cols = cols;
		this.data = data;
	}

	

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int colsIndex) {
		return data[rowIndex][colsIndex];
	}

	
}



