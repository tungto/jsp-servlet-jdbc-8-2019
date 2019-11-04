package com.laptrinhjavaweb.dto;

import java.util.Date;

public class AbstractDTO {

	private Long id;
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;

	private Integer page;
	private Integer limit;
	public Long getId() {
		return id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public Integer getPage() {
		return page;
	}
	public Integer getLimit() {
		return limit;
	}
	 
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}


}
