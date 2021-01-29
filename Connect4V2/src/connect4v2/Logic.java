/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


enum State {     //------HI MS LUCE----- here's my enum!!!
  O,r,y //stands for Enpty, Red, and Yellow
}
public class Logic {
    int gameNumber;
    public State board[][] =   {{State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O}
                                };
    public Logic(int gNum){
        gameNumber = gNum;
    }
    
    public Boolean checkWin(int pos){
        pos = pos-1;
        boolean won=false;
        //get the height of the placed piece--------------- important variable
        int height = 5;
        for (int h=0; h<board[pos].length; h++){ //HI MS LUCE, this is a quick LINEAR SEARCH that retreives the position of the first stop in the collum that is not empty.
            if (board[pos][h]!=State.O){
                continue;
            }
            height = h-1;
            break;
        }       
        
        //vertical wins-------------------------
        int maxHeight=0;
        
        for (int i=0; i< 6; i++){ 
            if (board[pos][i] !=State.O){
                maxHeight++;
            }
        }
        if (maxHeight>3){
            for (int repeat =0 ;repeat<maxHeight-3;repeat++){
                if (board[pos][repeat]==board[pos][1+repeat]&& board[pos][repeat]==board[pos][2+repeat]&&board[pos][repeat]==board[pos][3+repeat]){
                    won = true;
                }
            }
        }
        //Horizontal wins----------------
        int maxLength =0;
        
        for (int i=0; i< 7; i++){ 
            if (board[i][height] !=State.O){
                maxLength++;
            }
        }
        if (maxLength>3){
            for (int repeat = 0;repeat<4;repeat++){
                if(board[repeat][height]==board[1+repeat][height]&& board[repeat][height]==board[2+repeat][height]&&board[repeat][height]==board[3+repeat][height]){
                    won = true;
                }
            }
        }
        
        //diagonal win: positive direction-------------------
        

        int minHeight =height;
        int minPos =0;    
        
        if (pos-height<4 && pos-height>-3){
            for (int i=pos; i>=0; i--){
                if (i==0||minHeight==0){                
                    minPos = i;
                    break;
                }            
            minHeight--;
            }            
            do{
                if (board[minPos][minHeight]==board[1+minPos][1+minHeight]&&board[minPos][minHeight]==board[2+minPos][2+minHeight]&&board[minPos][minHeight]==board[3+minPos][3+minHeight]&&board[minPos][minHeight]!=State.O){
                    won = true;
                }

                minHeight++; minPos++;

            }while(minHeight+3<=5 && minPos+3<=6);
        }      
        
        // diagonal win: negative direction-------------------
        minHeight =height;
        int maxPos =0;       
        if (pos+height>2 && pos+height<9){
            for (int i=pos; i<=6; i++){
                if (i==6||minHeight==0){
                    maxPos = i;
                    break;
                }            
            minHeight--;
            }
            //System.out.println("min negative "+maxPos+" "+minHeight);
            do{
                //System.out.println("max positive "+(maxPos-3)+" "+(minHeight+3) );
                if (board[maxPos][minHeight]==board[maxPos-1][1+minHeight] && board[maxPos][minHeight]==board[maxPos-2][2+minHeight] && board[maxPos][minHeight]==board[maxPos-3][3+minHeight]&&board[maxPos][minHeight]!=State.O){
                    won = true;
                    break;
                }
                minHeight++; maxPos--;
            }while(minHeight+3<=5&&maxPos-3>=0);
        }     
        
        return won;
    }
    
    public void addPiece(State colour, int place){
        place = place-1;
        for (int i=0; i< board[0].length; i++){ //HI MS LUCE, this is a quick LINEAR SEARCH that retreives the position of the first stop in the collum that is not empty.
            if (board[place][i]!=State.O){
                continue;
            }
            board[place][i]=colour;
            break;
        }   
}
    
    public void drawBoard(){
        System.out.println();
        for (int row = 5; row>=0; row--){
            for (int col=0; col<=6; col++){
                System.out.print(board[col][row]+"\t");
            }
            System.out.println();                
        }
    }
    public void outputBoard(){
        try {
            FileWriter myWriter = new FileWriter("Board"+gameNumber+".txt");
            for (int row = 5; row>=0; row--){
                for (int col=0; col<=6; col++){
                    myWriter.write(board[col][row]+"\t");
                }
                myWriter.write("\n");                
            }
            myWriter.close();
        } 
        catch (IOException e) {
            System.out.println("We could not write that print your board.");
            e.printStackTrace();
        }
    }
}
