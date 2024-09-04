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
public class Customer {
    private String customerName;
    private boolean customerType;
    
    private static final ArrayList<Customer> customerList;
    
    public static ArrayList<Customer> loadCustomersFromFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        customerList.clear();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("CustomerName: ", "").replaceAll("CustomerType", ",")
                    .replaceAll("\\s*\\.\\s*$", "");

            String[] parts = line.split(",");
            if (parts.length == 2) {
                String name = parts[0].split(": ")[1].trim();
                String type = parts[1].split(": ")[1].trim();
                boolean isPremium = type.equalsIgnoreCase("premium");

                Customer customer = new Customer(name, isPremium);
                customerList.add(customer);

                System.out.println("Customer loaded: " + name + ", Type: " + type);
            } else {
                System.err.println("Invalid line format: " + line);
            }
        }
    } catch (IOException e) {
        System.err.println("An error occurred while loading customers from file: " + e.getMessage());
    }
    
    return customerList;
}

    
    static{
        customerList = new ArrayList();
        loadCustomersFromFile("customers.txt");
    }

    public Customer() {
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }
    
    

    public Customer(String customerName, boolean customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }
    
    public String customerType(){
        if (customerType == true){
            return "premium";
        }
        else{
            return "ordinary";
        }
    }  
    
    public static ArrayList <Customer> getCustomers(){
        return customerList;
    }
    
    public static void saveCustomersToFile(ArrayList<Customer> customerList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,false))) {
            for (Customer customer : customerList) {
                writer.write("CustomertName: " + customer.getCustomerName() + ", ");
                writer.write("CustomertType: " + customer.customerType() + ". ");
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while saving products to file: " + e.getMessage());
        }
    }
    public static void deleteProduct(String customer, String filePath) {
   
        boolean customerFound = false;
        System.out.println("Searching for customer: ");
        for (Customer c : customerList) {
            System.out.println("Checking customer: " + c.getCustomerName());
        }

        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerName().trim().equalsIgnoreCase(customer.trim())) {
                customerList.remove(i);
                customerFound = true;
                JOptionPane.showMessageDialog(null, "Customer found and removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }

        if (!customerFound) {
            JOptionPane.showMessageDialog(null, "Customer " + customer + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveCustomersToFile(customerList, filePath);
        printFileContents(filePath);
}
    public static void printFileContents(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
    }
}
    public static void addProduct(Customer obj){
        if(obj != null){
            customerList.add(obj);
            JOptionPane.showMessageDialog(null, "Customer Added Sucessfully");
            String filePath = "customers.txt";
            saveCustomersToFile(customerList, filePath);
        }
        else{
            JOptionPane.showMessageDialog(null, "Customer data not received.", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }
    
    public static void updateCustomerType(String customerName) {
        boolean customerFound = false;
        
        for (Customer customer : customerList) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName)) {
                customer.setCustomerType(!customer.isCustomerType()); // Toggle type
                customerFound = true;
                JOptionPane.showMessageDialog(null, "Customer type updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
        
        if (!customerFound) {
            JOptionPane.showMessageDialog(null, "Customer " + customerName + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        saveCustomersToFile(customerList, "customers.txt");
        printFileContents("customers.txt");
    }
    
    public static void searchCustomer(String customerName) {
        boolean customerFound = false;

        for (Customer customer : customerList) {
            if (customer.getCustomerName().equalsIgnoreCase(customerName)) {
                customerFound = true;
                JOptionPane.showMessageDialog(null, "Customer " + customerName + " found.", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }

        if (!customerFound) {
            JOptionPane.showMessageDialog(null, "Customer " + customerName + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
