package com.ejb;

import com.entity.Entity1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vaio
 */
@Stateless
public class Entity1Facade extends AbstractFacade<Entity1> {

    @PersistenceContext(unitName = "FoodpandaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Entity1Facade() {
        super(Entity1.class);
    
    }
    
    
    
}
