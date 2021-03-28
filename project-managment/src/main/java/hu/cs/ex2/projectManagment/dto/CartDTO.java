package hu.cs.ex2.projectManagment.dto;

import java.util.List;

public class CartDTO {

      
private Integer id;
private Integer total;
private Integer numberOfProducts;
private Integer invoiceId;

private List<Integer> productsIds;
private List<String> productsNames;

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Integer getTotal() {
    return total;
}

public void setTotal(Integer total) {
    this.total = total;
}

public Integer getNumberOfProducts() {
    return numberOfProducts;
}

public void setNumberOfProducts(Integer numberOfProducts) {
    this.numberOfProducts = numberOfProducts;
}

public Integer getInvoiceId() {
    return invoiceId;
}

public void setInvoiceId(Integer invoiceId) {
    this.invoiceId = invoiceId;
}

public List<Integer> getProductsIds() {
    return productsIds;
}

public void setProductsIds(List<Integer> productsIds) {
    this.productsIds = productsIds;
}

public List<String> getProductsNames() {
    return productsNames;
}

public void setProductsNames(List<String> productsNames) {
    this.productsNames = productsNames;
}

    
}
