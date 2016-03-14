import java.io.File;
import java.io.RandomAccessFile;
public class DirectReplace
{
	public static void main(String args[])
	{	try{   
		if(args.length!=4)
       {
        	System.out.println("provide all the arguments i.e file path start index end index and input string");
       	System.exit(0);
        }
		 RandomAccessFile raf=new RandomAccessFile(new File(args[0]),"rw");      
		int start=Integer.parseInt(args[1]);   	
	        int end=Integer.parseInt(args[2]); 
	        int dif=end-start;
	        String str=args[3];
	        
	        if(start<0)
	        {
	        	System.out.println("start index cannot be neagtive i.e less than 0");
	        	System.exit(0);
	        	
	        }
	        if(end>( (int)raf.length() ) )
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
          
  		     raf.seek(start);	     
		     raf.write(str.getBytes());  
		     raf.close();			
		     System.out.println("files contents are replaced from location "+start+" bytes to "+end+" bytes with string= " +str );	 
         }catch(Exception e)
           { 
        	System.out.println("enter vaild file path for reading and  replacement");
        	e.printStackTrace();
           }
	}
}
