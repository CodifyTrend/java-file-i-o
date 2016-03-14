import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class MyDelete
{
	public static void main(String args[])
	{ 
 	try{
		Path newFile = Paths.get(args[0]);  	
		Files.delete(newFile);
        System.out.println("file deleted successfully");
	    }catch(Exception e )
              {
                System.out.println("provide proper path");
                e.printStackTrace();      
               }
	 }
}