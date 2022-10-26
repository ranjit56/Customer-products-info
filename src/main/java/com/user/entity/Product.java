package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_model")
	private String productModel;

	@Column(name = "product_madeIn")
	private String productMadeIn;

	@Column(name = "product_price")
	private String productPrice;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getProductMadeIn() {
		return productMadeIn;
	}

	public void setProductMadeIn(String productMadeIn) {
		this.productMadeIn = productMadeIn;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product(Long id, String productName, String productModel, String productMadeIn, String productPrice,
			String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.productModel = productModel;
		this.productMadeIn = productMadeIn;
		this.productPrice = productPrice;
		this.description = description;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productModel=" + productModel
				+ ", productMadeIn=" + productMadeIn + ", productPrice=" + productPrice + ", description=" + description
				+ "]";
	}

}
