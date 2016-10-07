/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import com.entity.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vaio
 */
@Stateless
public class Operation {

    @PersistenceContext(unitName = "FoodpandaPU")
    private EntityManager em;

    public List<Products> retriveProducts(){
        return em.createQuery("SELECT p FROM Products p").getResultList();
    }
    

    public int checkIdQueryExist(String query){
        List<Products> products= em.createQuery("SELECT p FROM Products p WHERE p.mark =:mark").setParameter("mark", query).getResultList();
        return products.size();
    
        
    }
    
    
    
  public Products returnProduct(String query){
      Products product=(Products) em.createQuery("SELECT p FROM Products p WHERE p.mark =:mark").setParameter("mark", query)
              .getSingleResult();
      return product;
 
  }

    
    
    
}
