package GUI.GuiControl;

import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import DAO.KhanhhangDAO;
import entities.Khachhang;


public class TablemodelKhachhang_banhang extends AbstractTableModel {
	private String Header[] = { "Mã", "Tên ", "SDT", "Địa chỉ", 
	"Email" };
	private List<Khachhang> data ;
	public TablemodelKhachhang_banhang() {
            KhanhhangDAO ohelper = new KhanhhangDAO(Khachhang.class);
		data = ohelper.getdschoformkhachhang_banhang();
		
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
		Khachhang lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getTen();
			
		case 2:
			return lk.getSdt();
		case 3:
			return lk.getDiachi();
			
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

    public List<Khachhang> getData() {
        return data;
    }

    public void setData(List<Khachhang> data) {
        this.data = data;
    }
	

	
	
}
