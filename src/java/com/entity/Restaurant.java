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
@Table(name = "RESTAURANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findByRestId", query = "SELECT r FROM Restaurant r WHERE r.restId = :restId"),
    @NamedQuery(name = "Restaurant.findByAddress", query = "SELECT r FROM Restaurant r WHERE r.address = :address"),
    @NamedQuery(name = "Restaurant.findByDeliveryFee", query = "SELECT r FROM Restaurant r WHERE r.deliveryFee = :deliveryFee"),
    @NamedQuery(name = "Restaurant.findByDescription", query = "SELECT r FROM Restaurant r WHERE r.description = :description"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name"),
    @NamedQuery(name = "Restaurant.findByPlaceId", query = "SELECT r FROM Restaurant r WHERE r.placeId = :placeId")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REST_ID")
    private Integer restId;
    @Size(max = 255)
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DELIVERY_FEE")
    private Integer deliveryFee;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PLACE_ID")
    private Integer placeId;

    public Restaurant() {
    }

    public Restaurant(Integer restId) {
        this.restId = restId;
    }

    public Integer getRestId() {
        return restId;
    }

    public void setRestId(Integer restId) {
        this.restId = restId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restId != null ? restId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.restId == null && other.restId != null) || (this.restId != null && !this.restId.equals(other.restId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Restaurant[ restId=" + restId + " ]";
    }
    
}
