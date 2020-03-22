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
import entities.Linhkien;


public class TablemodelBanhang_linhkien extends AbstractTableModel {
	private String Header[] = { "Mã Hàng", "Tên Hàng", "Loại", "Đơn Giá", 
	"Số lượng tồn ", "Nhà cung cấp " , "Nguồn gốc" };
	private List<Linhkien> data ;

    public List<Linhkien> getData() {
        return data;
    }

    public void setData(List<Linhkien> data) {
        this.data = data;
    }
        
	public TablemodelBanhang_linhkien() {
		          LinhkienDAO lk = new LinhkienDAO(Linhkien.class);
		data = lk.getdschobanhang();
		
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
			return lk.getDongiaban();
			
		case 4:
			return lk.getSoluong();
                case 5 :
                    return lk.getNhacungcap().getTen();
                case 6  :
                    return lk.getXuatxu().getQuocgia();
			

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
		if (columnIndex == 4)
			return double.class;
		if (columnIndex == 5)
			return Integer.class;
		
		return String.class;
	}
	

	
	
}
