package DAO;

import entities.Danhmuclinhkien;
import java.util.List;

public class DanhmuclinhkienDAO extends DAOhelper<Danhmuclinhkien> {

    public DanhmuclinhkienDAO(Class<Danhmuclinhkien> type) {
        super(type);
        // TODO Auto-generated constructor stub
    }

    public Danhmuclinhkien findbyname(String name) {
        Danhmuclinhkien dm = null;

        entityManager.getTransaction().begin();
        List<Danhmuclinhkien> ds = entityManager.createNativeQuery("select * from danhmuclinhkien where ten =  N'" + name + "'", Danhmuclinhkien.class).getResultList();
        entityManager.getTransaction().commit();

        return ds.get(0);
    }

    public List<Danhmuclinhkien> getdsbyId_name(String id, String name) {
        List<Danhmuclinhkien> ds = null;
        entityManager.getTransaction().begin();

        ds = entityManager.createNativeQuery("select * from Danhmuclinhkien where id like '%" + id + "%' and ten like '%" + name + "%' ", type).getResultList();
        entityManager.getTransaction().commit();

        return ds;
    }

     @Override
 public boolean delete(Danhmuclinhkien need2remove)// goi cai ham nay la  xoa  dc
{
	try {
		entityManager.getTransaction().begin();
               
		entityManager.remove(entityManager.find(type, need2remove.getId()));
	    entityManager.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
                e.printStackTrace();
		entityManager.getTransaction().rollback();
                
		return false;
	}
	finally {
		
	}
	return true;
}
}
