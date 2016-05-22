package com.salsa.mkmApi;

import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.salsa.card.Card;

public class MkmXmlHandler extends DefaultHandler{
	ArrayList<Card> cardList = null;
	String valor = new String();
	String cardName;
	Boolean isName = false;
	String set;
	String rarity;
	Integer avgPrice;
	Integer lowPrice;
	
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
			avgPrice = Integer.parseInt(valor);
		}
		if(localName.equals("LOW")){
			lowPrice = Integer.parseInt(valor);
		}
		if(localName.equals("product")){
			Card card = new Card();
			card.setExpansion(set);
			card.setRarity(rarity);
			card.setNombreCarta(cardName);
			card.setAvgValue(avgPrice);
			card.setLowValue(lowPrice);
			cardList.add(card);
		}
	}
}
