package thankous.eshopAppbackend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String category;
    private String price;
    private long quantity;
    private String image;

    @ManyToMany(mappedBy = "products")
    private Set<Cart> carts = new HashSet<>();

    public Product() {
    }

    public Product(String name, String category, String price, long quantity, String image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public Product(String name, String category, String price, long quantity, String image, Set<Cart> carts) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.carts = carts;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id != null ? id.equals(product.id) : product.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
