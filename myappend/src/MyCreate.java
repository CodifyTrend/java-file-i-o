import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class MyCreate
{
	public static void main(String args[])
	{ try
	   {
		
		 int n=args.length,i; long s;
		 if(n%2!=0)
		 {
			 System.out.println("please provide both the arguments of file i.e path and size");
	    	   System.exit(0);		 
		 }
         for(i=0;i<n;i=i+2)
         {
	       s=Long.parseLong(args[i+1]);
	       if(s>1073741824)
	       {
	    	   System.out.println("file size is above 1GB.... enter valid size");
	    	   System.exit(0);
	       }
	       
	       if(s<0)
	       {
	    	   System.out.println("enter a valid positive file size");
	    	   System.exit(0);
	       }
		   Path p=Paths.get(args[i]);
               if(Files.exists(p)!=true)
               {
                   
		           Files.createFile(p);
		           System.out.println("going ahead creating file.......");
	               System.out.println("file successfully created");
	               OutputStream os=Files.newOutputStream(p);
	               for(long l=0;l<s;l=l+15)
			       os.write("writing data...".getBytes());
	               os.close(); 		
		           System.out.println("fize size in bytes="+Files.size(p));
 		       }
               else
               System.out.println("file already exits unable to create");      
         }//end of loop		
	   }catch(Exception e)
	    {   System.out.println("enter valid file path");
	       e.printStackTrace();  	   
       	}
		
	}//end of main method
	
}//end of class