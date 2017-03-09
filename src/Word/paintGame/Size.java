/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word.paintGame;

/**
 *
 * @author witold
 */
public class Size {
     private int scale; 
     private int width ; 
     private int higth ; 
     private char[][] field ; 
     
     Size(char[][] field, int scale, int width, int higth){
        this.scale = scale; 
        this.width = width;  
        this.higth = higth;
        this.field = field; 
     }
     
     public int getScale(){
         return this.scale; 
     }
     
     public int getWidth(){
         return this.width; 
     }
     
     public int getHigth(){
         return this.higth; 
     }
     
     public char getChar(int x, int y){
         return this.field[y][x]; 
     }
     
     public void setField(char[][] field){
        this.field = field; 
     }
}