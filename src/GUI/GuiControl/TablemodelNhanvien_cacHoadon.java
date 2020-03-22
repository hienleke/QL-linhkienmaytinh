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
import entities.Nhanvien;


public class TablemodelNhanvien_cacHoadon extends AbstractTableModel {
private String Header[] = { "Mã", "Ngày lập", "Khách Hàng ", "Thành tiền"
	};
	private List<Hoadon> data =null ;
	public TablemodelNhanvien_cacHoadon(String id) {
		DAOhelper<Nhanvien> ohelper = new DAOhelper<>(Nhanvien.class);
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
