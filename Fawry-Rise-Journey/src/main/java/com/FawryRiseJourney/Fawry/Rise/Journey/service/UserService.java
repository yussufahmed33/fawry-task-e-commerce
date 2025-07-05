package com.FawryRiseJourney.Fawry.Rise.Journey.service;

import com.FawryRiseJourney.Fawry.Rise.Journey.model.CartModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.model.ProductsModel;
import com.FawryRiseJourney.Fawry.Rise.Journey.model.User;
import com.FawryRiseJourney.Fawry.Rise.Journey.repository.CartRepository;
import com.FawryRiseJourney.Fawry.Rise.Journey.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    User user;

    public void addtocart(int productId,int quantity) {

        ProductsModel product = productsRepository.getById(productId);
        if(product.getQuantity() < quantity) {
            System.out.println("quantity is not enough");
        }else{
            product.setQuantity(product.getQuantity()-quantity);
            productsRepository.save(product);

            CartModel cartItem = new CartModel();
            cartItem.setName(product.getName());
            cartItem.setPrice(product.getPrice());
            cartItem.setQuantity(quantity);
            cartItem.setWheight(product.getWheight());
            cartItem.setExpireable(product.isExpireable());
            cartItem.setExpirationDate(product.getExpirationDate());
            cartItem.setShipable(product.isShipable());
            cartItem.setShipCost(product.getShipCost());
            cartRepository.save(cartItem);
        }
    }

    public List<CartModel> viewcart() {
            return cartRepository.findAll();
    }

    public void checkOut(){
        if(isCartEmpty()){

            System.out.println("cart is empty");

        }

            float paidamount = 0;
            float shippingfees = 0;
            float subtotal = 0;

            List<CartModel> cartItems = viewcart();
            for (CartModel cartItem : cartItems) {
                String name = cartItem.getName();
                float price = cartItem.getPrice();
                float shipcost = (cartItem.getShipCost() != null) ? cartItem.getShipCost() : 0f;
                int quantity = cartItem.getQuantity();
                float itemTotal = price * quantity + shipcost;
                subtotal += price * quantity;
                shippingfees += shipcost;
                paidamount += itemTotal;
                System.out.println("- " + name + " | Price: " + price + " | Shipping: " + shipcost + " | Qty: " + quantity + " | Total: " + itemTotal);
            }
            System.out.println("order subtotal price: " + subtotal);
            System.out.println("total shipping fees: " + shippingfees);
            System.out.println("paid amount: " + paidamount);
        System.out.println("checking out.....");
        if(!isCartEmpty()){
           if(paidamount< user.getBalance()){
               user.setBalance(user.getBalance()-paidamount);
               cartRepository.deleteAll();
               System.out.println("checked out successfully");
               System.out.println("your currently balance: "+user.getBalance());}else{
               System.out.println("you dont have enough balance -_-");
           }

        }
    }
    public boolean isCartEmpty(){
return viewcart().isEmpty();
        }
    }

