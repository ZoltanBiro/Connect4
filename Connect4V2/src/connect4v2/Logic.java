/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;
import java.util.ArrayList;

enum State {     //------HI MS LUCE----- here's my enum!!!
  O,r,y //stands for Enpty, Red, and Yellow
}
public class Logic {
    public int bod[];
    public State board[][] =   {{State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O},
                                {State.O,State.O,State.O,State.O,State.O,State.O}
                                };
    public Logic(){
    
    }
    
    public Boolean checkWin(int pos){
        return false;
    }
    
    public void addPiece(State colour, int place){
        place = place-1;
        for (int i=0; i< board[1].length; i++){ //HI MS LUCE, this is a quick LINEAR SEARCH that retreives the position of the first stop in the collum that is not empty.
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
}
