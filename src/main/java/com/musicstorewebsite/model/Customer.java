package com.musicstorewebsite.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Le on 10/22/2015.
 */

@Entity
@Getter
@Setter
public class Customer implements Serializable {

    private static final long serialVersionUID = -3280023076408333682L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "The customer name must not be null.")
    private String customerName;

    @NotEmpty (message = "The customer email must not be null.")
    private String customerEmail;
    private String customerPhone;

    @NotEmpty (message = "The username must not be null.")
    private String username;

    @NotEmpty (message = "The password must not be null.")
    private String password;
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne()
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

}
