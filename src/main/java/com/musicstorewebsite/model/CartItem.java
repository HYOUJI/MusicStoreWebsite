package com.musicstorewebsite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Le on 1/11/2016.
 */

@Entity
@Getter
@Setter
public class CartItem implements Serializable{

    private static final long serialVersionUID = -904360230041854157L;

    @Id
    @GeneratedValue
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name="cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;
    private double totalPrice;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="cartItems")
    @JsonIgnore
    private List<OrderHistory> orderHistoryList;

}
