package com.xinda.cn.vo;

import org.springframework.stereotype.Component;

@Component
public class OFac {
	private String cellphone;
	private String region_id;
    private String service_name;
    private String service_info;
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getRegion_id() {
		return region_id;
	}
	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_info() {
		return service_info;
	}
	public void setService_info(String service_info) {
		this.service_info = service_info;
	}
    
}
