/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddtocartMB;

import com.entity.Products;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author vaio
 */
@ManagedBean(name = "cartM")
@Dependent
public class CartM {

        public List<Products> products =new ArrayList<>();
    
    public CartM() {
    }
    
    public void add(Products p){
           products.add(p);
    }
    
    public void  remove(Products p){
        products.remove(p);
        
    }
    public int getCartCount(){
        return products.size();
    }
    
}
