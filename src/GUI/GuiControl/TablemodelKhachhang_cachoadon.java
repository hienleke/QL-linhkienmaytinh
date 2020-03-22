package GUI.GuiControl;

import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import entities.Hoadon;
import entities.Khachhang;


public class TablemodelKhachhang_cachoadon extends AbstractTableModel {
	private String Header[] = { "Mã", "Ngày lập", "Tên nhân viên", "Thành tiền" 
	};
	private List<Hoadon> data ;
	public TablemodelKhachhang_cachoadon(String id) {
		DAOhelper<Khachhang> ohelper = new DAOhelper<>(Khachhang.class);
		data = ohelper.findById(id).getDshd();
		
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
		Hoadon lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getNgaylap();
			
		case 2:
                   return  lk.getNhanvien().getTen();
                case 3 :
                    return lk.Tinhtien();
			

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
		
            if(columnIndex==3)
                return double.class;
            
            
		return String.class;
	}
	

	
	
}
