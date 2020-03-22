package DAO;

import entities.CT_hoadon;
import java.util.List;

public class CT_hoadonDAO extends DAOhelper<CT_hoadon>{

	public CT_hoadonDAO(Class<CT_hoadon> type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
        @Override
        public boolean save(CT_hoadon add)
{
	int kq=1;
	try {
		entityManager.getTransaction().begin();
		entityManager.persist(add);
	    entityManager.getTransaction().commit();
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
         public List<CT_hoadon> getbyidhd(String id)
        {
            List<CT_hoadon> dstrave = null;
            try {
	
		entityManager.getTransaction().begin();
	dstrave =  entityManager.createNativeQuery("SELECT * from ct_hoadon where mshd =" + "'" + id +"'" ,type).getResultList();
	    this.entityManager.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
            return dstrave;
        }


}
