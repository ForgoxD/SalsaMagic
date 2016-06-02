package com.salsa.mtgXml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.salsa.card.Set;

public class MtgXmlSetHandler extends DefaultHandler{
	ArrayList<Set> setList = null;
	String valor = new String();
	String setName;
	String setCode;
	Boolean isSet = false;
	
	public MtgXmlSetHandler(ArrayList<Set> list){
		this.setList = list;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(localName.equals("sets")){
			this.isSet = true;
		}
	}
	
	@Override  
	public void characters(char[] ch, int start, int length) throws SAXException{
		this.valor = String.copyValueOf(ch, start, length);
		
	}
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException{
		if(localName.equals("sets")){
			this.isSet = false;
		}
		if(localName.equals("code")){
			this.setCode = valor;
		}
		if(localName.equals("name")){
			this.setName = valor;
		}
		if(localName.equals("set")){
			if(isSet){
				Set expansion = new Set();
				expansion.setCode(setCode);
				expansion.setName(setName);
				setList.add(expansion);
			}
		}
	}
}  