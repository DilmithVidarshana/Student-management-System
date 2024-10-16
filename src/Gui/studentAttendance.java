/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.studentEnrolment.classMap;
import static Gui.teacherEnrolment.cityMap;
import static Gui.teacherEnrolment.subjectMap;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.mysql;

/**
 *
 * @author dilmi
 */
public class studentAttendance extends javax.swing.JFrame {
  public static HashMap<String,Integer> classMap = new HashMap();
    public static  HashMap<String,Integer> subjectMap = new HashMap();
     public static  HashMap<String,Integer> studentMap = new HashMap();
      public static  HashMap<String,Integer> attendanceMap = new HashMap();
    /**
     * Creates new form studentAttendance
     */
    public studentAttendance() {
        initComponents();
        loadclass();
        loadsubject();
        loadStudent();
        loadtable();
        attendance();
    }
  private void loadclass(){
    
         try{
            ResultSet ClassResult = mysql.execute("SELECT * FROM `class`");
            
            Vector Class = new Vector();
            Class.add("Select Class");
            
            while(ClassResult.next()){
             Class.add(ClassResult.getString("Class_name"));
             classMap.put(ClassResult.getString("Class_name"),ClassResult.getInt("ClassNo"));
            }
             DefaultComboBoxModel classmodel = new  DefaultComboBoxModel(Class);
              jComboBox3.setModel(classmodel);
          }catch(Exception e){
            e.printStackTrace();
        }
    }
 
  private void loadsubject(){
    
         try{
            ResultSet subjectResult = mysql.execute("SELECT * FROM `subject`");
            
            Vector subject = new Vector();
            subject.add("Select Subject");
            
            while(subjectResult.next()){
             subject.add(subjectResult.getString("Subject_name"));
             subjectMap.put(subjectResult.getString("Subject_name"),subjectResult.getInt("Subno"));
            }
             DefaultComboBoxModel subjectmodel = new  DefaultComboBoxModel(subject);
              jComboBox2.setModel(subjectmodel);
          }catch(Exception e){
            e.printStackTrace();
        }
    }
  private void loadStudent(){
   try{
            ResultSet studentResult = mysql.execute("SELECT * FROM `student`");
            
            Vector subject = new Vector();
            subject.add("Select student");
            
            while(studentResult.next()){
             subject.add(studentResult.getString("First_Name"));
             studentMap.put(studentResult.getString("First_Name"),studentResult.getInt("Sno"));
            }
             DefaultComboBoxModel studentmodel = new  DefaultComboBoxModel(subject);
              jComboBox1.setModel(studentmodel);
          }catch(Exception e){
            e.printStackTrace();
        }
  }
  private void loadtable(){
  
       try{
              ResultSet loardresult = mysql.execute("SELECT * FROM `attendance` INNER JOIN `student` ON `attendance`.`Student_Sno`=`student`.`Sno`"
         +"INNER JOIN `class` ON `attendance`.`Class_ClassNo`=`class`.`ClassNo`"
         +"INNER JOIN `subject` ON `attendance`.`Subject_Subno`=`subject`.`Subno`"
         +"INNER JOIN `attendance_status` ON `attendance`.`Attendance_status_attendancet_status id`=`attendance_status`.`attendancet_status id`");   
              
               DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            while(loardresult.next()){
             Vector<String> loadtable = new Vector();
             
             loadtable.add(loardresult.getString("Sno"));
             loadtable.add(loardresult.getString("First_Name"));
             loadtable.add(loardresult.getString("Last_Name"));
             loadtable.add(loardresult.getString("Subject_name"));
             loadtable.add(loardresult.getString("Class_name"));
             loadtable.add(loardresult.getString("Date"));
             loadtable.add(loardresult.getString("attendance_satatemant"));
             
              model.addRow(loadtable);
                  jTable1.setModel(model);
            }
             }catch(Exception e){
            e.printStackTrace();
       }
  }
  private void attendance(){
   try{
            ResultSet attendanceResult = mysql.execute("SELECT * FROM `attendance_status`");
            
            Vector attendance = new Vector();
            attendance.add("Select Attendance");
            
            while(attendanceResult.next()){
             attendance.add(attendanceResult.getString("attendance_satatemant"));
             attendanceMap.put(attendanceResult.getString("attendance_satatemant"),attendanceResult.getInt("attendancet_status id"));
            }
             DefaultComboBoxModel attendancemodel = new  DefaultComboBoxModel(attendance);
              jComboBox4.setModel(attendancemodel);
          }catch(Exception e){
            e.printStackTrace();
        }
  }
  private void reset(){
  jComboBox1.setSelectedIndex(0);
  jComboBox2.setSelectedIndex(0);
  jComboBox3.setSelectedIndex(0);
  jDateChooser1.setDate(null);
    jComboBox4.setSelectedIndex(0);
  
  
  
  }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("ROG Fonts", 3, 24)); // NOI18N
        jLabel1.setText("Student Attendance");

        jButton3.setFont(new java.awt.Font("ROG Fonts", 1, 18)); // NOI18N
        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("ROG Fonts", 1, 18)); // NOI18N
        jButton2.setText("Student Enrolment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Student Number");

        jButton4.setFont(new java.awt.Font("ROG Fonts", 1, 14)); // NOI18N
        jButton4.setText("Mark Attendance");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Number", "First name", "Last name", "subject Name", "Class Name", "Date", "Attendance status"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3643764_back_backward_left_reply_turn_icon.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Date");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Subject");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Class");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("attendance status");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      String studentNumber =String.valueOf(jComboBox1.getSelectedItem());
      SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    Date dob = jDateChooser1.getDate();
     String SubjectNumber =String.valueOf(jComboBox2.getSelectedItem());
      String ClassNumber =String.valueOf(jComboBox3.getSelectedItem());
       String attendanced =String.valueOf(jComboBox4.getSelectedItem());
      
      if(studentNumber.equals("Select student")){
         JOptionPane.showMessageDialog(this, "Select Student  Name",
                               "WARNING", JOptionPane.WARNING_MESSAGE);
       }else if(dob == null){
      JOptionPane.showMessageDialog(this, "Enter   Date ",
                               "WARNING", JOptionPane.WARNING_MESSAGE);
       }else if(SubjectNumber.equals("Select Subject")){
        JOptionPane.showMessageDialog(this, "Select Subject ",
                               "WARNING", JOptionPane.WARNING_MESSAGE);
       }else if(ClassNumber.equals("Select Class")){
        JOptionPane.showMessageDialog(this, "Select Class ",
                               "WARNING", JOptionPane.WARNING_MESSAGE);
       }else{
       try{
           
          mysql.execute("INSERT INTO `attendance` (`Student_Sno`,`Subject_Subno`,`Class_ClassNo`,`Attendance_status_attendancet_status id`,`Date`)"
                  +"VALUES('"+studentMap.get(studentNumber)+"','"+subjectMap.get(SubjectNumber)+"','"+classMap.get(ClassNumber)+"','"+attendanceMap.get(attendanced)+"','"+date.format(dob)+"')");
                   
          JOptionPane.showMessageDialog(this, "Student Attendance SuccessFull",
                               "information", JOptionPane.INFORMATION_MESSAGE);
          reset();
          loadtable();
       
            }catch(Exception e){
            e.printStackTrace();
        }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       home home = new home();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        studentEnrolment se = new studentEnrolment();
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      studentEnrolment se = new studentEnrolment();
      se.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
