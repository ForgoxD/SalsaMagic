package com.salsa.mtgXml;

import java.util.ArrayList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.salsa.card.Card;

public class MtgXmlCardHandler extends DefaultHandler{
	ArrayList<Card> cardList = null;
	String valor = new String();
	String cardName;
	String set;
	String rarity;
	String id;
	
	public MtgXmlCardHandler(ArrayList<Card> list){
		this.cardList = list;
	}
	
	@Override  
	public void characters(char[] ch, int start, int length) throws SAXException{
		valor = String.copyValueOf(ch, start, length);
		
	}
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException{
		if(localName.equals("id")){
			id = valor;
		}
		if(localName.equals("name")){
			cardName = valor;
		}
		if(localName.equals("set")){
			set = valor;
		}
		if(localName.equals("rarity")){
			rarity = valor;
		}
		if(localName.equals("card")){
			Card card = new Card();
			card.setExpansion(set);
			card.setMultiverseCartaId(id);
			card.setRarity(rarity);
			card.setNombreCarta(cardName);
			cardList.add(card);
		}
	}
}  