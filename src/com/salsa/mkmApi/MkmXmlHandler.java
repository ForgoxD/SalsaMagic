package com.salsa.mkmApi;

import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.salsa.card.Card;

public class MkmXmlHandler extends DefaultHandler{
	ArrayList<Card> cardList = null;
	String valor = null;
	String cardName = null;
	Boolean isName = false;
	String set = null;
	String rarity = null;
	Double avgPrice = null;
	Double lowPrice = null;
	
	public MkmXmlHandler(ArrayList<Card> list){
		this.cardList = list;
	}
	
	@Override  
	public void characters(char[] ch, int start, int length) throws SAXException{
		valor = String.copyValueOf(ch, start, length);
		
	}
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException{
		if(localName.equals("productName")){
			if(isName){
				cardName = valor;
			}
		}
		if(localName.equals("expansion")){
			set = valor;
		}
		if(localName.equals("idLanguage") && valor == "1"){
			isName = true;
		}else{
			isName = false;
		}
		if(localName.equals("rarity")){
			rarity = valor;
		}
		if(localName.equals("AVG")){
			if(valor != null && valor != ""){
				avgPrice = Double.parseDouble(valor);
			}
		}
		if(localName.equals("LOW")){
			if(valor != null && valor != ""){
				lowPrice = Double.parseDouble(valor);
			}
		}
		if(localName.equals("product")){
			Card card = new Card();
			if(set != null){
				card.setExpansion(set);
			}
			if(rarity != null){
				card.setRarity(rarity);
			}
			if(cardName != null){
				card.setNombreCarta(cardName);
			}
			if(avgPrice != null){
				card.setAvgValue(avgPrice);
			}
			if(lowPrice != null){
				card.setLowValue(lowPrice);
			}
			cardList.add(card);
		}
	}
}
