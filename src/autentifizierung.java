import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

class autentifizierung {

private String vorname,familienname;
private Scanner x;
private byte counter = 0;
private boolean gefunden = false;
private boolean sperre = true;

	public autentifizierung(String vorname, String familienname) {
		this.vorname = vorname;
		this.familienname= familienname;
	}

	public void fileerzeugen(){
		File benutzer = new File("benutzer.txt");
	}
	
	public void fileOeffnen() {

		try{
			x = new Scanner(new File("benutzer.txt"));
		}
		catch(Exception e){
			System.out.println("Kein file gefunden");
		}
	}

	public void lesenalles(){

		while (x.hasNext()) {  // bis ende file
			
			String a = x.next();
			System.out.print("   "+a+"  ");

			if (x.hasNext()){
				String b = x.next();
				System.out.println(b);
			}else{
				System.out.print(" ----------     [...]--->hear fehlt entweder Name oder Familienname");
			}
		}
	}

	public void filereiercounter(){	
		counter = 0;
		fileOeffnen(); //        <<<<--------------
		while (x.hasNextLine()) {  
			String a = x.nextLine(); /// WICHTIG!! wenn das wert nicht gegeben wird das while ist endlos!!!
			counter++;
		}
		fileschliessen(); //    <<<<<-------------
	}

	public void arrayvonfile(){

		this.x = new Scanner(System.in);

		String antwort = x.next();
		String ja = "ja";
		String j = "j";
		String nein = "nein";
		String n = "n";
		String vornameneubenutzer;
		String nachnamebenutzer;

		if (antwort.equals(ja) || antwort.equals(nein) || antwort.equals(j) || antwort.equals(n) ) {
			if (antwort.equals(ja) || antwort.equals(j)){

				System.out.println("Bitte NUR VORNAME eingeben:");
				x = new Scanner (System.in);
				vornameneubenutzer = x.nextLine();
				System.out.println(" \nBitte FAMILENNAME eingeben");
				x = new Scanner (System.in); 
				nachnamebenutzer = x.nextLine();

				String t = vornameneubenutzer + " " +nachnamebenutzer;
				String arr[] = new String[counter +1];

				fileOeffnen();  //// <<<<<<--------

				counter = 0;
				while (x.hasNextLine()) {

					String a = x.nextLine(); /// WICHTIG!! wenn das wert nicht gegeben wird das while ist endlos!!!
					arr[counter] = a;
					counter+=1; // !!!!! damit der counter wird 1 mal mehr gerechnet!!!
				}
				// hier couter ist schon 6!! array fängt an von 0 dann die reier unten passen schon
				arr[counter] = t;
				fileschliessen(); ////    <<<<<-------------
				// wielleicht noch file Oeffnen
				try{
        			PrintWriter output = new PrintWriter ("benutzer.txt");

        			for (int i = 0; i <= counter; i++){
						output.println(arr[i]);
        			}
					output.close();
        			System.out.println("\n Anmeldung efrolgreich, name hinzugefugt in unseres Database, ab ietzt der zugand in den sisteme ist frei \n");
    			}catch(IOException ex){
      				System.out.printf("error: %s\n",ex);
    			}
			}else{           //-------------//zweite if
				System.out.println("\n      NICHT angemeldet");
			}  
		}else{
			System.out.println("bitte entweder ja oder nein eingeben");
		}
	}

	public void namesuchen(){

		int r = 0;
		String s ;
		String ns ;
		byte namenCounter = 0;

		if(x.hasNext()){  // wenn file nicht leehr
			while(x.hasNext()){
				
				s = x.next(); // erstes wort des files
				if (x.hasNext()){
					ns= x.next(); // zweites wort des files
				}else{
					ns = "[...]";
				}
				if (familienname != null){ // wenn frage hat 2 namen

					if (vorname.equals(s) || vorname.equals(ns) || familienname.equals(s) || familienname.equals(ns)){
						System.out.println("Wilkommen "+ s + " " + ns +", \nvon hear können sie ihre gewünschte info über ihre begebenheit viederfinden");
						gefunden= true;
					}
				}else if (familienname == null){ // wenn frage hat nur einen namen(egal familie oder vorname, hier heisst so)
					
					if (vorname.equals(s) || vorname.equals(ns)){ 
							System.out.println("\nWilkommen " + s +  ", \nvon hear können sie ihre gewünschte info über ihre begebenheit viederfinden");
							gefunden = true;
							break; // wenn es mehrere gleiche namen gibt wir mehrere mahl gedrückt
						}
					}else{ 
					gefunden = false;
				}
			}//while
		}else{
			System.out.println("keiner has sich noch registriert, sich anmelden? [ ja  nein ]");
			anmeldung();
			gefunden = true;
			sperre = false;
			fileschliessen();
			}

			if (gefunden == false){
					System.out.println("name nicht gefunden.. sich anmelden?  [ja   nein]");
					arrayvonfile();
			}

		} /// end end end
		
	
	public void fileschliessen(){
		x.close();
	}

	public void anmeldung(){

		this.x = new Scanner(System.in);
		String antwort = x.nextLine();
		String ja = "ja";
		String j = "j";
		String nein = "nein";
		String n = "n";
		String namefile = "benutzer.txt";

		if (antwort.equals(ja) || antwort.equals(nein) || antwort.equals(j) || antwort.equals(n) ) {
			if (antwort.equals(ja)){
				System.out.println("Bitte NUR VORNAME eingeben:");
				x = new Scanner (System.in);
				String vornameneubenutzer = x.nextLine();

				System.out.println("Bitte FAMILENNAME eingeben");
				x = new Scanner (System.in); 
				String nachnamebenutzer = x.nextLine();

				String text = vornameneubenutzer + " " +nachnamebenutzer;
				
				fileschreiben namehinzufugen = new fileschreiben(namefile,text);
				namehinzufugen.einschreiben();
			}else{
				System.out.println("name nicht gespeichert");
			}
		}else{
			System.out.println("bitte entweder ja oder nein eingeben");
		}
	}

boolean returnStatement;

public Boolean sperre(){
	if (gefunden && sperre){
		returnStatement = true;
	}
	return returnStatement;
}

}//// END KLASS