import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
public class MyMemoryMapWriter
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
             RandomAccessFile raf=new RandomAccessFile(new File(args[j]),"rw");
            
	         FileChannel fc=raf.getChannel();	  
             MappedByteBuffer mbb=	fc.map(MapMode.READ_WRITE,0,l);	  
           
		     for(long n=0;n<l;n=n+1)
		     mbb.put((byte)'A');
		     fc.close();		     
		     raf.close();			
	      }
			  System.out.println("data write successfully for "+leng/2+ " files");
        } catch(Exception e)
		{
        	System.out.println("enter valid path of file");
        	e.printStackTrace();
        }
	}//end of main
}//end of class
