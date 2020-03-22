/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnnectDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ke Hien Le
 */
public class ConnectDB {
    
    private static EntityManagerFactory entityManagerFactory ;
    private static EntityManager entityManager;



   private  ConnectDB() {
        
        
    }
   
    public  static synchronized EntityManager getInstance () {
        if (entityManager == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	 entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
 
         
}
