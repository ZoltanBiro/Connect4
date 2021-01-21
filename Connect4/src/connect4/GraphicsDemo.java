/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import java.awt.*;
import javax.swing.*;

public class GraphicsDemo extends JPanel {
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        this.setBackground(Color.white);        
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setColor(Color.blue);
        g2D.fillRect(100,100,1200,700);   
        g2D.setColor(Color.white);
        for (int i=0; i<7; i++){
            for (int h=0;h<6;h++){
                g2D.fillOval(135+171*i, 110+116*h, 100, 100);
        }}        
    }
    
    public void drawpiece(Graphics g){
        super.paintComponent(g);        
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.red);
        g2D.fillRect(200,200,200,200);
      
        
    }
}
