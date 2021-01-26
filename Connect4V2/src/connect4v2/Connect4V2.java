/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;

import java.util.Scanner;



public class Connect4V2 {
        Scanner in = new Scanner(System.in);

        
    public static void main(String[] args) {
        int option = menu();
        if (option ==1){
            play();
        }
    }
    
    public static int menu(){
        Scanner in = new Scanner(System.in);
        int option=0;
        System.out.println("------Welcome to Connect 4!-------");
        System.out.println("Menu----");
        System.out.println("(1) play game");
        do{
            System.out.print("Choose an option: ");
            try{
                option = in.nextInt(); 
                Validate a = new Validate();
                try{
                    Validate.isAnOption(option);
                }
                catch(InvalidOption e){
                    System.out.println("\nPlease choose one of the options listed");
                }
            }
            catch(Exception e){
            System.out.println("\nPlease only enter a number");
            in.next();
            }        
        }while (option>1|| option<=0);
        return option;        
    }
    public static void play(){
        Logic game = new Logic();
        Scanner in = new Scanner(System.in);
        int option = 0;
        State win = State.O;
        int p =1;
        
        do{
            game.drawBoard();

            System.out.println("Player "+p +" it's your turn.");

            do{
            System.out.print("Which column would you like to pick: ");
                try{
                    option = in.nextInt();                    
                    try{
                        Validate.isASlot(option,game.board);
                        
                        if (p==1){
                            p=2;
                            game.addPiece(State.r,option);
                            if(game.checkWin(option)){
                                win=State.r;
                            }
                        }
                        else if (p==2){
                            p=1;
                            game.addPiece(State.y,option);
                            if(game.checkWin(option)){
                                win=State.y;
                            }
                        }
                    }
                    catch(InvalidSlot f){
                        System.out.println("\nThis is an invalid slot.");
                    }
                }
                catch(Exception f){
                    System.out.println("\nPlease only enter a number.");
                    in.next(); 
                }    
            }while (option>7|| option<1); 
            
        }while(win==State.O);
        game.drawBoard();
        winMessage(win);
        System.out.println("Would you like a copy of the board? yes(1) no(2): ");
        do{
        try{
            option = in.nextInt();
            try{
                Validate.isAnOption(option);
                game.outputBoard();
                break;
            }
            catch(InvalidOption e){
                System.out.println("\nPlease choose 1 or 2");    
            }
        }
        catch(Exception e){
            System.out.println("\nPlease only input a number.");
            in.next();
        }
        }while(option!=1);
    }
   
    public static void winMessage(State winner){
        int winna=0;
        if (winner == State.r){
            winna =1;
        }
        else{
            winna =2;
        }
        System.out.println("-------Congradulations!---------");
        System.out.println("Player "+winna+" wins!");
    }
    
    
    
}