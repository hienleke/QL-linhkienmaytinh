package DAO;

import entities.Khachhang;
import java.util.List;

public class KhanhhangDAO extends DAOhelper<Khachhang>{

	public KhanhhangDAO(Class<Khachhang> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
        
        public List<Khachhang> getdschoformkhachhang_banhang()
        {
            List<Khachhang> ds = null;
            entityManager.getTransaction().begin();

               ds= entityManager.createNativeQuery("  select  * from Khachhang where id  in (select top 15 with ties IDKHACHHANG from Hoadon \n" +
"   where month(ngaylap) = MONTH (GETDATE()) and year(ngaylap) = year(GETDATE())\n" +
"   group by IDKHACHHANG\n" +
"   order by count(IDKHACHHANG) desc\n" +
" )", type).getResultList();
	    entityManager.getTransaction().commit();
            
            return ds;
        }
        
         public List<Khachhang> getdsbyId_name_sdt(String id, String name , String sdt)
        {
            List<Khachhang> ds = null;
            entityManager.getTransaction().begin();

               ds= entityManager.createNativeQuery("select * from Khachhang where id like '%"+id+"%' and ten like '%"+name+"%' and sdt like '%"+sdt+"%' ", type).getResultList();
	    entityManager.getTransaction().commit();
            
            return ds;
        }
        
  public boolean luucapnhat(Khachhang lk )
               {
         
            try {
	
		entityManager.getTransaction().begin();

                entityManager.merge(lk);
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
                
                return false;
	
	}
	finally {
		
		
	}
            return true;
        }
  
    @Override
    public boolean delete(Khachhang need2remove) {
         try {
	
		entityManager.getTransaction().begin();

                entityManager.createNativeQuery("delete from khachhang where id = '" +need2remove.getId()+"'").executeUpdate();
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
                
                return false;
	
	}
	finally {
		
		
	}
            return true;
    }
}
