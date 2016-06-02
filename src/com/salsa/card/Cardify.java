package com.salsa.card;

import java.util.ArrayList;

import com.googlecode.objectify.cmd.Query;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class Cardify{
	public static void save(Card card){
		ofy().save().entity(card).now();
	}
	public static void save(ArrayList<Card> cards){
		for(Card card: cards){
			ofy().save().entity(card).now();
		}
	}
	public static ArrayList<Card> loadName(String name){
		ArrayList<Card> cardList = new ArrayList<Card>();
		Query<Card> query = ofy().load().type(Card.class).filter("nombreCarta", name);
		for(Card card: query){
			cardList.add(card);
		}
		return cardList;
	}
}