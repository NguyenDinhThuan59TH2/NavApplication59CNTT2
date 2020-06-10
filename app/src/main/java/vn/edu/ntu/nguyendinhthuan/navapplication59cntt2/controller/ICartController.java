package vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.controller;

import java.util.List;

import vn.edu.ntu.nguyendinhthuan.navapplication59cntt2.model.Product;

public interface ICartController {
    List<Product> getAllProduct();
    public boolean addToCart(Product p);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
    public void addProduct(Product p);
}
