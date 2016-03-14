import java.io.File;
import java.io.RandomAccessFile;
public class DirectDelete
{   
	public static void main(String args[])
	{	
   	  try{ 
   		 if(args.length!=3)
         {
         	System.out.println("provide all the arguments i.e file path start index end index");
         	System.exit(0);
         }
   		  
   		  byte b;
   	   	RandomAccessFile raf=new RandomAccessFile(new File(args[0]),"rw"); 
   	   	int start=Integer.parseInt(args[1]);   	
        int end=Integer.parseInt(args[2]); 
        int dif=end-start;
        int i=start,j=end;
       
        if(start<0)
        {
        	System.out.println("start index cannot be neagtive i.e less than 0");
        	System.exit(0);
        	
        }
        if(end>( (int)raf.length() ) )
        {
        	System.out.println("end index cannot be greater than file size");
        	System.exit(0);
        }
        if(start>=end)
        {
        	System.out.println("start index cannot be greater than or equal to end index");
        	System.exit(0);	
        }
     
		    for(long l=0;l<(raf.length()-dif);l++)
		    { 	
		      raf.seek(end); 
		      b=raf.readByte();
		      raf.seek(start);
		      raf.writeByte(b);
		      end++;start++;
		    }
   	         raf.setLength(raf.length()-dif);
   	        raf.close();
   	        System.out.println("data bytes from "+i+" to "+j+" are successfully deleted");
   	        
          }catch(Exception e)
           { 
        	System.out.println("enter vaild file path for reading and deletion");
        	e.printStackTrace();
           }
	}
}
