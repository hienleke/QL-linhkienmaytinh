/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.GuiControl.TablemodelBanhang_linhkien;
import GUI.GuiControl.TablemodelBanhang_ctHoadon;
import GUI.GuiControl.TablemodelNhanvien;
import GUI.GuiControl.TablemodelKhachhang;
import GUI.GuiControl.Tablemodeldanhmuc;
import GUI.GuiControl.Tablemodelxuatxu;
import DAO.DanhmuclinhkienDAO;
import DAO.HoadonDAO;
import DAO.KhanhhangDAO;
import DAO.LinhkienDAO;
import DAO.NhacungcapDAO;
import DAO.NhanvienDAO;
import DAO.XuatxuDAO;

import GUI.GuiControl.TablemodelCT_hoadon;
import GUI.GuiControl.TablemodelNCC;
import GUI.GuiControl.TablemodelLinhkien;
import GUI.GuiControl.Tablemodelthongke;
import GUI.GuiControl.TablemodelNCC_cacsanpham;
import entities.Danhmuclinhkien;
import entities.Linhkien;

import entities.Nhacungcap;
import entities.Xuatxu;
import java.awt.CardLayout;
import java.awt.Color;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import GUI.GuiControl.TablemodelHoadon;
import GUI.GuiControl.TablemodelKhachhang_cachoadon;
import GUI.GuiControl.TablemodelNhanvien_cacHoadon;
import com.sun.org.apache.bcel.internal.generic.AASTORE;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entities.CT_hoadon;
import entities.Hoadon;
import entities.Khachhang;
import entities.Nhanvien;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author lahcen
 */
public class Frame extends javax.swing.JFrame {



    public void kichhoatpanel11() {
        // TODO add your handling code here:
        //bar(jLabel16);
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlihoadon");
        if (khachhhang == null) {
            fromthongtinkhachhang fr = new fromthongtinkhachhang();
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fr.setFrame(this);

            //    fr.getjTable1().getTableHeader().setPreferredSize(new  Dimension(jTable1.getTableHeader().getPreferredSize().width,jTable1.getTableHeader().getPreferredSize().height+8 ));
            fr.setLocationRelativeTo(this);
            fr.setVisible(true);// TODO add your handling code here:
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            // fr.setVisible(true);

            this.setEnabled(false);

            fr.show();
            fr.setResizable(false);
            fr.setAlwaysOnTop(true);
            fr.pack();

            fr.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    setEnabled(true);
                    setAlwaysOnTop(true);

                }
            });
        }
    }

    public void nhapthongtinnhanvien() {
        if (nhanvien != null) {
            jLabel32.setText(nhanvien.getTen());
            if (nhanvien.getNguoiquanli() == null) {
                jLabel33.setText("Quản Lí");
            } else {
                jLabel33.setText("Nhân Viên");
            }
        }
    }

    public void nhapthongtinkhachhang(Khachhang kh) {
        jLabel45.setText(kh.getTen());
        jLabel42.setText(kh.getSdt());
        jLabel37.setText(kh.getDiachi());
    }

    public void back_qly_hoadon() {
        jTabbedPane2.setSelectedIndex(0);
    }

    public Khachhang getKhachhhang() {
        return khachhhang;
    }

    public void setKhachhhang(Khachhang khachhhang) {
        this.khachhhang = khachhhang;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public List<CT_hoadon> getGiohang() {
        return giohang;
    }

    public JLabel getjLabel42() {
        return jLabel42;
    }

    public void setjLabel42(JLabel jLabel42) {
        this.jLabel42 = jLabel42;
    }

    public void setGiohang(List<CT_hoadon> giohang) {
        this.giohang = giohang;
    }

    public JTable getjTable11() {
        return jTable11;
    }

    public void setjTable11(JTable jTable11) {
        this.jTable11 = jTable11;
    }

    public TablemodelBanhang_ctHoadon getModelgiohang() {
        return modelgiohang;
    }

    public void setModelgiohang(TablemodelBanhang_ctHoadon modelgiohang) {
        this.modelgiohang = modelgiohang;
    }

    public TablemodelBanhang_linhkien getModelbanhang_linhkien() {
        return modelbanhang_linhkien;
    }

    public JLabel getjLabel103() {
        return jLabel103;
    }

    public void setjLabel103(JLabel jLabel103) {
        this.jLabel103 = jLabel103;
    }

    public void setModelbanhang_linhkien(TablemodelBanhang_linhkien modelbanhang_linhkien) {
        this.modelbanhang_linhkien = modelbanhang_linhkien;
    }

    public JLabel getjLabel40() {
        return jLabel40;
    }

    public void setjLabel40(JLabel jLabel40) {
        this.jLabel40 = jLabel40;
    }
    
    void taobieudothongke(int month)
    {
        JFreeChart lineChart = ChartFactory.createLineChart(
         "Biểu đồ thống kê doanh thu các ngày trong tháng",
         "Thời gian","Tiền(Nghìn đồng)",
         createDataset(month),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      
      bieudo.add(chartPanel);
    }
    public String formattien(Double tien)
    {
         DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

symbols.setGroupingSeparator(',');
formatter.setDecimalFormatSymbols(symbols);
        return formatter.format(tien);
    }
    public  DefaultCategoryDataset createDataset(int monthzz) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
       HoadonDAO hddao = new HoadonDAO(Hoadon.class);
       Calendar cal = Calendar.getInstance();
       cal.set(Calendar.MONTH, monthzz);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println(df.format(cal.getTime()));
                for (int i = 1; i <= maxDay; i++) 
                {
                cal.set(Calendar.DAY_OF_MONTH, i + 1);
                
          List<Hoadon> list = hddao.getDSbyday(i, monthzz,Integer.valueOf(jComboBox2.getSelectedItem().toString()));
          Double doanhthu =0.0;
                   Double lai =0.0;
                   double thue=0.0;
                    for (Hoadon list1 : list) {
                        doanhthu += list1.Tinhtien();
                        lai +=list1.tinhlai();
                        thue+=list1.tinhthue();
                    }
          
                    
                  dataset.addValue( doanhthu/1000 , "Doanh thu" ,  i + "");
                   dataset.addValue( lai/1000 , " Lãi " , i + "" );
                   dataset.addValue( thue/1000 , "Thuế" , i + "" );
                
                }
    
 
      return dataset;
   }
    /**
     * Creates new form Frame
     */
    public Frame() {
        modelnhanvien = new TablemodelNhanvien();
        datanhanvien = modelnhanvien.getData();
        modelkhachhang = new TablemodelKhachhang();
        modelbanhang_linhkien = new TablemodelBanhang_linhkien();
        databanhang_linhkien = modelbanhang_linhkien.getData();
        modelhoadon = new TablemodelHoadon();
        modelnhacungcap = new TablemodelNCC();
        modellinhkien = new TablemodelLinhkien(0);
        modelloaihang = new Tablemodeldanhmuc();
        modelxuatxu = new Tablemodelxuatxu();
        initComponents();
        taobieudothongke(LocalDate.now().getMonthValue());
        modelgiohang = new TablemodelBanhang_ctHoadon(giohang);
        hd.setDsCthd(giohang);
        listentablesanpham();
        listentablethongke();
        getdataforcomboloaisanpham();
        getdataforcombothongke();
        getdataforcombonhacungcap();
        getdataforcomboxuatxu();
        getdataforcomboloaisanpham_banhang();
        listentable_loaihang();
        listentablenhacungcap();
        listentablehoadon();
        listentablekhachhang();
        listentablenhanvien();
        listentablebanhang_linhkien();
        listentable_xuatxu();
        jTable10.getTableHeader().setPreferredSize(new Dimension(jTable10.getTableHeader().getPreferredSize().width, jTable10.getTableHeader().getPreferredSize().height + 8));
        jTable10.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 15));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlilinhkien");
        bar(jLabel5);
        reset_panel();
        jPanel4.setBackground(Color.decode("#565255"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        trangchuyen = new javax.swing.JPanel();
        quanlinhacungcap = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel34 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel82 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jTextField11 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jTextField12 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        quanlikhachhang = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jTextField20 = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        jTextField21 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        quanlihoadon = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        hoadon = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel71 = new javax.swing.JPanel();
        jTextField43 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel130 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        thongke = new javax.swing.JPanel();
        bieudo = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        bahang = new javax.swing.JPanel();
        banhang = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel97 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jTextField14 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jTextField15 = new javax.swing.JTextField();
        jPanel51 = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jTextField42 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        quanlinhanvien = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jTextField25 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jTextField26 = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jTextField27 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel52 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        quanlilinhkien = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel62 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel42 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel89 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel58 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel63 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel131 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel110 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton26 = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jButton40 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jPanel69 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jPanel70 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();

        jPanel11.setBackground(new java.awt.Color(42, 39, 41));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-sell-stock-40.png"))); // NOI18N
        jPanel11.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("BÁN HÀNG");
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel16.setBackground(new java.awt.Color(192, 27, 54));
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(250, 250, 250));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1920, 995));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 995));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 995));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(42, 39, 41));
        jPanel2.setMinimumSize(new java.awt.Dimension(230, 930));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 930));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(42, 39, 41));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(192, 27, 54));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Sản phẩm");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Devices-computer-icon.png"))); // NOI18N
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, 50));

        jPanel5.setBackground(new java.awt.Color(42, 39, 41));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refrigeration-Truck-with-Open-Door-icon.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jLabel8.setBackground(new java.awt.Color(192, 27, 54));
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Nhà cung cấp");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 130, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 50));

        jPanel6.setBackground(new java.awt.Color(42, 39, 41));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Clients-icon.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jLabel11.setBackground(new java.awt.Color(192, 27, 54));
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Khách hàng");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 230, 50));

        jPanel7.setBackground(new java.awt.Color(42, 39, 41));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-30.png"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jLabel14.setBackground(new java.awt.Color(192, 27, 54));
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Nhân viên");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 230, 50));

        jPanel10.setBackground(new java.awt.Color(42, 39, 41));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-management-40.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jLabel23.setBackground(new java.awt.Color(192, 27, 54));
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("QUẢN LÍ");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 130, 30));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, 60));

        jPanel8.setBackground(new java.awt.Color(42, 39, 41));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Product-sale-report-icon.png"))); // NOI18N
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jLabel18.setBackground(new java.awt.Color(192, 27, 54));
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 50));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Hóa đơn");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 230, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 990));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(192, 27, 54));
        jLabel28.setOpaque(true);
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1700, 10));

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 51, 153));
        jLabel30.setText("Họ tên :");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 51, 153));
        jLabel31.setText("Vị trí    :");

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel32.setText("xx");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel33.setText("xxxx");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-profile-64.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/closing.png"))); // NOI18N
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 550, 100));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("CHƯƠNG TRÌNH QUẢN LÍ");
        jPanel13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("CỬA HÀNG BÁN LINH KIỆN MÁY TÍNH");
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 390, -1));

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1130, 100));

        jLabel36.setBackground(new java.awt.Color(192, 27, 54));
        jLabel36.setOpaque(true);
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 10));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 1700, 120));

        trangchuyen.setBackground(new java.awt.Color(250, 250, 250));
        trangchuyen.setLayout(new java.awt.CardLayout());

        quanlinhacungcap.setBackground(new java.awt.Color(250, 250, 250));
        quanlinhacungcap.setMinimumSize(new java.awt.Dimension(1180, 630));
        quanlinhacungcap.setName(""); // NOI18N
        quanlinhacungcap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel33.setLayout(new java.awt.BorderLayout());

        jSplitPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane2.setDividerLocation(700);
        jSplitPane2.setDividerSize(10);

        jPanel34.setLayout(new java.awt.BorderLayout());

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable5.setModel(new TablemodelNCC()
        );
        jTable5.setRowHeight(35);
        jTable5.setRowMargin(2);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(jTable5);

        jPanel34.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        jSplitPane2.setLeftComponent(jPanel34);

        jPanel35.setLayout(new java.awt.BorderLayout());

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable6.setRowHeight(35);
        jScrollPane11.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable6.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable6.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTable6.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jPanel35.add(jScrollPane11, java.awt.BorderLayout.PAGE_START);

        jSplitPane2.setRightComponent(jPanel35);

        jPanel33.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        quanlinhacungcap.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 1670, 490));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 51, 153));
        jLabel69.setText("EMAIL");
        quanlinhacungcap.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 210, 70, 30));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 51, 153));
        jLabel70.setText("ĐỊA CHỈ");
        quanlinhacungcap.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 250, -1, 40));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 51, 153));
        quanlinhacungcap.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 60, 170, 40));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 51, 153));
        jLabel72.setText("TÊN");
        quanlinhacungcap.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, 50, 40));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 51, 153));
        jLabel73.setText("SĐT");
        quanlinhacungcap.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 160, 70, 40));

        jButton18.setBackground(new java.awt.Color(0, 102, 0));
        jButton18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Làm mới");
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton18.setBorderPainted(false);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        quanlinhacungcap.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 50));

        jButton19.setBackground(new java.awt.Color(51, 153, 255));
        jButton19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Thêm +");
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton19.setBorderPainted(false);
        jButton19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        quanlinhacungcap.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, 80, 50));

        jButton20.setBackground(new java.awt.Color(153, 0, 0));
        jButton20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Xóa -");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton20.setBorderPainted(false);
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        quanlinhacungcap.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 80, 50));

        jButton22.setBackground(new java.awt.Color(102, 0, 0));
        jButton22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Lưu");
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton22.setBorderPainted(false);
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        quanlinhacungcap.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 50, 100, 50));

        try {
            jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("A*****************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        quanlinhacungcap.add(jFormattedTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 130, 30));

        jLabel82.setFont(new java.awt.Font("Tahoma", 2, 20)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 51, 153));
        jLabel82.setText("Danh sách sản phẩm đã cung cấp");
        jLabel82.setToolTipText("");
        quanlinhacungcap.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 310, 30));
        jLabel82.getAccessibleContext().setAccessibleName("Danh sách sản phẩm đã cung cấp ");

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 51, 153));
        jLabel92.setText("Mã :");

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel45.setForeground(new java.awt.Color(204, 204, 204));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 153, 153));
        jTextField11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel45.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 51, 153));
        jLabel93.setText("SDT:");

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel46.setForeground(new java.awt.Color(204, 204, 204));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(153, 153, 153));
        jTextField12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel46.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 350, 30));

        jButton16.setBackground(new java.awt.Color(0, 153, 51));
        jButton16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Lọc");
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel47.setForeground(new java.awt.Color(204, 204, 204));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(153, 153, 153));
        jTextField13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel47.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 130, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 51, 153));
        jLabel94.setText("Tên :");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                    .addContainerGap(762, Short.MAX_VALUE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(129, 129, 129)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        quanlinhacungcap.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1050, 80));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 51, 153));
        jLabel95.setText("ID");
        quanlinhacungcap.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 60, 40, 40));

        jLabel96.setFont(new java.awt.Font("Tahoma", 2, 20)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 51, 153));
        jLabel96.setText("Danh sách nhà cung cấp");
        jLabel96.setToolTipText("");
        quanlinhacungcap.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 250, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quanlinhacungcap.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 160, 300, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quanlinhacungcap.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 210, 300, 30));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quanlinhacungcap.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 260, 300, 30));

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        quanlinhacungcap.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 110, 300, 30));

        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setText("1");
        quanlinhacungcap.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 810, 50, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_next_page_50px.png"))); // NOI18N
        quanlinhacungcap.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 810, 50, 40));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back_to_50px.png"))); // NOI18N
        quanlinhacungcap.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 810, 50, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(726, 726, 726)
                .addComponent(jLabel1)
                .addContainerGap(725, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        quanlinhacungcap.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 40));

        trangchuyen.add(quanlinhacungcap, "quanlinhacungcap");

        quanlikhachhang.setBackground(new java.awt.Color(250, 250, 250));
        quanlikhachhang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton14.setBackground(new java.awt.Color(102, 0, 0));
        jButton14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Lưu");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton14.setBorderPainted(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        quanlikhachhang.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 50, 90, 40));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 51, 153));
        jLabel49.setText("Họ tên ");
        quanlikhachhang.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 110, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 51, 153));
        jLabel50.setText("SĐT ");
        quanlikhachhang.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 60, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 51, 153));
        jLabel74.setText("Email ");
        quanlikhachhang.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 110, -1, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 51, 153));
        jLabel76.setText("Địa chỉ");
        quanlikhachhang.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 170, 70, 30));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 51, 153));
        jLabel77.setText("ID:");
        quanlikhachhang.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 210, 30));

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 51, 153));
        jLabel83.setText("ID");
        quanlikhachhang.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 40, 30));

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));
        jPanel53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 51, 153));
        jLabel101.setText("Mã :");
        jPanel53.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 50, 50));

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel54.setForeground(new java.awt.Color(204, 204, 204));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(153, 153, 153));
        jTextField19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel54.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 30));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 15, 174, 51));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 51, 153));
        jLabel102.setText("SDT:");
        jPanel53.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 15, 50, 51));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel55.setForeground(new java.awt.Color(204, 204, 204));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(153, 153, 153));
        jTextField20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel55.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 170, 30));

        jPanel53.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 15, 192, 51));

        jButton31.setBackground(new java.awt.Color(0, 153, 51));
        jButton31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Lọc");
        jButton31.setBorder(null);
        jButton31.setBorderPainted(false);
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel53.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 69, 50));

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));
        jPanel56.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel56.setForeground(new java.awt.Color(204, 204, 204));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(153, 153, 153));
        jTextField21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jPanel56.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 130, 30));

        jPanel53.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 15, 155, 51));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 51, 153));
        jLabel104.setText("Tên :");
        jPanel53.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 15, -1, 51));

        quanlikhachhang.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 810, 90));

        jButton32.setBackground(new java.awt.Color(51, 153, 255));
        jButton32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Thêm +");
        jButton32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton32.setBorderPainted(false);
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        quanlikhachhang.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 80, 50));

        jButton33.setBackground(new java.awt.Color(153, 0, 0));
        jButton33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Xóa -");
        jButton33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton33.setBorderPainted(false);
        jButton33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        quanlikhachhang.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 80, 50));

        jButton34.setBackground(new java.awt.Color(0, 102, 0));
        jButton34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Làm mới");
        jButton34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton34.setBorderPainted(false);
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        quanlikhachhang.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 50));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quanlikhachhang.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 160, 280, 40));

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        quanlikhachhang.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 100, 230, 40));

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField23.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        quanlikhachhang.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 160, 230, 40));

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quanlikhachhang.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 280, 40));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable4.setModel(new TablemodelKhachhang
            ());
        jTable4.setRowHeight(35);
        jScrollPane7.setViewportView(jTable4);

        quanlikhachhang.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1660, 470));

        jLabel117.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(51, 51, 255));
        jLabel117.setText("Danh sách khách hàng");
        quanlikhachhang.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, -1));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_next_page_50px.png"))); // NOI18N
        quanlikhachhang.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 760, 50, 40));

        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back_to_50px.png"))); // NOI18N
        quanlikhachhang.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 760, 50, 40));

        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setText("1");
        quanlikhachhang.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 760, 50, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(736, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(733, 733, 733))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        quanlikhachhang.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 40));

        trangchuyen.add(quanlikhachhang, "quanlikhachhang");

        quanlihoadon.setBackground(new java.awt.Color(250, 250, 250));
        quanlihoadon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel32.setBackground(new java.awt.Color(250, 250, 250));

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        hoadon.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane1.setDividerLocation(700);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(1230, 408));

        jPanel26.setLayout(new java.awt.BorderLayout());

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setRowHeight(35);
        jScrollPane6.setViewportView(jTable1);

        jPanel26.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel26);

        jPanel25.setLayout(new java.awt.BorderLayout());

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new TablemodelHoadon());
        jTable2.setRowHeight(35);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable2);

        jPanel25.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel15.setLayout(new java.awt.BorderLayout());
        jPanel25.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setLeftComponent(jPanel25);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel29.setForeground(new java.awt.Color(204, 204, 204));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 153));
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel29.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 30));

        jPanel27.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, 350, 50));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 51, 153));
        jLabel51.setText("Tên khách hàng :");
        jPanel27.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 190, 40));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 51, 153));
        jLabel65.setText("ID Hóa đơn :");
        jPanel27.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 40));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel30.setForeground(new java.awt.Color(204, 204, 204));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 153));
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel30.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 30));

        jPanel27.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 90, 350, 50));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel31.setForeground(new java.awt.Color(204, 204, 204));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 153));
        jTextField7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel31.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 30));

        jPanel27.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 370, 50));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 51, 153));
        jLabel66.setText("Đến:");
        jPanel27.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 160, 40));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 51, 153));
        jLabel67.setText("Tên nhân viên :");
        jPanel27.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 180, 40));

        jButton35.setBackground(new java.awt.Color(0, 153, 51));
        jButton35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Lọc");
        jButton35.setBorder(null);
        jButton35.setBorderPainted(false);
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel27.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 70, 50));

        jButton37.setBackground(new java.awt.Color(0, 153, 255));
        jButton37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("Nạp lại danh sách");
        jButton37.setBorder(null);
        jButton37.setBorderPainted(false);
        jButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel27.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 20, 160, 50));

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jPanel27.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 370, 40));

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));
        jPanel71.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel71.setForeground(new java.awt.Color(204, 204, 204));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField43.setForeground(new java.awt.Color(0, 0, 153));
        jTextField43.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField43ActionPerformed(evt);
            }
        });
        jPanel71.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 30));

        jPanel27.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 370, 50));

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 51, 153));
        jLabel129.setText("SĐT Khách hàng :");
        jPanel27.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 198, 40));

        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jPanel27.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 350, 40));

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 51, 153));
        jLabel130.setText("Thời gian từ :");
        jPanel27.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 40));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 51, 51));
        jPanel27.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 370, 30));

        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setText("1");
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });

        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_next_page_50px.png"))); // NOI18N

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back_to_50px.png"))); // NOI18N

        javax.swing.GroupLayout hoadonLayout = new javax.swing.GroupLayout(hoadon);
        hoadon.setLayout(hoadonLayout);
        hoadonLayout.setHorizontalGroup(
            hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hoadonLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 1660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(hoadonLayout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel124)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel125)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hoadonLayout.setVerticalGroup(
            hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel124)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel125))
                .addGap(103, 103, 103))
        );

        jTabbedPane2.addTab("  Quản lý hoá đơn  ", hoadon);

        thongke.setBackground(new java.awt.Color(255, 255, 255));
        thongke.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bieudo.setLayout(new java.awt.BorderLayout());
        thongke.add(bieudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, 880, 650));

        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable7.setModel(new Tablemodelthongke(LocalDate.now().getYear(),this));
        jTable7.setRowHeight(35);
        jScrollPane8.setViewportView(jTable7);

        thongke.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 750, 360));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setMaximumRowCount(10);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2019", "2019", "2019", "2019", "2019" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        thongke.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 390, 140, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel68.setText("Lãi(nghìn đồng):");
        thongke.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, -1, -1));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel132.setText("Doanh thu (nghìn đồng):");
        thongke.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 240, -1));

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel135.setText("Tiền thuế(nghìn đồng):");
        thongke.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, -1, -1));

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel136.setText("Lượng sản phẩm đã bán :");
        thongke.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, -1, -1));

        jTextField44.setEditable(false);
        jTextField44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField44ActionPerformed(evt);
            }
        });
        thongke.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 440, 410, 40));

        jTextField45.setEditable(false);
        thongke.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 500, 410, 40));

        jTextField46.setEditable(false);
        thongke.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 560, 410, 40));

        jTextField47.setEditable(false);
        thongke.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 620, 410, 40));

        jTabbedPane2.addTab("  Thống kê  ", thongke);

        bahang.setBackground(new java.awt.Color(255, 255, 255));

        banhang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel16.setPreferredSize(new java.awt.Dimension(1180, 900));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel19.setForeground(new java.awt.Color(255, 255, 255));
        jPanel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Places-user-identity-icon.png"))); // NOI18N
        jLabel19.setText("Khách hàng ");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 51, 153));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 51, 153));
        jLabel38.setText("SDT      :");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 51, 153));
        jLabel39.setText("Địa chỉ :");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 51, 153));
        jLabel46.setText("Họ tên :");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 153));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel46)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel19)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)))
                .addGap(17, 17, 17))
        );

        jPanel16.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 170));

        jButton5.setBackground(new java.awt.Color(0, 153, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Thanh toán");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 710, 210, 50));

        jPanel18.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 380, 0));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 51));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel16.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 370, 20));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 51));
        jLabel41.setText("Tổng");
        jPanel16.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 90, 30));

        jButton7.setBackground(new java.awt.Color(153, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Hủy");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 220, 50));

        jScrollPane2.setBackground(new java.awt.Color(51, 153, 255));

        jTable11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable11.setModel(new TablemodelBanhang_ctHoadon()
        );
        jTable11.setRowHeight(30);
        jScrollPane2.setViewportView(jTable11);

        jPanel16.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 520, 390));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel47.setText("đồng");
        jPanel16.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 640, -1, -1));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 153));
        jLabel44.setText("Mô tả thêm :");
        jPanel20.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 51, 153));
        jLabel75.setText("Mã :");
        jPanel20.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(102, 102, 102));
        jPanel20.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 240, 30));
        jPanel20.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 270, 90));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(3);
        jScrollPane1.setViewportView(jTextArea2);

        jPanel20.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 440, 90));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox7.setMaximumRowCount(20);
        jComboBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox7ItemStateChanged(evt);
            }
        });
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jComboBox7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox7PropertyChange(evt);
            }
        });
        jPanel48.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 18, 135, 50));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 51, 153));
        jLabel97.setText("Mã :");
        jPanel48.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 16, 41, 50));

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel49.setForeground(new java.awt.Color(204, 204, 204));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(153, 153, 153));
        jTextField14.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel49.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        jPanel48.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 16, 220, 52));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 51, 153));
        jLabel98.setText("Nguồn gốc :");
        jPanel48.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 86, -1, 51));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel50.setForeground(new java.awt.Color(204, 204, 204));
        jPanel50.setPreferredSize(new java.awt.Dimension(220, 40));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(153, 153, 153));
        jTextField15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel50.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jPanel48.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 16, 189, 52));

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel51.setForeground(new java.awt.Color(204, 204, 204));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(153, 153, 153));
        jTextField16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jPanel51.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        jPanel48.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 86, 221, 51));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel52.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(153, 153, 153));
        jTextField17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanel52.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        jPanel48.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 86, 189, 51));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 51, 153));
        jLabel99.setText("Tên :");
        jPanel48.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 28, 50, 40));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 51, 153));
        jLabel100.setText("Nhà cung cấp :");
        jPanel48.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 86, -1, 51));

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel61.setForeground(new java.awt.Color(204, 204, 204));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField42.setForeground(new java.awt.Color(0, 51, 204));
        jTextField42.setText("Mô tả thêm");
        jTextField42.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField42MouseClicked(evt);
            }
        });
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField42ActionPerformed(evt);
            }
        });
        jPanel61.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        jPanel48.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 134, 50));

        jButton17.setBackground(new java.awt.Color(0, 153, 51));
        jButton17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Lọc");
        jButton17.setBorder(null);
        jButton17.setBorderPainted(false);
        jButton17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane13.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setBorder(null);

        jTable10.setModel(modelbanhang_linhkien);
        jTable10.setRowHeight(30);
        jScrollPane13.setViewportView(jTable10);

        jButton6.setBackground(new java.awt.Color(204, 0, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("<<");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText(">>");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jScrollPane13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(0, 454, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 455, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout banhangLayout = new javax.swing.GroupLayout(banhang);
        banhang.setLayout(banhangLayout);
        banhangLayout.setHorizontalGroup(
            banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        banhangLayout.setVerticalGroup(
            banhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banhangLayout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(817, 817, 817))
        );

        javax.swing.GroupLayout bahangLayout = new javax.swing.GroupLayout(bahang);
        bahang.setLayout(bahangLayout);
        bahangLayout.setHorizontalGroup(
            bahangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bahangLayout.createSequentialGroup()
                .addComponent(banhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        bahangLayout.setVerticalGroup(
            bahangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bahangLayout.createSequentialGroup()
                .addComponent(banhang, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Bán hàng", bahang);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1719, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel32Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel32Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        quanlihoadon.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        trangchuyen.add(quanlihoadon, "quanlihoadon");

        quanlinhanvien.setBackground(new java.awt.Color(250, 250, 250));
        quanlinhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane4.setDividerLocation(700);
        jSplitPane4.setDividerSize(10);

        jPanel38.setLayout(new java.awt.BorderLayout());

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable8.setModel(new TablemodelNhanvien
            ()
        );
        jTable8.setRowHeight(35);
        jScrollPane9.setViewportView(jTable8);

        jPanel38.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        jSplitPane4.setLeftComponent(jPanel38);

        jPanel39.setLayout(new java.awt.BorderLayout());

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));

        jTable9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable9.setRowHeight(35);
        jScrollPane12.setViewportView(jTable9);

        jPanel39.add(jScrollPane12, java.awt.BorderLayout.CENTER);

        jSplitPane4.setRightComponent(jPanel39);

        quanlinhanvien.add(jSplitPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1630, 570));

        jButton15.setBackground(new java.awt.Color(102, 0, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Lưu");
        jButton15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton15.setBorderPainted(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        quanlinhanvien.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 80, 50));

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 51, 153));
        jLabel105.setText("Mã :");

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel58.setForeground(new java.awt.Color(204, 204, 204));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(153, 153, 153));
        jTextField25.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jPanel58.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 51, 153));
        jLabel106.setText("SDT :");

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel59.setForeground(new java.awt.Color(204, 204, 204));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(153, 153, 153));
        jTextField26.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jPanel59.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel60.setForeground(new java.awt.Color(204, 204, 204));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(153, 153, 153));
        jTextField27.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jPanel60.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 51, 153));
        jLabel107.setText("Tên :");

        jButton21.setBackground(new java.awt.Color(0, 153, 51));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Lọc");
        jButton21.setBorder(null);
        jButton21.setBorderPainted(false);
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel105)
                .addGap(26, 26, 26)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel106)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel57Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        quanlinhanvien.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 890, 90));

        jButton23.setBackground(new java.awt.Color(0, 153, 255));
        jButton23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Thêm +");
        jButton23.setBorder(null);
        jButton23.setBorderPainted(false);
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        quanlinhanvien.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 80, 50));

        jButton24.setBackground(new java.awt.Color(0, 102, 0));
        jButton24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("Làm mới");
        jButton24.setBorder(null);
        jButton24.setBorderPainted(false);
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        quanlinhanvien.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 50));

        jButton25.setBackground(new java.awt.Color(153, 0, 0));
        jButton25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Xóa -");
        jButton25.setBorder(null);
        jButton25.setBorderPainted(false);
        jButton25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        quanlinhanvien.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 80, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(766, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(723, 723, 723))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        quanlinhanvien.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1700, 40));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 51, 153));
        jLabel84.setText("ID");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 51, 153));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 51, 153));
        jLabel79.setText("Họ tên");

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 51, 153));
        jLabel86.setText("SĐT");

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 51, 153));
        jLabel80.setText("Người quản lí");

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 51, 153));
        jLabel52.setText("Địa chỉ");

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 51, 153));
        jLabel85.setText("Mật khẩu đăng nhập");

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1)
                    .addComponent(jTextField29, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jTextField8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        quanlinhanvien.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, -1, 170));

        jLabel128.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 51, 153));
        jLabel128.setText("Danh sách nhân viên");
        quanlinhanvien.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, -1));

        trangchuyen.add(quanlinhanvien, "quanlinhanvien");

        quanlilinhkien.setBackground(new java.awt.Color(250, 250, 250));
        quanlilinhkien.setMinimumSize(new java.awt.Dimension(1700, 995));
        quanlilinhkien.setPreferredSize(new java.awt.Dimension(1700, 995));
        quanlilinhkien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable3.setModel(modellinhkien
        );
        jTable3.setRowHeight(35);
        jTable3.setRowMargin(2);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox4.setMaximumRowCount(20);
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 51, 153));
        jLabel90.setText("Mã :");

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel41.setForeground(new java.awt.Color(204, 204, 204));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 153, 153));
        jTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel41.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 51, 153));
        jLabel91.setText("Tên :");

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jPanel43.setForeground(new java.awt.Color(204, 204, 204));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(153, 153, 153));
        jTextField10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel43.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 400, 30));

        jButton11.setBackground(new java.awt.Color(0, 153, 51));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Lọc");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel40.setForeground(new java.awt.Color(204, 204, 204));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 51, 153));
        jLabel81.setText("ID");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 51, 153));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 51, 153));
        jLabel54.setText("Tên");

        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 51, 153));
        jLabel62.setText("Loại ");

        jComboBox5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jComboBox5.setMaximumRowCount(20);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 51, 153));
        jLabel55.setText("Số lượng ");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 51, 153));
        jLabel89.setText("Giá nhập");

        jFormattedTextField2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 51, 153));
        jLabel59.setText("Xuất xứ");

        jComboBox6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jComboBox6.setMaximumRowCount(20);
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 51, 153));
        jLabel58.setText("Nhà cung cấp");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jComboBox1.setMaximumRowCount(40);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 51, 153));
        jLabel57.setText("Mô tả       ");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 255));
        jTextArea1.setRows(4);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 51, 153));
        jLabel63.setText("Hình ảnh minh họa");

        jLabel61.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 51, 153));
        jLabel61.setText("Chọn ảnh ...");
        jLabel61.setToolTipText("");
        jLabel61.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel61MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel61MouseExited(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 51, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Lưu");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton9.setBorderPainted(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 51, 153));
        jLabel131.setText("Giá bán");

        jFormattedTextField4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel57)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel40Layout.createSequentialGroup()
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton13.setBackground(new java.awt.Color(51, 153, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Thêm +");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton13.setBorderPainted(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(153, 0, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Xóa -");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Làm mới");
        jButton12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton12.setBorderPainted(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel121.setBackground(new java.awt.Color(255, 255, 255));
        jLabel121.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 255));
        jLabel121.setText("Danh sách các sản phẩm thêm gần đây");

        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setText("1");

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_next_page_50px.png"))); // NOI18N
        jLabel126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel126MouseClicked(evt);
            }
        });

        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_back_to_50px.png"))); // NOI18N
        jLabel127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel127MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel62Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel62Layout.createSequentialGroup()
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton13)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel62Layout.createSequentialGroup()
                                .addGap(538, 538, 538)
                                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel126)))
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel121)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField41, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("  Sản phẩm   ", jPanel62);

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        jTable12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable12.setModel(new Tablemodeldanhmuc()
        );
        jTable12.setRowHeight(35);
        jTable12.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(jTable12);

        jLabel110.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 51, 153));
        jLabel110.setText("Danh sách các loại hàng");

        jButton28.setBackground(new java.awt.Color(0, 51, 153));
        jButton28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Thêm ");
        jButton28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton28.setBorderPainted(false);
        jButton28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 0, 51));
        jButton29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Xoá");
        jButton29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton29.setBorderPainted(false);
        jButton29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel65Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel65Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel110)
                    .addGroup(jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));
        jPanel66.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 153));
        jLabel48.setText("Mã loại hàng");

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 51, 153));
        jLabel56.setText("Mô tả :");

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 51, 153));
        jLabel87.setText("Tên loại hàng :");

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane14.setViewportView(jTextArea3);

        jButton26.setBackground(new java.awt.Color(153, 0, 0));
        jButton26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("Lưu");
        jButton26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton26.setBorderPainted(false);
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 51, 153));

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel66Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField31)
                            .addComponent(jScrollPane14)
                            .addGroup(jPanel66Layout.createSequentialGroup()
                                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel66Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 83, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel48)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel87)
                .addGap(18, 18, 18)
                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));
        jPanel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 51, 153));
        jLabel108.setText("MÃ :");

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 51, 153));
        jLabel109.setText("TÊN:");

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton27.setBackground(new java.awt.Color(51, 255, 51));
        jButton27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Lọc");
        jButton27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton27.setBorderPainted(false);
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(51, 255, 51));
        jButton41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("Làm mới");
        jButton41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton41.setBorderPainted(false);
        jButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel65, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Loại hàng   ", jPanel64);

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));
        jPanel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 51, 153));
        jLabel111.setText("Mã xuất xứ");

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 51, 153));
        jLabel112.setText("Tên xuất xứ");

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton40.setBackground(new java.awt.Color(51, 255, 51));
        jButton40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("Lọc");
        jButton40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton40.setBorderPainted(false);
        jButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(51, 255, 51));
        jButton42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("Làm mới");
        jButton42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton42.setBorderPainted(false);
        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel111)
                .addGap(34, 34, 34)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel112)
                .addGap(68, 68, 68)
                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jScrollPane16.setBackground(new java.awt.Color(255, 255, 255));

        jTable13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable13.setModel(new Tablemodelxuatxu()
        );
        jTable13.setRowHeight(35);
        jScrollPane16.setViewportView(jTable13);

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));
        jPanel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 204));
        jLabel113.setText("Quốc gia");

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 204));
        jLabel114.setText("Mã xuất xứ :");

        jTextField36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 51, 255));

        jButton36.setBackground(new java.awt.Color(255, 0, 0));
        jButton36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Lưu");
        jButton36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton36.setBorderPainted(false);
        jButton36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel70Layout.createSequentialGroup()
                        .addComponent(jLabel114)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField36, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel113)
                .addGap(18, 18, 18)
                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jButton38.setBackground(new java.awt.Color(51, 51, 255));
        jButton38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 255, 255));
        jButton38.setText("Thêm ");
        jButton38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton38.setBorderPainted(false);
        jButton38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton38.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButton38AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(255, 0, 51));
        jButton39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Xoá");
        jButton39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton39.setBorderPainted(false);
        jButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Xuất xứ  ", jPanel63);

        quanlilinhkien.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1690, 870));

        trangchuyen.add(quanlilinhkien, "quanlilinhkien");

        jPanel1.add(trangchuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 1670, 870));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 995));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        formtatchuongtrinh fr = new formtatchuongtrinh();
        fr.setFrame(this);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        // fr.setVisible(true);

        this.setEnabled(false);

        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);

            }
        });
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        bar(jLabel5);
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlilinhkien");
        reset_panel();
        jPanel4.setBackground(Color.decode("#565255"));

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // jPanel4.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        //   jPanel4.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        ///  jPanel5.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
//        jPanel5.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        bar(jLabel8);
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlinhacungcap");
        reset_panel();
        jPanel5.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        bar(jLabel11);  // TODO add your handling code here:
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlikhachhang");
        reset_panel();
        jPanel6.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // jPanel6.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        //    jPanel6.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel6MouseExited
    public void reset_panel() {
        jPanel4.setBackground(Color.decode("#2a2729"));
        jPanel5.setBackground(Color.decode("#2a2729"));
        jPanel6.setBackground(Color.decode("#2a2729"));
        jPanel7.setBackground(Color.decode("#2a2729"));
        jPanel8.setBackground(Color.decode("#2a2729"));
    }
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        if (nhanvien == null || nhanvien.getNguoiquanli() != null) {
            JOptionPane.showMessageDialog(this, "Bạn không thể sử dụng đc chức năng này ");
            return;
        }
        bar(jLabel14);// TODO add your handling code here:
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlinhanvien");
        reset_panel();
        jPanel7.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
///        jPanel7.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        ///        jPanel7.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        bar(jLabel16);
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "banhang");
        if (khachhhang == null) {
            fromthongtinkhachhang fr = new fromthongtinkhachhang();
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fr.setFrame(this);

            //    fr.getjTable1().getTableHeader().setPreferredSize(new  Dimension(jTable1.getTableHeader().getPreferredSize().width,jTable1.getTableHeader().getPreferredSize().height+8 ));
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            fr.setVisible(true);// TODO add your handling code here:
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fr.setLocationRelativeTo(this);
            // fr.setVisible(true);

            this.setEnabled(false);

            fr.show();
            fr.setResizable(false);
            fr.setAlwaysOnTop(true);
            fr.pack();

            fr.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    setEnabled(true);
                    setAlwaysOnTop(true);

                }
            });
        }
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
        jPanel11.setBackground(Color.decode("#565255"));

    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
        jPanel11.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        bar(jLabel18);
        CardLayout cl = (CardLayout) trangchuyen.getLayout();
        cl.show(trangchuyen, "quanlihoadon");
        reset_panel();
        jPanel8.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        //  jPanel8.setBackground(Color.decode("#565255"));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        ///   jPanel8.setBackground(Color.decode("#2a2729"));
    }//GEN-LAST:event_jPanel8MouseExited
    public boolean check_themlinhkien(){
        String ten = jFormattedTextField1.getText().trim();
        if(ten.isEmpty()){
            JOptionPane.showMessageDialog(this, "Tên không được để trống !!");
            jFormattedTextField1.requestFocus();
            return false;
        }
        String gia =jFormattedTextField2.getText();
        if(gia.isEmpty()){
            JOptionPane.showMessageDialog(this, "Giá nhập không được để trống !!");
            jFormattedTextField2.requestFocus();
            return false;
        }
        String giaban =jFormattedTextField2.getText();
        if (giaban.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá bán không được để trống !!");
            jFormattedTextField4.requestFocus();
            return false;
        }
        try {
            double gia_nhap =Double.parseDouble(gia);
             double gia_ban =Double.parseDouble(giaban);
             if(gia_ban <=0 || gia_nhap <=0){
                 JOptionPane.showMessageDialog(this, "Không được nhập số âm !!!");
                 return false;
             }
             if(gia_ban<gia_nhap){
                                 JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn giá nhập !!!");
                 return false;
             }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Phải nhập số !!!");

            // xử lý khi số nhập vào ko đúng   
            return false;
            
        }
        return true;
    }
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        if (check_themlinhkien() == true) {
            String ten = jFormattedTextField1.getText().trim();
            DanhmuclinhkienDAO dmdao = new DanhmuclinhkienDAO(Danhmuclinhkien.class);
            Danhmuclinhkien dm = dmdao.findbyname(jComboBox5.getSelectedItem().toString());
            int sl = (int) jSpinner1.getValue();
            double dg = Double.valueOf(jFormattedTextField2.getText());
            double dgiaban = Double.valueOf(jFormattedTextField4.getText());
            XuatxuDAO xxdao = new XuatxuDAO(Xuatxu.class);
            Xuatxu xx = xxdao.findbyname(jComboBox6.getSelectedItem().toString());
            String mota = jTextArea1.getText();
            NhacungcapDAO ncdao = new NhacungcapDAO(Nhacungcap.class);
            Nhacungcap ncc = ncdao.findbyname(jComboBox1.getSelectedItem().toString());

            String id = jLabel53.getText().trim();

            linhkienthemvao = new Linhkien(id, ten, sl, dg, mota, ncc, xx, dm, path);
            linhkienthemvao.setDongiaban(dgiaban);

            linhkienthemvao.setHinhanh(path);
            LinhkienDAO lkDAO = new LinhkienDAO(Linhkien.class);
            boolean k = lkDAO.luucapnhat(linhkienthemvao);
            if (k == false) {
                JOptionPane.showMessageDialog(this, "Không thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thành công");
                jButton12ActionPerformed(evt);
            }
        }

        // linhkienthemvao = new Linhkien(ten, dg, ncc, xx, dm, path);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        String id = jLabel53.getText();
        if (id != null) {

            formxacnhan fr = new formxacnhan();
            fr.setId(id);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            fr.setVisible(true);// TODO add your handling code here:
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            // fr.setVisible(true);

            this.setEnabled(false);

            fr.show();
            fr.setResizable(false);
            fr.setAlwaysOnTop(true);
            fr.pack();

            fr.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    setEnabled(true);
                    setAlwaysOnTop(true);

                }
            });
            if (fr.getXacnhan() == 1) {
                jButton12ActionPerformed(evt);
            }
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String ma = jTextField9.getText().trim();
        String ten = jTextField10.getText().trim();
        String dm = jComboBox4.getSelectedItem().toString();
        if(dm.equalsIgnoreCase("Tất cả"))
            dm="";
      //  List<Linhkien> ds = bangtam;

        List<Linhkien> dstam = new ArrayList<>(); 
        dstam = new LinhkienDAO(Linhkien.class).quanli_loc(ma, ten, dm);
            modellinhkien.setData(dstam);
            modellinhkien.fireTableDataChanged();
            jTable3.setModel(modellinhkien);

     
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        modellinhkien = new TablemodelLinhkien(0);
        modellinhkien.fireTableDataChanged();
        jTable3.setModel(modellinhkien);
        jTable3.clearSelection();
        jComboBox4.setSelectedItem("Tất cả");
  
        jLabel53.setText("");
        jFormattedTextField1.setText("");
        jSpinner1.setValue(0);
        jFormattedTextField2.setText("");
        jTextArea1.setText("");
        jTextField41.setText("1");

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseEntered
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
    }//GEN-LAST:event_jLabel61MouseEntered

    private void jLabel61MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseExited
        // TODO add your handling code here:
        jLabel61.setForeground(new java.awt.Color(0, 51, 153));
        jLabel61.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
    }//GEN-LAST:event_jLabel61MouseExited

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        JFileChooser fileChooser = new JFileChooser();
//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            path = selectedFile.getPath();
            ImageIcon image = new ImageIcon(selectedFile.getPath());
      jLabel122.setIcon(image);
            // lưu ý sửa lại, xoá mất jLanel20 mẹ roii
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel61MouseClicked

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:

        jTable3.clearSelection();
        jLabel53.setText("");
        jFormattedTextField1.setText("");
        jFormattedTextField4.setText("");
        jSpinner1.setValue(0);
        jFormattedTextField2.setText("");
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        modelnhacungcap = new TablemodelNCC();
        modelnhacungcap.fireTableDataChanged();
        datancc = modelnhacungcap.getData();
        jTable5.setModel(modelnhacungcap);
        jLabel71.setText("");
        jTextField18.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        // jButton18ActionPerformed(evt);

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        jButton18ActionPerformed(evt);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:

        if (jTable5.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn một sản phẩm nào");
            return;
        }

        formxacnhannhacungcap fr = new formxacnhannhacungcap();
        fr.setId(jLabel71.getText());
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);

        this.setEnabled(false);
        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);

            }
        });
        jButton18ActionPerformed(evt);

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String id = jLabel71.getText();
        String ten = jTextField18.getText();
        String sdt = jTextField1.getText().trim();
        String email = jTextField2.getText().trim();
        String diachi = jTextField3.getText().trim();
        Nhacungcap ncc = new Nhacungcap(id, ten, diachi, sdt, email);
        NhacungcapDAO ndao = new NhacungcapDAO(Nhacungcap.class);
        boolean q = ndao.luucapnhat(ncc);
        if (q == true) {
            JOptionPane.showMessageDialog(this, "Thành công ");
        } else {
            JOptionPane.showMessageDialog(this, "Không thành công");
        }
    }//GEN-LAST:event_jButton22ActionPerformed
    public boolean check_khachhang(){
        String ten = jTextField24.getText().trim();
        if(ten.isEmpty()){
          
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống ");
            jTextField24.requestFocus();
            return false;
        }
        
        String sdt = jTextField4.getText().trim();
        if (sdt.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng không được để trống ");
            jTextField4.requestFocus();
            return false;
        }
        

        String email = jTextField22.getText().trim();
        if (email.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Email không được để trống  ");
            jTextField24.requestFocus();
            return false;
        }

        String diachi = jTextField23.getText().trim();
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống ");
            jTextField24.requestFocus();
            return false;
        }
        if(sdt.length()>10){
            JOptionPane.showMessageDialog(this, "Số điện thoại quá dài ");
            jTextField4.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(sdt);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Số điện thoại không được nhập chữ ");
            jTextField4.requestFocus();
        }
        return true;
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        if(check_khachhang()==true){
        String id = jLabel77.getText();
        String ten = jTextField24.getText();
        String sdt = jTextField4.getText().trim();
        String email = jTextField22.getText().trim();
        String diachi = jTextField23.getText().trim();
        Khachhang ncc = new Khachhang(id, ten, diachi, sdt, email);
        KhanhhangDAO khdao = new KhanhhangDAO(Khachhang.class);
        boolean q = khdao.luucapnhat(ncc);
        if (q == true) {
            JOptionPane.showMessageDialog(this, "Thành công ");
        }
        }

    }//GEN-LAST:event_jButton14ActionPerformed
    public boolean check_nhanvien(){
        String ten = jTextField28.getText().trim();
        if(ten.isEmpty()){
          
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống ");
            jTextField28.requestFocus();
            return false;
        }
        
        String sdt = jTextField30.getText().trim();
        if (sdt.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Số điện thoại nhân viên không được để trống ");
            jTextField30.requestFocus();
            return false;
        }
        

        String diachi = jTextField29.getText().trim();
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống ");
            jTextField29.requestFocus();
            return false;
        }
        if(sdt.length()>10){
            JOptionPane.showMessageDialog(this, "Số điện thoại quá dài ");
            jTextField4.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(sdt);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Số điện thoại không được nhập chữ ");
            jTextField4.requestFocus();
        }
        return true;
    }
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if(check_nhanvien()==true){
                    String id = jLabel78.getText();
        String hoten = jTextField28.getText().trim();
        String sdt = jTextField30.getText().trim();

        String diachi = jTextField29.getText().trim();
        String mk = jTextField8.getText();
        NhanvienDAO nvdao = new NhanvienDAO(Nhanvien.class);
        boolean kq = nvdao.luucapnhat(new Nhanvien(id, hoten, diachi, sdt, mk, new Nhanvien("NV0001")));
        if (kq == true) {
            JOptionPane.showMessageDialog(this, "Thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Không thành công");
        }
        } 
    }//GEN-LAST:event_jButton15ActionPerformed

    public List<Linhkien> getDatabanhang_linhkien() {
        return databanhang_linhkien;
    }

    public void setDatabanhang_linhkien(List<Linhkien> databanhang_linhkien) {
        this.databanhang_linhkien = databanhang_linhkien;
    }

    public Hoadon getHd() {
        return hd;
    }

    public void setHd(Hoadon hd) {
        this.hd = hd;
    }

    public JTable getjTable10() {
        return jTable10;
    }

    public void setjTable10(JTable jTable10) {
        this.jTable10 = jTable10;
    }

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        String ma = jTextField11.getText().trim();
        String ten = jTextField12.getText().trim();
        String sdt = jTextField13.getText().trim();

        datancc = modelnhacungcap.getData();
        List<Nhacungcap> ds = datancc;
        List<Nhacungcap> tam = new ArrayList<>();
       tam = new NhacungcapDAO(Nhacungcap.class).getdsbyId_name_sdt(ma, ten, sdt);
        modelnhacungcap.setData(tam);
        modelnhacungcap.fireTableDataChanged();
        jTable5.setModel(modelnhacungcap);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentResized

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // TODO add your handling code here:
//        String x = jComboBox4.getSelectedItem().toString();
//        if (x == null) {
//            return;
//        }
//
//        if (x.equalsIgnoreCase("Tất cả")) {
//            modellinhkien = new TablemodelLinhkien();
//            jTable3.setModel(modellinhkien);
//            datalinhkien = modellinhkien.getData();
//            bangtam = datalinhkien;
//            return;
//        }
//        bangtam = new ArrayList<>();
//
//        for (Linhkien lk : datalinhkien) {
//            if (lk.getDanhmuclinhkien().getTen().equalsIgnoreCase(x)) {
//                bangtam.add(lk);
//            }
//        }
//        modellinhkien.setData(bangtam);
//        modellinhkien.fireTableDataChanged();
//        jTable3.setModel(modellinhkien);
//
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        String ma = jTextField19.getText().trim();
        String ten = jTextField20.getText().trim();
        String sdt = jTextField21.getText().trim();

        datakhachhang = modelkhachhang.getData();
        List<Khachhang> ds = datakhachhang;
        List<Khachhang> tam = new ArrayList<>();
       tam = new KhanhhangDAO(Khachhang.class).getdsbyId_name_sdt(ma, ten, sdt);
        modelkhachhang.setData(tam);
        modelkhachhang.fireTableDataChanged();
        jTable4.setModel(modelkhachhang);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        jButton34ActionPerformed(evt);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        String idcanxoa = jLabel77.getText();

        formxacnhankhachhang fr = new formxacnhankhachhang();
        fr.setId(idcanxoa);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        // fr.setVisible(true);

        this.setEnabled(false);

        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);

            }
        });
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        modelkhachhang = new TablemodelKhachhang();
        modelkhachhang.fireTableDataChanged();
        jTable4.setModel(modelkhachhang);
        jLabel77.setText("");
        jTextField4.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTable4.clearSelection();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
        jButton37ActionPerformed(evt);
        datahoadon = modelhoadon.getData();
        String ma = jTextField7.getText().trim();
        String tenkh = jTextField5.getText().trim();
        String tennv = jTextField6.getText().trim();
        String sdtkh = jTextField43.getText().trim();
        String tg;
        String tgden;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(jDateChooser1.getDate());
        tgden = formatter.format(jDateChooser2.getDate());
        if (jDateChooser1.getDate() == null) {
            tg = "";
        } else {
            tg = format;
        }
        if (jDateChooser1.getDate().before(jDateChooser2.getDate())) {
            jLabel123.setText("");
            List<Hoadon> ds = datahoadon;
            List<Hoadon> tam = new ArrayList<>();
            tam = new HoadonDAO(Hoadon.class).locdshoadon(tg, tgden, tennv, tenkh, sdtkh, ma);
            modelhoadon.setData(tam);
            modelhoadon.fireTableDataChanged();
            jTable2.setModel(modelhoadon);
        }
        else{
            jLabel123.setText("Ngày bắt đầu phải trước ngày kết thúc");
        }
  

    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
        modelhoadon = new TablemodelHoadon();
        modelhoadon.fireTableDataChanged();
        jTable2.clearSelection();
        jTable2.setModel(modelhoadon);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        String ma = jTextField25.getText().trim();
        String ten = jTextField26.getText().trim();
        String sdt = jTextField27.getText().trim();
        List<Nhanvien> ds = modelnhanvien.getData();
        List<Nhanvien> dstam = new ArrayList<>();
        for (Nhanvien d : ds) {

            if (d.getId().toUpperCase().matches(".*" + ma.toUpperCase() + ".*") && d.getTen().toUpperCase().matches(".*" + ten.toUpperCase() + ".*") && d.getSdt().toUpperCase().matches(".*" + sdt.toUpperCase() + ".*")) {
                dstam.add(d);
            }

            modelnhanvien.setData(dstam);
            modelnhanvien.fireTableDataChanged();
            jTable8.setModel(modelnhanvien);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        jButton24ActionPerformed(evt);
        jCheckBox1.setVisible(false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        modelnhanvien = new TablemodelNhanvien();
        modelnhanvien.fireTableDataChanged();
        jLabel78.setText("");
        jTextField28.setText("");
        jTextField30.setText("");

        jTextField29.setText("");
        jTextField8.setText("");
        jTable8.setModel(modelnhanvien);
        jTable8.clearSelection();
        jCheckBox1.setVisible(true);
        jCheckBox1.setSelected(false);

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        if (jTable8.getSelectedRow() != -1) {
            String id = jLabel78.getText();
            if (id.equals("NV0001")) {
                JOptionPane.showMessageDialog(this, "Không thể  xóa tài khoản này");
                return;
            } else {
                formxacnhannhanvien fr = new formxacnhannhanvien();
                fr.setId(id);
                fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                fr.setLocationRelativeTo(this);
                fr.setVisible(true);// TODO add your handling code here:
                fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                fr.setLocationRelativeTo(this);
                // fr.setVisible(true);

                this.setEnabled(false);

                fr.show();
                fr.setResizable(false);
                fr.setAlwaysOnTop(true);
                fr.pack();

                fr.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        setEnabled(true);
                        setAlwaysOnTop(true);

                    }
                });
            }
        }

    }//GEN-LAST:event_jButton25ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized
    public boolean check_themloaihang(){
        String ten_lh = jTextField31.getText().trim();
        if(ten_lh.isEmpty()){
            jLabel133.setText("Tên loại hàng không được để trống");
            jTextField31.requestFocus();
            return false;
        }
        jLabel133.setText("");
        return true;
    }
    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if(check_themloaihang()){
            /*Viết hàm thêm và lưu chỗ này
            */
            String id = jLabel88.getText();
            String ten = jLabel133.getText();
            String mota= jTextArea3.getText();
            Danhmuclinhkien dmlk = new Danhmuclinhkien(id, ten, mota);
            DanhmuclinhkienDAO dao = new DanhmuclinhkienDAO(Danhmuclinhkien.class);
            boolean kq = dao.update(dmlk);
            if (kq == false) {
                JOptionPane.showMessageDialog(this, "Không thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thành công");
                jButton12ActionPerformed(evt);
        }
                   
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        String ma = jTextField33.getText().trim();
        String ten = jTextField32.getText().trim();

        List<Danhmuclinhkien> dstam = new ArrayList<>();
        dstam = new DanhmuclinhkienDAO(Danhmuclinhkien.class).getdsbyId_name(ma, ten);
        modelloaihang.setData(dstam);
        modelloaihang.fireTableDataChanged();
        jTable12.setModel(modelloaihang);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        jLabel88.setText("");
        jTextField31.setText("");
        jTextArea3.setText("");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        String id = jLabel88.getText();
        if (id != null) {

            formxacnhan_xoaloaihang fr = new formxacnhan_xoaloaihang();
            fr.setId(id);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            fr.setVisible(true);// TODO add your handling code here:
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            // fr.setVisible(true);

            this.setEnabled(false);

            fr.show();
            fr.setResizable(false);
            fr.setAlwaysOnTop(true);
            fr.pack();

            fr.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    setEnabled(true);
                    setAlwaysOnTop(true);

                }
            });
            if (fr.getXacnhan() == 1) {
                jButton41ActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        // TODO add your handling code here:
        if (check_themxuatxu()) {
            // thêm xuất xứ ở đây
            String id = jLabel116.getText();
            String quocgia = jTextField36.getText();
            Xuatxu xx = new Xuatxu(id, quocgia);
            XuatxuDAO dao = new XuatxuDAO(Xuatxu.class);
            boolean kq= dao.update(xx);
                   if (kq == false) {
            JOptionPane.showMessageDialog(this, "Không thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thành công");
            jButton42ActionPerformed(evt);
        }
            
        }
    }//GEN-LAST:event_jButton36ActionPerformed
    public boolean check_themxuatxu(){
        String ten_xuatxu = jTextField36.getText().trim();
        if(ten_xuatxu.isEmpty()){
            jLabel134.setText("Tên quốc gia không được để trống");
            jTextField36.requestFocus();
            return false;
        }else{
            jLabel134.setText("");
        }
        return true;
    }
    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
       jLabel116.setText("");
        jTextField36.setText("");
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
         String id = jLabel116.getText();
        if (id != null) {

            formxacnhan_xoaxuatxu fr = new formxacnhan_xoaxuatxu();
            fr.setId(id);
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            fr.setVisible(true);// TODO add your handling code here:
            fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            fr.setLocationRelativeTo(this);
            // fr.setVisible(true);

            this.setEnabled(false);

            fr.show();
            fr.setResizable(false);
            fr.setAlwaysOnTop(true);
            fr.pack();

            fr.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    setEnabled(true);
                    setAlwaysOnTop(true);

                }
            });
            if (fr.getXacnhan() == 1) {
                jButton42ActionPerformed(evt);
            }
        }
        
        
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
       List<Xuatxu> dstam= new ArrayList<Xuatxu>();
        String ma =jTextField34.getText();
        String quocgia= jTextField35.getText();
         dstam = new XuatxuDAO(Xuatxu.class).getdsbyId_name(ma, quocgia);
        modelxuatxu.setData(dstam);
        modelxuatxu.fireTableDataChanged();
        jTable13.setModel(modelxuatxu);
        
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // TODO add your handling code here:

        int index = jTabbedPane2.getSelectedIndex();
        if (index == 2) {
            kichhoatpanel11();
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (jTable10.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa  chọn 1 sản phẩm nào");
            return;

        }
        LinhkienDAO lkdao = new LinhkienDAO(Linhkien.class);
        Linhkien lk = lkdao.findById(jLabel103.getText().trim());
        
           
        

        formnhapsl fr = new formnhapsl(this.giohang);

        fr.setLinhkien(lk);
        fr.setFrame(this);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        // fr.setVisible(true);

        this.setEnabled(false);

        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);

            }
        });
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        if (jTable11.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa  chọn 1 sản phẩm nào để  bỏ ra ");
            return;

        }
        int index = jTable11.getSelectedRow();
      //  modelbanhang_linhkien.getData().add(giohang.get(index).getLinhkien());

        giohang.remove(index);
        this.getModelgiohang().fireTableDataChanged();
        this.getModelbanhang_linhkien().fireTableDataChanged();
        this.getjLabel40().setText(formattien(hd.Tinhtien()));
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        LinhkienDAO lkdao = new LinhkienDAO(Linhkien.class);
        String danhmuc = jComboBox7.getSelectedItem().toString();
        if(danhmuc.equalsIgnoreCase("tất cả"))
            danhmuc ="";
        String ma = jTextField14.getText().trim();
         String mota = jTextField42.getText().trim();
        String ten = jTextField15.getText().trim();
        String nhacungcap = jTextField16.getText().trim();
        String nguongoc = jTextField17.getText().trim();
        List<Linhkien> ds = databanhang_linhkien;
        List<Linhkien> tam = new ArrayList<>();
        tam=lkdao.banhang_loc(ma, ten, nhacungcap, danhmuc, mota, nguongoc);
        modelbanhang_linhkien.setData(tam);
        modelbanhang_linhkien.fireTableDataChanged();
        jTable10.setModel(modelbanhang_linhkien);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jComboBox7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox7PropertyChange

    }//GEN-LAST:event_jComboBox7PropertyChange

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox7ItemStateChanged
//        String x = jComboBox7.getSelectedItem().toString();
//        if (x == null) {
//            return;
//        }
//
//        if (x.equalsIgnoreCase("Tất cả")) {
//            modelbanhang_linhkien.setData(databanhang_linhkien);
//            modelbanhang_linhkien.fireTableDataChanged();
//            jTable10.setModel(modelbanhang_linhkien);
//
//            return;
//        }
//        tam = new ArrayList<>();
//
//        for (Linhkien lk : databanhang_linhkien) {
//            if (lk.getDanhmuclinhkien().getTen().equalsIgnoreCase(x)) {
//                tam.add(lk);
//            }
//        }
//        modelbanhang_linhkien.setData(tam);
//        modelbanhang_linhkien.fireTableDataChanged();
//        jTable10.setModel(modelbanhang_linhkien);
    }//GEN-LAST:event_jComboBox7ItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:

        formxacnhanhuyhoadon fr = new formxacnhanhuyhoadon(this);
        fr.setFrame(this);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);

        // fr.setVisible(true);
        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);
                int xacnhan = fr.getXacnhan();
                if (xacnhan == 1) {
                    fr.dispose();
                    fr.getFrame().getModelbanhang_linhkien().fireTableDataChanged();
                    khachhhang = null;
                    giohang.clear();
                    modelbanhang_linhkien = new TablemodelBanhang_linhkien();
                    modelgiohang.fireTableDataChanged();
                    jTable10.setModel(modelbanhang_linhkien);
                    jTable11.setModel(modelgiohang);
                    jLabel40.setText("");
                    jLabel45.setText("");
                    jLabel42.setText("");
                    jLabel37.setText("");
                  jPanel11MouseClicked(evt);
                } else {

                }
            }
        });

    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        if (giohang.size() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào trong hóa đơn");
            return;
        }

        formnhaptienkhachhangdua fr = new formnhaptienkhachhangdua(giohang);

        fr.setFrame(this);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        fr.setLocationRelativeTo(this);
        fr.setVisible(true);// TODO add your handling code here:
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocationRelativeTo(this);
        // fr.setVisible(true);

        this.setEnabled(false);

        fr.show();
        fr.setResizable(false);
        fr.setAlwaysOnTop(true);
        fr.pack();

        fr.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                setEnabled(true);
                setAlwaysOnTop(true);

            }
        });
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTextField42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField42ActionPerformed

    private void jTextField43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField43ActionPerformed

    private void jLabel126MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel126MouseClicked
        // TODO add your handling code here:
        int vt = Integer.valueOf(jTextField41.getText());
        
        if ( modellinhkien.getData().size()<20)
            return;
        else
        {
              jTextField41.setText(String.valueOf(vt+1));

              modellinhkien = new TablemodelLinhkien(vt);
            
            modellinhkien.fireTableDataChanged();
            jTable3.setModel(modellinhkien);
    
        
        }
    }//GEN-LAST:event_jLabel126MouseClicked

    private void jTextField42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField42MouseClicked
        // TODO add your handling code here:
        jTextField42.selectAll();
    }//GEN-LAST:event_jTextField42MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        int y = Integer.valueOf(jComboBox2.getSelectedItem().toString());
        jTable7.setModel( new Tablemodelthongke(y,this));
        jTable7.updateUI();
        Double doanhthu=0.0;
        Double lai=0.0;
        Double thue=0.0;
        Integer slsanpham=0;
        for(int i=0;i<12;i++)
        {
           
                doanhthu+=Double.valueOf(jTable7.getValueAt(i, 1).toString().replaceAll(",", ""));
                  lai+=Double.valueOf(jTable7.getValueAt(i, 2).toString().replaceAll(",", ""));
                   thue+=Double.valueOf(jTable7.getValueAt(i, 3).toString().replaceAll(",", ""));
                      slsanpham+=Integer.valueOf(jTable7.getValueAt(i, 4).toString().replaceAll(",", ""));
            
                    }
      
   
            
        jTextField44.setText(formattien(doanhthu));
       jTextField45.setText(formattien(lai));
        jTextField46.setText(formattien(thue));
       jTextField47.setText(slsanpham.toString());
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        jTextField32.setText("");
        jTextField33.setText("");
        jButton27ActionPerformed(evt);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code her:
        jTextField34.setText("");
        jTextField35.setText("");
        jLabel116.setText("");
        jTextField36.setText("");
        jButton40ActionPerformed(evt);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton38AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButton38AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton38AncestorAdded

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        String sl =jSpinner1.getValue().toString();
        try {
           if (Integer.parseInt(sl) <=0){
               jSpinner1.setValue(Integer.valueOf("1"));
           }
        } catch (Exception e) {
            
            
        }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jTextField44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField44ActionPerformed

    private void jLabel127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseClicked
        // TODO add your handling code here:
         int vt = Integer.valueOf(jTextField41.getText());
        
        if (  vt==1)
            return;
        else
        {
              jTextField41.setText(String.valueOf(vt-1));

              modellinhkien = new TablemodelLinhkien(vt-2);
            
            modellinhkien.fireTableDataChanged();
            jTable3.setModel(modellinhkien);
    
        
        }
    }//GEN-LAST:event_jLabel127MouseClicked

    public void bar(JLabel lab) {
        jLabel11.setOpaque(false);
        jLabel8.setOpaque(false);
        jLabel14.setOpaque(false);
        jLabel5.setOpaque(false);
        jLabel16.setOpaque(false);
        jLabel18.setOpaque(false);
        // jLabel17.setOpaque(false);
        lab.setOpaque(true);
        jPanel2.repaint();
    }

    public void listentablesanpham() {

        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                // TODO Auto-generated method stub
                int k = jTable3.getSelectedRow();
                if (k != -1) {

                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);
                    Linhkien sp = x.findById((String) jTable3.getModel().getValueAt(k, 0));
                    jLabel53.setText(sp.getId());
                    jFormattedTextField1.setText(sp.getTen());
                    jSpinner1.setValue(sp.getSoluong());
                    jFormattedTextField2.setText(String.valueOf(sp.getDongiagoc()));
                    jFormattedTextField4.setText(String.valueOf(sp.getDongiaban()));
                    jComboBox5.setSelectedItem(sp.getDanhmuclinhkien().getTen());

                    jComboBox1.setSelectedItem(sp.getNhacungcap().getTen());

                    jComboBox6.setSelectedItem(sp.getXuatxu().getQuocgia());

                    jTextArea1.setText(sp.getMota());
                    String hinhanh = sp.getHinhanh();
                 
                        try{
                            
                            
                        jLabel122.setIcon(new ImageIcon(hinhanh)); // 
                 
                        }
                        catch(Exception ex)
                        {
                          // ex.printStackTrace();
///      Devices-computer-iconSystem.out.println("AAAAAAAAAAAAAAAAAAAAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");    
                             jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Devices-computer-icon.png"))); // 
                        }
                        if(hinhanh==null)
                        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Devices-computer-icon.png")));
                }

            }
        });

    }
    public void listentable_loaihang(){
        jTable12.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
              int k = jTable12.getSelectedRow();
              if(k != -1){
                  DanhmuclinhkienDAO dmlk_dao = new DanhmuclinhkienDAO(Danhmuclinhkien.class);
                  Danhmuclinhkien dmlk = dmlk_dao.findById((String)jTable12.getModel().getValueAt(k, 0));
                  jLabel88.setText(dmlk.getId());
                  jTextField31.setText(dmlk.getTen());
                  if (dmlk.getMota() != null) {
                      jTextArea3.setText(dmlk.getMota());
                  } else {
                      jTextArea3.setText("");
                  }
              }
            }
        });
    }
    
    public void listentable_xuatxu(){
         jTable13.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
              int k = jTable13.getSelectedRow();
              if(k != -1){
                  XuatxuDAO dmlk_dao = new XuatxuDAO(Xuatxu.class);
                  Xuatxu xx = dmlk_dao.findById((String)jTable13.getModel().getValueAt(k, 0));
                  jLabel116.setText(xx.getId());
                  jTextField36.setText(xx.getQuocgia());
                  
              }
            }
        });
    }
    public void listentablebanhang_linhkien() {
        
        // đợi xíu
        
        jTable10.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                // TODO Auto-generated method stub
                int k = jTable10.getSelectedRow();
                if (k != -1) {

                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);
                    Linhkien sp = x.findById((String) jTable10.getModel().getValueAt(k, 0));
                    jLabel103.setText(sp.getId());
                    if (sp.getMota() != null) {
                        jTextArea2.setText(sp.getMota());
                    } else {
                        jTextArea2.setText("");
                    }
                    String hinhanh = sp.getHinhanh();
                 
                        try{
                            
                            
                        jLabel43.setIcon(new ImageIcon(hinhanh)); // 
                 
                        }
                        catch(Exception ex)
                        {
                          // ex.printStackTrace();
///      Devices-computer-iconSystem.out.println("AAAAAAAAAAAAAAAAAAAAXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");    
                             jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Devices-computer-icon.png"))); // 
                        }
                        if(hinhanh==null)
                        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Devices-computer-icon.png")));

                }

            }
        });

    }

    public void listentablenhacungcap() {
        jTable5.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                int k = jTable5.getSelectedRow();
                if (k != -1) {
                    jLabel71.setText((String) jTable5.getModel().getValueAt(k, 0));
                    jTextField18.setText((String) jTable5.getModel().getValueAt(k, 1));
                    jTextField1.setText((String) jTable5.getModel().getValueAt(k, 3));
                    jTextField3.setText((String) jTable5.getModel().getValueAt(k, 2));
                    jTextField2.setText((String) jTable5.getModel().getValueAt(k, 4));
                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);

                    jTable6.setModel(new TablemodelNCC_cacsanpham((String) jTable5.getModel().getValueAt(k, 0)));
                }

            }
        });

    }

    public void listentablehoadon() {
        jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                int k = jTable2.getSelectedRow();
                if (k != -1) {
                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);
                  
                    jTable1.setModel(new TablemodelCT_hoadon((String) jTable2.getModel().getValueAt(k, 0)));
                }

            }
        });
    }

    public void listentablekhachhang() {
        jTable4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                int k = jTable4.getSelectedRow();
                if (k != -1) {
                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);

                    jLabel77.setText((String) jTable4.getModel().getValueAt(k, 0));
                    jTextField4.setText((String) jTable4.getModel().getValueAt(k, 2));
                    jTextField22.setText((String) jTable4.getModel().getValueAt(k, 4));
                    jTextField24.setText((String) jTable4.getModel().getValueAt(k, 1));
                    jTextField23.setText((String) jTable4.getModel().getValueAt(k, 3));
                }

            }
        });
    }

       public void listentablethongke()
       {
           jTable7.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

               @Override
               public void valueChanged(ListSelectionEvent e) {
                 int k = jTable7.getSelectedRow()+1;
                 bieudo.removeAll();
                
                  taobieudothongke(k);
                   bieudo.updateUI();
                   
              
                 
                   
               }
           });
       }
    public void listentablenhanvien() {
        jTable8.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                int k = jTable8.getSelectedRow();
                if (k != -1) {
                    LinhkienDAO x = new LinhkienDAO(Linhkien.class);
                    try{
                    jTable9.setModel(new TablemodelNhanvien_cacHoadon((String) jTable8.getModel().getValueAt(k, 0)));
                    }
                    catch(Exception ex){
                        
                    }
                    NhanvienDAO nvdao = new NhanvienDAO(Nhanvien.class);
                    Nhanvien nv = nvdao.findById((String) jTable8.getModel().getValueAt(k, 0));
                    jLabel78.setText(nv.getId());
                    jTextField28.setText(nv.getTen());
                    jTextField30.setText(nv.getSdt());
                    jTextField29.setText(nv.getDiachi());
                    jTextField8.setText(nv.getTaikhoan());
                    if (nv.getNguoiquanli() == null) {
                        jCheckBox1.setSelected(true);
                    } else {
                        jCheckBox1.setSelected(false);
                    }
                }

            }
        });
    }

    public void getdataforcomboloaisanpham() {
        DanhmuclinhkienDAO dmDAO = new DanhmuclinhkienDAO(Danhmuclinhkien.class);
        List<Danhmuclinhkien> danhsachdanhmuc = dmDAO.findAll();
        List<String> datacombo5 = new ArrayList<String>();
        for (Danhmuclinhkien danhmuc : danhsachdanhmuc) {
            datacombo5.add(danhmuc.getTen());
        }
        jComboBox5.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));
        datacombo5.add("Tất cả");
        jComboBox4.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));
        jComboBox4.setSelectedItem("Tất cả");

    }
    
      public void getdataforcombothongke() {
      
        HoadonDAO d = new HoadonDAO(Hoadon.class);
       
        List<Integer> kq = d.getdataforcombothongke();
          
         
        jComboBox2.setModel(new DefaultComboBoxModel<>(kq.toArray()));
        
         
        
       
    
        

    }

    public void getdataforcomboloaisanpham_banhang() {
        DanhmuclinhkienDAO dmDAO = new DanhmuclinhkienDAO(Danhmuclinhkien.class);
        List<Danhmuclinhkien> danhsachdanhmuc = dmDAO.findAll();
        List<String> datacombo5 = new ArrayList<String>();
        for (Danhmuclinhkien danhmuc : danhsachdanhmuc) {
            datacombo5.add(danhmuc.getTen());
        }
        jComboBox7.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));
        datacombo5.add("Tất cả");
        jComboBox7.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));
        jComboBox7.setSelectedItem("Tất cả");

    }

    public void getdataforcombonhacungcap() {
        NhacungcapDAO dmDAO = new NhacungcapDAO(Nhacungcap.class);
        List<Nhacungcap> danhsachdanhmuc = dmDAO.findAll();

        List<String> datacombo5 = new ArrayList<String>();
        for (Nhacungcap danhmuc : danhsachdanhmuc) {
            datacombo5.add(danhmuc.getTen());
        }
        jComboBox1.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));

    }

    public void getdataforcomboxuatxu() {
        XuatxuDAO dmDAO = new XuatxuDAO(Xuatxu.class);
        List<Xuatxu> danhsachdanhmuc = dmDAO.findAll();

        List<String> datacombo5 = new ArrayList<String>();
        for (Xuatxu danhmuc : danhsachdanhmuc) {
            datacombo5.add(danhmuc.getQuocgia());
        }
        jComboBox6.setModel(new DefaultComboBoxModel<>(datacombo5.toArray()));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
        private Tablemodeldanhmuc modelloaihang;
    private  Tablemodelxuatxu modelxuatxu;
    private TablemodelNhanvien modelnhanvien;
    private List<Nhanvien> datanhanvien;
    private TablemodelBanhang_ctHoadon modelgiohang;
    private TablemodelBanhang_linhkien modelbanhang_linhkien;
    private TablemodelLinhkien modellinhkien;
    private TablemodelHoadon modelhoadon;
    private List<Hoadon> datahoadon = new ArrayList<>();
    private TablemodelKhachhang modelkhachhang;
    private TablemodelNCC modelnhacungcap;
    private List<Nhacungcap> datancc = new ArrayList<>();
    private List<Nhacungcap> databangtamnhacc = new ArrayList<>();
    private List<Linhkien> datalinhkien = new ArrayList<>();
    private List<Linhkien> bangtam = new ArrayList<>();
    private List<Khachhang> datakhachhang = new ArrayList<>();
    private Khachhang khachhhang;
    private List<Linhkien> databanhang_linhkien = new ArrayList<>();
    // Variables declaration - do not modify               
    List<Linhkien> tam;
    private Linhkien linhkienthemvao;
    private Nhanvien nhanvien;
    private Hoadon hd = new Hoadon(khachhhang, nhanvien, LocalDate.now());
    private List<CT_hoadon> giohang = new ArrayList<>();
    private String path;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bahang;
    private javax.swing.JPanel banhang;
    private javax.swing.JPanel bieudo;
    private javax.swing.JPanel hoadon;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JTextField jFormattedTextField1;
    private javax.swing.JTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel quanlihoadon;
    private javax.swing.JPanel quanlikhachhang;
    private javax.swing.JPanel quanlilinhkien;
    private javax.swing.JPanel quanlinhacungcap;
    private javax.swing.JPanel quanlinhanvien;
    private javax.swing.JPanel thongke;
    public javax.swing.JPanel trangchuyen;
    // End of variables declaration//GEN-END:variables
}
