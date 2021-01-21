/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;

import java.util.Scanner;

/**
 *
 * @author Zoltan
 */
public class Connect4V2 {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("------Welcome to Connect 4!-------");
        System.out.println("Menu-----");
        System.out.println("(1) Play Game)");  
        String opt = in.nextLine();
        System.out.println(opt);

    }
    
}
