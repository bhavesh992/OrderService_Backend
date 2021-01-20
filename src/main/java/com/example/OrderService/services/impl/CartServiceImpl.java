package com.example.OrderService.services.impl;

import com.example.OrderService.domain.*;
import com.example.OrderService.entity.Cart;
import com.example.OrderService.entity.CartItem;
import com.example.OrderService.exception.MaxOrderLimitReach;
import com.example.OrderService.feignclient.MerchantClient;
import com.example.OrderService.feignclient.ProductClient;
import com.example.OrderService.repository.CartItemRepository;
import com.example.OrderService.repository.CartRepository;
import com.example.OrderService.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductClient productClient;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private MerchantClient merchantClient;

    @Override
    public CartItem addItemToCart(String cartId, CartItem cartItem) throws MaxOrderLimitReach {
        try {
            if(cartItem.getQuantity()>0) {
                cartItem.setCart(cartRepository.findById(cartId).get());
                return cartItemRepository.save(cartItem);
            }
            else
            {
                throw  new MaxOrderLimitReach("Limit Reached");
            }
        }
        catch(Exception e)
        {
            throw  new MaxOrderLimitReach("Limit Reached");
        }



    }



    @Override
    public void deleteItemFromCart(String cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public boolean checkIfItemIsExist(String cartId, String productId) {
        return false;
    }

    @Override
    public List<CartItemData> getAllItemsFromCart(String cartId) {

         List<CartItem>cartItems=cartItemRepository.getCartItemsByCartId(cartId);
         List<CartItemData>cartItemData=new ArrayList<>(cartItems.size());
         for(CartItem cartItem:cartItems)
         {
             Product product=productClient.getProductById(cartItem.getProductId());
             Color color=productClient.getColorByColorId(cartItem.getColorId());
             Size size=productClient.getSizeBySizeId(cartItem.getSizeId());
             MerchantStore merchantStore=merchantClient.getMerchantById(cartItem.getMerchantId());
             cartItemData.add(new CartItemData(product,size,color,merchantStore,cartItem));
         }
        return cartItemData;
    }

    @Override
    public void deleteCart(String cartId) {
        cartItemRepository.deleteByCart(cartRepository.findById(cartId).get());
    }

    @Override
    public Cart createCart(Cart cart) {
          Cart cart1=cartRepository.findByUserId(cart.getUserId());
          if(cart1==null)
        return cartRepository.save(cart);
          else return cart1;
    }

    @Override
    public Cart getCartIdByUserId(String userId) {
            return cartRepository.findByUserId(userId);
    }
}
