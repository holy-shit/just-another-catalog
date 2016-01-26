package com.olegchir.jac.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by olegchir on 26/01/16.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="category", cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE} )
    public Set<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
