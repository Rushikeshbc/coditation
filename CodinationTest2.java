/* */

import java.util.*;

class CodinationTest2
  {
          // METHOD FOR NEXT GENRATION
      public void nextMove(int grid[][],int x,int y)
         {
             int[][] future=new int[x][y];                  //INTEGER ARRAY FOR STORING NEXT GENERATION
  
             for(int i=1;i<x-1;i++)                       //LOOP THROUGH EVERY CELL
                 {
                   for(int j=1;j<y-1;j++)
                     {
                        int aliveNeig=0;                //DECLARE AND ASSIGN VALUE FOR ALIVE NEIGHBOR
                         for(int k=-1;k<=1;k++)        //finding ALIVE NEIGHBOUR
                            {
                             for(int l=-1;l<=1;l++)
                                  aliveNeig+=grid[i+k][j+l];
                             }
                         aliveNeig-=grid[i][j];          //CELL NEED TO BE SUBSTRACTED WHICH IS COUNTED BEFORE
                     
                        // GIVEN CONDITION FOR NEXT GENERATION

                        // CELL LONELY AND DIES
                         if((grid[i][j]==1)&&(aliveNeig<2))
                              future[i][j]=0;

  
                        //CELL DIES DUE TO OVER CROWDING
                         else if((grid[i][j]==1)&&(aliveNeig>3))
                               future[i][j]=0;
                     
                      // NEW CELL
                         else if((grid[i][j]==0)&&(aliveNeig==3))
                               future[i][j]=1;


                     // REMAIN THE SAME
                        else
                           future[i][j]=grid[i][j];
                     }
                } 

             //PRINTING THE NEXT GENERATION  
            System.out.println("Next Generation");
            for(int e=0;e<x;e++)
              {
                for(int f=0;f<y;f++)
                 {
                   if(future[e][f]==0)
                     System.out.print("D"+" ");
                  else
                     System.out.print("L"+" "); 
                  }
                 System.out.println();
              }
          }

     //MAIN METHOD

   public static void main(String args[])
  	 {
           Scanner sc=new Scanner(System.in);
           int x=10;            //VARIABLE DECLARATION ACCORDING TO SIZE
           int y=10;

       //INITILIZE THE GRID

         int[][] grid={{0,0,0,0,0,0,0,0,0,0},
                      {0,0,0,0,0,1,1,0,0,0},
                       {0,0,0,0,0,0,1,0,0,0}, 
                        {0,0,0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0,0,0},
                        {0,0,1,1,0,0,0,0,0,0},
			 {0,0,0,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}};
   while(true){
      System.out.print("1) Print the Current Generation ");
      System.out.print("\n2) Print The Next Generation");
        System.out.print("\n3) Exit the Program ");
      System.out.print("\nEnter Your Choice :");
            
           int ch;
          ch=sc.nextInt();
    switch(ch){
   

            case 1:
               System.out.println("Orirginal");
      //PRINTING THE GRID
            for(int i=0;i<x;i++)
               {
                 for(int j=0;j<y;j++)
                     {
                        if(grid[i][j]==0)
                              System.out.print("D"+" ");     // D FOR DEAD
                        else
                               System.out.print("L"+" ");     // L FOR ALIVE
                     }System.out.println();
               }
             System.out.println();
             break;
         case 2:
                CodinationTest2 obj=new CodinationTest2();     // OBJECT CREATION
                obj.nextMove(grid,x,y); 
                   break;                     // METHOD CALL FOR NEXT GENERATION
         case 3:
               return;
            }     
     } 
   	 }
}