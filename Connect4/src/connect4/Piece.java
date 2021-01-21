/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Zoltan
 */
public class Piece extends JPanel {
     public void paintComponent(Graphics g){
        
        super.paintComponent(g);        
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.red);
        g2D.fillRect(200,200,200,200);
        }       
    }

