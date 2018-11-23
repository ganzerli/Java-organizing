
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class machfile {
	
	public void machfile() {
		File file = new File ("benutzer.txt");
		      try{
        	PrintWriter output = new PrintWriter ("benutzer.txt");
        	output.println("");
        	output.close();
    	} catch (IOException ex) {
      	System.out.printf("error: %s\n",ex);
    	}
	}

}