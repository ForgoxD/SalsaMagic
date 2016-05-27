package com.salsa.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.xml.sax.SAXException;

import com.salsa.card.Card;
import com.salsa.card.Cardify;
import com.salsa.mkmApi.MkmApi;
import com.salsa.mtgXml.MtgXmlReader;

@SuppressWarnings("serial")
public class SalsaMagicServlet extends HttpServlet {
	String mkmAppToken;
    String mkmAppSecret;
    String mkmAccessToken;
    String mkmAccessTokenSecret;
	
	public SalsaMagicServlet() throws SAXException, IOException{
		this.mkmAppToken = "QtN5IV8Yr3DumHd0" ;
		this.mkmAppSecret = "NwIEDYS3ow9I2czAjvvzDeMHcPXf5IsQ" ;
		this.mkmAccessToken = "EChRWjof2eRakPmxvC1e3K2E3JZuVbdw";
		this.mkmAccessTokenSecret = "CKMlZc2Vt2scdLgAL9bQI0OaobiD2i1m";
		
		ArrayList<Card> saveList = null;
		
		saveList = MtgXmlReader.read("WEB-INF/AppDataBase/MtgXml.xml");
		Cardify.save(saveList);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Card prueba = null;
        ArrayList<Card> listPrueba = null;
        MkmApi app = new MkmApi(this.mkmAppToken, this.mkmAppSecret, this.mkmAccessToken, this.mkmAccessTokenSecret);
        
        if (app.request("https://www.mkmapi.eu/ws/v1.1/output.xml/products/" + req.getParameter("consultaNombre") + "/1/1/false")){
			//app.responseContent();
        }
		
		listPrueba = Cardify.loadName(req.getParameter("consultaNombre"));
        if(!listPrueba.isEmpty()){
        	prueba = listPrueba.get(0);
	        req.setAttribute("card", prueba);
	        req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }else{
        	String vacio = "no se ha encontrado la carta";
        	req.setAttribute("error", vacio);
        	req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }
		
	}
}