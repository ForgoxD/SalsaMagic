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
	private String Img = "vacio";
	@Index private Integer AvgValue = -1;
	@Index private Integer LowValue = -1;
	
	public Card(){}
	
	public String getMultiverseCartaId() {
		return multiverseCartaId;
	}
	public void setMultiverseCartaId(String multiverseCartaId) {
		this.multiverseCartaId = multiverseCartaId;
		this.Img = "<img class='decoded' alt='http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" +
					multiverseCartaId + "&amp;type=card' src='http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" +
					multiverseCartaId + "&amp;type=card'>";
	}
	public String getNombreCarta() {
		return nombreCarta;
	}
	public void setNombreCarta(String nombreCarta) {
		this.nombreCarta = nombreCarta;
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
	public Integer getAvgValue() {
			return AvgValue;
		}
	public void setAvgValue(Integer avgValue) {
		this.AvgValue = avgValue;
	}
	public Integer getLowValue() {
		return LowValue;
	}
	public void setLowValue(Integer lowValue) {
		this.LowValue = lowValue;
	}
}