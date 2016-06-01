package com.salsa.tratatexto;


public class Tratatexto {
	
	public static String treatUrl(String texto){
		String treated = "";
		for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) == " ".charAt(0)){
            	treated += "+";
            }else{
            	treated += texto.charAt(i);
            }
            
        }
		return treated;
	}
}
