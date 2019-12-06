package com.metallica.notificationservice.repository.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.metallica.notificationservice.subscriber.bean.Side;
import com.metallica.notificationservice.subscriber.bean.TradeStatus;


@Entity
@Table(name = "trades")
public class TradeDAO {
	
	@Override
	public String toString() {
		return "TradeEntity [id=" + id + ", side=" + side + ", quantity=" + quantity + ", price=" + price
				+ ", tradeDate=" + tradeDate + ", tradeStatus=" + tradeStatus + ", commodity=" + commodity
				+ ", counterParty=" + counterParty + ", commodityUnitPrice=" + commodityUnitPrice + "]";
	}

	@Id
	@GeneratedValue
	@Column(name="trade_id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="trade_side")
	private Side side;
	
	@Column(name="trade_quantity")
	private int quantity;
	
	@Column(name="trade_price")
	private double price;
	
	@Temporal(TemporalType.DATE)
	private Date tradeDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="trade_status")
	private TradeStatus tradeStatus;
	
	@Column(name="trade_commodity")
	private String commodity;
	
	@Column(name="trade_counterParty")
	private String counterParty;
	
	@Column(name="trade_commodityUnitPrice")
	private double commodityUnitPrice;
	
	public TradeDAO(Long id, Side side, int quantity, double price, Date tradeDate, TradeStatus tradeStatus,
			String commodity, String counterParty, double commodityUnitPrice) {
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.tradeDate = tradeDate;
		this.tradeStatus = tradeStatus;
		this.commodity = commodity;
		this.counterParty = counterParty;
		this.commodityUnitPrice = commodityUnitPrice;
	}
	public TradeDAO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


