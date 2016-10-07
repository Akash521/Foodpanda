package com.query;

import com.entity.Entity1;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vaio
 */
public class query {
private EntityManagerFactory emf;

public  query(){
    emf= Persistence.createEntityManagerFactory("FoodpandaPU");
}
public Entity1 validateuser(String name,String password){
    Entity1 user;
    EntityManager em =emf.createEntityManager();
    
    String sql ="SELECT e  FROM Entity1 e WHERE e.name = :name and e.password = :password";
    Query q1=em.createQuery(sql);
    q1.setParameter("name",name);
    q1.setParameter("password",password);
    
    user =(Entity1)q1.getSingleResult();
    
            
        return user;
    
}

}
