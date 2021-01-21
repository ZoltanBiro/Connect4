/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame{

    GraphicsDemo graphicDemo = new GraphicsDemo();
    Piece p = new Piece();
    
    public MyFrame(){
        Graphics g = getGraphics();

        this.setSize(1400,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicDemo);
        
        
        
        this.setVisible(true);
        this.add(p);
        GraphicsDemo graphicDemo = new GraphicsDemo();

    }
    
    
}
