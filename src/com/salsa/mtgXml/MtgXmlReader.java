package com.salsa.mtgXml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.salsa.card.Card;
import com.salsa.card.Set;

public class MtgXmlReader {
	
	public static ArrayList<Card> readCards(String datos) throws SAXException, IOException{
		ArrayList<Card> list = null;
		
		try{
			list = new ArrayList<Card>();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			
			reader.setContentHandler(new MtgXmlCardHandler(list));
			reader.parse(new InputSource(new FileInputStream(datos)));
		}catch (SAXException e){  
	       e.printStackTrace();  
	    }catch (IOException e){  
	       e.printStackTrace();  
	    }
		return list;
	}
	public static ArrayList<Set> readSets(String datos) throws SAXException, IOException{
		ArrayList<Set> list = null;
		
		try{
			list = new ArrayList<Set>();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			
			reader.setContentHandler(new MtgXmlSetHandler(list));
			reader.parse(new InputSource(new FileInputStream(datos)));
		}catch (SAXException e){  
	       e.printStackTrace();  
	    }catch (IOException e){  
	       e.printStackTrace();  
	    }
		return list;
	}
}
