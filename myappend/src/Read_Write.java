import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

 class Read_Write 
{

	public static void main(String[] args) throws Exception
	{
     performw p=new performw();
     performr p1=new performr();
     File f1,f2;
     long len;
     f1=new File(args[0]);
     len=Long.parseLong(args[1]);
     f2=new File(args[2]);
     Scanner sc=new Scanner(System.in);
     System.out.println("1. Byte Streams:FileInput/OutputStream\n"
     		            + "2. Character Stream: FileReader/Writer\n"
     		            + " 3. Buffered Stream: BufferedReader/Writer\n"
     		            + "4. DataInput/OutputStream\n"
     		            +"5. Use write/readObject");
     System.out.println("enter your choice");
     int choice=sc.nextInt(); 
     switch(choice)
     {
     case 1:
    	 p.start();
    	 p.write_fout(f1,len);
    	 p1.start();
    	 p1.read_fin(f2);
    	 break;
     case 2:
    	 p.start();
    	 p.write_fchar(f1,len);
    	 p1.start();
    	 p1.read_fchar(f2);
    	 break;
     case 3:
    	 p.start();
    	 p.write_buffer(f1,len);
    	 p1.start();
    	 p1.read_buffer(f2);
    	 break;
     case 4:
    	 p.start();
    	 p.write_datastream(f1,len);
    	 p1.start();
    	 p1.read_datastream(f2);
    	 break;
     case 5:
    	 p.start();
     	 p.write_object(f1,len);
    	 p1.start();
    	 p1.read_object(f2);
    	 break;
    	 default:
         System.out.println("wrong choice");
     
     }
     
    sc.close(); 
	}
 
}
class performw extends Thread
{
  public void write_fout(File f1,long l) throws FileNotFoundException,IOException
  { 
	  FileOutputStream fo=new FileOutputStream(f1,true);  
	  for(long i=0;i<l;i++)
		  fo.write("h".getBytes());
	     fo.close();
  }
  public void write_fchar(File f1,long l) throws FileNotFoundException,IOException
  {  
	  FileWriter fo=new FileWriter(f1,true); 
	  for(long i=0;i<l;i++)
		  fo.write('b');
	     fo.close();
  }
  public void write_buffer(File f1,long l) throws FileNotFoundException,IOException
  {
	  FileOutputStream fo=new FileOutputStream(f1,true);
	  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fo));
	  for(long i=0;i<l;i++)
	  {
		  bw.write('b');
		  bw.newLine();
	  }
	  fo.close();
  }
    public void write_datastream(File f1,long l) throws Exception
   {
    	DataOutputStream dos=new DataOutputStream(new FileOutputStream(f1,true));
    
    	  for(long i=0;i<l;i=i+5)
    	   dos.write("hello".getBytes());
    	  dos.close();
    }
    public void write_object(File f1,long l) throws Exception
    {  
    	ObjectOutputStream ob= new ObjectOutputStream((new FileOutputStream(f1,true)));
    	  ob.write(2);
    	 ob.close();
    	
    }

}
class performr extends Thread
{
	public void read_fin(File f2) throws Exception
	  {
		 FileInputStream fi=new FileInputStream(f2);
		 int c;
		 while((c=fi.read())!=-1)
		 {
			 System.out.print((char)c);
		 }
		  fi.close();
	  }
	public void read_fchar(File f2) throws Exception
	  {
		 FileReader fi=new FileReader(f2);
		 int c;
		 while((c=fi.read())!=-1)
		 {
			 System.out.print((char)c);
		 }
		  fi.close();
	  }
	public void read_buffer(File f2) throws Exception
	  {
		 FileInputStream fi=new FileInputStream(f2);
		 BufferedReader br=new BufferedReader(new InputStreamReader(fi));
		 int c;
		 while((c=br.read())!=-1)
		 {
			 System.out.print((char)c);
		 }
		  fi.close();
	  }
	public void read_datastream(File f2) throws Exception
	{
	DataInputStream dis=new DataInputStream(new FileInputStream(f2));
	while(  dis.available()>0 )
	System.out.print((char)dis.read());	
	dis.close();
	}
	public void read_object(File f2) throws Exception
	{
		
		ObjectInputStream ob= new ObjectInputStream(new FileInputStream(f2));
		
		while(ob.available()>0)
		{	
			System.out.print(ob.read());	
		}
		ob.close();
	}
	
}

