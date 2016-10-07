/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAddtocartMB;

import com.entity.Products;
import Session.Operation;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author vaio
 */
@Named(value = "indexM")
@Dependent


public class indexM {

    @EJB
    private Operation operation;




    public indexM() {
    }


    public List<Products> getProducts(){
        return operation.retriveProducts();

    
}
    
}