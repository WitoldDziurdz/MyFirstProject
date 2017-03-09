/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Word;

/**
 *
 * @author witold
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
       int a =22; 
       int b =22; 
       int w = 30; 
       if(a<0||b<0||w<0){
         throw new MyException("Niepoprawny rozmiar swiata");
       }
       World W = new World(a,b,w); 
       Contener B = new Contener(W); 
       W.conectionContener(B);
       W.nextRound();
       W.visiable();
        }
        catch(MyException ex){
             System.out.print(ex.toString()); 
        }
    }
}
