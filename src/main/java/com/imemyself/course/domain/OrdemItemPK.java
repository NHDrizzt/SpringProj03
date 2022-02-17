package com.imemyself.course.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrdemItemPK implements Serializable {

    @ManyToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Product product;

    public OrdemItemPK() {
    }

    public OrdemItemPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrdemItemPK order(Order order) {
        setOrder(order);
        return this;
    }

    public OrdemItemPK product(Product product) {
        setProduct(product);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrdemItemPK)) {
            return false;
        }
        OrdemItemPK ordemItemPK = (OrdemItemPK) o;
        return Objects.equals(order, ordemItemPK.order) && Objects.equals(product, ordemItemPK.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public String toString() {
        return "{" +
                " order='" + getOrder() + "'" +
                ", product='" + getProduct() + "'" +
                "}";
    }

}
