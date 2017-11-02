package com.shutl.controller;

import com.shutl.model.Quote;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);
        
        String vehicle = null;
        
        if(quote.getVehicle_id() == null) {
        	vehicle = calculateVolumetrics(quote.getProducts());
        } else {
        	vehicle = quote.getVehicle_id();
        }
        
        Long newprice = updatePriceByVehicle( vehicle, price);
        
        String newvehicle = updateVehicleByPrice(price);
        
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), newprice, newvehicle);
    }
    
    private Long updatePriceByVehicle(String vehicle, Long price) {
		
		Long updatedPrice = null;
		if(vehicle == "bicycle") {
			updatedPrice = (long) (0.1*price);
		} else if(vehicle == "motorbike") {
			updatedPrice = (long) (0.15*price);
		} else if(vehicle == "parcel_car") {
			updatedPrice = (long) (0.2*price);
		} else if(vehicle == "small_van") {
			updatedPrice = (long) (0.3*price);
		} else if(vehicle == "large_van") {
			updatedPrice = (long) (0.4*price);
		}
		return updatedPrice;
	}
    
    private String updateVehicleByPrice(Long price) {
		
		if(price <= 500) {
			return "bicylce";
		} else if(price <= 750) {
			return "motorbike";
		} else if(price <= 1000) {
			return "parcel_car";
		} else if(price <= 1500) {
			return "small_van";
		} else {
			return "large_van";
		}
	}
    
    private String calculateVolumetrics(List<HashMap<String, Integer>> products) {
		if(products == null) {
			return null;
		}
		String vehicle = null;
		
		int weight = 0;
		int width = 0;
		int height = 0;
		int length = 0;
		
		int listLength = products.size();
		
		for(int i=0; i<listLength; i++) {
			
			HashMap<String,Integer> temp = products.get(i);
			
			weight += temp.get("weight");
			width += temp.get("width");
			height += temp.get("height");
			length += temp.get("length");
		}
		
		
		
		if(weight <= 3 && length <= 30 && width <= 25 && height <= 10) {
			vehicle = "bicycle";
		} else if (weight <= 6 && length <= 35 && width <= 25 && height <= 25) {
			vehicle = "motorbike";
		} else if (weight <= 50 && length <= 100 && width <= 100 && height <= 75) {
			vehicle = "parcel_car";
		} else if (weight <= 400 && length <= 133 && width <= 133 && height <= 133) {
			vehicle = "small_van";
		} else {
			vehicle = "large_van";
		}
		
		return vehicle;
	}
}
