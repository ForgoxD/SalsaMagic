package com.salsa.card;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;

import com.googlecode.objectify.cmd.Query;

public class Setify {
	public static void save(Set set){
		ofy().save().entity(set).now();
	}
	public static void save(ArrayList<Set> sets){
		for(Set set: sets){
			ofy().save().entity(set).now();
		}
	}
	public static ArrayList<Set> loadName(String code){
		ArrayList<Set> setList = new ArrayList<Set>();
		Query<Set> query = ofy().load().type(Set.class).filter("code", code);
		for(Set set: query){
			setList.add(set);
		}
		return setList;
	}
}
