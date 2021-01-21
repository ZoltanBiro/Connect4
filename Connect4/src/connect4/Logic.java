/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import java.util.ArrayList;


public class Logic {
    ArrayList<Integer> board = new ArrayList<Integer>();
    public Logic(ArrayList<Integer> a){
        board = a;
    }
    
    public static Boolean checkWin(int pos){
        return false;
    }
    
}
