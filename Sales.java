/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pos_system;

import POS.Customer;
import POS.Product;
import POS.Sale;
import POS.Store;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dell
 */
public final class Sales extends javax.swing.JFrame {
    
    private final ArrayList<Sale> selectedSales = new ArrayList<>();
    private static final ArrayList <Sale> sales = new ArrayList();
     
public static ArrayList<Sale> loadValuesFromFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            
             String[] parts = line.split(",\\s*");    

             if (parts.length == 7) {
                try {
                    String productName = parts[0].split(":\\s*")[1].trim();
                    int productID = Integer.parseInt(parts[1].split(":\\s*")[1].trim());
                    String customerName = parts[2].split(":\\s*")[1].trim();
                    String customerType = parts[3].split(":\\s*")[1].trim();
                    double retailPrice = Double.parseDouble(parts[4].split(":\\s*")[1].trim());
                    int q = Integer.parseInt(parts[5].split(":\\s*")[1].trim());
                    LocalDate saleDate = LocalDate.parse(parts[6].split(":\\s*")[1].trim());

                    Product product = new Product(productID, productName, retailPrice, 0, 0); 
                    Customer customer = new Customer(customerName, customerType.equalsIgnoreCase("Premium"));
                    Sale sale = new Sale(customer,product, q, saleDate);

                    sales.add(sale);
                } catch (NumberFormatException | DateTimeParseException e) {
                    System.err.println("Error parsing line: " + line + " Error: " + e.getMessage());
                }
            } else {
                System.err.println("Invalid line format: " + line);
            }
        }
    } catch (IOException e) {
        System.err.println("An error occurred while loading sales from file: " + e.getMessage());
    }

    return sales;
}




    /**
     * Creates new form TrackRecord
     */
    public Sales() {
        initComponents();
        loadProductsIntoComboBox();
        loadCustomersIntoComboBox();
    }
    
    
    private void loadProductsIntoComboBox() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(", ");

                for (String detail : productDetails) {
                    if (detail.startsWith("ProductName: ")) {
                        String productName = detail.substring("ProductName: ".length()).trim();
                        jComboBox1.addItem(productName);
                        break; 
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while loading products from file: " + e.getMessage());
        }
    }

    private void loadCustomersIntoComboBox() {
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {// Split the line by commas to extract the different attributes
                String[] customerDetails = line.split(", ");

                for (String detail : customerDetails) {
                    if (detail.startsWith("CustomertName: ")) {
                        String customerName = detail.substring("CustomertName: ".length()).trim();
                        jComboBox2.addItem(customerName);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while loading customers from file: " + e.getMessage());
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        Logo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        SubTitle = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        addSales = new javax.swing.JButton();
        cmpltSales = new javax.swing.JButton();
        viewSales = new javax.swing.JButton();
        generateReports = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(51, 51, 51));
        Header.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        Logo.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_system/assests/POSicon.png"))); // NOI18N
        jLabel3.setText("P.O.S");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(153, 153, 153));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Point of Sale System");
        Title.setPreferredSize(new java.awt.Dimension(139, 40));

        SubTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SubTitle.setForeground(new java.awt.Color(153, 153, 153));
        SubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SubTitle.setText("Ease of User");
        SubTitle.setPreferredSize(new java.awt.Dimension(134, 30));

        Backbtn.setBackground(new java.awt.Color(51, 51, 51));
        Backbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(204, 204, 204));
        Backbtn.setText("Go Back");
        Backbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addComponent(SubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(Backbtn)
                .addGap(25, 25, 25))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Backbtn)
                .addGap(18, 18, 18))
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 80));

        data.setBackground(new java.awt.Color(0, 0, 0,80));
        data.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        data.setForeground(new java.awt.Color(204, 204, 204));
        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Customer Name", "Customer Type", "Retail Price", "Quantity", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(data);
        if (data.getColumnModel().getColumnCount() > 0) {
            data.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 620, 260));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0,80));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Search Product");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0,80));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Search Customer");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0,80));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Quantity");

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0,80));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(204, 204, 204));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBox2.setBackground(new java.awt.Color(0, 0, 0,80));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(204, 204, 204));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        addSales.setBackground(new java.awt.Color(0, 0, 0,80));
        addSales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addSales.setForeground(new java.awt.Color(204, 204, 204));
        addSales.setText("Add to Sales");
        addSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSalesActionPerformed(evt);
            }
        });

        cmpltSales.setBackground(new java.awt.Color(0, 0, 0,80));
        cmpltSales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmpltSales.setForeground(new java.awt.Color(204, 204, 204));
        cmpltSales.setText("Complete Sales");
        cmpltSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmpltSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpltSalesActionPerformed(evt);
            }
        });

        viewSales.setBackground(new java.awt.Color(0, 0, 0,80));
        viewSales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewSales.setForeground(new java.awt.Color(204, 204, 204));
        viewSales.setText("View Sales");
        viewSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSalesActionPerformed(evt);
            }
        });

        generateReports.setBackground(new java.awt.Color(0, 0, 0,80));
        generateReports.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        generateReports.setForeground(new java.awt.Color(204, 204, 204));
        generateReports.setText("Generate Reports");
        generateReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportsActionPerformed(evt);
            }
        });

        quantity.setBackground(new java.awt.Color(0, 0, 0,80));
        quantity.setForeground(new java.awt.Color(204, 204, 204));
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewSales, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateReports)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(addSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(cmpltSales))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addSales))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmpltSales)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(viewSales)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateReports)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 440, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_system/assests/SalesPic.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1070, 520));

        setSize(new java.awt.Dimension(1084, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        Dashboard d = new Dashboard();
        d.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackbtnActionPerformed

    private void addSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSalesActionPerformed

    String selectedCustomerName = jComboBox2.getSelectedItem().toString();
    String selectedProductName = jComboBox1.getSelectedItem().toString();
    jComboBox2.setEnabled(false);
    int q;
    try {
        q = Integer.parseInt(quantity.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid quantity.");
        return;
    }

    if (q <= 0) {
        JOptionPane.showMessageDialog(null, "Quantity must be greater than 0.");
        return;
    }

    ArrayList<Customer> customerList = Customer.getCustomers();
    ArrayList<Product> productList = Store.getProducts(); 

    Customer selectedCustomer = null;
    Product selectedProduct = null;

    for (Customer customer : customerList) {
        if (customer.getCustomerName().equals(selectedCustomerName)) {
            selectedCustomer = customer;
            break;
        }
    }

    for (Product product : productList) {
        if (product.getProductName().equals(selectedProductName)) {
            selectedProduct = product;
            break;
        }
    }

    if (selectedCustomer == null) {
        JOptionPane.showMessageDialog(null, "Selected customer does not exist.");
        return;
    }

    if (selectedProduct == null) {
        JOptionPane.showMessageDialog(null, "Selected product does not exist.");
        return;
    }

    if (selectedProduct.getStock() < q) {
        JOptionPane.showMessageDialog(null, "Not enough stock available for the selected product.");
        return;
    }

    LocalDate saleDate = LocalDate.now();
    double totalPrice = selectedProduct.getRetailPrice() * q;
    double discount = Sale.calculateDiscount(selectedCustomer , totalPrice);
    double finalAmount = totalPrice - discount;

    Sale sale = new Sale(selectedCustomer,selectedProduct, q, saleDate);
   
    selectedProduct.setStock(selectedProduct.getStock() - q);
    selectedSales.add(sale);

    Store.saveProductsToFile(productList, "products.txt");
    this.saveSaleToFile(sale);

    this.setTableValue(sales); 

    quantity.setText("");
    jComboBox1.setSelectedIndex(-1);

    JOptionPane.showMessageDialog(null, "Sale added successfully.");

    }//GEN-LAST:event_addSalesActionPerformed

    private void cmpltSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpltSalesActionPerformed
        jComboBox2.setSelectedIndex(-1);  
        jComboBox1.removeAllItems();
        jComboBox2.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Sales completed!", "Info", JOptionPane.INFORMATION_MESSAGE);

        Billing b = new Billing(selectedSales);
        b.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cmpltSalesActionPerformed

    private void viewSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSalesActionPerformed
        this.loadValuesFromFile("sales.txt");
        this.setTableValue(sales);
        this.refreshTable();
    }//GEN-LAST:event_viewSalesActionPerformed

    private void generateReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generateReportsActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Logo;
    private javax.swing.JLabel SubTitle;
    private javax.swing.JLabel Title;
    private javax.swing.JButton addSales;
    private javax.swing.JButton cmpltSales;
    private javax.swing.JTable data;
    private javax.swing.JButton generateReports;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton viewSales;
    // End of variables declaration//GEN-END:variables

private void saveSaleToFile(Sale sale) {
    String filePath = "sales.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write("Product: " + sale.getProduct().getProductName() + ", ");
        writer.write("Product Id: " + sale.getProduct().getProductId() + ", ");
        
        Customer customer = sale.getCustomer();
        if (customer != null) {
            writer.write("CustomerName: " + customer.getCustomerName() + ", ");
            writer.write("CustomerType: " + (customer.isCustomerType() ? "Premium" : "Ordinary") + ", ");
        } else {
            writer.write("CustomerName: Not Provided, ");
            writer.write("CustomerType: Not Provided, ");
        }
        writer.write("RetailPrice: " + sale.getProduct().getRetailPrice() + ", ");
        writer.write("Quantity: " + sale.getQuantityPurchased() + ", ");
        writer.write("Sale Date: " + sale.getPurchaseDate());
        
        writer.newLine();
    } catch (IOException e) {
        System.err.println("An error occurred while saving the sale: " + e.getMessage());
    }
}

public void setTableValue(ArrayList<Sale> sales) {
        if (sales != null) {
            DefaultTableModel model = (DefaultTableModel) data.getModel();
            model.setRowCount(0);

            for (Sale sale : sales) {
                Object[] row = new Object[7];
                row[0] = sale.getProduct().getProductName();
                row[1] = sale.getProduct().getProductId();  
                row[2] = sale.getCustomer().getCustomerName(); 
                row[3] = sale.getCustomer().isCustomerType() ? "Premium" : "Ordinary"; 
                row[4] = sale.getProduct().getRetailPrice(); 
                row[5] = sale.getQuantityPurchased();
                row[6] = sale.getPurchaseDate();

                model.addRow(row);
            }
        }
    }

public void refreshTable() {
        setTableValue(sales);
    }
}

    

