package GUI.GuiControl;

import DAO.CT_hoadonDAO;
import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import entities.CT_hoadon;

;

public class TablemodelCT_hoadon extends AbstractTableModel {
	private String Header[] = { "Tên Hàng",
	"Số lượng" , "Giá" };
	private List<CT_hoadon> data ;
	public TablemodelCT_hoadon(String id) {
		CT_hoadonDAO ohelper = new CT_hoadonDAO(CT_hoadon.class);
		data = ohelper.getbyidhd(id);
		
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
		CT_hoadon lk = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return lk.getLinhkien().getTen();
			
		case 1:
			return lk.getSoluong();
		

			
		case 2:
			return lk.tinhtien_chitiet();
	

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
		if (columnIndex == 3 || columnIndex ==2)
			return Double.class;
		if (columnIndex == 1)
			return Integer.class;
		
		return String.class;
	}
	

	
	
}
