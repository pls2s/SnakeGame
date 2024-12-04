/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cs318_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author peera
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    public homepage() {
        initComponents();
    }
    
    public String readPlayerName() {
    try {
        FileInputStream fis = new FileInputStream("D:\\player.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        String playerName = (String) ois.readObject(); // อ่านชื่อผู้เล่นจากไฟล์
        ois.close();
        fis.close();
        return playerName;
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        return null; // คืนค่า null หากเกิดข้อผิดพลาด
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

        pnel_bg1 = new javax.swing.JPanel();
        pnel_bg2 = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        txt_playerName = new javax.swing.JTextField();
        lbl_selectDifficulty = new javax.swing.JLabel();
        btn_btnEasy = new javax.swing.JButton();
        btn_btnMedium = new javax.swing.JButton();
        btn_btnHard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 220, 201));
        setForeground(java.awt.Color.white);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnel_bg1.setBackground(new java.awt.Color(249, 241, 224));
        pnel_bg1.setForeground(new java.awt.Color(249, 241, 224));

        pnel_bg2.setBackground(new java.awt.Color(255, 251, 241));

        lbl_name.setFont(new java.awt.Font("LilyUPC", 1, 36)); // NOI18N
        lbl_name.setText("Name");

        txt_playerName.setBackground(new java.awt.Color(255, 228, 207));
        txt_playerName.setToolTipText("");
        txt_playerName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_playerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_playerNameActionPerformed(evt);
            }
        });

        lbl_selectDifficulty.setFont(new java.awt.Font("IrisUPC", 0, 48)); // NOI18N
        lbl_selectDifficulty.setText("Select your Difficulty");

        btn_btnEasy.setBackground(new java.awt.Color(255, 228, 207));
        btn_btnEasy.setFont(new java.awt.Font("LilyUPC", 1, 36)); // NOI18N
        btn_btnEasy.setForeground(new java.awt.Color(92, 135, 88));
        btn_btnEasy.setText("EASY");
        btn_btnEasy.setToolTipText("");
        btn_btnEasy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_btnEasyMouseClicked(evt);
            }
        });
        btn_btnEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_btnEasyActionPerformed(evt);
            }
        });

        btn_btnMedium.setBackground(new java.awt.Color(255, 228, 207));
        btn_btnMedium.setFont(new java.awt.Font("IrisUPC", 1, 36)); // NOI18N
        btn_btnMedium.setForeground(new java.awt.Color(255, 179, 0));
        btn_btnMedium.setText("MEDIUM");
        btn_btnMedium.setToolTipText("");
        btn_btnMedium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_btnMediumMouseClicked(evt);
            }
        });
        btn_btnMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_btnMediumActionPerformed(evt);
            }
        });

        btn_btnHard.setBackground(new java.awt.Color(255, 228, 207));
        btn_btnHard.setFont(new java.awt.Font("IrisUPC", 1, 36)); // NOI18N
        btn_btnHard.setForeground(new java.awt.Color(151, 45, 18));
        btn_btnHard.setText("HARD");
        btn_btnHard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_btnHardMouseClicked(evt);
            }
        });
        btn_btnHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_btnHardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnel_bg2Layout = new javax.swing.GroupLayout(pnel_bg2);
        pnel_bg2.setLayout(pnel_bg2Layout);
        pnel_bg2Layout.setHorizontalGroup(
            pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg2Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(lbl_name)
                .addGap(18, 18, 18)
                .addComponent(txt_playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_bg2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_bg2Layout.createSequentialGroup()
                        .addComponent(lbl_selectDifficulty)
                        .addGap(323, 323, 323))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_bg2Layout.createSequentialGroup()
                        .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_btnMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_btnHard, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_btnEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(250, 250, 250))))
        );
        pnel_bg2Layout.setVerticalGroup(
            pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_name))
                .addGap(41, 41, 41)
                .addComponent(lbl_selectDifficulty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btn_btnEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btn_btnMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_btnHard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout pnel_bg1Layout = new javax.swing.GroupLayout(pnel_bg1);
        pnel_bg1.setLayout(pnel_bg1Layout);
        pnel_bg1Layout.setHorizontalGroup(
            pnel_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnel_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        pnel_bg1Layout.setVerticalGroup(
            pnel_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnel_bg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        getContentPane().add(pnel_bg1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_playerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_playerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_playerNameActionPerformed

    private void btn_btnEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_btnEasyActionPerformed
    
    }//GEN-LAST:event_btn_btnEasyActionPerformed

    private void btn_btnMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_btnMediumActionPerformed
      
    }//GEN-LAST:event_btn_btnMediumActionPerformed

    private void btn_btnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_btnHardActionPerformed
     
    }//GEN-LAST:event_btn_btnHardActionPerformed

    private void btn_btnEasyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_btnEasyMouseClicked
      String playerName = txt_playerName.getText().trim();
    if (playerName.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter your name before playing.", 
            "Name Required", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            
            File file = new File(System.getProperty("user.home") + "\\Documents\\player.bin");
            if (!file.exists()) {
                file.getParentFile().mkdirs(); 
                file.createNewFile(); 
            }

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerName); 
            oos.close();
            fos.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Welcome, " + playerName + "! Starting the game...");
            EasyHowToPage easy = new EasyHowToPage(); 
            easy.setVisible(true);
            this.dispose();    
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "An error occurred while saving player data.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }
    }//GEN-LAST:event_btn_btnEasyMouseClicked

    private void btn_btnMediumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_btnMediumMouseClicked
     String playerName = txt_playerName.getText().trim();
    if (playerName.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter your name before playing.", 
            "Name Required", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            
            File file = new File(System.getProperty("user.home") + "\\Documents\\player.bin");
            if (!file.exists()) {
                file.getParentFile().mkdirs(); 
                file.createNewFile(); 
            }

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerName);
            oos.close();
            fos.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Welcome, " + playerName + "! Starting the game...");
            MediumHowToPage medium = new MediumHowToPage(); 
            medium.setVisible(true);
            this.dispose();   
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "An error occurred while saving player data.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_btn_btnMediumMouseClicked

    private void btn_btnHardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_btnHardMouseClicked
        String playerName = txt_playerName.getText().trim();
    if (playerName.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter your name before playing.", 
            "Name Required", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        try {
            
            File file = new File(System.getProperty("user.home") + "\\Documents\\player.bin");
            if (!file.exists()) {
                file.getParentFile().mkdirs(); 
                file.createNewFile(); 
            }

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerName); 
            oos.close();
            fos.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Welcome, " + playerName + "! Starting the game...");
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "An error occurred while saving player data.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
    }  
    }//GEN-LAST:event_btn_btnHardMouseClicked

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_btnEasy;
    private javax.swing.JButton btn_btnHard;
    private javax.swing.JButton btn_btnMedium;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_selectDifficulty;
    private javax.swing.JPanel pnel_bg1;
    private javax.swing.JPanel pnel_bg2;
    private javax.swing.JTextField txt_playerName;
    // End of variables declaration//GEN-END:variables
}
