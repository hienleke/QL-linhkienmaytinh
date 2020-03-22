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

public class TablemodelNCC extends AbstractTableModel {
	private String Header[] = {"Mã", "Tên", "Địa chỉ", "SDT", 
	"Email" };
	private List<Nhacungcap> data ;
	public TablemodelNCC() {
		DAOhelper<Nhacungcap> ohelper = new DAOhelper<>(Nhacungcap.class);
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
		Nhacungcap lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getTen();
			
		case 2:
			return lk.getDiachi();
		case 3:
			return lk.getSdt();
			
		case 4:
			return lk.getEmail();
			

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

    public List<Nhacungcap> getData() {
        return data;
    }

    public void setData(List<Nhacungcap> data) {
        this.data = data;
    }
	

	
	
}
