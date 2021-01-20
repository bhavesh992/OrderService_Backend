package com.example.OrderService.controller;

import com.example.OrderService.domain.JwtToken;
import com.example.OrderService.entity.Cart;
import com.example.OrderService.entity.CartItem;
import com.example.OrderService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public ResponseEntity createCart(@RequestBody Cart cart)
    {
        try
        {
            System.out.println("Cart Created");
            return new ResponseEntity(cartService.createCart(cart),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/remove/{cart_item_id}")
    public ResponseEntity deleteByCartitemId(@PathVariable("cart_item_id") String cartitem)
    {
        try
        {
            cartService.deleteItemFromCart(cartitem);
            return new ResponseEntity(new JwtToken("Item Deleted"),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/removecart/{cartId}")
    public ResponseEntity deleteByCartId(@PathVariable("cartId") String cart)
    {
        try
        {
            cartService.deleteCart(cart);
            return new ResponseEntity("Items Deleted",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }
    @GetMapping("/get/{cartId}")
    public ResponseEntity getByCartId(@PathVariable("cartId") String cart)
    {
        try
        {
            return new ResponseEntity(cartService.getAllItemsFromCart(cart),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }
    @PostMapping("/addtocart/{cartId}")
    public ResponseEntity addtoCart(@PathVariable("cartId") String cart, @RequestBody CartItem cartItem)
    {
        try
        {
            System.out.println("Add to Cart="+cart+" "+cartItem.toString());
            return new ResponseEntity(cartService.addItemToCart(cart,cartItem),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity getCartByUserId(@PathVariable("user_id") String user)
    {
        try
        {
            return new ResponseEntity(cartService.getCartIdByUserId(user),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return  new ResponseEntity(e.getMessage().toString(),HttpStatus.OK);
        }
    }


}
