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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Store {
    
    private static final ArrayList <Product> products;
    
    public static ArrayList <Product> loadProductsFromFile(String filePath) {
        products.clear(); 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("ProductID: ", "")
                       .replaceAll("ProductName: ", "")
                       .replaceAll("Retailprice: ", "")
                       .replaceAll("WholeSalePrice: ", "")
                       .replaceAll("ProductStock: ", "")
                       .replaceAll("\\s*\\.\\s*$", "");
            
                String[] data = line.split(", ");
                if (data.length == 5) {
                    try {
                        Product product = new Product(
                            Integer.parseInt(data[0].trim()),
                            data[1].trim(),
                            Double.parseDouble(data[2].trim()),
                            Double.parseDouble(data[3].trim()),
                            Integer.parseInt(data[4].trim())
                        );
                    products.add(product);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing product data: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while loading products from file: " + e.getMessage());
        }
    return products;
}

    
    static{
        products = new ArrayList();
        loadProductsFromFile("products.txt");
    }
    
    public static void addProduct(Product obj){
        if(obj != null){
            products.add(obj);
            JOptionPane.showMessageDialog(null, "Product Added Sucessfully");
            String filePath = "products.txt";
            Store.saveProductsToFile(products, filePath);
        }
        else{
            JOptionPane.showMessageDialog(null, "Product data not received.", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public static ArrayList<Product> getProducts(){
        return products;
    }
    
    public static Product searchPrdName(String name){
        if (name == null || name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search term cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getProductName().trim();
            String searchName = name.trim();
            System.out.println("Comparing: " + productName + " with " + searchName);
            if (productName.equalsIgnoreCase(searchName)) {
                return products.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Product not found.", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
     
    public static void saveProductsToFile(ArrayList<Product> products, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false))) {
            for (Product product : products) {
                writer.write("ProductID: " + product.getProductId() + ", ");
                writer.write("ProductName: " + product.getProductName() + ", ");
                writer.write("Retailprice: " + product.getRetailPrice() + ", ");
                writer.write("WholeSalePrice: " + product.getWholesalePrice() + ", ");
                writer.write("ProductStock: " + product.getStock() + ".");
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while saving products to file: " + e.getMessage());
        }
    } 
    
    public static void updateProduct(Product updatedProduct) {
        boolean productFound = false;

        for (Product product : products) {
            if (product.getProductId() == updatedProduct.getProductId()) {
                productFound = true;

                if (!product.getProductName().equals(updatedProduct.getProductName())) {
                    product.setProductName(updatedProduct.getProductName());
                }
                if (product.getRetailPrice() != updatedProduct.getRetailPrice()) {
                    product.setRetailPrice(updatedProduct.getRetailPrice());
                }
                if (product.getWholesalePrice() != updatedProduct.getWholesalePrice()) {
                    product.setWholesalePrice(updatedProduct.getWholesalePrice());
                }
                if (product.getStock() != updatedProduct.getStock()) {
                    product.setStock(updatedProduct.getStock());
                }
                saveProductsToFile(products,"products.txt");
                JOptionPane.showMessageDialog(null, "Product updated successfully.");
                return;
            }
        }

        if (!productFound) {
            JOptionPane.showMessageDialog(null, "Product not found. Wrong ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void deleteProduct(int productId, String filePath) {
   
        boolean productFound = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            JOptionPane.showMessageDialog(null, "Product with ID " + productId + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveProductsToFile(products, filePath);
        JOptionPane.showMessageDialog(null, "Product deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
}


}
