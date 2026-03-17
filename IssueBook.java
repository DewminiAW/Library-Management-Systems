
package Jframe;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class IssueBook extends javax.swing.JFrame {
    public IssueBook() {
        initComponents();
    }
public void getBookDetails() {
    int bookId = Integer.parseInt(txt_book1.getText());
    try {
       Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "SELECT * FROM book_details WHERE book_id = ?"
        );
        pst.setInt(1, bookId); 
     ResultSet rs = pst.executeQuery();
           if(rs.next()) {
           bookid.setText(rs.getString("book_id"));
            bookname.setText(rs.getString("book_name"));
          bookauthor.setText(rs.getString("author"));
            lbl_bookError.setText(rs.getString("quantity"));
                }else{
            lbl_bookError.setText("invalid student id");
        }
    } catch (Exception e) {
       e.printStackTrace();
    }
}
public void getStudentDetails() {
    int StudentId = Integer.parseInt(txt_student.getText());
    try {
       Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(
            "SELECT * FROM student_details WHERE student_id = ?"
        );
        pst.setInt(1, StudentId); 
     ResultSet rs = pst.executeQuery();
        if(rs.next()) {
           studentid1.setText(rs.getString("student_id"));
            studentName1.setText(rs.getString("name"));
          studentcourse1.setText(rs.getString("course"));
          studentbranch2.setText(rs.getString("branch1"));
        }else{
                lbl_studentError1.setText("invalid Book id");
                }
    } catch (SQLException e) {
       e.printStackTrace();
    }}
public boolean issueBook() throws SQLException{    
    boolean issueBook = false;
     int book_id=Integer.parseInt(txt_book1.getText());
     int student_id= Integer.parseInt(txt_student.getText());
     String Bookname =bookname.getText();
     String  studentname = studentName1.getText();
     try{
         Connection con =DBConnection.getConnection();
         String sql ="insert into issue_book_details(book_id,book_name,student_id,student_name)Values(?,?,?,?)";
                 PreparedStatement pst = con.prepareStatement(sql);                 
                 pst.setInt(1,book_id );
                 pst.setString(2,Bookname);
                 pst.setInt(3,student_id);
                 pst.setString(4,studentname);
                 pst.setString(7,"pending");                 
                pst.executeUpdate();                
                int rowCount = pst.executeUpdate();
                if(rowCount>0){
                     issueBook=true;
                    }else{
                    issueBook=false;
                } 
                }catch(Exception e){
                        e.printStackTrace();
               }
                return issueBook;                    
     }
public void updateBookCount(){
    int book_id=Integer.parseInt(txt_book1.getText());
    try{
      Connection con =DBConnection.getConnection();
      String sql ="update issue_book_details set quantity-1 where book_id=?";
      PreparedStatement pst = con.prepareStatement(sql);
      pst.setInt(1,book_id );      
      int rowCount =pst.executeUpdate();
        if(rowCount>0){
                     JOptionPane.showMessageDialog(this,"book count update");
                     int initialCount =Integer.parseInt(bookquantity1.getText());
                     bookquantity1.setText(Integer.toString(initialCount-1));
                    }else{
                    JOptionPane.showMessageDialog(this,"can't update book count ");
                } 
    }catch(Exception e){
        e.printStackTrace();
    }
}
 public  boolean isAlreadyissue(){
     boolean isAlreadyissue=false;
     int book_id=Integer.parseInt(txt_book1.getText());
     int student_id= Integer.parseInt(txt_student.getText());       
     try{
              Connection con =DBConnection.getConnection();
              String sql ="select* from issue_book_details where boo_id=? and student_id=? and status=? ";
                    PreparedStatement pst = con.prepareStatement(sql);
 pst.setInt(1,book_id );
 pst.setInt(2,student_id);
 pst.setString(3,"pending");
ResultSet rs =pst.executeQuery();    
    if(rs.next()){
        isAlreadyissue=true;
    }else{
        isAlreadyissue=false;
    }
     }catch(Exception e){
         e.printStackTrace();
     }
     return isAlreadyissue;
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookid = new javax.swing.JTextField();
        bookname = new javax.swing.JTextField();
        bookauthor = new javax.swing.JTextField();
        lbl_bookError = new javax.swing.JTextField();
        bookquantity1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        txt_student = new javax.swing.JTextField();
        txt_book1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        studentName1 = new javax.swing.JTextField();
        studentid1 = new javax.swing.JTextField();
        studentcourse1 = new javax.swing.JTextField();
        studentbranch2 = new javax.swing.JTextField();
        lbl_studentError1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 380, 5));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Quantity :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 160, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book   Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("    Book Details ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 240, 100));

        bookid.setBackground(new java.awt.Color(204, 255, 255));
        bookid.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookid.setToolTipText("");
        bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookid.setName(""); // NOI18N
        jPanel1.add(bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 370, 40));

        bookname.setBackground(new java.awt.Color(204, 255, 255));
        bookname.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookname.setToolTipText("");
        bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookname.setName(""); // NOI18N
        jPanel1.add(bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 370, 40));

        bookauthor.setBackground(new java.awt.Color(204, 255, 255));
        bookauthor.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookauthor.setToolTipText("");
        bookauthor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookauthor.setName(""); // NOI18N
        jPanel1.add(bookauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 370, 40));

        lbl_bookError.setBackground(new java.awt.Color(204, 255, 255));
        lbl_bookError.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        lbl_bookError.setToolTipText("");
        lbl_bookError.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lbl_bookError.setName(""); // NOI18N
        lbl_bookError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookErrorActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 710, 230, 20));

        bookquantity1.setBackground(new java.awt.Color(204, 255, 255));
        bookquantity1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        bookquantity1.setToolTipText("");
        bookquantity1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bookquantity1.setName(""); // NOI18N
        bookquantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookquantity1ActionPerformed(evt);
            }
        });
        jPanel1.add(bookquantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 370, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 130, 30));

        jLabel9.setBackground(new java.awt.Color(204, 0, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\abesi\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem_new\\src\\resources\\icons8_Rewind_48px.png")); // NOI18N
        jLabel9.setText("Back");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 780));

        jPanel3.setBackground(new java.awt.Color(204, 0, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\abesi\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem_new\\src\\resources\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel1.setText("       Issue Book  ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 370, 10));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Book   Id :");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, 30));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Student   Id :");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 130, 30));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle3.setText("Issue  Book");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 300, 60));

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
        jPanel3.add(txt_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 370, 40));

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
        txt_book1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_book1ActionPerformed(evt);
            }
        });
        jPanel3.add(txt_book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 370, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("X");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, -1));

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 470, 760));

        jLabel14.setBackground(new java.awt.Color(0, 0, 204));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 0, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 51));
        panel_main.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 240, 820));

        jPanel7.setBackground(new java.awt.Color(0, 51, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("    Student Details ");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 240, 100));
        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 185, 380, 5));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Branch :");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 130, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Student Name:");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 150, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Course:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 130, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Student   Id :");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 30));

        studentName1.setBackground(new java.awt.Color(204, 255, 255));
        studentName1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        studentName1.setToolTipText("");
        studentName1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        studentName1.setName(""); // NOI18N
        jPanel7.add(studentName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 370, 40));

        studentid1.setBackground(new java.awt.Color(204, 255, 255));
        studentid1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        studentid1.setToolTipText("");
        studentid1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        studentid1.setName(""); // NOI18N
        jPanel7.add(studentid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 370, 40));

        studentcourse1.setBackground(new java.awt.Color(204, 255, 255));
        studentcourse1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        studentcourse1.setToolTipText("");
        studentcourse1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        studentcourse1.setName(""); // NOI18N
        jPanel7.add(studentcourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 370, 40));

        studentbranch2.setBackground(new java.awt.Color(204, 255, 255));
        studentbranch2.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        studentbranch2.setToolTipText("");
        studentbranch2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        studentbranch2.setName(""); // NOI18N
        studentbranch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentbranch2ActionPerformed(evt);
            }
        });
        jPanel7.add(studentbranch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 370, 40));

        lbl_studentError1.setBackground(new java.awt.Color(204, 255, 255));
        lbl_studentError1.setFont(new java.awt.Font("Rockwell", 2, 18)); // NOI18N
        lbl_studentError1.setToolTipText("");
        lbl_studentError1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        lbl_studentError1.setName(""); // NOI18N
        lbl_studentError1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentError1ActionPerformed(evt);
            }
        });
        jPanel7.add(lbl_studentError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 710, 230, 20));

        jLabel10.setBackground(new java.awt.Color(204, 204, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 0));
        jLabel10.setText("Quantity :");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 150, 30));

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 430, 770));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 800));

        setSize(new java.awt.Dimension(1364, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       HomePage home =new HomePage();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
          if(lbl_studentError1.getText().equals("0")){
              JOptionPane.showMessageDialog (this,"book is not availabel");
          }else{
                 if(isAlreadyissue()==false){           
                     try {
                         if(issueBook() ==true){
                             JOptionPane.showMessageDialog(this,"book issued successfully" );
                             updateBookCount();
                         }else{
                             JOptionPane.showMessageDialog(this,"Can't issue the book");  
                         }    } catch (SQLException ex) {
                         Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }else{
                     JOptionPane.showMessageDialog(this," this student alredy has this book");     
        }
          }
        
     
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void lbl_bookErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookErrorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookErrorActionPerformed

    private void txt_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentActionPerformed

    private void txt_studentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentFocusLost
     if(!txt_student.getText().equals("")){
          getStudentDetails();
     }
    }//GEN-LAST:event_txt_studentFocusLost

    private void bookquantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookquantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookquantity1ActionPerformed

    private void studentbranch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentbranch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentbranch2ActionPerformed

    private void lbl_studentError1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentError1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentError1ActionPerformed

    private void txt_book1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book1FocusLost
        if(!txt_book1.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_txt_book1FocusLost

    private void txt_book1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_book1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_book1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
HomePage home = new HomePage();
home.setVisible(true);
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

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
    private javax.swing.JTextField bookauthor;
    private javax.swing.JTextField bookid;
    private javax.swing.JTextField bookname;
    private javax.swing.JTextField bookquantity1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField lbl_bookError;
    private javax.swing.JTextField lbl_studentError1;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private javax.swing.JTextField studentName1;
    private javax.swing.JTextField studentbranch2;
    private javax.swing.JTextField studentcourse1;
    private javax.swing.JTextField studentid1;
    private javax.swing.JTextField txt_book1;
    private javax.swing.JTextField txt_student;
    // End of variables declaration//GEN-END:variables
}
