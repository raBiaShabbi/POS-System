/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Sale {

    
    
    public enum PaymentType {
    CARD, CASH
    }

    private Customer customer;
    private Product product;
    private int quantityPurchased;
    private double totalBillAmount;
    private PaymentType paymentType; // "Card" or "Cash"
    private double receivedAmount;
    private LocalDate purchaseDate;

    public Sale() {
    }

    public Sale(Customer customer, Product product, int quantityPurchased, double totalBillAmount, PaymentType paymentType, double receivedAmount, LocalDate purchaseDate) {
        this.customer = customer;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalBillAmount = totalBillAmount;
        this.paymentType = paymentType;
        this.receivedAmount = receivedAmount;
        this.purchaseDate = purchaseDate;
    }

    public Sale(Product product, int quantityPurchased, LocalDate purchaseDate) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.purchaseDate = purchaseDate;
    }

    public Sale(Customer customer, Product product, int quantityPurchased, LocalDate purchaseDate) {
        this.customer = customer;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.purchaseDate = purchaseDate;
    }

    public Sale(Customer customer, Product product, int quantityPurchased, double totalBillAmount, LocalDate purchaseDate) {
        this.customer = customer;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalBillAmount = totalBillAmount;
        this.purchaseDate = purchaseDate;
    }
    
   

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public void calculateTotalBillAmount() {
        this.totalBillAmount = product.getRetailPrice() * quantityPurchased;
    }

    public void addSale() {
        String saleRecord = String.format(
            "CustomerName: %s, ProductName: %s, QuantityPurchased: %d, TotalBillAmount: %.2f, PaymentType: %s, ReceivedAmount: %.2f, PurchaseDate: %s%n",
            
            customer.getCustomerName(),
            product.getProductName(),
            quantityPurchased,
            totalBillAmount,
            paymentType.toString(),
            receivedAmount,
            purchaseDate.toString()
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sales.txt", true))) {
            writer.write(saleRecord);
        } catch (IOException e) {
            System.err.println("An error occurred while saving the sale: " + e.getMessage());
        }
    }
    
    public static double calculateDiscount(Customer selectedCustomer, double totalPrice) {
        double discount = 0.0;

        if (selectedCustomer != null && selectedCustomer.isCustomerType()) {
            discount = 0.15;
        }

        return totalPrice * (1 - discount);
    }
    
   
}
