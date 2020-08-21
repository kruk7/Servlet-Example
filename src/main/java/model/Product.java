package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NamedQueries
({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findOrderByName", query = "SELECT p FROM Product p order by p.name")
})
@NamedNativeQueries
({
        @NamedNativeQuery(name = "Product.findTenProd", query = "SELECT * FROM product LIMIT 10", resultClass = Product.class),
        @NamedNativeQuery(name = "Product.findNumberProd", query = "SELECT * FROM product LIMIT :num", resultClass = Product.class)
})
public class Product implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;
    private String name;
    private Double price;
    private String category;

    public Product() { }

    public Product(String name, Double price, String category)
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getName()
    { return name; }

    public void setName(String name)
    { this.name = name; }

    public Double getPrice()
    { return price; }

    public void setPrice(Double price)
    { this.price = price; }

    public String getCategory()
    { return category; }

    public void setCategory(String category)
    { this.category = category; }
}
