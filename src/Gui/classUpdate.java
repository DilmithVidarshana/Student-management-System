/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.classRegestor.subjectMap;
import static Gui.classRegestor.teacherMap;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.ResultSet;
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
public class classUpdate extends javax.swing.JFrame {
    public static HashMap<String,Integer> teacherMap = new HashMap();
    public static  HashMap<String,Integer> subjectMap = new HashMap();
    /**
     * Creates new form classUpdate
     */
    public classUpdate() {
        initComponents();
        loadClass();
    }
    
     private void loadClass(){
      try{
          ResultSet classresult = mysql.execute("SELECT * FROM `class` INNER JOIN `teacher` ON `class`.`Teacher_Tno`=`teacher`.`Tno`"
          +"INNER JOIN`subject`ON `class`.`Subject_Subno`=`subject`.`Subno`");
          
          DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            while(classresult.next()){
            
                 Vector<String> Class = new Vector();
                 
                 Class.add(classresult.getString("ClassNo"));
                 Class.add(classresult.getString("Class_name"));
                 Class.add(classresult.getString("First_Name"));
                 Class.add(classresult.getString("Subject_name"));
                 Class.add(classresult.getString("TimeSlot"));
                 
                       model.addRow(Class);
                  jTable1.setModel(model);
                        
                
            }
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
              jComboBox1.setModel(subjectmodel);
          }catch(Exception e){
            e.printStackTrace();
        }
    
     }
       
        private void loadTeachers(){
    try{
        ResultSet teachersResult = mysql.execute("SELECT * FROM `teacher`");
        Vector teacher = new Vector();
        teacher.add("Select teacher");
        
        while(teachersResult.next()){
        teacher.add(teachersResult.getString("First_Name"));
        teacherMap.put(teachersResult.getString("First_Name"),teachersResult.getInt("Tno"));
        }
        DefaultComboBoxModel teachermodel = new  DefaultComboBoxModel(teacher);
              jComboBox2.setModel(teachermodel);
         }catch(Exception e){
            e.printStackTrace();
        }
    
    }
        private void reset(){
         jLabel3.setText("");
         jTextField2.setText("");
         jTextField1.setText("");
         jComboBox1.setSelectedIndex(0);
         jComboBox2.setSelectedIndex(0);
                          
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("ROG Fonts", 3, 24)); // NOI18N
        jLabel1.setText("Classs Update");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3643764_back_backward_left_reply_turn_icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("ROG Fonts", 1, 18)); // NOI18N
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("ROG Fonts", 1, 18)); // NOI18N
        jButton3.setText("Class Regester");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Class Number");

        jLabel3.setText("*************");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Class Name");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Time Slot");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Select Teacher");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Teacher" }));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Select Subject");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));

        jButton4.setText("Update Class");

        jButton5.setText("Remove Class");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Number", "Class Name", "Time Slot", "Teacher Name", "Subject Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       classRegestor cr = new classRegestor();
       cr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      home home = new home();
      home .setVisible(true);
      this.dispose();;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         classRegestor cr = new classRegestor();
       cr.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      if (evt.getClickCount()==1){
        
            jTable1.setEnabled(false);
            
             int selectdeRow = jTable1.getSelectedRow();
             
               String classNumber = String.valueOf(jTable1.getValueAt(selectdeRow, 1));
            jLabel3.setText(classNumber);
            
              String className = String.valueOf(jTable1.getValueAt(selectdeRow, 2));
            jTextField2.setText(className);
            
            String timeSlot= String.valueOf(jTable1.getValueAt(selectdeRow, 3));
            jTextField1.setText(timeSlot);
            

      }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         int selectedRow = jTable1.getSelectedRow();
                if(selectedRow==0){
                JOptionPane.showMessageDialog(this, "Please Select Row",
                               "WARNING", JOptionPane.WARNING_MESSAGE);
                }
                  String classNumber =String.valueOf(jTable1.getValueAt(selectedRow, 0));
                  
                   try{
                       
                         mysql.execute("DELETE FROM `attendance` WHERE`Class_ClassNo`='"+classNumber+"'");
                         
                       mysql.execute("DELETE FROM `student` WHERE`Class_ClassNo`='"+classNumber+"'");
                         
                       
                       mysql.execute("DELETE FROM `class` WHERE`ClassNo`='"+classNumber+"'");
                       
                        JOptionPane.showMessageDialog(this, "Class Remove SuccessFull",
                               "information", JOptionPane.INFORMATION_MESSAGE);
                            
                           reset();
                           loadClass();
                           
                           jTable1.setEnabled(true);
                           
                           }catch(Exception e){
            e.printStackTrace();
          }
                   
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new classUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
