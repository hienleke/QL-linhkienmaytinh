package TEST;

import DAO.HoadonDAO;
import DAO.LinhkienDAO;
import DAO.NhacungcapDAO;
import DAO.NhanvienDAO;
import DAO.KhanhhangDAO;
import entities.Hoadon;
import entities.Khachhang;
import entities.Linhkien;

import entities.Nhacungcap;
import entities.Nhanvien;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class main4test {

	
	

public static void main(String[] args) throws FileNotFoundException {
/*	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction tr =entityManager.getTransaction();
    tr.begin();
    entityManager.persist(  new Linhkien("11234", "asdfa", 2, 3.5, "asdfa", null, null, null));
    tr.commit();*/
	//DAOhelper<Nhacungcap> lkdao = new DAOhelper<>(Nhacungcap.class);
       
//       // lkdao.save(new Linhkien("lk123", "cc", 2, 1000, null, null, null, null));
//             NhanvienDAO nvdao = new NhanvienDAO(Nhanvien.class);
//             LinhkienDAO lkdao = new LinhkienDAO(Linhkien.class);
// 
//          KhanhhangDAO khdao = new KhanhhangDAO(Khachhang.class);
//         NhacungcapDAO ncao = new NhacungcapDAO(Nhacungcap.class);
       // boolean k =  ncao.save(new Nhacungcap(null, "Hoàng hà ","33 Nguyễn Đình chiểu ","12312-12321 ", "haong@gmail.com"));
     // System.out.println(k);
     
     // ncao.findAll().forEach(x->  System.out.println(x));
 
    Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, LocalDate.now().getMonthValue()-1);
                cal.set(Calendar.DAY_OF_MONTH, 1);
                int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println(df.format(cal.getTime()));
                for (int i = 1; i < maxDay; i++) 
                {
                cal.set(Calendar.DAY_OF_MONTH, i + 1);
                System.out.println(df.format(cal.getTime()));
                }
           
       //System.out.println(      nvdao.findById("NV0003").getNguoiquanli().getTen());
         /*    List<CT_hoadon> dsct = new ArrayList<>();
                Hoadon hd = new Hoadon(new Khachhang("KH0001"), new Nhanvien("NV0001"), LocalDate.now());
              //  Linhkien lk =  lkdao.findById("lk1234");
               // lkdao.close();
               // hd.setDsCthd(dsct);
                HoadonDAO hddao = new HoadonDAO(Hoadon.class);
         //   dsct.add(new CT_hoadon( hd,lk, 2, 23));
             CT_hoadonDAO ctdao = new  CT_hoadonDAO(CT_hoadon.class);
            hddao.getEntityManager().getTransaction().begin();
            hddao.getEntityManager().persist(hd);
             hddao.getEntityManager().merge(new CT_hoadon(hd,new Linhkien("lk1234"),2, (float) 3.0));
           //hddao.getEntityManager().persist();
               hddao.getEntityManager().getTransaction().commit();*/
          /* String  k ="KH0001";
            if(k.matches(".*.*"))
                System.out.println("dc");
            else
            System.out.println("khong dc");
           // hddao.savewithorder(hd);*/

         
           
    }
          
      // CT_hoadon ct = new CT_hoadon(hd, lk , 2, (float) 0.4);
    
 
   //  hddao.save(hd);
    //ctdao.save(ct);
  
      //  ctdao.save(new CT_hoadon(hd, new Linhkien("lk1234"), 2, 23));
    
       //System.out.println(hd);
      // boolean k = hddao.save(hd);
   
       //CT_hoadonDAO cthd_dao = new CT_hoadonDAO(CT_hoadon.class);
   //  System.out.println(k);
   
      
     // LinhkienDAO lk = new LinhkienDAO(Linhkien.class);
      // System.out.print(lk.findById("lk1234").getDsCthd());
     //  NhacungcapDAO nccdao = new NhacungcapDAO(Nhacungcap.class);
        
      //List<CT_hoadon> bien =  
    //   System.out.println(hddao.findById("HD0001").getDsCthd());
      // nvdao.findById("NV0001").getDshd();
           // if(bien!=null)
                // 
              //.forEach(x->System.out.println(x));
    // System.out.println(cthd_dao.findById().getDsCthd());
     
     
               
	//boolean kq =lkdao.save(new Nhacungcap("NCC1234", "le Kế", "quangnam", "1123123", "asdfa@asdfa"));
	//System.out.println(lkdao.findById("NCC1234"));
	//System.out.println(lkdao.findAll());//.forEach(x->System.out.println(x));
     
	
}

