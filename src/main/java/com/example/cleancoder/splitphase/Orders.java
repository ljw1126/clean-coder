package com.example.cleancoder.splitphase;

record Product(double basePrice, double discountThreshold, double discountRate) {}

record ShippingMethod(double discountThreshold, double discountedFee, Double feePerCase) {}

public class Orders {
    double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        double basePrice = product.basePrice() * quantity;
        double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();
        double shippingPerCase = (basePrice > shippingMethod.discountThreshold())
                ? shippingMethod.discountedFee() : shippingMethod.feePerCase();
        double shippingCost = quantity * shippingPerCase;
        double price = basePrice - discount * shippingCost;
        return price;
    }
}
