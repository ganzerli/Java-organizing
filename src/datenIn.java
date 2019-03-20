
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

class datenIn{

private String datum,trinkgeld,besonderheit,noten,ausgegeben,wofuer;
private String datArr[] = new String[6];

private String nameFile;
private Scanner scan;
private byte zaehler = 0;

private String datumZuNameFile = ""; //wenn man die String auf ainander Addirt muss man das default wert geben.


public datenIn(){}// constructor


public void datenRein(){

	scan = new Scanner(System.in);
	
	System.out.print("datum schreiben:   ");
		this.datum = scan.nextLine();
		System.out.println();
		datArr[0] = datum;
	// waere besser ein datum kontrolle..
	System.out.print("$ eingenommen :    ");
		this.trinkgeld = scan.nextLine();
		System.out.println();
		datArr[1] = trinkgeld;

	System.out.print("besonderheit?      ");
		this.besonderheit = scan.nextLine();
		System.out.println();
		datArr[2] = besonderheit;

	System.out.print("noten.. :          ");
		this.noten =scan.nextLine();
		System.out.println();
		datArr[3] = noten;

	System.out.print("ausgegeben :       ");
		this.ausgegeben =scan.nextLine();
		System.out.println();
		datArr[4] = ausgegeben;

	System.out.print("wofuer(sache-preiz/) ");
		this.wofuer =scan.nextLine();
		System.out.println();
		datArr[5] = wofuer;
} 

//     /     //     /      //      /     //       /      // getter und setter

public String getDatum(){				
	return datum;							
}											
public String getTrinkgeld(){				
	return trinkgeld;					
}											
public String getBesonderheit(){			
	return besonderheit;					
}													
public String getNoten(){
	return noten;									// Am besen waere es zu schreiben: RETURN THIS.VARIABLE;
}
public String getAusgenommen(){						// 	nur nun hab keine lust..
	return ausgegeben;
}
public String getWofuer(){
	return wofuer;
}
public String getNameFile(){
	return nameFile;
}
public String[] getDatArr(){
	return datArr;
}
public String getDatumZuNameFile(){
	return datumZuNameFile;
}
//     /      //      /      //      /      //     /     //      /       //
public void fileCheck(String nameFile){

	this.nameFile  = nameFile;
	boolean datumPasst = false;

	if(nameFile.length() == 11){
		datumPasst = true;
	}

	File f = new File(System.getProperty("user.dir")+"/2015/" + nameFile);
	nameFile = System.getProperty("user.dir")+"/2015/" + nameFile;
	this.nameFile = nameFile;

	if (datumPasst){
		if(f.exists() && !f.isDirectory()) {
		
			zusammenFassenAdd(nameFile);
			System.out.print("    Hingeschrieben   ");
		}else if(!f.exists()) {

			datenInFIleSchreiben(nameFile);
			System.out.print("   in neues file hingeschrieben   ");
		}else{}
	}else{
		System.out.println("\n[ERROR]: falsche Datum eingegeben habe keine lust die ganze sektione vom programme hinzuschreiben dann muss man den ganzen vorgang wiederholen \n");
	}
}

public void umtausch(String vas,char altChar, char mitVas){

	String altFormat = vas;
	char arr[] = altFormat.toCharArray();
	byte counter = 0;
	char zuUmtauschen = altChar;
	char neuChar = mitVas;
	String neu;
		for (char c: arr){
			// c ist das char..
			if (c == zuUmtauschen){
				arr[counter] = neuChar;
			}
			counter ++;
		}
	String tempVar;
	for (byte i = 3; i<=counter-1 ; i++){
		tempVar = String.valueOf(arr[i]);
		datumZuNameFile = datumZuNameFile + tempVar;
	}
}

public void datenInFIleSchreiben(String woHin){

	byte counter = 0;
	
	try{
        PrintWriter output = new PrintWriter(woHin);

        for (String dat:datArr){
        	output.print(datArr[counter] + "  <->  ");
        	counter +=1;
        }
		output.close();
	} catch (IOException ex) {
      System.out.printf("error: %s\n",ex);
    }
}

public void reierZaehlen(String welcheFile){
		try{
		scan = new Scanner(new File(welcheFile));
	}catch(Exception e){
		System.out.println("File nicht gefunden: " + e );
	}
	String wert;
	if (scan.hasNextLine()){
		while(scan.hasNextLine()){
			wert = scan.nextLine();
			zaehler += 1;
		}
	}
	fileSchliessen();
}

public void zusammenFassenAdd (String welcheFile){   	// wenn es gibt!!

	reierZaehlen(nameFile);
	String zusArr[] = new String[zaehler+1];
	fileOffnen(welcheFile);// !!! in reierZahlen() wurde das file geschlossen, dann muss ietzt wieder geöffnet werden..

	if (scan.hasNextLine()){
		int i = 0;
		String wert;
		/* wenn man hier das wert von :  scan.hasNextLine()   gibt, wenn sie die ERSTE reie ist,bleibt kein "next" mehr speter.. und das loop faengt bloss nicht an...*/
		while(scan.hasNextLine()){
			// erstmal das wert hier geben, sodass auch mit einer reie geht in loop
			wert = scan.nextLine();
			zusArr[i] = wert;
			i += 1;
		}
	}else{}

	fileSchliessen();// vielleicht besser uber else ??

	String hinzufuegen = datum + "  <->  "+ trinkgeld + "  <->  "+ besonderheit + "  <->  " +noten +"  <->  "+ ausgegeben + "  <->  "+ wofuer + "  <->  ";
	zusArr[zaehler]=hinzufuegen;

	try{
        PrintWriter output = new PrintWriter(nameFile);
        byte counter =0;
        for(String d : zusArr){
        	output.println(zusArr[counter]);
        	counter ++;
        }
        output.close();
	} catch (IOException ex) {
      System.out.printf("error: %s\n",ex);
    }
}

//   /   //     /     //        //    /    //    /    //    /     //    /     // file schliessen und Offnen
public void fileOffnen(String welches) {
	try{scan = new Scanner(new File(welches));}
	catch(Exception e){System.out.println("Kein file gefunden");}
}

public void fileSchliessen(){scan.close();}
//    /     //      /      //    /       //      /       //     /      //      /     //        /      //

} //// END KLASS ///