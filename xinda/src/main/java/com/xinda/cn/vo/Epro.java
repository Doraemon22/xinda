package com.xinda.cn.vo;

import org.springframework.web.multipart.MultipartFile;

public class Epro {
	private String id;//产品id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name;

	private String sname;

    private String img;

    private String info;
    
    private Integer mapket_price;
    

    private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


}
