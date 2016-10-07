/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaio
 */
@Entity
@Table (name = "Entity1")
@XmlRootElement
@NamedQueries({
// @NamedQuery(name = "Entity1.control", query = "SELECT e  FROM Entity1 e WHERE e.name = :name and e.password = :password")   
}
)
public class Entity1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String Phoneno;
    @Column(length = 1)
    private String sex;
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

//    public Date getBirthdate() {
//        return Birthdate;
//    }
//
//    public void setBirthdate(Date Birthdate) {
//        this.Birthdate = Birthdate;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entity1)) {
            return false;
        }
        Entity1 other = (Entity1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Entity1[ id=" + id + " ]";
    }

}
