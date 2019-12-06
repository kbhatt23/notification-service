package com.metallica.notificationservice.subscriber.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trade implements Serializable{

	private Side side;
	
	private int quantity;
	
	private double price;
	
	@JsonIgnore
	private Date tradeDate;
	
	private TradeStatus tradeStatus;
	
	private String commodity;
	
	private String counterParty;
	
	private double commodityUnitPrice;
	
	@Override
	public String toString() {
		return "Trade [side=" + side + ", quantity=" + quantity + ", price=" + price + ", tradeDate=" + tradeDate
				+ ", tradeStatus=" + tradeStatus + ", commodity=" + commodity + ", counterParty=" + counterParty
				+ ", commodityUnitPrice=" + commodityUnitPrice + "]";
	}

	public Trade(Side side, int quantity, double price, Date tradeDate, TradeStatus tradeStatus, String commodity,
			String counterParty, double commodityUnitPrice) {
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.tradeDate = tradeDate;
		this.tradeStatus = tradeStatus;
		this.commodity = commodity;
		this.counterParty = counterParty;
		this.commodityUnitPrice = commodityUnitPrice;
	}
	public Trade() {
		
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public double getCommodityUnitPrice() {
		return commodityUnitPrice;
	}

	public void setCommodityUnitPrice(double commodityUnitPrice) {
		this.commodityUnitPrice = commodityUnitPrice;
	}

	
}
