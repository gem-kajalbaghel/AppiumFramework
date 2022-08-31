package com.gemini.generic;

public class random {
	
	   public static void waitSec(long seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    

}
