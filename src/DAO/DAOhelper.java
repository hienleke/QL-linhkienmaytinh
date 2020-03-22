package DAO;

import ConnnectDB.ConnectDB;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.CT_hoadon;
import entities.Danhmuclinhkien;
import entities.Hoadon;
import entities.Khachhang;
import entities.Linhkien;
import entities.Nhacungcap;
import entities.Nhanvien;
import entities.Xuatxu;

public  class DAOhelper<T> {
	protected static EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("persistence");;
	protected EntityManager entityManager;
	protected Class<T> type =null ;
	public DAOhelper(Class<T> type) {
		// TODO Auto-generated constructor stub
	
	 entityManager = entityManagerFactory.createEntityManager();
	 this.type=type;
	}
public boolean save(T add)
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
public boolean delete(T need2remove)
{
	try {
		entityManager.getTransaction().begin();
                
		entityManager.remove(need2remove);
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
public boolean update(T need2update)// them thi goi cai hamupdate nay thi no them dc
{
	try {
		entityManager.getTransaction().begin();
		entityManager.merge(need2update);
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
public T findById(String id ) {
	
	T need2find = null;

	try {
		entityManager.getTransaction().begin();
		 need2find = entityManager.find(type, id);
	
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
		
	}
	
    return need2find;
  }
  public List<T> findAll() {
	  
	  List<T> listneed2find = null;
	  String tablename ="";
	if(type.equals(Hoadon.class))
		tablename="Hoadon";
	else if(type.equals(CT_hoadon.class))
		tablename="ct_Hoadon";
	else if(type.equals(Danhmuclinhkien.class))
		tablename="danhmuclinhkien";
	else if(type.equals(Linhkien.class))
		tablename="linhkien";
	else if(type.equals(Nhanvien.class))
		tablename="nhanvien";
	else if(type.equals(Nhacungcap.class))
		tablename="nhacungcap";
	else if(type.equals(Khachhang.class))
		tablename="khachhang";
	else if(type.equals(Xuatxu.class))
		tablename="xuatxu";
		
	try {
	
		entityManager.getTransaction().begin();
	
		listneed2find =  entityManager.createNativeQuery("SELECT * from " + tablename,type).getResultList();
	
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		
		entityManager.getTransaction().rollback();
	
	}
	finally {
		
	} 
  return  listneed2find;
    
  
  
  }
  public void close()
  {
	  
	  entityManager.close();
	//  entityManagerFactory.close();

  }
public Class<T> getType() {
	return type;
}
public void setType(Class<T> type) {
	this.type = type;
}

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
