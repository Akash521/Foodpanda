/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddtocartMB;

import com.entity.Products;
import Session.Operation;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author vaio
 */
@ManagedBean(name = "productM")
@RequestScoped
public class ProductM  implements Serializable{

    @EJB
    private Operation operation;
    
    
    @ManagedProperty(value = "#{cartM}")
    CartM myCartM;

    public CartM getMyCartM() {
        return myCartM;
    }

    public void setMyCartM(CartM myCartM) {
        this.myCartM = myCartM;
    }
    public ProductM() {
    }
    
    
    public String getQuery(){
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
    }
    
    
    public void checkIfQueryExists() throws IOException{
        if(operation.checkIdQueryExist(getQuery())==0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        } 
    }
    
    public Products getProduct(){
        return operation.returnProduct(getQuery());
    }
    
    
    
    public void addtocart(){
        String query=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
        myCartM.add(operation.returnProduct(query));
    }
    
}
