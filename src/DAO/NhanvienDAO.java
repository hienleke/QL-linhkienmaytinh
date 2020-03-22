package DAO;

import entities.Nhanvien;

public class NhanvienDAO extends DAOhelper<Nhanvien>{

	public NhanvienDAO(Class<Nhanvien> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
        public boolean luucapnhat(Nhanvien lk )
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
    public boolean delete(Nhanvien need2remove) {
         try {
	
		entityManager.getTransaction().begin();

                entityManager.createNativeQuery("delete from nhanvien where id = '" +need2remove.getId()+"'").executeUpdate();
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
