package com.imemyself.course.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrdemItem implements Serializable {

    @EmbeddedId
    private OrdemItemPK id;

    private Integer quantity;
    private Double price;

    public OrdemItem() {
    }

    public OrdemItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public OrdemItemPK getId() {
        return this.id;
    }

    public void setId(OrdemItemPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrdemItem id(OrdemItemPK id) {
        setId(id);
        return this;
    }

    public OrdemItem quantity(Integer quantity) {
        setQuantity(quantity);
        return this;
    }

    public OrdemItem price(Double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrdemItem)) {
            return false;
        }
        OrdemItem ordemItem = (OrdemItem) o;
        return Objects.equals(id, ordemItem.id) && Objects.equals(quantity, ordemItem.quantity)
                && Objects.equals(price, ordemItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
