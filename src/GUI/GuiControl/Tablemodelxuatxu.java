package GUI.GuiControl;



import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import entities.Nhacungcap;
import entities.Xuatxu;

public class Tablemodelxuatxu extends AbstractTableModel {
	private String Header[] = {"Mã", "Tên"
	 };
	private List<Xuatxu> data ;
	public Tablemodelxuatxu() {
		DAOhelper<Xuatxu> ohelper = new DAOhelper<>(Xuatxu.class);
		data = ohelper.findAll();
		
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Header.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Xuatxu lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getQuocgia();
		
		default:
			break;
		}
		return null;
	}
	

	@Override
	public String getColumnName(int column) {

		return Header[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}
          public void setData(List<Xuatxu> data) {
        this.data = data;
    }
 

	
	

	
	
}
