/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cs318_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
/**
 *
 * @author peera
 */
public class MediumHowToPage extends javax.swing.JFrame {

    /**
     * Creates new form MediumHowToPage
     */
    public MediumHowToPage() {
        initComponents();
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
        lbl_howTo1 = new javax.swing.JLabel();
        lbl_howTo2 = new javax.swing.JLabel();
        lbl_howTo3 = new javax.swing.JLabel();
        lbl_howTo4 = new javax.swing.JLabel();
        lbl_howTo5 = new javax.swing.JLabel();
        lbl_howTo6 = new javax.swing.JLabel();
        lbl_howTo7 = new javax.swing.JLabel();
        lbl_pickey = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        lbl_Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        pnel_bg1.setBackground(new java.awt.Color(255, 228, 207));

        pnel_bg2.setBackground(new java.awt.Color(255, 251, 241));

        lbl_howTo1.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo1.setText("About Rounds ");

        lbl_howTo2.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo2.setText("Collect apples (red and green) while avoiding obstacles.");

        lbl_howTo3.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo3.setText("Rules");

        lbl_howTo4.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo4.setText("Red apples give +1 point, and green apples give +2 points.");

        lbl_howTo5.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo5.setText("Use the arrow keys to control the snake");

        lbl_howTo6.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo6.setText("Watch out for rocks scattered on the field; they are obstacles.");

        lbl_howTo7.setFont(new java.awt.Font("IrisUPC", 0, 36)); // NOI18N
        lbl_howTo7.setText("The game ends if the snake hits a wall, its own tail, or a rock.");

        lbl_pickey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/keyboard1.png"))); // NOI18N
        lbl_pickey.setText("jLabel1");

        btn_ok.setFont(new java.awt.Font("IrisUPC", 1, 48)); // NOI18N
        btn_ok.setText("OK");
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnel_bg2Layout = new javax.swing.GroupLayout(pnel_bg2);
        pnel_bg2.setLayout(pnel_bg2Layout);
        pnel_bg2Layout.setHorizontalGroup(
            pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_howTo1)
                    .addGroup(pnel_bg2Layout.createSequentialGroup()
                        .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_howTo2)
                            .addComponent(lbl_howTo6)
                            .addComponent(lbl_howTo7)
                            .addComponent(lbl_howTo3)
                            .addComponent(lbl_howTo5)
                            .addComponent(lbl_howTo4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pickey, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_bg2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(418, 418, 418))
        );
        pnel_bg2Layout.setVerticalGroup(
            pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(lbl_howTo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnel_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnel_bg2Layout.createSequentialGroup()
                        .addComponent(lbl_howTo2)
                        .addGap(35, 35, 35)
                        .addComponent(lbl_howTo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_howTo5)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_howTo4)
                        .addGap(22, 22, 22)
                        .addComponent(lbl_howTo6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_howTo7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_pickey, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btn_ok.setContentAreaFilled(false); // ปิดพื้นที่ปุ่มปกติ
        btn_ok.setFocusPainted(false); // ปิดการแสดงผลโฟกัส
        btn_ok.setBorderPainted(false); // ปิดการแสดงผลขอบ
        btn_ok.setOpaque(false); // ทำให้ปุ่มโปร่งใสเพื่อให้การวาดเงาทำงาน
        btn_ok.setForeground(Color.WHITE); // สีข้อความ
        btn_ok.setFont(new Font("LilyUPC", Font.BOLD, 36)); // ตั้งฟอนต์

        // ปรับแต่ง UI สำหรับการวาดปุ่ม
        btn_ok.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            private boolean isHovered = false; // ตัวแปรสำหรับตรวจจับ Hover

            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = c.getWidth();
                int height = c.getHeight();

                // วาดเงาด้านหลังปุ่ม
                g2.setColor(new Color(255, 102, 0, 100)); // สีเงา (ส้มอ่อนโปร่งแสง)
                g2.fillRoundRect(5, 10, width - 10, height - 10, 30, 30);

                // วาดพื้นหลังปุ่ม (ไล่ระดับสี)
                GradientPaint gradientPaint = new GradientPaint(
                    0, 0,
                    isHovered ? new Color(255, 204, 0) : new Color(255, 153, 0), // สีเมื่อ Hover หรือปกติ
                    0, height,
                    isHovered ? new Color(255, 180, 0) : new Color(255, 102, 0)
                );
                g2.setPaint(gradientPaint);
                g2.fillRoundRect(0, 0, width - 10, height - 10, 30, 30);

                // วาดข้อความของปุ่ม
                super.paint(g, c);
                g2.dispose();
            }

            @Override
            protected void installListeners(final AbstractButton b) {
                super.installListeners(b);

                // เพิ่ม MouseListener เพื่อจัดการ Hover Effect
                b.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                        isHovered = true;
                        b.repaint();
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                        isHovered = false;
                        b.repaint();
                    }
                });
            }
        });

        lbl_Title.setFont(new java.awt.Font("IrisUPC", 1, 48)); // NOI18N
        lbl_Title.setText("[Medium] How To Play");

        javax.swing.GroupLayout pnel_bg1Layout = new javax.swing.GroupLayout(pnel_bg1);
        pnel_bg1.setLayout(pnel_bg1Layout);
        pnel_bg1Layout.setHorizontalGroup(
            pnel_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_bg1Layout.createSequentialGroup()
                .addGroup(pnel_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnel_bg1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(pnel_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnel_bg1Layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(lbl_Title)))
                .addGap(50, 50, 50))
        );
        pnel_bg1Layout.setVerticalGroup(
            pnel_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_bg1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnel_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        getContentPane().add(pnel_bg1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
    MediumGame mediumGame = new MediumGame();
    mediumGame.setVisible(true);
    this.dispose();   
    }//GEN-LAST:event_btn_okMouseClicked

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
            java.util.logging.Logger.getLogger(MediumHowToPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediumHowToPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediumHowToPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediumHowToPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MediumHowToPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_howTo1;
    private javax.swing.JLabel lbl_howTo2;
    private javax.swing.JLabel lbl_howTo3;
    private javax.swing.JLabel lbl_howTo4;
    private javax.swing.JLabel lbl_howTo5;
    private javax.swing.JLabel lbl_howTo6;
    private javax.swing.JLabel lbl_howTo7;
    private javax.swing.JLabel lbl_pickey;
    private javax.swing.JPanel pnel_bg1;
    private javax.swing.JPanel pnel_bg2;
    // End of variables declaration//GEN-END:variables
}
