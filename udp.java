import java.io.*; 
import java.net.*; 
class udpser 
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket serversocket=new DatagramSocket(9876);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		byte[] receiveData=new byte[1024];
		byte[] sendData=new byte[1024];
		DatagramPacket receivePacket=new DatagramPacket (receiveData,receiveData.length); 
		serversocket.receive(receivePacket);
String sentence=new String(receivePacket.getData());        System.out.println("RECEIVED:"+sentence); 
                        InetAddress IPaddress=receivePacket.getAddress(); 
		int port=receivePacket.getPort(); 
		System.out.println("enter the message");
		String data=br.readLine(); 
		sendData=data.getBytes();
DatagramPacket sendPacket=new  DatagramPacket(sendData,sendData.length,IPaddress,port); 
		serversocket.send(sendPacket);
		serversocket.close();

	}

}

UDP Client  program


import java.io.*; 
import java.net.*; 
class udpcl
{
	public static void main(String[]args)throws Exception
    	{
       		BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
       		DatagramSocket clientsocket=new DatagramSocket();
		InetAddress IPaddress=InetAddress.getByName("localhost");
        		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
        		String sentence="hello server"; 		
        		sendData=sentence.getBytes();
               DatagramPacket sendPacket=new DatagramPacket (sendData,sendData.length,IPaddress,9876); 
        		clientsocket.send(sendPacket);
	DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length); 


TCP Client  program

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


 	clientsocket.receive(receivePacket);
	String modifiedsentence=new String(receivePacket.getData()); 	   		System.out.println("FROM SERVER:" +modifiedsentence); 
	clientsocket.close();
    }
