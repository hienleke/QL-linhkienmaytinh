package GUI.GuiControl;

import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import DAO.LinhkienDAO;
import DAO.NhacungcapDAO;
import entities.Linhkien;
import entities.Nhacungcap;


public class TablemodelNCC_cacsanpham extends AbstractTableModel {
	private String Header[] = { "Mã Hàng", "Tên Hàng", "Loại", "Đơn Giá", 
	"Số lượng tồn " };
	private List<Linhkien> data ;
	public TablemodelNCC_cacsanpham(String id) {
		//LinhkienDAO ohelper = new LinhkienDAO(Linhkien.class);
		//data = ohelper.getbyidNCC(id);
                NhacungcapDAO nccDAo = new NhacungcapDAO(Nhacungcap.class);
                
                data = nccDAo.findById(id).getDslk();
		
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
		Linhkien lk = data.get(rowIndex);
		switch (columnIndex) {
		
			
		case 0:
			return lk.getId();
		
		case 1:
			return lk.getTen();
			
		case 2:
			return lk.getDanhmuclinhkien().getTen();
		case 3:
			return lk.getDongiagoc();
			
		case 4:
			return lk.getSoluong();
            
			

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
		if (columnIndex == 3)
			return double.class;
		if (columnIndex == 4)
			return Integer.class;
		
		return String.class;
	}
	

	
	
}
