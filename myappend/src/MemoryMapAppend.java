import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
class MemoryMapAppend
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
	       RandomAccessFile raf=new RandomAccessFile(new File(args[0]),"rw");
             raf.seek(raf.length());
	         FileChannel fc=raf.getChannel();	  
           MappedByteBuffer mbb=	fc.map(MapMode.READ_WRITE,raf.length(),raf.length()+s);
		     for(long n=0;n<s;n=n+1)
		      mbb.put((byte)'A');
		     fc.close();		   
		     raf.close();			
 		        System.out.println("data successfully write in append mode of given bytes");      
	   }catch(Exception e)
	    {   System.out.println("enter valid file path");
	       e.printStackTrace();  	   
       	}		
	}
}