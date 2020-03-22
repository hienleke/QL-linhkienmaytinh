package GUI.GuiControl;



import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import entities.Danhmuclinhkien;
import entities.Nhacungcap;
import entities.Xuatxu;

public class Tablemodeldanhmuc extends AbstractTableModel {
	private String Header[] = {"Mã", "Tên" ,"Mô tả "
	 };
	private List<Danhmuclinhkien> data ;
	public Tablemodeldanhmuc() {
		DAOhelper<Danhmuclinhkien> ohelper = new DAOhelper<>(Danhmuclinhkien.class);
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
		Danhmuclinhkien lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getTen();
                    case 2:
			return lk.getMota();
		
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

   
	
    public void setData(List<Danhmuclinhkien> data) {
        this.data = data;
    }
	
	
}
