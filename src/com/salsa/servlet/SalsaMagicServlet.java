package com.salsa.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.salsa.card.Card;
import com.salsa.card.Cardify;
import com.salsa.mkmApi.MkmApi;

@SuppressWarnings("serial")
public class SalsaMagicServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Card prueba = null;
        ArrayList<Card> listPrueba = null;
		String mkmAppToken = "QtN5IV8Yr3DumHd0" ;
        String mkmAppSecret = "NwIEDYS3ow9I2czAjvvzDeMHcPXf5IsQ" ;
        String mkmAccessToken = "EChRWjof2eRakPmxvC1e3K2E3JZuVbdw";
        String mkmAccessTokenSecret = "CKMlZc2Vt2scdLgAL9bQI0OaobiD2i1m";
        MkmApi app = new MkmApi(mkmAppToken, mkmAppSecret, mkmAccessToken, mkmAccessTokenSecret);
        
        if (app.request("https://www.mkmapi.eu/ws/v1.1/output.xml/products/" + req.getParameter("consultaNombre") + "/1/1/false")){
			//app.responseContent();
        }
		
		listPrueba = Cardify.loadName(req.getParameter("consultaNombre"));
        if(!listPrueba.isEmpty()){
        	prueba = listPrueba.get(0);
	        req.setAttribute("card", prueba.getMultiverseCartaId());
	        req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }else{
        	String vacio = "no se ha encontrado la carta";
        	req.setAttribute("vacio", vacio);
        	req.getRequestDispatcher("mostrarCarta.jsp").forward(req, resp);
        }
		
	}
}