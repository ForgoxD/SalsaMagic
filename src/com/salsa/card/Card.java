package com.salsa.card;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Card {
	
	@Id private String multiverseCartaId = "vacio";
	@Index private String nombreCarta = "vacio";
	@Index private String expansion = "vacio";
	@Index private String rarity = "vacio";
	@Index private Double AvgValue = -1.0;
	@Index private Double LowValue = -1.0;
	private String Img = "vacio";
	private String url = "vacio";

	public Card(){}
	
	public String getMultiverseCartaId() {
		return multiverseCartaId;
	}
	public void setMultiverseCartaId(String multiverseCartaId) {
		this.multiverseCartaId = multiverseCartaId;
		this.Img = "http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" + multiverseCartaId + "&amp;type=card";
	}
	public String getNombreCarta() {
		return nombreCarta;
	}
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta.toLowerCase();
	}
	public String getExpansion() {
		return expansion;
	}
	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getImg() {
		return Img;
	}
	public Double getAvgValue() {
			return AvgValue;
		}
	public void setAvgValue(Double avgValue) {
		this.AvgValue = avgValue;
	}
	public Double getLowValue() {
		return LowValue;
	}
	public void setLowValue(Double lowValue) {
		this.LowValue = lowValue;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}