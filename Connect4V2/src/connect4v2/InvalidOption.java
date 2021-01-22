/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4v2;

// Hi Ms luce, I made a custom exception I'm pretty sure it made my code less efficient but hey, it's another aspect/layer of complexity

class InvalidOption extends Exception {
  InvalidOption(String s){  
  super(s);
  }
}

