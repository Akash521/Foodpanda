
package com.managebean;

import com.entity.Entity1;
import com.query.query;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean(name = "login")
public class UserManager {
    
    @PersistenceContext 
    private EntityManager em;
    
    @Resource 
    private UserTransaction utx;
    
    private Long id;

    private String email;
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return Phoneno;
    }

    public void setPhoneno(String Phoneno) {
        this.Phoneno = Phoneno;
    }
    public String Phoneno;
    @Column(length = 1)
    public String sex;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date Birthdate;
//    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String validateUser() {   
    
        return "";
    }
    
    public String createUser() {
        FacesContext context = FacesContext.getCurrentInstance();
//        Entity1_1 wuser = getUser();
////        if (wuser == null) {
////            if (!password.equals(passwordv)) {
//                FacesMessage message = new FacesMessage("The specified passwords do not match.  Please try again");
//                context.addMessage(null, message);
//                return null;
//            }
           Entity1 wuser = new Entity1();
        wuser.setName(name);
        wuser.setPassword(password);
        wuser.setPhoneno(Phoneno);
        wuser.setEmail(email);
        wuser.setSex(sex);
        try {
                utx.begin();
                em.persist(wuser);
                utx.commit();
                return "welcomePrimefaces";
            } catch (Exception e) {               
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                        "Error creating user!",
                                                        "Unexpected error when creating your account.  Please contact the system Administrator");
                context.addMessage(null, message);
                Logger.getAnonymousLogger().log(Level.SEVERE,
                                                "Unable to create new user",
                                                e);
                return null;
            }
        
   
        
        }
    
    
    public  String loginUser()throws Exception
    {
        
        
        query user =new query();
        user.validateuser(name,password);
        if(user!=null){
            
            return "home";        
        }
        else
            return "invalid";
    }
    
}
