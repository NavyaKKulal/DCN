import java.math.*; 
import java.util.*; 
import java.util.Random; 	
import java.io.*;
import java.lang.*; 
public class leaky_bucket
{
     public static void main(String[]args)
     {
              int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0; 
	  int packet[]=new int[100];
	  Scanner in=new Scanner(System.in); 
	  System.out.print("Enter the bucket size:\n"); 
	  b_size=in.nextInt(); 
	  System.out.print("Enter output rate:\n"); 
	  o_rate=in.nextInt();
	  System.out.print("Enter the number of seconds to simulate:\n"); 		  
              nsec=in.nextInt();
	  Random rand=new Random(); 
              for(i=0;i<nsec;i++)
	  packet[i]=(rand.nextInt(1000));
              System.out.println("seconds|packet received|packet sent| packets left|packets dropped\n"); 
	  System.out.println("                   ");		
	  for(i=0;i<nsec;i++)
	  {
	       p_remain+=packet[i]; 
	       if(p_remain>b_size)
	       {
	            drop=p_remain-b_size; 
                        p_remain=b_size; 
		System.out.print(i+1         +"       "); 
		System.out.print(packet[i] +"                ");
	            mini=Math.min(p_remain,o_rate); 
                    	System.out.print(mini +"	                 "); 
p_remain=p_remain-mini; 
                    	System.out.print(p_remain+"           "); 
                    	System.out.println(drop +"	           "); 
                    	System.out.print("	           \n"); 
                       drop=0;
	       }
          }
          while(p_remain!=0)
          {
 if(p_remain>b_size)
	      	{
	          		drop=p_remain-b_size;
              	}
	      	mini=Math.min(p_remain,o_rate); 
              	System.out.print("              "+p_remain +"      	" +mini); 
              	p_remain=p_remain-mini;
              	System.out.println("            "+p_remain +"     	" +drop); 
              	drop=0;
          }
     }
}










