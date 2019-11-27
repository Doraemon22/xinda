package com.xinda.cn.vo;

public class ECart {
	private String id;//购物车id
	private String product_id;//产品id
	private String name;//产品名字
    private Integer mapket_price;
    private int store_num;
    private int num;
    private int  totalPrice;
    private String sname;
    
    
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMapket_price() {
		return mapket_price;
	}
	public void setMapket_price(Integer mapket_price) {
		this.mapket_price = mapket_price;
	}
	public int getStore_num() {
		return store_num;
	}
	public void setStore_num(int store_num) {
		this.store_num = store_num;
	}
    
    
}
