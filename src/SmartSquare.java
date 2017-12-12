import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SmartSquare extends GameSquare
{
	private int count;
	private String[] filename ;
	private boolean sqRevealed = false;
	
	private boolean thisSquareHasMich = false;
	public static final int MINE_PROBABILITY = 10;

//	SmartSquare covers all the squares in blank 
	public SmartSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);        

		Random r = new Random();
		thisSquareHasMich = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	//  Checks Square for Mich and return true or false  
	public boolean Mich()
	{
        return(thisSquareHasMich);	             
	}
	
	/**
	 *This recursive meathod is called when the user clicks on the square Jbutton which unreveal the information on the square   
	 *
	 */
	public void clicked()
	{ 
     // The arrays Filename consist of the images location that will be displayed
	 //	when square is revealed
     	 
     //                              0   	          1              2         
	  filename = new String[] {"images/0.png", "images/1.png", "images/2.png",
			  //      3                4              5               6          
			  "images/3.png", "images/4.png", "images/5.png", "images/6.png", 
			  //    7               8
			  "images/7.png", "images/8.png"};
	  
	  count = 0;                 // used to keep track of surrounding Michigan Alumni
	  
	  // displays bobs if clicked at Michigan Alumni 
	  if(Mich() == true)                
	      {  
             board.getSquareAt((xLocation),(yLocation)).setImage("images/mich.png");
		 }
	     else
		 {
       //  when clicked on a square it checks the surrounding and displays the number 
	   // 	 of Mich Alum present in the surrounding
	   // and changed the sqRevealed to true once clicked
		 
	         for(int i = -1; i<=1; i++)
	         {
               for(int j = -1; j<=1; j++)
		       {  
		          SmartSquare square = (SmartSquare) board.getSquareAt((xLocation + i),
		        		  (yLocation + j));
				  
	             if(board.getSquareAt((xLocation + i),(yLocation + j)) != null)
			     {
			      if(square.Mich() == true ){  
				     count++;
			        }
		        }		
		       }
	        }
	  
	         board.getSquareAt((xLocation),(yLocation)).setImage(filename[count]); 
	         sqRevealed = true;
	
	/**This is used to reveal the unclicked surrounding square if a square
	 *  has no Mich/s surrounding it and also its adjacent squares  
	  *
	  */
            if(count ==0)
		    {	  
                  for(int i = -1; i<=1; i++)
	               {
                    for(int j = -1; j<=1; j++)
		            { 
		              SmartSquare r_square = (SmartSquare) 
		            		  board.getSquareAt((xLocation + i),(yLocation + j));
	                 if(r_square != null)
				    {
						 if(r_square.Mich() == false && r_square.sqRevealed == false )
					   {  		          
					    r_square.clicked();              // recursive clicked() recalled 
			           }                                                                     
		            }	
		         }
	           }
	 	
	        }
	  
	    }  // else ends 
	}
}