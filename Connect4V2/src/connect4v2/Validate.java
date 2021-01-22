/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;

// Hi Ms luce, I made a custom exception I'm pretty sure it made my code less efficient but hey, it's another aspect/layer of complexity

class Validate {
    public static void isAnOption(int opt) throws InvalidOption {
        if (opt>1 || opt<=0) {
            throw new InvalidOption("Number is invalid");
        }        
    }
    public static void isASlot(int slot,State [][] board) throws InvalidSlot{
        if (slot<0||slot>7){
            throw new InvalidSlot("Slot is invalid");
        }
        if (board[slot-1][5]!=State.O){
            throw new InvalidSlot("Slot is invalid");
        }
    }
}
