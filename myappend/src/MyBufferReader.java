import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyBufferReader {
	public static void main(String args[])
	{  
		try
	 {
        Path file = Paths.get(args[0]);
	    FileChannel fc=FileChannel.open(file);	
        ByteBuffer bf=ByteBuffer.allocate(100); 
     int n = fc.read(bf);		
      while (n!= -1)
      {   
    	  bf.flip();
        while (bf.hasRemaining()) {
            System.out.print((char) bf.get());                    
        }
        bf.clear();
        n= fc.read(bf);
       }
      fc.close();  
	 }catch(Exception e)
		{
		  System.out.println("file does not exit give valid path of file at cmd");
		 e.printStackTrace();
		}
}

}
