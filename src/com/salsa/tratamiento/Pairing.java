package com.salsa.tratamiento;

import java.util.ArrayList;
import java.util.Iterator;

import com.salsa.card.Card;
import com.salsa.card.Set;

public class Pairing {
	public static ArrayList<Card> pair(ArrayList<Card> xmlCards, ArrayList<Set> xmlSets, ArrayList<Card> mkmCards) {
		ArrayList<Card> paired = new ArrayList<Card>();
		Card actualXmlCard = null;
		Card actualMkmCard = null;
		String actualSet = null;
		Integer distance = 5000;
		Integer distName = null;
		Integer distSet = null;
		Iterator<Card> iterador = xmlCards.iterator();
		
		while(iterador.hasNext()){
			actualXmlCard = iterador.next();
			for(Set set: xmlSets){
				if(set.getCode().equals(actualXmlCard.getExpansion())){
					actualSet = set.getName();
				}
			}
			for(Card carta: mkmCards){
				distName = new Integer(Tratatexto.distance(actualXmlCard.getNombreCarta(), carta.getNombreCarta()));
				distSet = new Integer(Tratatexto.distance(actualSet, carta.getExpansion()));
				if((distName + distSet) < distance){
					distance = (distName + distSet);
					actualMkmCard = carta;
				}
			}
			actualXmlCard.setAvgValue(actualMkmCard.getAvgValue());
			actualXmlCard.setLowValue(actualMkmCard.getLowValue());
			actualXmlCard.setUrl(actualMkmCard.getUrl());
			paired.add(actualXmlCard);
			distance = 5000;
		}
		return paired;
	}
}
