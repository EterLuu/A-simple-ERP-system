package pdc.assignment.erp.ui.dialog.sale;

import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;
import pdc.assignment.erp.dbo.service.ItemServiceImpl;
import pdc.assignment.erp.ui.dialog.Search;
import pdc.assignment.erp.util.Judgement;

import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import java.math.BigDecimal;

public class OrderDetailManagement extends javax.swing.JDialog implements InvoiceFrame {

    private int status = -1;
    private int row = -1;
    private javax.swing.JDialog prev;
    
    /**
     * Creates new form OrderDetailManagement
     */
    public OrderDetailManagement() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        addListener();
    }

    public OrderDetailManagement(javax.swing.JDialog prev) {
        this.prev = prev;

        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        addListener();
    }

    public OrderDetailManagement(javax.swing.JDialog prev, int row, OrderDetailsEntity e) {
        this.row=row;
        this.prev = prev;
        this.status = 0;
        
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        addListener();
        
        jButton1.setText("Change");
        jCheckBox1.setVisible(false);

        ItemServiceImpl itemService = new ItemServiceImpl();
        
        jTextField1.setText(itemService.selectItem(e.getIid()).getName());
        jTextField2.setText(e.getPrice().toString());
        jTextField3.setText(e.getNumber().toString());
        jTextField4.setText(e.getTotalPrice().toString());
        jTextPane1.setText(e.getRemark());
    }

    private void addListener(){
        Document dt1 = jTextField2.getDocument();
        Document dt2 = jTextField3.getDocument();

        dt1.addDocumentListener(new javax.swing.event.DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!Judgement.judgeNumber(jTextField2.getText())) {
                    jTextField4.setText("");
                    return;
                }
                if(!Judgement.judgeNumber(jTextField3.getText())) {
                    jTextField4.setText("");
                    return;
                }
                getTotalPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!Judgement.judgeNumber(jTextField2.getText())) {
                    jTextField4.setText("");
                    return;
                }
                if(!Judgement.judgeNumber(jTextField3.getText())) {
                    jTextField4.setText("");
                    return;
                }
                getTotalPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException();
            }
        });

        dt2.addDocumentListener(new javax.swing.event.DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!Judgement.judgeNumber(jTextField2.getText())) {
                    jTextField4.setText("");
                    return;
                }
                if(!Judgement.judgeNumber(jTextField3.getText())) {
                    jTextField4.setText("");
                    return;
                }
                getTotalPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!Judgement.judgeNumber(jTextField2.getText())) {
                    jTextField4.setText("");
                    return;
                }
                if(!Judgement.judgeNumber(jTextField3.getText())) {
                    jTextField4.setText("");
                    return;
                }
                getTotalPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void getTotalPrice(){
        try {
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(jTextField3.getText()) * Double.parseDouble(jTextField2.getText()));
            jTextField4.setText(price.toString());
        }
        catch (Exception e){
            jTextField4.setText("");
        }
    }

    @Override
    public void customizeCustomer(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void customizeUser(String name) {
        throw new UnsupportedOperationException();
    }

    public void customizeOrderDetail(Object[] obj) {
        jTextField1.setText(String.valueOf(obj[1]));
        BigDecimal price = (BigDecimal) obj[2];
        jTextField2.setText(price.toString());
    }

    private void change(){
        if(jTextField2.getText().isEmpty()){
            jLabel5.setText("Illegal price.");
            return;
        }
        if(jTextField3.getText().isEmpty()){
            jLabel5.setText("Illegal number.");
            return;
        }
        if(jTextField4.getText().isEmpty()){
            jLabel5.setText("Illegal total price.");
            return;
        }

        String item = jTextField1.getText();
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(jTextField2.getText()));
        BigDecimal number = BigDecimal.valueOf(Double.parseDouble(jTextField3.getText()));

        if(item.isEmpty()){
            jLabel5.setText("Please choose an item.");
            return;
        }

        if(price.compareTo(BigDecimal.valueOf(0))<0){
            jLabel5.setText("Illegal price.");
            return;
        }

        if(number.compareTo(BigDecimal.valueOf(0))<0){
            jLabel5.setText("Illegal number.");
            return;
        }

        ItemServiceImpl itemService = new ItemServiceImpl();

        BigDecimal totalPrice = price.multiply(number);

        OrderDetailsEntity detail = new OrderDetailsEntity();
        detail.setIid(itemService.selectItem(jTextField1.getText()).getIid());
        detail.setNumber(number);
        detail.setPrice(price);
        detail.setTotalPrice(totalPrice);
        detail.setRemark(jTextPane1.getText());

        Invoice p = (Invoice) prev;
        p.updateOrderDetail(row, detail);
        this.dispose();
    }

    private void add(){
        if(jTextField2.getText().isEmpty()){
            jLabel5.setText("Illegal price.");
            return;
        }
        if(jTextField3.getText().isEmpty()){
            jLabel5.setText("Illegal number.");
            return;
        }
        if(jTextField4.getText().isEmpty()){
            jLabel5.setText("Illegal total price.");
            return;
        }

        String item = jTextField1.getText();
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(jTextField2.getText()));
        BigDecimal number = BigDecimal.valueOf(Double.parseDouble(jTextField3.getText()));

        if(item.isEmpty()){
            jLabel5.setText("Please choose an item.");
            return;
        }

        if(price.compareTo(BigDecimal.valueOf(0))<0){
            jLabel5.setText("Illegal price.");
            return;
        }

        if(number.compareTo(BigDecimal.valueOf(0))<0){
            jLabel5.setText("Illegal number.");
            return;
        }

        ItemServiceImpl itemService = new ItemServiceImpl();

        BigDecimal totalPrice = price.multiply(number);

        OrderDetailsEntity detail = new OrderDetailsEntity();
        detail.setIid(itemService.selectItem(jTextField1.getText()).getIid());
        detail.setNumber(number);
        detail.setPrice(price);
        detail.setTotalPrice(totalPrice);
        detail.setRemark(jTextPane1.getText());

        Invoice p = (Invoice) prev;
        p.addOrderDetail(detail);

        if(jCheckBox1.isSelected()){
            jLabel5.setText("Successfully added.");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextPane1.setText("");
        }
        else {
            this.dispose();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Item");

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField1.setEnabled(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Price");

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Number");

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Total Price");

        jTextField4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField4.setEnabled(false);

        jCheckBox1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jCheckBox1.setText("Continuity add");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Remark");
        jLabel6.setToolTipText("");

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        new Search(this, "ITEMS", "").setVisible(true);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(status==-1){
            add();
        }
        else {
            change();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OrderDetailManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDetailManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDetailManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDetailManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrderDetailManagement().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
