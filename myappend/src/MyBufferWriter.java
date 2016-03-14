import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class MyBufferWriter
{
	public static void main(String args[])
	{	   	int leng=args.length,j; long l; int k=1;
	try{
		   if((args.length)%2!=0)
		    {
			   System.out.println("provide both the arguments at cmd");
			   System.exit(0);
		    }
		   for(j=0;j<leng;j=j+2)
			  {		  
		      l=Long.parseLong(args[j+1]);	
			if(l==0)
		    {
			   System.out.println("file no "+k+" size is zero enter valid size");
			   System.exit(0);
		    }
			if(l<0)
			{
				System.out.println("file no "+k+" size is neagtive enter valid size");
				System.exit(0);
			}
			
			if(l>1073741824)
			{
				System.out.println("file no "+k+" size is greater than 1GB enter valid size");
				System.exit(0);
			}		
		
			 k++;
			 
			 Path file = Paths.get(args[j]);
		        FileChannel fc=FileChannel.open(file,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		      
		        ByteBuffer buf = ByteBuffer.allocate(15);
		    
		      
		        for(long n=0;n<l;n=n+15)
		      { 	
		            buf.clear();
		        buf.put( "writing data...".getBytes());

		        buf.flip();

		        while(buf.hasRemaining()) {
		            fc.write(buf);
		        }
		      } 
		        fc.close(); 		 
         
		
	      }
			  System.out.println("data write successfully for "+leng/2+ " files");
        } catch(Exception e)
		{
        	System.out.println("enter valid path of file"); 
        	e.printStackTrace();
		}
	}//end of main
}//end of class
