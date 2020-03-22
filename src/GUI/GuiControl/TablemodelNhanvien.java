package GUI.GuiControl;

import java.awt.Checkbox;
import java.time.LocalDate;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import DAO.DAOhelper;
import entities.Nhanvien;


public class TablemodelNhanvien extends AbstractTableModel {
	private String Header[] = { "Mã ", "Tên Nhân viên", "SDT ","Địa chỉ ","Người quản lí "
	};
	private List<Nhanvien> data ;
	public TablemodelNhanvien() {
		DAOhelper<Nhanvien> ohelper = new DAOhelper<>(Nhanvien.class);
		data = ohelper.findAll();
		
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return Header.length;
	}

	@Override
	public int getRowCount() {
		try{// TODO Auto-generated method stub
		return data.size();
                }
                catch(Exception e)
                {
                    
                }
                return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Nhanvien lk = data.get(rowIndex);
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
                        
                        if (lk.getNguoiquanli()==null)
                            return  "";
                                    else
			return lk.getNguoiquanli().getTen();
			

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

    public List<Nhanvien> getData() {
        return data;
    }

    public void setData(List<Nhanvien> data) {
        this.data = data;
    }
	

	
	
}
