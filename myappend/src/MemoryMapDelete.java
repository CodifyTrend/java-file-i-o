import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class MemoryMapDelete
{   
	public static void main(String args[])
	{	
   	  try{ 
   		 if(args.length!=3)
         {
         	System.out.println("provide all the arguments i.e file path start index end index");
         	System.exit(0);
         }
   		 Path p =Paths.get(args[0]);  byte b;
   		 SeekableByteChannel sbc=  Files.newByteChannel(p,StandardOpenOption.READ,StandardOpenOption.WRITE);
		  FileChannel fc=(FileChannel)sbc;
		  MappedByteBuffer mbb=fc.map(MapMode.READ_WRITE, 0,sbc.size());
	   
   	   	int start=Integer.parseInt(args[1]);   	
        int end=Integer.parseInt(args[2]); 
        int dif=end-start;
        int i=start,j=end;
       
        if(start<0)
        {
        	System.out.println("start index cannot be neagtive i.e less than 0");
        	System.exit(0);
        	
        }
        if(end>mbb.capacity() )
        {
        	System.out.println("end index cannot be greater than file size");
        	System.exit(0);
        }
        if(start>=end)
        {
        	System.out.println("start index cannot be greater than or equal to end index");
        	System.exit(0);	
        }
      
      
		    for(long l=0;l<( mbb.capacity()-dif);l++)
		    { 	
		      mbb.position(end); 	
		     mbb.clear();
		     b= mbb.get();
		      mbb.position( start);
		      mbb.flip();
		      mbb.put(b);
		      end++;start++;
		    }
   	          sbc.truncate(mbb.capacity()-dif);
   	         
   	        sbc.close();
   	        System.out.println("data bytes from "+i+" to "+j+" are successfully deleted");
   	        
          }catch(Exception e)
           { 
        	System.out.println("enter vaild file path for reading and deletion");
        	e.printStackTrace();
           }
	}
}
