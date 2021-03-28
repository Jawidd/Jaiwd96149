package hu.cs.ex2.projectManagment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Cart {
//Automate Number of products 
    public Cart(){
        products=new ArrayList<>();
numberOfProducts=products.size();
//total=products.stream().map(prod->prod.getPrice()).mapToInt(i->i).sum();
total=products.stream().mapToInt(prod->prod.getPrice()).sum();
    }
   
private Integer id;
private Integer total;
private Integer numberOfProducts;

private Invoice invoice;
private List<Product> products;


//private Date creationDate;
//private Date modificationDate;
//private Integer price;
 

@OneToMany(mappedBy = "cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
public List<Product> getProducts() {
    return products;
}
 
public void setProducts(List<Product> products) {
    this.products = products;
}
  
@OneToOne
public Invoice getInvoice() {
    return invoice;
}

public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
}




@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getTotal() {
    total=products.stream().mapToInt(prod->prod.getPrice()).sum();
    return total;
}

public void setTotal(Integer total) {
    this.total = total;
}

public Integer getNumberOfProducts() {
    
    //Automate Number of products
    numberOfProducts=products.size();
    
    return numberOfProducts;
}

public void setNumberOfProducts(Integer numberOfProducts) {
    this.numberOfProducts = numberOfProducts;
}


    
}
