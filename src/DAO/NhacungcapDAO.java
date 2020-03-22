package DAO;

import entities.Danhmuclinhkien;
import entities.Nhacungcap;
import java.util.List;

public class NhacungcapDAO extends DAOhelper<Nhacungcap>{

	public NhacungcapDAO(Class<Nhacungcap> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
         public Nhacungcap findbyname(String name)
        {
            
            
            entityManager.getTransaction().begin();
            List<Nhacungcap> ds = entityManager.createNativeQuery("select * from nhacungcap ", Nhacungcap.class).getResultList();
            entityManager.getTransaction().commit();
            if (ds.isEmpty())
                return null;
            
            for (Nhacungcap d : ds) {
               if( d.getTen().equalsIgnoreCase(name))
                        return d;
            }
            
            return null;
            
        }
             public boolean luucapnhat(Nhacungcap lk )
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
    public boolean delete(Nhacungcap need2remove) {
         try {
	
		entityManager.getTransaction().begin();

                entityManager.createNativeQuery("delete from nhacungcap where id = '" +need2remove.getId()+"'").executeUpdate();
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
    
     public List<Nhacungcap> getdsbyId_name_sdt(String id, String name , String sdt)
        {
            List<Nhacungcap> ds = null;
            entityManager.getTransaction().begin();

               ds= entityManager.createNativeQuery("select * from nhacungcap where id like '%"+id+"%' and ten like '%"+name+"%' and sdt like '%"+sdt+"%' ", type).getResultList();
	    entityManager.getTransaction().commit();
            
            return ds;
        }

}
