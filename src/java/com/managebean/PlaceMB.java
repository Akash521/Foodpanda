/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managebean;

import Session.PlaceSessionbean;
import com.entity.Place;


import com.entity.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author vaio
 */
@ManagedBean(name = "placeMB")
@ViewScoped
public class PlaceMB {

    @EJB
    private PlaceSessionbean placeSessionbean;

    
    
public void disp()
    {
        if(placeSessionbean.getPlace(city, area)==0)
        {
            System.out.println("No results available");
        }
        else
        {
            int place_id=placeSessionbean.getPlace(city, area);
          //  System.out.println(place_id);
            List<Restaurant> r=placeSessionbean.getRestaurants(place_id);
            for(Restaurant e:r)
            {
                System.out.println(e.getName()+" "+e.getAddress());
            }
            
        }
 
    }


public  List <String> showCity(String city){
    List<String> Area = new ArrayList<String>();
    
    List<Place> objArea;
    objArea=placeSessionbean.find(city);
    for(Place p:objArea){
        Area.add(p.getCity());
    }
    return Area;
}


public void onCitySelect(SelectEvent e){
    this.city=e.getObject().toString();
}

public  List <String> showAll(String query){
    List<String> Area = new ArrayList<String>();
    
    List<Place> objArea;
    objArea=placeSessionbean.findby(query,city);
    for(Place p:objArea){
        Area.add(p.getArea());
    }
    return Area;
}
    

    


private String city;
private String area;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public PlaceMB() {
    }
    
}
