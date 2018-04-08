package net.youss.ecommercebackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	@Column(name = "unit_price")
	private double unitPrice;
	private int quantity;
	@Column(name = "is_active")
	@JsonIgnore
    private boolean active;
	@JsonIgnore
    @Column(name = "category_id")
    private int categoryId;
	@JsonIgnore
    @Column(name = "supplier_id")
    private int supplierId;
    private int purchases;
    private int views;
    
    public Product() {
		this.code = "PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
    public String getBrand() {
		return brand;
	}
    
    
    
    public int getCategoryId() {
		return categoryId;
	}
    
    
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPurchases() {
		return purchases;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public int getViews() {
		return views;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", brand=" + brand + ", description=" + description
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active + ", categoryId="
				+ categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views=" + views + "]";
	}

    
  
}
