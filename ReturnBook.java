package Jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }

  
   public boolean getIssueBookDetails(){
       boolean succes=false;
       int bookId = Integer.parseInt(txt_book1.getText());
       int  StudentId  = Integer.parseInt(txt_student.getText());
       
       try{
           Connection con =DBConnection.getConnection();
           String sql = "select * from    IssueBook_Detail where book_id=? and student_id=? and status=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           pst.setInt(2,StudentId);
           pst.setString(3,"pending");

      ResultSet rs = pst.executeQuery();
   if(rs.next()){
               boolean success = true;
       issueid.setText(rs.getString("id"));
       bookid1.setText(rs.getString("book_name"));
       student_name.setText(rs.getString("student_name"));
       txt_student.setText("");
   }else{
       txt_student.setText("No Record Found");
        boolean success=false;}
   }catch(Exception e){
           e.printStackTrace();
       }
        boolean success = false;
     return success;
   }

   public boolean returnBook(){
       boolean isReturned=false;
           int bookId = Integer.parseInt(txt_book1.getText());
       int  StudentId  = Integer.parseInt(txt_student.getText());
       
       try{
           Connection con =DBConnection.getConnection();
           String sql ="update issue_book_details set status =? where student_id=? and book_id=?  ";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,"returned");
             pst.setInt(2,StudentId);
             pst.setString(4,"pending");
             
             int rowCount = pst.executeUpdate();
             if(rowCount>0){
                 isReturned=true;
}else{
                 isReturned=false;
             }}catch(Exception e){
           e.printStackTrace();
       }
       return isReturned;
       
   }
    
    public void updateBookCount() {
        int book_id = Integer.parseInt(txt_book1.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set  quantity=quantity  + 1  where   book_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this, "book count update");
          //    int initialCount = Integer.parseInt(bookquantity1.getText());
           //     bookquantity1.setText(Integer.toString(initialCount - 1));
            } else {
                JOptionPane.showMessageDialog(this, "can't update book count ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        issueid = new javax.swing.JTextField();
        bookname = new javax.swing.JTextField();
        student_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bookid1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        txt_student = new javax.swing.JTextField();
        txt_book1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(51, 0, 51));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 380, 5));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 130, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("StduntName:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book   Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\abesi\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem_new\\src\\resources\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel4.setText("    Book Details ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, 100));

        issueid.setBackground(new java.awt.Color(204, 255, 255));
        issueid.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        issueid.setToolTipText("");
        issueid.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        issueid.setName(""); // NOI18N
        issueid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueidActionPerformed(evt);
            }
        });
        jPanel1.add(issueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 360, 40));

        bookname.setBackground(new java.awt.Color(204, 255, 255));
        bookname.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookname.setToolTipText("");
        bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookname.setName(""); // NOI18N
        jPanel1.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 360, 40));

        student_name.setBackground(new java.awt.Color(204, 255, 255));
        student_name.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        student_name.setToolTipText("");
        student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        student_name.setName(""); // NOI18N
        jPanel1.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 360, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Issue Id :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 110, 30));

        bookid1.setBackground(new java.awt.Color(204, 255, 255));
        bookid1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookid1.setToolTipText("");
        bookid1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookid1.setName(""); // NOI18N
        jPanel1.add(bookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 360, 40));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 410, 750));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\abesi\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem_new\\src\\resources\\icons8_Books_52px_1.png")); // NOI18N
        jLabel1.setText("Return Book ");
        panel_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 180, 210, -1));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 340, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 0, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Book   Id :");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 130, 30));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Student   Id :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 470, 130, 30));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 0, 204));
        rSMaterialButtonCircle3.setText("FIND");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 600, 300, 60));

        txt_student.setBackground(new java.awt.Color(0, 0, 0));
        txt_student.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        txt_student.setForeground(new java.awt.Color(255, 255, 255));
        txt_student.setToolTipText("");
        txt_student.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txt_student.setName(""); // NOI18N
        txt_student.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentFocusLost(evt);
            }
        });
        txt_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentActionPerformed(evt);
            }
        });
        panel_main.add(txt_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 370, 40));

        txt_book1.setBackground(new java.awt.Color(0, 0, 0));
        txt_book1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        txt_book1.setForeground(new java.awt.Color(255, 255, 255));
        txt_book1.setToolTipText("");
        txt_book1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txt_book1.setName(""); // NOI18N
        txt_book1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_book1FocusLost(evt);
            }
        });
        panel_main.add(txt_book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 370, 40));

        jPanel6.setBackground(new java.awt.Color(0, 102, 51));
        panel_main.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 240, 820));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle4.setText("RETURN BOOK");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 670, 300, 60));

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Jframe/library-2.png"))); // NOI18N
        jLabel8.setText("Book   Id :");
        panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 440, 730));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\abesi\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem_new\\src\\resources\\icons8_Rewind_48px.png")); // NOI18N
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("X");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, -1, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 800));

        setSize(new java.awt.Dimension(1299, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
getIssueBookDetails();

    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void txt_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentActionPerformed

    private void txt_studentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentFocusLost
      
    }//GEN-LAST:event_txt_studentFocusLost

    private void txt_book1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book1FocusLost
        
    }//GEN-LAST:event_txt_book1FocusLost

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
      if(returnBook()==true){
          JOptionPane.showMessageDialog(this,"Book returned Successfully");
          updateBookCount();
      }else{
          JOptionPane.showMessageDialog(this,"Book Returned Failed");
      }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void issueidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueidActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
      HomePage home =new HomePage();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookid1;
    private javax.swing.JTextField bookname;
    private javax.swing.JTextField issueid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private javax.swing.JTextField student_name;
    private javax.swing.JTextField txt_book1;
    private javax.swing.JTextField txt_student;
    // End of variables declaration//GEN-END:variables
}
