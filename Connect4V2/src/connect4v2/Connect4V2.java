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
        int gameNum = 1;
        boolean stay = true;
        do{
        int option = menu();
        if (option ==1){
            play(gameNum);
            gameNum++;
        }
        else if (option ==2){
            rules();
        }
        else if(option ==3){
            System.out.println("Bye Bye");
            stay =false;
        }
        else if (option ==4){
            System.out.println("The First row can be played "+ ((fac(4)*fac(3))-4) +" without anyone winning?\n");
        }        
        }while (stay);
    }
    
    public static int fac(int base){ //recursion
      if (base == 0){    
        return 1;    
      }
      else {   
        return(base * fac(base-1)); 
      }
    }
    
    public static void rules(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nRules----");
        System.out.println("Take turns dropping pieces to connect 4\nYour pieces will fall to the bottom of the board\nYou will win by getting 4 of your colour in a row\nTo place a piece press the numberd slot of the place you want to put it");
        System.out.print("\nEnter anything to continue: ");
        in.nextLine();
    }
    public static int menu(){
        Scanner in = new Scanner(System.in);
        int option=0;
        System.out.println("------Welcome to Connect 4!-------");
        System.out.println("Menu----");
        System.out.println("(1) Play game\n(2) Rules\n(3) Quit\n(4) Fun connect 4 facts to use advanced coding concepts");
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
        }while (option>4|| option<=0);
        return option;        
    }
    
    public static void play(int gNum){
        Logic game = new Logic(gNum);
        Scanner in = new Scanner(System.in);
        int option = 0;
        State win = State.O;
        int p=1;
        
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
        System.out.print("Would you like a copy of the board? yes(1) no(2): ");
        do{
        try{
            option = in.nextInt();
            try{
                Validate.isAnOption(option);
                game.outputBoard();
                break;
            }
            catch(InvalidOption e){
                System.out.print("\nPlease choose 1 or 2: ");    
            }
        }
        catch(Exception e){
            System.out.print("\nPlease only input a number: ");
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