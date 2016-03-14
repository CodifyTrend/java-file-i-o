
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class BufferAppend
{
	public static void main(String args[])
	{	   	 long  l=Long.parseLong(args[1]);	
	try{
		   if((args.length)%2!=0)
		    {
			   System.out.println("provide both the arguments at cmd");
			   System.exit(0);
		    }		    
			if(l==0)
		    {
			   System.out.println("file size is zero enter valid size");
			   System.exit(0);
		    }
			if(l<0)
			{
				System.out.println("file size is neagtive enter valid size");
				System.exit(0);
			}
			
			if(l>1073741824)
			{
				System.out.println("file  size is greater than 1GB enter valid size");
				System.exit(0);
			}		
			   Path file = Paths.get(args[0]);
		        FileChannel fc=FileChannel.open(file,StandardOpenOption.APPEND);
		        ByteBuffer buf = ByteBuffer.allocate(15);		      
		        for(long n=0;n<l;n=n+2)
		      { 	
		        buf.clear();
		        buf.put( "WA".getBytes());
		        buf.flip();
		        while(buf.hasRemaining())
		            fc.write(buf);
		      } 
		        System.out.println("data successfully write in append mode of given bytes");  
		        fc.close(); 		 
        } catch(Exception e)
		{
        	System.out.println("enter valid path of file"); 
        	e.printStackTrace();
		}
	}//end of main
}//end of class
