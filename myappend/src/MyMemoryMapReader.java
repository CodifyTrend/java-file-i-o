import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class MyMemoryMapReader 
{
	public static void main(String args[])
	{ try{
		Path p=Paths.get(args[0]);	
		  FileChannel fc=(FileChannel) Files.newByteChannel(p);	
		  MappedByteBuffer mbb=fc.map(MapMode.READ_ONLY,0,fc.size());
		  for (long i = 0; i < mbb.limit(); i++)
	            System.out.print((char)mbb.get());
	  }catch(Exception e)
	   {
		  System.out.println("file does not exit enter valid path");
		e.printStackTrace();  
	    }
	}//end of main
}//end of class
