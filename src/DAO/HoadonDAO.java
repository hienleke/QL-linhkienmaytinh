package DAO;

import entities.CT_hoadon;

import entities.Hoadon;
import entities.Hoadon;
import java.util.HashMap;
import java.util.List;
import javafx.util.Pair;

public class HoadonDAO extends DAOhelper<Hoadon>{

	public HoadonDAO(Class<Hoadon> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
        
        public boolean savewithorder(Hoadon add)
{
	int kq=1;
	try {
               
		   this.getEntityManager().getTransaction().begin();
           this.getEntityManager().persist(add);
          for (CT_hoadon ct  : add.getDsCthd()) {
                    this.getEntityManager().merge(new CT_hoadon(add,ct.getLinhkien(),ct.getSoluong()));
               }
           
           //hddao.getEntityManager().persist();
                this.getEntityManager().getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
		kq=0;
                e.printStackTrace();
	
	}
	finally {
		
	}
	if(kq==0)
		return false;
	return true;
    

}
        public Pair<String,String > getsanphamtheongay(int ngay,int thang, int year)
        {
            entityManager.getTransaction().begin();
            List ds = entityManager.createNativeQuery("select ngaylap ,sum(soluong) as soluong\n" +
                    "from Hoadon hd join CT_hoadon cthd on hd.id=cthd.mshd\n" +
                    "where year(ngaylap) = "+year+" and month (ngaylap)="+thang+" and day(ngaylap) ="+ngay+"\n" +
                    "group by ngaylap").getResultList();
            entityManager.getTransaction().commit();
            
       Pair<String,String > ds1 = null;
            
       /**/
                 for (Object d : ds) {
                Object[] o = (Object[]) d   ;
                ds1 = new Pair<>((String)o[0].toString(),(String) o[1].toString());
                
            }
            
            return ds1;
        }
       public List<Hoadon> getDSbyday(int day, int month, int year )
       {
           entityManager.getTransaction().begin();
            List<Hoadon> ds = entityManager.createNativeQuery("select *\n" +
"from Hoadon hd \n" +
"where year(ngaylap) = "+year+" and month (ngaylap)= "+month+" and day(ngaylap) ="+day+"\n" ,Hoadon.class).getResultList();
            entityManager.getTransaction().commit();
            
     
            
            return ds;
       }
        public List<Hoadon> getDSbymonth(int month , int year )
       {
           entityManager.getTransaction().begin();
            List<Hoadon> ds = entityManager.createNativeQuery("select *\n" +
"from Hoadon hd \n" +
"where year(ngaylap) = "+year+" and month (ngaylap)="+month+  "" ,Hoadon.class).getResultList();
            entityManager.getTransaction().commit();
            
     
            
            return ds;
       }
      
       public List<Hoadon> locdshoadon(String tungay , String denngay , String tennv , String tenkh , String sdtkh , String idhoadon)
       {
           entityManager.getTransaction().begin();
            List<Hoadon> ds = entityManager.createNativeQuery("  select hd.[id],[luuy],[ngaylap],[tienkhachhangdua],[IDKHACHHANG],[IDNHANVIEN] from Hoadon hd join Khachhang kh   on hd.IDKHACHHANG=kh.id join Nhanvien nv  on nv.id = hd.IDNHANVIEN\n" +
"  where (ngaylap between CONVERT(date,'"+tungay+"')  and  CONVERT(date,'"+denngay+"')) and  hd.id like '%"+idhoadon+"%' and kh.sdt like '%"+sdtkh+"%' and nv.ten like '%' +N'"+tennv+"'+'%' and kh.ten like '%' +N'"+tenkh+"'+'%'" ,Hoadon.class).getResultList();
            entityManager.getTransaction().commit();
            
     
            
            return ds;
       }
       
        public List<Hoadon> getdshoadontrongngay()
       {
           entityManager.getTransaction().begin();
            List<Hoadon> ds = entityManager.createNativeQuery(" select * from hoadon where CONVERT(date,GETDATE()) = CONVERT(date,ngaylap)",Hoadon.class).getResultList();
            entityManager.getTransaction().commit();
            
     
            
            return ds;
       }
        
         public List<Integer> getdataforcombothongke()
       {
           entityManager.getTransaction().begin();
            List<Integer> ds = entityManager.createNativeQuery("select YEAR(ngaylap)\n" +
"from Hoadon\n" +
"group by YEAR(ngaylap)\n" +
"order by YEAR(ngaylap) desc").getResultList();
            entityManager.getTransaction().commit();
            
     
            
            return ds;
       }
       
       
}
