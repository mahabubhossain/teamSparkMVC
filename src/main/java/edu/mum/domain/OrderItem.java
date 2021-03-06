package edu.mum.domain;

import java.io.Serializable;

 
public class OrderItem implements Serializable {

    private Long id = null;
 
   private int version = 0;

 
   private Integer quantity;
 
   private Order order;

    private Item product;
    
	   public OrderItem() {}
	   public OrderItem (Integer  quantity,  Item product ) {
		   this.quantity = quantity;
 		   this.product = product;
	   }


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public int getVersion() {
	return version;
}

public void setVersion(int version) {
	this.version = version;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public Item getProduct() {
	return product;
}

public void setProduct(Item product) {
	this.product = product;
}
   
}