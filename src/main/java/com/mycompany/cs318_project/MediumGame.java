/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cs318_project;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author peera
 */
public class MediumGame extends javax.swing.JFrame {

    /**
     * Creates new form EasyGame
     */
    private final String playerName;
    public MediumGame(String playerName) {
    this.playerName = playerName;
    initComponents();
    initGame();
    initKeyListener();
    initDirectionAngles();
    }
    
    
    private void initGame() {
        loadAppleImage();
        snakeBody = new ArrayList<>();
        snakeBody.add(new Point(0, 0)); // จุดเริ่มต้นของงู
        spawnItems(); // สุ่มตำแหน่งอาหาร
        timer = new Timer(200, e -> moveSnake()); // ตั้ง Timer
        timer.start();
    }

    private void spawnItems() {
        Random rand = new Random();
        int appleType = rand.nextInt(3); 
        isRedApple = (appleType == 0); 

        int appleX = rand.nextInt(GRID_SIZE);
        int appleY = rand.nextInt(GRID_SIZE);
        apple = new Point(appleX, appleY);
        
        rocks = new ArrayList<>();
        for (int i = 0; i < 7; i++) { 
            int rockX = rand.nextInt(GRID_SIZE);
            int rockY = rand.nextInt(GRID_SIZE);
            Point rock = new Point(rockX, rockY);

            
            if (!snakeBody.contains(rock) && !rock.equals(redApple) && !rock.equals(greenApple)) {
                rocks.add(rock);
            }
        }
    }

    private void renderGame() {
    pnel_playpnel.removeAll();
    for (int y = 0; y < GRID_SIZE; y++) {
        for (int x = 0; x < GRID_SIZE; x++) {
            JLabel cell = new JLabel();
            cell.setOpaque(true); 
            cell.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0xFFE4CF)));
            
            Point point = new Point(x, y);
            if (point.equals(snakeBody.get(0))) {
                double angle = directionAngles.get(direction); // ดึงองศาของทิศทางปัจจุบัน
                ImageIcon rotatedHead = rotateIcon(snakeHeadIcon, angle); // หมุนภาพหัวงู
                cell.setIcon(rotatedHead);
                cell.setBackground(new Color(0xFFFBF1));
            } else if (snakeBody.contains(point)) {
                int index = snakeBody.indexOf(point);
                if (index % 2 == 1) {
                    cell.setIcon(snakeBodyDarkIcon);
                    cell.setBackground(new Color(0xFFFBF1));
                } else {
                    cell.setIcon(snakeBodyLightIcon);
                    cell.setBackground(new Color(0xFFFBF1));
                }
            } else if (point.equals(apple)) {
                if (isRedApple) {
                    cell.setIcon(radAppleIcon);
                    cell.setHorizontalAlignment(SwingConstants.CENTER); // จัดให้อยู่ตรงกลางแนวนอน
                    cell.setVerticalAlignment(SwingConstants.CENTER);
                    cell.setBackground(new Color(0xFFFBF1));
                  } else {
                    cell.setIcon(greenAppleIcon);
                    cell.setHorizontalAlignment(SwingConstants.CENTER); // จัดให้อยู่ตรงกลางแนวนอน
                    cell.setVerticalAlignment(SwingConstants.CENTER);
                    cell.setBackground(new Color(0xFFFBF1));
                }  
            } else if (rocks.contains(point)) {
                cell.setIcon(RockIcon);
                cell.setHorizontalAlignment(JLabel.CENTER); // จัดก้อนหินให้อยู่กลางแนวนอน
                cell.setVerticalAlignment(JLabel.CENTER);
                cell.setBackground(new Color(0xFFFBF1));
               
            } else {
                cell.setBackground(new Color(0xFFFBF1));
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

        
         if (newHead.x < 0 || newHead.x >= GRID_SIZE || newHead.y < 0 || newHead.y >= GRID_SIZE 
            || snakeBody.contains(newHead) || rocks.contains(newHead)) {
        timer.stop();
        String difficulty = "medium";
        javax.swing.JOptionPane.showMessageDialog(this, "Game Over");
         int finalScore = Integer.parseInt(lbl_point.getText());
            ScoreManager.saveScore(playerName, finalScore,difficulty); // บันทึกคะแนน
            Endgame endGamePage = new Endgame(playerName, finalScore,difficulty); // เปิดหน้าจอ Endgame
            
            endGamePage.setVisible(true);
            this.dispose();
        return;
        }

        snakeBody.add(0, newHead);

       
        if (newHead.equals(apple)) {
            if (isRedApple) {
                lbl_point.setText(String.valueOf(Integer.parseInt(lbl_point.getText()) + 1)); // แอปเปิ้ลแดง +1
            } else {
                lbl_point.setText(String.valueOf(Integer.parseInt(lbl_point.getText()) + 2)); // แอปเปิ้ลเขียว +2
        }
            spawnItems();
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
            java.util.logging.Logger.getLogger(MediumGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediumGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediumGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediumGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String playerName = "DefaultPlayer"; 
                new MediumGame(playerName).setVisible(true);
            }
        });
    }
     private ImageIcon rotateIcon(ImageIcon icon, double angle) {
    Image image = icon.getImage();
    int width = image.getWidth(null);
    int height = image.getHeight(null);

    BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = rotatedImage.createGraphics();

    // ตั้งค่าการหมุน
    g2d.rotate(Math.toRadians(angle), width / 2.0, height / 2.0);
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();

    return new ImageIcon(rotatedImage);
    }
    
    private Map<String, Double> directionAngles;

    private void initDirectionAngles() {
    directionAngles = new HashMap<>();
    directionAngles.put("UP", 0.0);       // หันขึ้น (0 องศา)
    directionAngles.put("DOWN", 180.0);  // หันลง (180 องศา)
    directionAngles.put("LEFT", 270.0);  // หันซ้าย (270 องศา)
    directionAngles.put("RIGHT", 90.0);  // หันขวา (90 องศา)
}
    private Point greenApple;
    private Point redApple;

    private List<Point> rocks;
    private List<Point> snakeBody; 
    
    private ImageIcon radAppleIcon;
    private ImageIcon greenAppleIcon;
    private ImageIcon snakeHeadIcon;
    private ImageIcon snakeBodyDarkIcon;
    private ImageIcon snakeBodyLightIcon;
    private ImageIcon RockIcon;

    private Point apple; 
    private boolean isRedApple; 
    private String direction = "RIGHT";
    private Timer timer;
    private final int GRID_SIZE = 23;
    
    private void loadAppleImage() {
    ImageIcon originalIconApple = new ImageIcon(getClass().getResource("/applered_1.png"));
    ImageIcon originalIconRock = new ImageIcon(getClass().getResource("/rock.png"));
    ImageIcon originalIconGreenApple = new ImageIcon(getClass().getResource("/applegreen.png"));
    ImageIcon originalIconhead = new ImageIcon(getClass().getResource("/snake_head.png"));
    ImageIcon originalIcondarkBody = new ImageIcon(getClass().getResource("/snake_body_dark.png"));
    ImageIcon originalIconLightBody = new ImageIcon(getClass().getResource("/snake_body_dark.png"));
    
   
    
    Image scaledImageApple = originalIconApple.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image scaledImageRock = originalIconRock.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    Image scaledGreenApple = originalIconGreenApple.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image scaledHead = originalIconhead.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image scaleddarkBody = originalIcondarkBody.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    Image scaledLightBody = originalIconLightBody.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    
    snakeHeadIcon = new ImageIcon(scaledHead); // เปลี่ยน path ตามไฟล์ของคุณ
    snakeBodyDarkIcon = new ImageIcon(scaleddarkBody);
    snakeBodyLightIcon = new ImageIcon(scaledLightBody);
    radAppleIcon = new ImageIcon(scaledImageApple);
    RockIcon = new ImageIcon(scaledImageRock);
    greenAppleIcon = new ImageIcon(scaledGreenApple);
  
    }
    
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
