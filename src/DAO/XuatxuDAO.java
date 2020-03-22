package DAO;

import entities.Danhmuclinhkien;
import entities.Xuatxu;
import java.util.List;

public class XuatxuDAO extends DAOhelper<Xuatxu> {

    public XuatxuDAO(Class<Xuatxu> type) {
        super(type);
        // TODO Auto-generated constructor stub
    }

    public Xuatxu findbyname(String name) {

        entityManager.getTransaction().begin();
        List<Xuatxu> ds = entityManager.createNativeQuery("select * from xuatxu", Xuatxu.class).getResultList();
        entityManager.getTransaction().commit();

        if (ds.size() == 0) {
            return null;
        }
        for (Xuatxu d : ds) {
            if (d.getQuocgia().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public List<Xuatxu> getdsbyId_name(String id, String name) {
        List<Xuatxu> ds = null;
        entityManager.getTransaction().begin();

               ds= entityManager.createNativeQuery("select * from xuatxu where id like '%"+id+"%' and quocgia like '%"+name+"%'  ", type).getResultList();
        entityManager.getTransaction().commit();

        return ds;
    }
     @Override
 public boolean delete(Xuatxu need2remove)
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
