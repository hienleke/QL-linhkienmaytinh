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

public class TablemodelBanhang_ctHoadon extends AbstractTableModel {
	private String Header[] = { "Mặt Hàng",
	"Số lượng" ,"Đơn giá" };
	private List<CT_hoadon> data =null ;
	public TablemodelBanhang_ctHoadon() {
		
		
	}

    public List<CT_hoadon> getData() {
        return data;
    }

    public void setData(List<CT_hoadon> data) {
        this.data = data;
    }
        
        
        public TablemodelBanhang_ctHoadon(List<CT_hoadon> data ) {
		
		this.data = data;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Header.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
            if (data==null)
                return 0;
            
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
			return lk.getLinhkien().getDongiaban();
	

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
		if (columnIndex == 2 )
			return double.class;
		if (columnIndex == 1)
			return Integer.class;
		
		return String.class;
	}
	

	
	
}
