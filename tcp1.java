import java.net.*;
import java.io.*;
public class tcpser 
{
    public static void main(String args[])throws Exception
    {
         ServerSocket sersock= new ServerSocket(4000);
         System.out.println("sever ready for connection");
         Socket sock=sersock.accept();
         System.out.println("connection is successfull and waiting to serve");
         InputStream istream=sock.getInputStream();
 BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
         String fname=fileRead.readLine();
      BufferedReader contentRead=new BufferedReader(new FileReader(fname));
         OutputStream ostream=sock.getOutputStream();
         PrintWriter pwrite=new PrintWriter(ostream,true);
         String str;
         while((str=contentRead.readLine())!=null)
         {
            pwrite.println(str);


         }
	
    }
}


/*TCP Client program*/

import java.net.*; 
import java.io.*;

public class tcpcl 
{
     public static void main(String args[])throws Exception
     {
          Socket sock=new Socket("127.0.0.1",4000); 
	  System.out.println("enter the file name");
          BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in)); 
          String fname=keyRead.readLine();
          OutputStream ostream=sock.getOutputStream(); 
          PrintWriter pwrite=new PrintWriter(ostream,true); 
          pwrite.println(fname);
          InputStream istream=sock.getInputStream();
          BufferedReader SocketRead=new BufferedReader(new InputStreamReader(istream)); 
          String str;
          while((str=SocketRead.readLine())!=null)
         {
             System.out.println(str); 
	 }
         pwrite.close(); 
         SocketRead.close(); 
         keyRead.close();    
    }
}

