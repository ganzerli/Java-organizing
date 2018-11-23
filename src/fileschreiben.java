
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class fileschreiben {

private String filename;
private String waszuschreiben;
 
	public fileschreiben(String filename, String waszuschreiben){
			      
		this.filename = filename;
		this.waszuschreiben = waszuschreiben;
	}

	public void einschreiben(){
        try{
        	PrintWriter output = new PrintWriter ("benutzer.txt");
        	output.println(waszuschreiben);
        	output.close();
        	System.out.println("Anmeldung efrolgreich, name hinzugefugt in unseres Database, ab ietzt der zugand in den sisteme ist frei \n");
    	} catch (IOException ex) {
      	System.out.printf("error: %s\n",ex);
    	}
    }
	

}