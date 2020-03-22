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
import GUI.Frame;
import entities.CT_hoadon;
import entities.Hoadon;
import java.math.BigDecimal;
import java.util.ArrayList;


public class Tablemodelthongke extends AbstractTableModel {
	private String Header[] = { "Tháng" ,"Doanh thu(nghìn đồng)", "Lãi(nghìn đồng)", "Thuế(nghìn đồng)", "Lượng sản phẩm đã bán"
	 };
	private List<ArrayList<String>> data  = new ArrayList<>();
        
        private Frame f;
	public Tablemodelthongke(int year,Frame f) {
		          HoadonDAO hddao = new HoadonDAO(Hoadon.class);
                          this.f=f;
                         for(int i=1;i<=12;i++)
                         {
                             Double doanhthu=0.0;
                             Double lãi=0.0;
                             Double thuế=0.0;
                             int slsanphamdaban=0;
                             List<Hoadon> ds = hddao.getDSbymonth(i,year);
                             for (Hoadon d : ds) {
                                doanhthu += d.Tinhtien()/1000;
                                lãi +=d.tinhlai()/1000;
                                thuế +=d.tinhthue()/1000;
                                 for (CT_hoadon d1 : d.getDsCthd()) {
                                     slsanphamdaban+=d1.getSoluong();
                                 }
                              
                             }
                             ArrayList<String> dulieu = new ArrayList<>();
                             dulieu.add(String.valueOf(i));
                             dulieu.add(f.formattien(doanhthu));
                              dulieu.add(f.formattien(lãi));
                               dulieu.add(f.formattien(thuế));
                                dulieu.add(String.valueOf(slsanphamdaban));
                             data.add(dulieu);
                         }
                                     
                          
		
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
		
		
		return data.get(rowIndex).get(columnIndex);
			
		
                    
			
		
			

	}
	

	@Override
	public String getColumnName(int column) {

		return Header[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}

    public Frame getF() {
        return f;
    }

    public void setF(Frame f) {
        this.f = f;
    }

 
	

	
	
}
