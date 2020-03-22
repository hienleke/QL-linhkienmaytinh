package GUI_model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.DAOhelper;

public class TablemodelHelper <T> extends AbstractTableModel {
	private DAOhelper<T> helper;
	private String header[];
	private List<T> data;

	
	

	public TablemodelHelper(String[] header, List<T> data, Class<T> type) {
		super();
		this.header = header;
		this.data = data;
		helper =new DAOhelper<>(type);
	}
	
	

	public String[] getHeader() {
		return header;
	}



	public void setHeader(String[] header) {
		this.header = header;
	}



	public List<T> getData() {
		return data;
	}



	public void setData(List<T> data) {
		this.data = data;
	}



	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return header.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
