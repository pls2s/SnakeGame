/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cs318_project;

import java.awt.Color;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author peera
 */
public class EasyGame extends javax.swing.JFrame {

    /**
     * Creates new form EasyGame
     */
    public EasyGame() {
    initComponents();
    initGame();
    initKeyListener();
    }
    private void initGame() {
        snakeBody = new ArrayList<>();
        snakeBody.add(new Point(0, 0)); // จุดเริ่มต้นของงู
        spawnFood(); // สุ่มตำแหน่งอาหาร
        timer = new Timer(200, e -> moveSnake()); // ตั้ง Timer
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        int x = rand.nextInt(GRID_SIZE);
        int y = rand.nextInt(GRID_SIZE);
        food = new Point(x, y);
    }
    private void renderGame() {
    pnel_playpnel.removeAll();
    for (int y = 0; y < GRID_SIZE; y++) {
        for (int x = 0; x < GRID_SIZE; x++) {
            JLabel cell = new JLabel();
            cell.setOpaque(true);
            Point point = new Point(x, y);
            if (snakeBody.contains(point)) {
                cell.setBackground(Color.GREEN); // ตัวงู
            } else if (point.equals(food)) {
                cell.setBackground(Color.RED); // อาหาร
            } else {
                cell.setBackground(Color.WHITE); // ช่องว่าง
            }
            pnel_playpnel.add(cell);
        }
    }
    pnel_playpnel.revalidate();
    pnel_playpnel.repaint();
    }
        private void moveSnake() {
        Point head = snakeBody.get(0);
        Point newHead = switch (direction) {
            case "UP" -> new Point(head.x, head.y - 1);
            case "DOWN" -> new Point(head.x, head.y + 1);
            case "LEFT" -> new Point(head.x - 1, head.y);
            case "RIGHT" -> new Point(head.x + 1, head.y);
            default -> head;
        };

        // ตรวจสอบชนกำแพงหรือตัวเอง
        if (newHead.x < 0 || newHead.x >= GRID_SIZE || newHead.y < 0 || newHead.y >= GRID_SIZE || snakeBody.contains(newHead)) {
            timer.stop();
            javax.swing.JOptionPane.showMessageDialog(this, "Game Over");
            return;
        }

        snakeBody.add(0, newHead);

        // ตรวจสอบการกินอาหาร
        if (newHead.equals(food)) {
            spawnFood();
            lbl_point.setText(String.valueOf(Integer.parseInt(lbl_point.getText()) + 1));
        } else {
            snakeBody.remove(snakeBody.size() - 1); // ลบส่วนท้าย
        }

        renderGame();
    }
    private void initKeyListener() {
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (!direction.equals("DOWN")) direction = "UP";
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (!direction.equals("UP")) direction = "DOWN";
                    }
                    case KeyEvent.VK_LEFT -> {
                        if (!direction.equals("RIGHT")) direction = "LEFT";
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (!direction.equals("LEFT")) direction = "RIGHT";
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnel_header = new javax.swing.JPanel();
        lbl_picApple = new javax.swing.JLabel();
        lbl_point = new javax.swing.JLabel();
        pnel_play = new javax.swing.JPanel();
        pnel_top = new javax.swing.JPanel();
        pnel_right = new javax.swing.JPanel();
        pnel_buttom = new javax.swing.JPanel();
        pnel_left = new javax.swing.JPanel();
        pnel_playpnel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnel_header.setBackground(new java.awt.Color(254, 201, 160));

        lbl_picApple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applered_1.png"))); // NOI18N

        lbl_point.setFont(new java.awt.Font("IrisUPC", 1, 36)); // NOI18N
        lbl_point.setText("0");

        javax.swing.GroupLayout pnel_headerLayout = new javax.swing.GroupLayout(pnel_header);
        pnel_header.setLayout(pnel_headerLayout);
        pnel_headerLayout.setHorizontalGroup(
            pnel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_headerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_picApple, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_point)
                .addContainerGap(1079, Short.MAX_VALUE))
        );
        pnel_headerLayout.setVerticalGroup(
            pnel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_headerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_picApple)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_point)
                .addGap(32, 32, 32))
        );

        getContentPane().add(pnel_header, java.awt.BorderLayout.PAGE_START);

        pnel_play.setBackground(new java.awt.Color(240, 220, 173));

        pnel_top.setBackground(new java.awt.Color(255, 179, 0));

        javax.swing.GroupLayout pnel_topLayout = new javax.swing.GroupLayout(pnel_top);
        pnel_top.setLayout(pnel_topLayout);
        pnel_topLayout.setHorizontalGroup(
            pnel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        pnel_topLayout.setVerticalGroup(
            pnel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnel_right.setBackground(new java.awt.Color(255, 179, 0));

        javax.swing.GroupLayout pnel_rightLayout = new javax.swing.GroupLayout(pnel_right);
        pnel_right.setLayout(pnel_rightLayout);
        pnel_rightLayout.setHorizontalGroup(
            pnel_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnel_rightLayout.setVerticalGroup(
            pnel_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        pnel_buttom.setBackground(new java.awt.Color(255, 179, 0));

        javax.swing.GroupLayout pnel_buttomLayout = new javax.swing.GroupLayout(pnel_buttom);
        pnel_buttom.setLayout(pnel_buttomLayout);
        pnel_buttomLayout.setHorizontalGroup(
            pnel_buttomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        pnel_buttomLayout.setVerticalGroup(
            pnel_buttomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnel_left.setBackground(new java.awt.Color(255, 179, 0));
        pnel_left.setToolTipText("");

        javax.swing.GroupLayout pnel_leftLayout = new javax.swing.GroupLayout(pnel_left);
        pnel_left.setLayout(pnel_leftLayout);
        pnel_leftLayout.setHorizontalGroup(
            pnel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnel_leftLayout.setVerticalGroup(
            pnel_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        pnel_playpnel.setPreferredSize(new java.awt.Dimension(23, 20));
        pnel_playpnel.setRequestFocusEnabled(false);
        pnel_playpnel.setLayout(new java.awt.GridLayout(23, 23));

        javax.swing.GroupLayout pnel_playLayout = new javax.swing.GroupLayout(pnel_play);
        pnel_play.setLayout(pnel_playLayout);
        pnel_playLayout.setHorizontalGroup(
            pnel_playLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnel_playLayout.createSequentialGroup()
                .addComponent(pnel_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(987, 987, 987)
                .addComponent(pnel_right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnel_buttom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pnel_playLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_playLayout.createSequentialGroup()
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(pnel_playpnel, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(102, Short.MAX_VALUE)))
        );
        pnel_playLayout.setVerticalGroup(
            pnel_playLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnel_playLayout.createSequentialGroup()
                .addComponent(pnel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnel_playLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnel_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnel_right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(pnel_buttom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnel_playLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnel_playLayout.createSequentialGroup()
                    .addContainerGap(98, Short.MAX_VALUE)
                    .addComponent(pnel_playpnel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        getContentPane().add(pnel_play, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EasyGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EasyGame().setVisible(true);
            }
        });
    }

    private List<Point> snakeBody; // ตำแหน่งของงู
    private Point food; // ตำแหน่งของอาหาร
    private String direction = "RIGHT"; // ทิศทางเริ่มต้น
    private Timer timer; // ตัวจับเวลา
    private final int GRID_SIZE = 23; // ขนาดของกริด

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_picApple;
    private javax.swing.JLabel lbl_point;
    private javax.swing.JPanel pnel_buttom;
    private javax.swing.JPanel pnel_header;
    private javax.swing.JPanel pnel_left;
    private javax.swing.JPanel pnel_play;
    private javax.swing.JPanel pnel_playpnel;
    private javax.swing.JPanel pnel_right;
    private javax.swing.JPanel pnel_top;
    // End of variables declaration//GEN-END:variables
}