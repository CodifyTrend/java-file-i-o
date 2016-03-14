import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class MyReader
{
    public static void main(String[] args)
    {   
   	try
   	{ 	
	  Path p= Paths.get(args[0]);
      
        BufferedReader reader = Files.newBufferedReader(p);
            String line;
            while ((line=reader.readLine())!= null)
             System.out.println(line);	
   	}catch(Exception e)
   	  {
   	  System.out.println("file does not exit on given path");
   	  e.printStackTrace();  		
   	  }
   }
}