package com.xinda.cn.vo;


public class Epro {
	private String id;//产品id
	private String e_id;
//	
	public String getId() {
		return id;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;

	private String sname;

    private byte[] img;

    public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	private String info;
    
    private Integer mapket_price;



	public Integer getMapket_price() {
		return mapket_price;
	}

	public void setMapket_price(Integer mapket_price) {
		this.mapket_price = mapket_price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


}
