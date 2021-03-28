package hu.cs.ex2.projectManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.cs.ex2.projectManagment.dto.CartDTO;
import hu.cs.ex2.projectManagment.dto.ProductDTO;
import hu.cs.ex2.projectManagment.model.Cart;
import hu.cs.ex2.projectManagment.model.Product;
import hu.cs.ex2.projectManagment.service.CartService;
import hu.cs.ex2.projectManagment.service.ProductService;

@RestController
@CrossOrigin
public class CartController {
    

    @Autowired
    CartService cartService;

   
    @Autowired
    ProductService productService;
   
    @GetMapping("/cart/{cartId}/getAllProductsByCartId")
    public ResponseEntity<List<ProductDTO>> getProductsOfCart(@PathVariable Integer cartId){
    
      List<Product> productList=cartService.getCartById(cartId).getProducts();
     
      return new ResponseEntity<>(productService.convertToDTO(productList),HttpStatus.OK);

       //return new ResponseEntity<>(cartService.convertToDTO(cartService.getAllCarts()),HttpStatus.OK);
    }


 //delete this
 @RequestMapping("/cart/{ProdId}/remove")
 public ResponseEntity<CartDTO> removeProductFromCart(@PathVariable Integer ProdId){

Product a=productService.getProductById(ProdId);
Cart b=cartService.getCartById(14);


//productService.addProduct(a);
a.setCart(null);
b.getProducts().remove(a);
cartService.addCart(b);

CartDTO c= cartService.convertToDTO(cartService.getCartById(14));
    return new ResponseEntity<>(c,HttpStatus.OK);

 }






    //delete this
    @PutMapping("/cart/{ProdId}/get")
     public ResponseEntity<CartDTO> getCartByIdd(@PathVariable Integer ProdId){

    Product a=productService.getProductById(ProdId);
    Cart b=cartService.getCartById(14);
   

    productService.addProduct(a);
   a.setCart(b);
   b.getProducts().add(a);
   cartService.addCart(b);
 
 CartDTO c= cartService.convertToDTO(cartService.getCartById(14));
        return new ResponseEntity<>(c,HttpStatus.OK);

     }


@RequestMapping("/cart/addPrdouct")
public ResponseEntity<CartDTO> addProductToCart(@RequestBody Integer cartId,@RequestBody Integer productId){
  /*  Product a=productService.getProductById(productId);
 cartService.getCartById(cartId).getProducts().add(a); */
 return new ResponseEntity<>(cartService.convertToDTO(cartService.getCartById(cartId)),HttpStatus.OK);

}



   
   /*   @PutMapping("/cart/{cartId}/{productId}/addProduct")
     public ResponseEntity<CartDTO> addProductToCart(@PathVariable Integer cartId,@PathVariable Integer productId){
        Product a=productService.getProductById(productId);
      cartService.getCartById(cartId).getProducts().add(a);
      return new ResponseEntity<>(cartService.convertToDTO(cartService.getCartById(cartId)).HttpStatus.OK);

     }
 */



 
    @PostMapping("/cart/add")
     public ResponseEntity<CartDTO> saveCart(@RequestBody Cart cart){
    
       CartDTO cartDTO=cartService.convertToDTO(cartService.addCart(cart));
        return new ResponseEntity<>(cartDTO,HttpStatus.CREATED);
     }


    @GetMapping("/cart/getAll")
     public ResponseEntity<List<CartDTO>> getAllCarts(){
     
        return new ResponseEntity<>(cartService.convertToDTO(cartService.getAllCarts()),HttpStatus.OK);
     }

   /*   @PutMapping("/cart/{cartId}/{productId}/addProduct")
     public ResponseEntity<CartDTO> addProductToCart(@PathVariable Integer cartId,@PathVariable Integer productId){
        Product a=productService.getProductById(productId);
      cartService.getCartById(cartId).getProducts().add(a);
      return new ResponseEntity<>(cartService.convertToDTO(cartService.getCartById(cartId)).HttpStatus.OK);

     }
 */

    @GetMapping("/cart/{id}/getOne")
     public ResponseEntity<CartDTO> getCartById(@PathVariable Integer id){
       
        return new ResponseEntity<>(cartService.convertToDTO(cartService.getCartById(id)),HttpStatus.OK);

     }

   
    
    @PutMapping(value="/cart/update")
    public ResponseEntity<CartDTO> updateCart(@RequestBody Cart cart){
    
        CartDTO cartDTO=cartService.convertToDTO(cartService.addCart(cart));
         return new ResponseEntity<>(cartDTO,HttpStatus.CREATED);
      }


}
