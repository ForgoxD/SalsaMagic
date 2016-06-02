package com.salsa.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.xml.sax.SAXException;

import com.salsa.card.Card;
import com.salsa.card.Cardify;
import com.salsa.card.Set;
import com.salsa.card.Setify;
import com.salsa.mkmApi.MkmApi;
import com.salsa.mkmApi.MkmXmlReader;
import com.salsa.mtgXml.MtgXmlReader;
import com.salsa.tratatexto.Tratatexto;

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
		
		ArrayList<Card> cardsList = null;
		ArrayList<Set>  setsList = null;
		
		cardsList = MtgXmlReader.readCards("WEB-INF/AppDataBase/MtgXml.xml");
		Cardify.save(cardsList);
		setsList = MtgXmlReader.readSets("WEB-INF/AppDataBase/MtgXml.xml");
		Setify.save(setsList);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Card aux = null;
		Set setAux = null;
        ArrayList<Card> listCardXml = null;
        ArrayList<Set>  listSetXml = null;
        ArrayList<Card> listMkm = null;
        MkmApi app = new MkmApi(this.mkmAppToken, this.mkmAppSecret, this.mkmAccessToken, this.mkmAccessTokenSecret);

        if (app.request("https://www.mkmapi.eu/ws/v1.1/output.xml/products/" + Tratatexto.treatUrl(req.getParameter("consultaNombre").toLowerCase()) + "/1/1/false")){
			try {
				listMkm = MkmXmlReader.read(app.responseContent());
				listCardXml = Cardify.loadName(req.getParameter("consultaNombre").toLowerCase());
			} catch (SAXException e) {
				
			}
			if(!listCardXml.isEmpty() && !listMkm.isEmpty()){
				aux = listCardXml.get(0);
				aux.setAvgValue(listMkm.get(0).getAvgValue());
				aux.setLowValue(listMkm.get(0).getLowValue());
        	}
        }
        
        if(aux != null){
	        req.setAttribute("card", aux);
	        req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }else{
        	String vacio = "no se ha encontrado la carta";
        	req.setAttribute("error", vacio);
        	req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }
		
	}
}