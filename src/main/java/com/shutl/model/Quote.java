package com.shutl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quote {
    String pickupPostcode;
    String deliveryPostcode;
    Long price;
    String vehicle_id;
    List<HashMap<String,Integer>> products;

    public Quote() {
    	products = new ArrayList<HashMap<String,Integer>>();
    }

    public Quote(String pickupPostcode, String deliveryPostcode) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        
    }

    public Quote(String pickupPostcode, String deliveryPostcode, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
        
    }
    
    public Quote(String pickupPostcode, String deliveryPostcode, Long price,String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
        this.vehicle_id = vehicle;
        
    }
    
    public Quote(String pickupPostcode, String deliveryPostcode, Long price,ArrayList<HashMap<String,Integer>> products) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
        this.products = products;
        
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public List<HashMap<String, Integer>> getProducts() {
		return products;
	}

	public void setProducts(List<HashMap<String, Integer>> products) {
		this.products = products;
	}
	
	
    
    
}
