/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vaio
 */
@Entity
@Table(name = "PLACE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Place.findByPlaceId", query = "SELECT p FROM Place p WHERE p.placeId = :placeId"),
    @NamedQuery(name = "Place.findByArea", query = "SELECT p FROM Place p WHERE p.area = :area"),
    @NamedQuery(name = "Place.findByCity", query = "SELECT distinct(p) FROM Place p WHERE p.city LIKE :city"),
    @NamedQuery(name = "Place.findByPlace", query = "SELECT p FROM Place p WHERE p.area = :area and p.city = :city"),
    @NamedQuery(name = "Place.findByAreaLike", query = "SELECT p FROM Place p WHERE p.area LIKE :query and p.city = :city")})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLACE_ID")
    private Integer placeId;
    @Size(max = 255)
    @Column(name = "AREA")
    private String area;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;

    public Place() {
    }

    public Place(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeId != null ? placeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.placeId == null && other.placeId != null) || (this.placeId != null && !this.placeId.equals(other.placeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Place[ placeId=" + placeId + " ]";
    }
    
}
