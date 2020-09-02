package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodtabs")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pname")
	private String prodName;
	@Column(name="prodCost")
	private Double prodCost;
	public Integer getProdId() {
		return prodId;
	}
	
	public Product() {
		super();
	}
	
	

	public Product(Integer prodId) {
		super();
		this.prodId = prodId;
	}
	

	public Product(Integer prodId, String prodName, Double prodCost) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodCost = prodCost;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodCost=" + prodCost + "]";
	}
	
	

}
