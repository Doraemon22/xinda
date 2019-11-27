package com.xinda.cn.vo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class OUser {
	private String name;
	private String cellphone;
	private Date register_time;
	private String region_id;
	private String e_id;//xml
	private String id;//xml
	private Integer buy_num;
	private Integer total_price;
	private Integer num;//别名
	private Integer money;//别名
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Date register_time) {
		this.register_time = register_time;
	}
	public String getRegion_id() {
		return region_id;
	}
	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	
	public Integer getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(Integer buy_num) {
		this.buy_num = buy_num;
	}
	public Integer getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	
	

	
}
