import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
class DirectAppend
{
	public static void main(String args[])
	{ try
	   {
		long  s=Long.parseLong(args[1]);
		 if(args.length%2!=0)
		 {
			 System.out.println("please provide both the arguments of file i.e path and bytes to write");
	    	   System.exit(0);		 
		 }    
	      
	       if(s>1073741824)
	       {
	    	   System.out.println("bytes to write is above 1GB.... enter valid bytes size");
	    	   System.exit(0);
	       }
	       
	       if(s<0)
	       {
	    	   System.out.println("bytes to write is negative enter valid byte size");
	    	   System.exit(0);
	       }
		           Path p=Paths.get(args[0]);
	               OutputStream os=Files.newOutputStream(p,StandardOpenOption.APPEND);
	               for(long l=0;l<s;l=l+2)
	      	       os.write("WA".getBytes());
	               os.close(); 		
 		        System.out.println("data successfully write in append mode of given bytes");      
	   }catch(Exception e)
	    {   System.out.println("enter valid file path");
	       e.printStackTrace();  	   
       	}		
	}
}