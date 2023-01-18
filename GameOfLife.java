/*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This program simulates the Game of Life on a 20 x 20 grid.*/
import java.util.Scanner;
import java.io.*;
import java.*;

class GameOfLifeMadeline{
  public static void main(String[]arg){
    Game obj1 = new Game();
    obj1.play();
  }
}

/*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This class simulates the Game of Life on a 20 x 20 grid.*/
class Game{
  Scanner in = new Scanner(System.in);
  int play, cells, gen;
  int life[][] = new int [20][20];
  
/*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method introduces the Game of Life on a 20 x 20 grid.
 * @Return: void     @Param: n/a                           */
  public void play(){
    System.out.println("Welcome to the game of life!\nPlease enter how many "
                         +"cells you wish to start the game with.");
    cells = in.nextInt();
    for(int x = 0; x < 20; x++){
      for (int y = 0; y < 20; y++){
        life[x][y] = 0;        
      }
    }
    generationZero(cells);
  }
  /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method simulates the initial generation of the Game of Life.
 * @Return: void     @Param: int                           */
  public void generationZero(int cells){
    for(int a = 0; a < cells; a++){
          life[(int)(Math.random()*20)][(int)(Math.random()*20)] = 1;         
    
  }
    System.out.println("----Generation 0-----------------------------");
      
    for(int x = 0; x < 20; x++){
      for (int y = 0; y < 20; y++){
        if(life[x][y] == 0){          
          System.out.print(".");
        }        
          else
         System.out.print("o");
        }
      System.out.println();
    
      }
    
  grow();
  }
  
  /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method if they want to contine or exit the Game of Life.
 * @Return: void     @Param: n/a                           */
  public void grow(){
    System.out.println("1 - Advance one generation\n"
                         +"0 - Exit");
    
           play = in.nextInt();
      
    
    if (play == 0){
    play=0;
    exit();
    
    }
    else if (play!=0&&play == 1){
    gen++; 
    nextGen();
    }
    else{
     System.out.println("The input was invalid. Try Again");
     grow();
    }
  }
    /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method simulates the next generation of the Game of Life.
 * @Return: void     @Param: n/a                           */
  public void nextGen(){
    int check [][] = new int [20][20];
    for (int x = 0; x < 20; x++) {
      for (int y = 0; y < 20; y++) {
        check[x][y] = life[x][y];
        
        int neighbours = 0;
        
        //checking top row for neighbours
        if(y!=0){
        if (x!=0&&check[x-1][y-1] == 1)
          neighbours=neighbours+neighbours;
        if (check[x][y-1] == 1)
          neighbours=neighbours+neighbours;
        if (x!=19&&check[x+1][y-1] == 1) 
          neighbours=neighbours+neighbours;
         }
        
        
        //checking middle row for neighbours
        
        if (x!=0&&check[x-1][y] == 1)
          neighbours=neighbours+neighbours;        
        if (x!=19&& check[x+1][y] == 1) 
          neighbours=neighbours+neighbours;
         
        
        
        //checking bottom row for neighbours
        
        if (y!=19&&x!=0&&check[x-1][y+1] == 1)
          neighbours=neighbours+neighbours;
        if (y<19&&check[x][y+1] == 1)
          neighbours=neighbours+neighbours;
        if (y<19&&x!=19&&check[x+1][y+1] == 1) 
          neighbours=neighbours+neighbours;
        
        change(neighbours, check);
      }}}
         
  /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method determines the next generation of the Game of Life.
 * @Return: void     @Param: int, int[][]                           */
  public void change(int neighbours, int[][] check){
    for (int x = 0; x < 20; x++) {
      for (int y = 0; y < 20; y++) {
        
        //If a cell is alive and it has two or three neighbours, 
        //it will continue to live the next day; otherwise, it will die.
        if(check[x][y] == 1 && neighbours == 2||check[x][y] == 1 && neighbours == 3)
          check[x][y] = 1;
        else
          check[x][y] = 0;
        
        //If a cell is not alive and it has exactly three neighbours,
        //it will be born the next day; otherwise, it remains not alive.
        if(check[x][y] == 0 && neighbours == 3)
          check[x][y] = 1;
        else
          check[x][y] = 0;
        
        life[x][y] = check[x][y];
        }}
        printGen();
      }
      
     
  

  
  
  /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method prints the next generation of the Game of Life.
 * @Return: void     @Param: n/a                           */
  public void printGen(){
  System.out.printf("----Generation %d-----------------------------\n", gen);
      
    for(int x = 0; x < 20; x++){
      for (int y = 0; y < 20; y++){
        if(life[x][y] == 0){          
          System.out.print(".");
        }        
          else
         System.out.print("o");
        }
      System.out.println();
    
      }
    
  grow();
  
  
  
  }
    /*@Author:    Madeline Pinto       @Date: September 23 2021
 * 
 * This method exits the Game of Life.
 * @Return: void     @Param: n/a                           */
  public void exit(){
  System.out.println("Goodbye.");
  }
}

  



  
  

    
      

     
        