package com.esprit.pi.entities;

import java.util.Arrays;


public enum UserRole {
	 ADMINISTRATEUR("ADMINISTRATEUR"), CLIENT("CLIENT");
	
	String type;
	 private UserRole(String type) {
	        this.type = type;
	    }

	    public String getType() {
	        return type;
	    }

	    public static UserRole getEnum(String value) {
	        for(UserRole v : values())
	            if(v.getType().equalsIgnoreCase(value)) return v;
	        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	    }
}
