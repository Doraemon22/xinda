package com.xinda.cn.vo;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class EOrderComment {
	private String id;//产品id
	
	private String order_id;//订单id
	
	private String e_id;//用户id，可能会用不到

	private String name;

	private String sname;

    private byte[] img;
    
	private String info;
	
    private Date create_time;
    
    private int comment_status;
    
    private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getComment_status() {
		return comment_status;
	}

	public void setComment_status(int comment_status) {
		this.comment_status = comment_status;
	}

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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
    
    
}
