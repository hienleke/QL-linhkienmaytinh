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


public class TablemodelLinhkien extends AbstractTableModel {
	private String Header[] = { "Mã Hàng", "Tên Hàng", "Loại","Giá nhập" ,"Giá bán", 
	"Số lượng tồn ", "Nhà cung cấp " , "Nguồn gốc" };
	private List<Linhkien> data ;
	public TablemodelLinhkien(int vt) {
		  LinhkienDAO lkdao = new LinhkienDAO(Linhkien.class);
		data = lkdao.findAll(vt);
		
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
                      if (lk.getDanhmuclinhkien()==null)
                        return " ";
                 
			return lk.getDanhmuclinhkien().getTen();
		case 3:
			return lk.getDongiagoc();
                case 4:
                     return lk.getDongiaban();
		case 5:
			return lk.getSoluong();
                case 6 :
                 
   
                    if (lk.getNhacungcap()==null)
                        return " ";
                 
                    
                        return lk.getNhacungcap().getTen();
                
                case 7  :
                      if (lk.getXuatxu()==null)
                        return " ";
                 
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
		if (columnIndex == 3 || columnIndex == 4)
			return double.class;
		if (columnIndex == 5)
			return Integer.class;
		
		return String.class;
	}

    public List<Linhkien> getData() {
        return data;
    }

    public void setData(List<Linhkien> data) {
        this.data = data;
    }
	

	
	
}
