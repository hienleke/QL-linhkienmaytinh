package GUI.GuiControl;

import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import DAO.HoadonDAO;
import entities.Hoadon;


public class TablemodelHoadon extends AbstractTableModel {
	private String Header[] = { "Mã" ,"Khách Hàng", "Nhân Viên", "Ngày lập", "Thành tiền","Thuế" 
	 };
	private List<Hoadon> data ;
        
	public TablemodelHoadon() {
		          HoadonDAO hddao = new HoadonDAO(Hoadon.class);
                          data=hddao.getdshoadontrongngay();
		
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
			return lk.getKhachhang().getTen();
		
		case 2:
			return lk.getNhanvien().getTen();
			
		case 3:
			return lk.getNgaylap();
		case 4:
			return lk.Tinhtien();
                  
			
		case 5:
			return lk.tinhthue();
                    
			
		
			

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
		if (columnIndex == 4 || columnIndex==5)
			return Double.class;
		
		return String.class;
	}

    public List<Hoadon> getData() {
        return data;
    }

    public void setData(List<Hoadon> data) {
        this.data = data;
    }
	

	
	
}
