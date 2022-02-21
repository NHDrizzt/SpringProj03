package com.imemyself.course.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment id(Long id) {
        setId(id);
        return this;
    }

    public Payment moment(Instant moment) {
        setMoment(moment);
        return this;
    }

    public Payment order(Order order) {
        setOrder(order);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(moment, payment.moment)
                && Objects.equals(order, payment.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, order);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", moment='" + getMoment() + "'" +
                ", order='" + getOrder() + "'" +
                "}";
    }

}
