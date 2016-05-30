package com.salsa.mkmApi;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.salsa.card.Card;

public class MkmXmlReader{
	
	public static ArrayList<Card> read(String datos) throws SAXException, IOException{
		ArrayList<Card> list = null;
		
		try{
			list = new ArrayList<Card>();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			
			reader.setContentHandler(new MkmXmlHandler(list));
			reader.parse(new InputSource(new StringReader(datos)));
		}catch (SAXException e){  
	       e.printStackTrace();  
	    }catch (IOException e){  
	       e.printStackTrace();  
	    }
		return list;
	}
}
