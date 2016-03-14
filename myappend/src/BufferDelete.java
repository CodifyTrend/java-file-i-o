import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class BufferDelete
{   
	public static void main(String args[])
	{	
   	  try{ 
   		 if(args.length!=3)
         {
         	System.out.println("provide all the arguments i.e file path start index end index");
         	System.exit(0);
         }
   		 Path p =Paths.get(args[0]);
		 SeekableByteChannel sbc=  Files.newByteChannel(p,StandardOpenOption.READ,StandardOpenOption.WRITE);     
   	   	long start=Long.parseLong(args[1]);   	
        long end=Long.parseLong(args[2]); 
        long dif=end-start;
        long i=start,j=end;
       
        if(start<0)
        {
        	System.out.println("start index cannot be neagtive i.e less than 0");
        	System.exit(0);
        	
        }
        if(end>  sbc.size()  )
        {
        	System.out.println("end index cannot be greater than file size");
        	System.exit(0);
        }
        if(start>=end)
        {
        	System.out.println("start index cannot be greater than or equal to end index");
        	System.exit(0);	
        }
      
                  ByteBuffer bb= ByteBuffer.allocate(1);
		    for(long l=0;l<( sbc.size()-dif);l++)
		    { 	
		      sbc.position(end); 	
		     bb.clear();
		      sbc.read(bb);
		      sbc.position(start);
		      bb.flip();
		      sbc.write(bb);
		      end++;start++;
		    }
   	          sbc.truncate(sbc.size()-dif);
   	        sbc.close();
   	        System.out.println("data bytes from "+i+" to "+j+" are successfully deleted");
   	        
          }catch(Exception e)
           { 
        	System.out.println("enter vaild file path for reading and deletion");
        	e.printStackTrace();
           }
	}
}
