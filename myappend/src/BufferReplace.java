import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class BufferReplace
{
	public static void main(String args[])
	{	try{   
		if(args.length!=4)
       {
        	System.out.println("provide all the arguments i.e file path start index end index and input string");
       	System.exit(0);
        }
		   Path p =Paths.get(args[0]);
		  SeekableByteChannel sbc=  Files.newByteChannel(p,StandardOpenOption.WRITE);      
		int start=Integer.parseInt(args[1]);   	
	        int end=Integer.parseInt(args[2]); 
	        int dif=end-start;
	        String str=args[3];
	        
	        if(start<0)
	        {
	        	System.out.println("start index cannot be neagtive i.e less than 0");
	        	System.exit(0);
	        	
	        }
	        if(end>( (int)sbc.size() ) )
	        {
	        	System.out.println("end index cannot be greater than file size");
	        	System.exit(0);
	        }
	        if(start>=end)
	        {
	        	System.out.println("start index cannot be greater than or equal to end index");
	        	System.exit(0);	
	        }
	        
	     
             if(str.length()>dif)
             {   
            	 str=str.substring(0,dif);
            	 
             }
            
             if(str.length()<dif)
             {   int amt=dif-str.length();
                  for(int i=0;i<amt;i++)
            	 str=str.concat("_");
            	 
             }
          
  		     sbc.position( (long)(start) );		            
		     sbc.write( ByteBuffer.wrap(str.getBytes()));  
		     sbc.close();			
		     System.out.println("files contents are replaced from location "+start+" bytes to "+end+" bytes with string= " +str );	 
         }catch(Exception e)
           { 
        	System.out.println("enter vaild file path for reading and  replacement");
        	e.printStackTrace();
           }
	}
}
