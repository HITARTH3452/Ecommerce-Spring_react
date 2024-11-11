package model;

import jakarta.persistence.*;

import java.util.List;

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL )
    private List<CartItem> items;
}
