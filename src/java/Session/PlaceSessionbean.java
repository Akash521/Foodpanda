/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import com.entity.Place;
import com.entity.Restaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vaio
 */
@Stateless
public class PlaceSessionbean {
 @PersistenceContext(unitName = "FoodpandaPU")
    private EntityManager em;
    public int getPlace(String city,String area)
    {
       Query q=em.createNamedQuery("Place.findByPlace");
       q.setParameter("area", area);
       q.setParameter("city", city);
       try
       {
           Place p=(Place)q.getSingleResult();
       return p.getPlaceId();
       }
       catch(NoResultException e)
       {
           return 0;
       }
    }
           
        public List<Restaurant> getRestaurants(int placeID)
    {
        Query q=em.createNamedQuery("Restaurant.findByPlaceId");
        q.setParameter("placeId", placeID);
        List<Restaurant> rest=q.getResultList();
        return rest;
    }
    
          public List<Place> findby(String query,String city){
              Query q= em.createNamedQuery("Place.findByAreaLike");
                      q.setParameter("query",query.concat("%"));
                      q.setParameter("city",city);
                     return q.getResultList();
                      
          }
           public List<Place> find(String city ){
              Query q= em.createNamedQuery("Place.findByCity");
                      q.setParameter("city",city.concat("%"));
                      return q.getResultList();
                      
          }
          
    public void persist(Object object) {
        em.persist(object);
    }   
}
