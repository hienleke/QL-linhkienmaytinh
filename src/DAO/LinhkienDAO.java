package DAO;

import entities.CT_hoadon;
import entities.Danhmuclinhkien;
import entities.Hoadon;
import entities.Khachhang;
import entities.Linhkien;
import entities.Nhacungcap;
import entities.Nhanvien;
import entities.Xuatxu;
import java.util.List;
import javax.persistence.Query;

public class LinhkienDAO extends DAOhelper<Linhkien>{

	public LinhkienDAO(Class<Linhkien> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
        
          public List<Linhkien> findAll(int vitri ) {
	   List<Linhkien> listneed2find =null;
	  
		
	try {
	
		entityManager.getTransaction().begin();
             
         listneed2find  =  entityManager.createNativeQuery("select * from linhkien order by id OFFSET "+vitri*20+" ROWS FETCH NEXT 20 ROWS ONLY",Linhkien.class).getResultList();
	
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
	} 
  return  listneed2find;
    
  
  
  }
        
        
      public List<Linhkien> getbyidNCC(String id)
        {
            List<Linhkien> dstrave = null;
            try {
	
		entityManager.getTransaction().begin();
	dstrave =  entityManager.createNativeQuery("SELECT * from linhkien where IDNHACUNGCAP =" + "'" + id +"'" ,type).getResultList();
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
            return dstrave;
        }
       public List<Linhkien> getdschobanhang()
        {
            List<Linhkien> dstrave = null;
            try {
	
		entityManager.getTransaction().begin();
	dstrave =  entityManager.createNativeQuery("  \n" +
"  select * from Linhkien where  id in  (\n" +
"  select  top 20 with ties mslk   from CT_hoadon  ct join Hoadon hd  on ct.mshd = hd.id \n" +
"  where month(ngaylap) = MONTH (GETDATE()) and year(ngaylap) = year(GETDATE())\n" +
"  group by mslk\n" +
"  order by count(mslk) desc)",type).getResultList();
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
            return dstrave;
        }
 public List<Linhkien> banhang_loc(String idlk, String tenlk, String ncc, String danhmuc,String mota ,String nguongoc)
        {
            List<Linhkien> dstrave = null;
            try {
	
		entityManager.getTransaction().begin();
	dstrave =  entityManager.createNativeQuery("  select lk.[id],[dongiagoc],[hinhanh],[dongiaban],lk.[mota],[soluong],lk.[ten],[IDDANHMUCLINHKIEN],[IDNHACUNGCAP],[IDXUATXU] \n" +
"  from Linhkien lk join [dbo].[Nhacungcap] ncc on lk.IDNHACUNGCAP =ncc.id join [dbo].[Xuatxu] xx  on lk.IDXUATXU =xx.id join Danhmuclinhkien dm on dm.id=lk.IDDANHMUCLINHKIEN\n" +
"  where quocgia like '%' +N'"+nguongoc+"'+'%' and dm.ten like '%' +N'"+danhmuc+"'+'%' and ncc.ten like '%' +N'"+ncc+"'+'%' and lk.ten like '%' +N'"+tenlk+"'+'%' and lk.mota like '%' +N'"+mota+"'+'%' and lk.id like '%"+idlk+"%'",type).getResultList();
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
            return dstrave;
        }
 
 
 public List<Linhkien> quanli_loc(String idlk, String tenlk , String danhmuc)
        {
            List<Linhkien> dstrave = null;
            try {
	
	dstrave =  entityManager.createNativeQuery("  select lk.[id],[dongiagoc],[dongiaban],[hinhanh],lk.[mota],[soluong],lk.[ten],[IDDANHMUCLINHKIEN],[IDNHACUNGCAP],[IDXUATXU] \n" +
"  from Linhkien lk join [dbo].[Nhacungcap] ncc on lk.IDNHACUNGCAP =ncc.id join [dbo].[Xuatxu] xx  on lk.IDXUATXU =xx.id join Danhmuclinhkien dm on dm.id=lk.IDDANHMUCLINHKIEN\n" +
"where dm.ten like '%' +N'"+danhmuc+"'+'%'  and lk.ten like '%' +N'"+tenlk+"'+'%' and lk.id like '%"+idlk+"%'",type).getResultList();
	    entityManager.getTransaction().commit();
	    entityManager.getTransaction().commit();
           
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
            return dstrave;
        }

      public boolean luucapnhat(Linhkien lk )
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
    public boolean delete(Linhkien need2remove) {
         try {
	
		entityManager.getTransaction().begin();

                entityManager.createNativeQuery("delete from linhkien where id = '" +need2remove.getId()+"'").executeUpdate();
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
