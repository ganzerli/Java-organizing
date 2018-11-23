import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Datensuche {

public static String datenZuSuchen,erleichterung,wasGenau,filter="nf",erleichterungDatums,zwischen1,zwishcen2;
private static Scanner scan; // = new Scanner (System.in);
private static boolean control = false, producktOderPreiz = false;
private static byte nummerGegenstände = 6;
private static String arr[] = new String[nummerGegenstände];
private static String vorstellung[] = {"Datum            >>>  : ","Eingenommen      >>>  :","Besonderheit     >>>  :","Noten            >>>  :","Ausgegeben       >>>  :","Preiz:             >>>:"};

public Datensuche(){}

public static void frage(){
	scan = new Scanner(System.in);
	System.out.println("Daten gehörigen zu welcher sort suchen? [ NUMMER EINGEBEN ]\n 1) Datum\n 2) Eingenommen\n 3) Besonderheit\n 4) Noten\n 5) Ausgegeben\n 6) Preiz (zeug-preiz)");
	datenZuSuchen = scan.nextLine();
	datVereinigung();
	while (!control){
		System.out.println(" !!! [E:] ungenauen Wert eingegeben, bitte den vorgang wirderholen");
		scan = new Scanner(System.in);
		System.out.println("Daten gehörigen zu welcher sort suchen? [ NUMMER EINGEBEN ]\n 1) Datum\n 2) Eingenommen\n 3) Besonderheit\n 4) Noten\n 5) Ausgegeben\n 6) Preiz (zeug-preiz)");
		datenZuSuchen = scan.nextLine();
		datVereinigung();
	}
}

public static void datVereinigung (){
	control = true;
	do{
		if (!control){
			System.out.println(" !!! [E]: falsches Wert eingegeben, biette wiederholen..");
			System.out.println("Daten gehörigen zu welcher sort suchen? [ NUMMER EINGEBEN ]\n 1) Datum\n 2) Eingenommen\n 3) Besonderheit\n 4) Noten\n 5) Ausgegeben\n 6) Preiz (zeug-preiz)");
			System.out.println();
			datenZuSuchen = scan.nextLine();
		}

		switch(datenZuSuchen){
			case "1":
			datenZuSuchen = "Datum";
			control = true;
			break;

			case "2":
			datenZuSuchen = "Eingenommen";
			control = true;
			break;

			case "3":
			datenZuSuchen = "Besonderheit";
			control = true;
			break;

			case "4":
			datenZuSuchen = "Noten";
			control = true;
			break;

			case "5":
			datenZuSuchen = "Ausgegeben";
			control = true;
			break;

			case "6":
			datenZuSuchen = "Preiz";
			control = true;
			break;

			default:
			datenZuSuchen = "nix";
			control = false;
		}
	}while(!control);
}

public static String datVereinigung (String was){
	control = true;
	String tempVar="";
	do{
		if (!control){
			System.out.println(" !!! [E]: falsches Wert eingegeben, biette wiederholen..\n");
		}
		switch(was){
			case "1":
			tempVar = "Datum";control = true;break;
			case "2":
			tempVar = "Eingenommen";control = true;break;
			case "3":
			tempVar = "Besonderheit";control = true;break;				
			case "4":
			tempVar = "Noten";control = true;break;
			case "5":
			tempVar = "Ausgegeben";control = true;break;
			case "6":
			tempVar = "Preiz";control = true;break;
			default:
			control = false;
		}		
	}while(!control);
	return tempVar;
}

public static void setWasGenau(){
	scan = new Scanner(System.in);
	String ant ;
	switch(datenZuSuchen){
// braucht nict beachutzt werden weil die variabel sicher ist schon genau!!
		case "Datum":
		System.out.println("von wann? TT/MM/JJJJ");
		wasGenau = scan.nextLine();
		break;
// das wert ist schon geändert worden damit auch mit einer nummern eníngabe wird ein wort in die variabel gespeichert
		case "Eingenommen":
		nummerSuche("Eingenommen");
		break;

		case "Besonderheit":
		System.out.println("Welches wort als Besonderheit genau suchen? ");
		wasGenau = scan.nextLine();
		break;

		case "Noten":
		System.out.println("Welches wort als Noten genau suchen? ");
		wasGenau = scan.nextLine();
		break;

		case "Ausgegeben":
nummerSuche("Ausgegeben");  // nummerSuche() setzt ein die werte von wasGenau und auch filter
break;

case "Preiz":
control = false;

do{
	System.out.println("\n 1) Aus Bestimmten produkt\n 2) Aus bestimmten preiz?");

	ant = scan.nextLine();
	if (ant.equals("1")){
		control = true;
		System.out.println("Welches gekaufte Produkt genau suchen? [ Bezeichnung ]");
		wasGenau = scan.nextLine();
		producktOderPreiz = true;
	}else if(ant.equals("2")){
		control = true;
		nummerSuche("Preiz aus produkt Bezeichnung");
		producktOderPreiz=false;
	}
	else{
		control = false;
		System.out.println("[ ERROR ]  antwort inicht gültig ( ---> entweder   1   oder   2  \n--> bitte Vorgang wiederholen");
	}
} while(!control);

/*if (wasGenau.equals("1")){
System.out.println("was für ein produkt?");
wasGenau  = scan.nextLine();
}else{
System.out.println("produckt mit welchem Preiz?");
nummerSuche("Gekaufte Produckt");
}*/
break;
}
}
public static String nummerSuche(String betreff){
	String tempVar = "";
	do{
		if (!control){
			System.out.println("[E]: falsches Wert eingegeben, biette wiederholen..");
		}
		System.out.println("--------- [ "+betreff+" ] --------- :");
		System.out.println("\n 1) wie viele:? \n 2) veniger als? \n 3) mehr als? \n 4) zwischen welchem wert?\n [nummer eingeben]");
		wasGenau = scan.nextLine();
		switch(wasGenau){
			case "1":
			System.out.println("Wie viel genau?");
			wasGenau = scan.nextLine();
			filter = "genau";
			control = true;
			tempVar= "1";
			break;
			case "2":
			System.out.println("weniger als?");
			wasGenau = scan.nextLine();
			filter = "wenigerals";
			control = true;
			tempVar = "2";
			break;
			case "3":
			System.out.println("mehr als?");
			wasGenau = scan.nextLine();
			filter = "mehrals";
			control = true;
			tempVar = "3";
			break;
			case "4":
			System.out.println("zwischen was und was?  [nummer - nummer]");
			boolean passt = false;
			filter = "zwischen";
			tempVar="";
			do{
				wasGenau = scan.nextLine();
				String spaltenArr[] = wasGenau.split(" - ");
				if (spaltenArr.length == 2){
					zwischen1 = spaltenArr[0];
					zwishcen2 = spaltenArr[1];
					passt = true;
				}else{
					passt = false;
					System.out.println("[  FEHLER  ] format könnte nicht richtig sein, bitte das format beachten:\n[nummer - nummer]");
				}
			}while(!passt);
control = true;			// ???? ähnlich wie passt??? keine ahnung lasse ich den da
tempVar = "4"; // extreme wiichtig!!
System.out.println("\n \t SUCHE zwischen :" +parsieren(zwischen1)+" und "+parsieren(zwishcen2)+"\n");
break;

default: 
System.out.println("default");
control = false;
}
}while(!control);
return tempVar;
}

public static boolean datumCheck(String zuTesten){
	control = false;
	String tempVar = zuTesten;
	char ch [] = tempVar.toCharArray();
	byte besondereCharZählen = 0;
	for (byte i=0 ; i < ch.length; i++){
		if (ch[i] == '/' ||ch[i] == ' ' || ch[i] == '-'){
			besondereCharZählen+=1;
		} 
	}
	if (besondereCharZählen == 7){
		tempVar = "";
		String checkPasst;
		for (byte i=0 ; i < ch.length; i++){
			tempVar = tempVar + String.valueOf(ch[i]);
		}
		control = true;
	}else{

		control = false;
	}
	return control;
}

public static boolean erleichterung(){
	boolean zurückgeben = true;
	control = false;
	boolean datcontr = false;
	if (datenZuSuchen != "Datum"){
		do{
			System.out.println("um die suche angenehmer zu erhalten ist angeboten die möglichkeit ob in einer bestimmter zeit die daten suchen oder einfach seit immer in den ganzen database");
			System.out.println(" 1) aus zeit period [tt/mm/jjjj - tt/mm/jjjj] \n 2) seit immer");
			String tempVar = scan.nextLine();
			String eins ="1";
			if (tempVar.equals(eins)){
				do{
					System.out.println("bitte genau wie gezeigt die datum eingeben [TT/MM/JJJJ - TT/MM/JJJJ]");
					tempVar = scan.nextLine();
					if (datumCheck(tempVar)){
						datcontr = true;
						erleichterungDatums = tempVar;
					}else{
						datcontr = false;
						System.out.println("\n 		[ERROR]\netwas stimmt nicht mit dem eingegebenen Datum-paar..");
					}
				}while(!datcontr);
				zurückgeben = true;
				control = true;
			}else if (tempVar.equals("2")){
				zurückgeben = false;
				control  = true;
			}else{
				control = false;
			}
			if (control == false){
				System.out.println("\n[ERROR: flasches wert eingegeben [ etweder--> 1 oder--> 2 ]\n");
			}
		}while(!control);
	}
	return zurückgeben;
}

public static boolean lesenDatum(String vonWelchemFile,String betreff){
// mach controlle, wenn datum gefunden, zählen wie viele ist die reiher und laden ohne begrenzung gefunden mach array
	fileÖffnen(vonWelchemFile);
	String tempVar ="";
	boolean endeReie = false;
//byte nummerGegenstände = 6;
	int abtrennungCounter = 0;
//String arr[] = new String[nummerGegenstände];
	String arrayFutter ="";
	boolean gefunden = false;
	arr = new String [nummerGegenstände];
//String vorschuz = "";
	if (istDatum(betreff)){

		while (scan.hasNext()){
			tempVar = scan.next();

			if (tempVar.equals(betreff)){
				arrayFutter = tempVar;
				gefunden = true;
				while(!endeReie){

					tempVar = scan.next();

					if (tempVar.equals("<->")){

						arr[abtrennungCounter] = arrayFutter;
						arrayFutter = "";
						abtrennungCounter ++;

					}else{
						arrayFutter = arrayFutter + " " + tempVar;
					}
					if (abtrennungCounter == nummerGegenstände){
						endeReie = true;
					}
				}
			}
			if (endeReie){
				break;
			}
		}
	}
//////////////////////////////////////////////////////////////
	scan.close();
	return gefunden;
}

public static void fileÖffnen(String welches){
	try{ scan = new Scanner(new File(welches));}
	catch(Exception e){System.out.println("kein file gefunden");}
}

public static boolean istDatum(String betreff){
	char dat[] = betreff.toCharArray();
	byte counter=0;
	byte bestimmung = 0;
	boolean istDatum = false;

	if (dat.length == 10){
		for(char c : dat){
			if (dat[counter] == '/'){
				bestimmung++;
			} 
			counter++;
		}
		if (bestimmung != 2){
			System.out.println("Entweder das format ist nicht richtig oder kein datum eingegeben, bitte erneut eingeben");
		}else{istDatum = true;}
	}else{
		istDatum=false;
		System.out.println("Das ist kein Datum, biette erneut das Datum einschreiben");
	}
	return istDatum;
}

/*	public void versuch(){

String a = "hallo";
char ch[] = a.toCharArray();
String st = "";

for (byte i=0; i<= ch.length-1; i++){

String tempVar = String.valueOf(ch[i]);
st = st + tempVar;
}
System.out.println(st);
}*/
/*public String etwas(){
datenIn di = new datenIn();
System.out.println(di.getDatum());
String a = di.getDatArr()[2];// das geht..!!
String b[] = {"1","2","3"};
}*/

////--------------------------------------------------------

public static String checkName(String input){
	char[] control = input.toCharArray();
	String st ="";
	String tempVar;

	for (byte i = 3; i <= control.length-1; i++){
		if (control[i] == '/'){
			control[i] = '-';
		}
		st = st + String.valueOf(control[i]);
	}
	return st;
}

public static boolean checkFile(String nameVonFile){
	File f = new File(System.getProperty("user.dir")+"/2015/"+nameVonFile+".txt");
	if (f.exists() && !f.isDirectory()){
		return true;
	}else if(!f.exists()){
		return false;
	}else{return false;}
}

public static void wennDatum(){
	if (datenZuSuchen.equals("Datum")){
		if (istDatum(wasGenau)){
			if (checkFile(checkName(wasGenau))){
				if(lesenDatum(System.getProperty("user.dir")+"/2015/"+ checkName(wasGenau) +".txt",wasGenau)){
					datenDrücken(wasGenau,"alle");
				}else{System.out.println("keine daten gefunden am"+wasGenau);}
			}else{
				System.out.println("entstehen keine Deaten an desem Tag");
			}
		}
	}
}

public static void datenDrücken (String betreff,String welches){
	arr = new String[nummerGegenstände];

	if (checkFile(checkName(betreff))){
		lesenDatum(System.getProperty("user.dir")+"/2015/"+ checkName(betreff) +".txt",betreff);
		if (welches.equals("alle")){
			System.out.println("##############################################################################\n");
			for (byte i = 0; i< nummerGegenstände; i++){
				System.out.printf("%s%s\n\n",vorstellung[i],arr[i]);
			}
			System.out.println("##############################################################################\n");
		}else{
			System.out.print("");
			System.out.printf("%s%s\n",vorstellung[woMussSein(welches)],arr[woMussSein(welches)]);
			System.out.println("");
		}
	}else{
		System.out.println("das ist kein Datum oder format falsh");
	}	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//--------------------------------------BISHER NUR UM DATUM ZU SUCEHN UND ZU LESEN-----------------------------------------------------------//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		//
//		ACTUNG!!:  NOCH DAS METHOD UM ZWIESCHEN 2 DATEN SUCHEN FEHLT     <<<<}}}}}}}}}  // 


//############################################################################################################################################################################
//#############################################      ACHTUNG SUCHEN MUSS WIEDEREINGEEIGNET WERDEN  !!  (FUR VIELE FILE)#######################################################
// WAS WENN MUSS MAN FIELE WERTE VERGLEICHEN??? VIELE MAHL DAS WORT FRAGEN..

/* ERST EINARRAY BAUEN MIT ALLE DIE DATEN, LOOPEN UND ADDIEREN LENGTH UND EINE NUMMER FINDEN WIE VIELE MAHL DAS WER EINGEGEBEN WURDE, aber mit ausgegeben und eingenommen muss 
man finden auch weniger als oder mehr als .. wielleich nur finden die  erste nummer und die dezumalen später machen..
WENN NUR EINE REIER, WIE DA UNTEN
FRAGEN HERSTELLEN
DANN LOOPEN IN VERSCHIEDENE FILE UND ZEIGEN DIE ERGEBNISSSE
WIEVIELEFILE KANN AUC ERROR ZURÜCKGEBEN*/

public static String[] datumSpalten(){

	char arrDat[] = erleichterungDatums.toCharArray();
	String ersteDat = "";
	String zweiteDat  = "";
	for (byte i = 0; i < 10 ; i++){
		ersteDat = ersteDat + String.valueOf(arrDat[i]);
	}
	for (byte i = 13; i < 23 ; i++){
		zweiteDat = zweiteDat + String.valueOf(arrDat[i]);
	}
	String arr[] = {ersteDat , zweiteDat};
	return arr;
}
public static boolean datumKontrolle(String datum){

	char ad[] = datum.toCharArray();
	control = false;
	try{
		int tag= Integer.valueOf(String.valueOf(ad[0]) + String.valueOf(ad[1]));
		int monat = Integer.valueOf(String.valueOf(ad[3]) + String.valueOf(ad[4]));
		int jahr = Integer.valueOf(String.valueOf(ad[6]) + String.valueOf(ad[7]) +  String.valueOf(ad[8])+ String.valueOf(ad[9]));

if (tag < 31 && monat < 13 && jahr <2025 && jahr > 2014){ // voraussetzungen damit das datum passt
	control = true;
}else{
	control = false;
}
}catch(NumberFormatException nfEx){
	control = false;
}
return control;
}

public static String[] zweiDatumUmkehren(String erste, String zweite){ // im fall des zweites datum ist frühere im zeitpunkt des erstes.. wird im array die index umgewechselt
control = false;													// kein try catch weil in suche() das method zweidatumumkehren kommt später..
char ersteArr[] = erste.toCharArray();
int tag= Integer.valueOf(String.valueOf(ersteArr[0]) + String.valueOf(ersteArr[1]));
int monat = Integer.valueOf(String.valueOf(ersteArr[3]) + String.valueOf(ersteArr[4]));
int jahr = Integer.valueOf(String.valueOf(ersteArr[6]) + String.valueOf(ersteArr[7]) +  String.valueOf(ersteArr[8])+ String.valueOf(ersteArr[9]));

char zweiteArr[] = zweite.toCharArray();
int tag2= Integer.valueOf(String.valueOf(zweiteArr[0]) + String.valueOf(zweiteArr[1]));
int monat2 = Integer.valueOf(String.valueOf(zweiteArr[3]) + String.valueOf(zweiteArr[4]));
int jahr2 = Integer.valueOf(String.valueOf(zweiteArr[6]) + String.valueOf(zweiteArr[7]) +  String.valueOf(zweiteArr[8])+ String.valueOf(zweiteArr[9]));


if (jahr2 >= jahr){
	if (monat2 >= monat){
		if (tag2 >= tag){
			control = true;
		}else{
			control = false;
		}
	}else{
		control = false;
	}
}else{
	control =false;
}
String zurückZuGeben[] = {erste, zweite};
if (!control){
	zurückZuGeben[0] = zweite;
	zurückZuGeben[1] = erste;
}
return zurückZuGeben;
}

//####################################################################################################################################
//####################################################################################################################################


public static void suche(){

	if (!datenZuSuchen.equals("Datum")){ 
// erstes mahl war equals to eingegeben oder ausgegeben.. aber bisher man untersucht nur die datum
		control = false;
		String ersteDatum = "";
		String zweiteDatum = "";
		boolean seitImmer = true;
		do{
if(erleichterung()){// kuken ob zwischen 2 datum oder seit immer, 	dieses method speichert schon die variabel als global !!  >> so heisst nicht seitimmer
//System.out.println(erleichterungDatums +"   "+ filter+" " +wasGenau);
if ( datumKontrolle(datumSpalten()[0]) && datumKontrolle(datumSpalten()[1]) ){ // shauen ob die zwei datum sind eigentlich datum

	ersteDatum = zweiDatumUmkehren(datumSpalten()[0],datumSpalten()[1])[0];
	zweiteDatum = zweiDatumUmkehren(datumSpalten()[0],datumSpalten()[1])[1];
//nur wenn die zwei datum sind!!!
//System.out.println(ersteDatum + " --- " +zweiteDatum );
	control = true;
}else{
	control = false;
	System.out.println("\n	[ERROR] 		\nformat von datum oder datum selber falsch oder nicht im ZieitBereich\n");
}
seitImmer = false;
}//ende datum vervahltung
}while(!control);
///man hat die zwei datum um einen datumspectrum zu haben... muss man ein method erschaffen das die zwei als array kriegt,und die suche mit den FILTER fort setzt..

// array mit allen den daten möglich kriegen;
String datum[] = wieVieleFile(seitImmer,checkName(ersteDatum),checkName(zweiteDatum));


if (datum.length > 0){			
byte zähler,reierFindenZähler, counter,counter2,counter3;		// nur wenn es etwas drinnen gibt..
// 2 dimensional array??
String datenArr[], ganzerFileName,wort,infoDesTages[],antwort,arrSache[],arrPrize[], prodArr[];
String prod=""; // für das loop wo man zeigt das produckt und preiz..
String prei=""; // für das loop wo man zeigt das produckt und preiz.
float floTest;
float vergleichen = 0;// wenn zwischen 2 nummern haben die komma stört
if(!filter.equals("zwischen")){
	vergleichen = parsieren(wasGenau);
}
boolean etwasGefunden = false;
boolean passt = false;
String datumHerausbekommt="";
boolean schalter= false;
boolean einmahl = true;
boolean knt = false;
boolean ja = false;
antwort = "";
//String passende[] = new String[];
for (int i = 0; i< datum.length; i++){ // für jeden File array kriegen, und kontrollieren ob passt durch den filter, sodass alle genau zu suchen werden 


datenArr = datGesuchtHerausBekommen(datum[i]); // alle die daten vom sort datenZusuchen, vom file datum[i] in den array
/*datGesuchtHerrausBekkommen ist ein array der gibt ale die daten an datenArr, datum[i] ist der richtige file
und datGesuchtHerausbekommen nimmt von alle den tegen von datum[i] das Teil aus datenzusuchen, 
datenArr[] kriegt aus dem file datum [i] die ganze "datenZuSuchen" werte  */
//System.out.println(datum[i] +"dfsadfsadfasdfasdfasdfasdf" + datenArr[i]);

zähler = 0;
reierFindenZähler = Byte.valueOf(zähler + "1");
ganzerFileName = System.getProperty("user.dir")+"/2015/"+datum[i]+".txt";

///#////////#///#//////#/#///#///#//////#//#////#//#///////#//#/////##///////#////#///#/////#//#/#///////#######////

for (String j : datenArr){
//System.out.println(datenArr[zähler]);

	if (datenZuSuchen.equals("Eingenommen") || datenZuSuchen.equals("Ausgegeben")){
		switch (filter){
//if (filter.equals("genau")){ // brauch man nur sehen wenn die nummer stimmt genau
			case "genau":
floTest = parsieren(datenArr[zähler]);// den wert wird in float parsiert, wenn nur buhstabe oder nichts = 0.0
if (floTest == vergleichen){
etwasGefunden = true; // dann man sagt etwas;
datumHerausbekommt  = datumVonReier(reierFindenZähler, ganzerFileName);// der zähler passt zu reier weil es wird wieder null jede file, die file möglich sind in datenArr[i]
schalter = true;
}
break;
case "wenigerals":
floTest = parsieren(datenArr[zähler]);// den wert wird in float parsiert, wenn nur buhstabe oder nichts = 0.0
if (floTest <= vergleichen){
etwasGefunden = true; // dann man sagt etwas;
datumHerausbekommt  = datumVonReier(reierFindenZähler, ganzerFileName);// der zähler passt zu reier weil es wird wieder null jede file, die file möglich sind in datenArr[i]
schalter = true;
}
break;
case "mehrals":
floTest = parsieren(datenArr[zähler]);// den wert wird in float parsiert, wenn nur buhstabe oder nichts = 0.0
if (floTest >= vergleichen){
etwasGefunden = true; // dann man sagt etwas;
datumHerausbekommt  = datumVonReier(reierFindenZähler, ganzerFileName);// der zähler passt zu reier weil es wird wieder null jede file, die file möglich sind in datenArr[i]
schalter = true;
}
break;
case "zwischen":
System.out.println("wasGenau = "+wasGenau);
break;

default:
System.out.println("\n -----  Filter ERROR  -----\n");

//														+##+#+#+##+#+##+#+##+++#
// ALLE DIE ANDERE CASE FEHLEN !!!!!!!!!!!!!!!!!!!!!  ########################

}// case switch..end 

} else if (datenZuSuchen.equals("Besonderheit") || datenZuSuchen.equals("Noten")){
//#############   ### baustelle totoal !!! '###############################################################################
	if(datenArr[zähler] != null || datenArr[zähler] != "" || datenArr[zähler] != " "){
		infoDesTages = datenArr[zähler].split(" ");
		for (String w : infoDesTages){
			if (w.equals(wasGenau)){
	datumHerausbekommt  = datumVonReier(reierFindenZähler, ganzerFileName);// der zähler passt zu reier weil es wird wieder null jede file, die file möglich sind in datenArr[i]

	schalter = true;
	etwasGefunden = true;
}
}
}
}
//###########################################################################################################################

if (datenZuSuchen.equals("Preiz")){
	counter = 0;
// von datenArr[zähler] die einzelne sache/preiz kriegen
	if (datenArr[zähler] != null || !datenArr[zähler].equals("")){
		arrSache = datenArr[zähler].split("/");

/* 	for (String p : arrSache){
	System.out.println(arrSache[counter] + "   " + datum[i]);
	counter++;
}*/
}else{
	String falschArray[]={"nix - 0"};
	arrSache = falschArray;
}
// BISHEAR MAN KANN ALLE DIE EINTRÄGE SEHEN

counter = 0;
char cn[];
//###### ##### ####   # # ## ##  ## ####  ## das teilt preiz und produkt 
for (String p : arrSache){
	cn = arrSache[counter].toCharArray();

	counter2 = 0;
	prod = "";
	prei = "";
	passt=false;
	for (char c :cn){
	//System.out.println(cn[counter2]);
		if (cn[counter2] == '-' ){
			passt = true;
		}else{
			if (!passt){
				prod = prod + String.valueOf(cn[counter2]);
			}
			else{
				prei = prei + String.valueOf(cn[counter2]);
			}
		}
		counter2++;
	}
	if (prei.equals("") || prei.equals(" ")){ prei =" [ kein preiz verfügbar ] ";}
//##################################################### AB HIER NUR FÜR PRODUCKT SUCHE
//JETZT HAT MAN PRODUCKT UND PREIZ GETRENNT
// SHAUEN OB EIN WORT VON PRODUCKT STIMMT MIT WASGENAU
//filter !!
//	System.out.println("PROD :"+ prod +" -->PREIZ : "+prei+"  AM : "+datumVonReier(reierFindenZähler,ganzerFileName)+"\n");

	/*array von produckt satz*/ 
	if(producktOderPreiz){
prodArr = prod.split(" "); // wenn zu splitten ist " ", der packt rein""  !!!
counter3=0;
ja = false;
for (String s : prodArr){
	if (prodArr[counter3].equals(wasGenau)){
		ja = true;
	}
	counter3++;
}
if (ja){
	System.out.println("PROD :"+ prod +" -->PREIZ : "+prei+   " AM : "+datumVonReier(reierFindenZähler,ganzerFileName)+"\n");
}
}else{
	// case , parsieren und finden ob zwischen funktioniert
}



// }filter  -- aber ist noch nicht eingestellt
counter++;
}
}

//#########################################################################################################################

if (einmahl && etwasGefunden){ // nur einmahl..
	do{
		System.out.println("\n  --- !!!! ----\nWerden gezeigt die tagen wann als "+datenZuSuchen+": >" +wasGenau+"< hingeshcrieben wurde, andere daten won welche Sort MITZEIGEN ?\n\n"+ausgeschlossenZeigen(datenZuSuchen,"1) NEIN NUR WANN -"+ wasGenau +"- im database gefunden wird",true,true));
		scan = new Scanner(System.in);
		antwort = scan.nextLine();
for (byte k = 2; k <= nummerGegenstände; k++){ // kontrollieren das die antwort zwischen 2 und 6 ist und isr nicht was scon gefragt hat "datenZuSuchen"
if (antwort.equals(String.valueOf(k)) && k != woMussSein(datenZuSuchen)+1 ){
	knt = true;
}
}
if (antwort.equals("1")){
	knt = true;
}
}while(!knt);
einmahl = false;
}

if (schalter && etwasGefunden){ // diese zeile sind im dem loop sodass die datum und  andere daten werden updated, aber sonstt drückt jedes mahl und nicht nur wenn eon wert gefunden wird
	if (antwort.equals("1")){
//datenDrücken(datumHerausbekommt,"alle");
		datenDrücken(datumHerausbekommt,"Datum");
		datenDrücken(datumHerausbekommt, datenZuSuchen );
	}else{
		datenDrücken(datumHerausbekommt,"Datum");
		datenDrücken(datumHerausbekommt, datenZuSuchen );
		datenDrücken(datumHerausbekommt,datVereinigung(String.valueOf(antwort)));
	}
	schalter = false;
}
//###########################
/**/zähler++;			 //##		ACHTUNG SEHR WICHTIG
/**/reierFindenZähler++; //##		DAS IST DER TRIEBRIEMER
//###########################
}
}
if (!etwasGefunden){
	System.out.println("kein wert gefunden vergleichbar mit  -" + wasGenau+" -  ");
}
}else{
	System.out.println("Das eingegebene zeitraum enthält keine daten");
}
}
}




public static float parsieren(String betreff){
	char bt[] = betreff.toCharArray();
	byte counter = 0;
	float endwert;
	boolean ignorieren = false;

	for(char b : bt){
		if (b ==','){
			bt[counter]='.';
		}else if(b =='.'){
//mach nix
		}else if(!Character.isDigit(b)){
			bt[counter]='0';
		}
		counter++;
	}

	String neue = new String(bt);
//System.out.print("--->"+neue+"<---");
	float endWert = Float.valueOf(neue);

	return endWert;
}


//############################################################################################################################################################################
//############################################################################################################################################################################





// suchen das Wort    önnte String mit datum als imput um das array zu machen.. datum ist das ID in diesem database von ganzerli massimo
/*	public static void suchen(String wert, String nameVonFile){

nameVonFile =(System.getProperty("user.dir")+"/2015/"+nameVonFile+".txt");
int arrGrösse = reierFinden(wert,nameVonFile).length;


if (arrGrösse > 0){// schaut ob es uberhaupt gibt es in dem file das wort in der richtigen position.
System.out.println("wert : " + wasGenau +" von Sort :" +datenZuSuchen+"\ngefunden  "+arrGrösse+ "  mahl \n");
if (arrGrösse > 1){
System.out.println(" 1) nur die tagen die (als Datum) gehören zu "+datenZuSuchen+ "zeigen \n 2) Alle die andere Daten auch? \n");
scan = new Scanner(System.in);
String antwort = scan.nextLine();
if (antwort.equals("1")){// unten antwort wird ein neuen wer bekommen
byte reier; // nur eine sort won dem gleichen tag zeigen
/*2)*//*			String datumHerausbekommt;
boolean knt = false;
String antwort2;
do{
System.out.println("\nWerden gezeigt die tagen wann als "+datenZuSuchen+": " +wasGenau+" hingeshcrieben wurde, andere daten won welche Sort MITZEIGEN ?\n\n"+ausgeschlossenZeigen(datenZuSuchen," 1) NEIN NUR WANN -"+ wasGenau +"- im database gefunden wird",true,true));

antwort2 = scan.nextLine();

for (byte i = 2; i <= nummerGegenstände; i++){ // kontrollieren das die antwort zwischen 2 und 6 ist und isr nicht was scon gefragt hat "datenZuSuchen"
if (antwort2.equals(String.valueOf(i)) && i != woMussSein(datenZuSuchen)+1 ){
knt = true;
}
}

if (antwort2.equals("1")){// hier antwort hat ein neuen wert
for (int i = 0 ; i <arrGrösse;i++){
	reier = Byte.valueOf(String.valueOf(reierFinden(wert,nameVonFile)[i])); // nimmt wo ist in dem file die reier 
	datumHerausbekommt  = datumVonReier(reier,nameVonFile); // kriegt die datum raus von der reier
	System.out.print(datenZuSuchen+": "+wasGenau+"  ");
	datenDrücken(datumHerausbekommt,"Datum"); // drückt
	knt = true;
}
}else if (knt){
for (int i = 0 ; i <arrGrösse;i++){
	reier = Byte.valueOf(String.valueOf(reierFinden(wert,nameVonFile)[i])); // nimmt wo ist in dem file die reier 
	datumHerausbekommt  = datumVonReier(reier,nameVonFile); // kriegt die datum raus von der reier
	System.out.print(datenZuSuchen+": "+wasGenau+"  ");
	datenDrücken(datumHerausbekommt,"Datum");
	datenDrücken(datumHerausbekommt,datVereinigung(String.valueOf(antwort2)));
}
}else{
System.out.println("\n:::::-----  Antwort nicht gültig, bitte wieder wählen  ----:::::\n");
}
}while(!knt);

}else{ 
byte reier;
/*2)*//*			String datumHerausbekommt;
for (int i = 0 ; i <arrGrösse;i++){
reier = Byte.valueOf(String.valueOf(reierFinden(wert,nameVonFile)[i]));
datumHerausbekommt  = datumVonReier(reier,nameVonFile);
datenDrücken(datumHerausbekommt,"alle");
}
}
}
}else{
System.out.println("wert -- "+ wasGenau +" -- , in >"+ datenZuSuchen  +" < nicht gefunden");
}
}*/
public static String[] datGesuchtHerausBekommen(String nameFile){
	String tempVar;
	int reierCounter=1;
	byte columncounter=0;
String monatArr[] = new String[31]; // nur maximale mänge
byte index=0;
String arrayFutter="";

fileÖffnen(System.getProperty("user.dir")+"/2015/"+nameFile+".txt");// macht schon den scann.
//System.out.println(nameFile);

if (scan.hasNext()){
	while(scan.hasNext()){
		tempVar = scan.next();

		if (tempVar.equals("<->")){
			columncounter++;
			if (columncounter==nummerGegenstände){
				columncounter = 0;
				reierCounter++;

				monatArr[index]=arrayFutter;
				index++;
				arrayFutter="";

			}
		}else if (columncounter == woMussSein(datenZuSuchen)){

			arrayFutter = arrayFutter +" "+tempVar;

//monatArr[index]=tempVar;
//index++;// hier index wird ein mahl mehr zu viehl, die konrolle while wird danach und das loop geht raus das array wird gefullt aber index wird win mahl mehr hinzugefügt

//System.out.println(monatArr[index] +"  "+ index);
		}
	}
}
String zuRückZugeben[] = new String[index]; //hier wird ein passende genau index array zurückgegeben, sodass das arraymethod die richtige mass hat;
for (byte i = 0; i <index ; i++){ /// index ist schon ein mahl oben zu viel, dann brauch man ken [index +1] und ; i <= index
	zuRückZugeben[i] = monatArr[i];
}
scan.close();
return zuRückZugeben;
}

public static String[] reierFinden(String wert,String nameVonFile){
	String tempVar;
	int reierCounter=1;
	byte columncounter=0;
	boolean gefunden = false;
	int arrMass = arrMass(wert,nameVonFile);
	arr = new String[arrMass];

	if (arrMass > 0 ){

		fileÖffnen(nameVonFile);
		int arrIndex = 0;

		if (scan.hasNext()){
			while(scan.hasNext()){
tempVar = scan.next(); // nur hier tempVar bekommt ein Wert

if (tempVar.equals("<->")){
	columncounter++;
	if (columncounter==nummerGegenstände){
		columncounter = 0;
		reierCounter++;
	}
}
if (tempVar.equals(wert) && columncounter == woMussSein(datenZuSuchen)){
	arr[arrIndex] = String.valueOf(reierCounter);

//System.out.println(arr[arrIndex]);
	arrIndex++;  
	
	if (arrIndex >= arrMass ){
		arrIndex = arrIndex;
	}
}
}
}
}else{
//System.out.println("wert -- "+ wasGenau +" -- nicht gefunden");
}	
scan.close();
return arr;
}

// rechnet wie viele mahl ein wort erscheint in einem file (in diesem fall return eine nummer die wird um das Mass von einem array zu geben benutzt)
public static int arrMass(String wert, String nameVonFile){
	int counter =0;
	byte columncounter =0;
	byte reierCounter=0;
	String tempVar="";

	fileÖffnen(nameVonFile);
	if (scan.hasNext()){
		while(scan.hasNext()){
			tempVar= scan.next();
			if (tempVar.equals("<->")){
				columncounter++;
				if (columncounter==nummerGegenstände){
					columncounter = 0;
					reierCounter++;
				}
			}
			if (tempVar.equals(wert) && columncounter == woMussSein(datenZuSuchen)){
				counter ++;
			}
		}
	}
	scan.close();
	return counter;
}

public static String datumVonReier(byte reierNummer,String nameVonFile){

	byte reierCounter=1;
	byte columncounter=0;
	String tempVar="";
	String dat="";

	fileÖffnen(nameVonFile);

	if (scan.hasNext()){
		while(scan.hasNext()){
tempVar = scan.next(); // nur hier tempVar bekommt ein Wert

if (reierNummer == reierCounter){
	dat = tempVar;
	break;
}

if (tempVar.equals("<->")){
	columncounter++;
	if (columncounter==nummerGegenstände){
		columncounter = 0;
		reierCounter++;
	}
}
}
}
scan.close();
return dat;
}

public static byte woMussSein (String datenZuSuchen){
	byte zuDagegenGeben;
	switch(datenZuSuchen){
		case "Datum":zuDagegenGeben=Byte.valueOf("0");break;
		case "Eingenommen":zuDagegenGeben=Byte.valueOf("1");break;
		case "Besonderheit":zuDagegenGeben=Byte.valueOf("2");break;
		case "Noten":zuDagegenGeben=Byte.valueOf("3");break;
		case "Ausgegeben":zuDagegenGeben=Byte.valueOf("4");break;
		case "Preiz":zuDagegenGeben=Byte.valueOf("5");break;
		default: zuDagegenGeben=Byte.valueOf("0");
	}
	return zuDagegenGeben;
}	
// eine string zurückgeben die nur die andere nicht der ausgewählt in den möglichkeiten zeigt
public static String ausgeschlossenZeigen(String ausgeschlossen, String wasAnders, boolean mitNeueReie, boolean auchNummerZeigen){

	String neueReier="";
	String möglichkeitZeigen="";

	if (mitNeueReie){
		neueReier = "\n";
	}
	if (!wasAnders.equals("nein")){
		möglichkeitZeigen =  wasAnders +" "+neueReier;
	}
	for (byte i = 2; i<= nummerGegenstände; i++){
		if (ausgeschlossen == datVereinigung(String.valueOf(i))){
// nix wird es trotzdem nicht gezeigt;
		}else if (auchNummerZeigen){
			möglichkeitZeigen = möglichkeitZeigen + String.valueOf(i)+") "+datVereinigung(String.valueOf(i))+ neueReier;
		}else{
			möglichkeitZeigen = möglichkeitZeigen + datVereinigung(String.valueOf(i))+" "+neueReier;
		}
	}
	return möglichkeitZeigen;
}
/*############################################################################################################################################################################
##############################################    MAN KANN LESEN DATUM UND ALLES ANDERE SORTE ZEIGEN #########################################################################
###############################################   ABER NUR VON EINEM FILE .... ###############################################################################################
##############################################################################################################################################################################*/
// SEIT IMMER OPTIMIZIEREN..	//LETZTE DATUM KRIEGEN...

// method dre mit den letzten tag eingegeben return die file zu lesen..
/// ACHTUNG   #    #    #  ACHTEN DARAUF DASS WIRD NIE EINE FALSCHE DATUUM HINGESCHRIEBEN WIE 40-2015 ODER SO VAS
public static String[] wieVieleFile(boolean seitImmer,String erstesFile,String grenzeDatum){
	boolean stop = false;
	String erMonat="";
	String erJahr="";
	String leJahr ="";
	String leMonat = "";
	String tempNameFile="";
	byte counter = 0;
	byte arrMass;
	String sammlungString="";
// wenn nicht seit immer 11-2015 ist das erste datum;
	if (seitImmer){
		erstesFile = "11-2015";
	}
	char arrErsteDatum[] = erstesFile.toCharArray();
	char arrGrenzeDatum[] = grenzeDatum.toCharArray();

	for (byte i = 0; i<2; i++){
		erMonat = erMonat + String.valueOf(arrErsteDatum[i]);
		if (!seitImmer){
			leMonat = leMonat + String.valueOf(arrGrenzeDatum[i]);
		}
	}
	for(byte i = 3; i<=6; i++ ){
		erJahr = erJahr + String.valueOf(arrErsteDatum[i]);
		if (!seitImmer){
			leJahr  = leJahr +String.valueOf(arrGrenzeDatum[i]);
		}
	}

	if ( Byte.valueOf(erMonat) > 12 || Byte.valueOf(erMonat) < 1 || Integer.valueOf(erJahr) > 2024 ) {
		stop = true;
		String error[] = new String[] {"Error"};
		return error;
	}

	if (!seitImmer){
		if(Byte.valueOf(leMonat) > 12 || Byte.valueOf(leMonat) < 1 || Integer.valueOf(leJahr) > 2024){
			stop = true;
			String error[] = new String[] {"Error"};
			return error;
		}
	}  
	int jahr = Integer.valueOf(erJahr);
	byte i = Byte.valueOf(erMonat);

	while(!stop){

		for (i = i ; i<=12; i++){

			if (i<10){
				tempNameFile ="0"+ String.valueOf(i)+"-"+String.valueOf(jahr);

				if (checkFile(tempNameFile)){
					sammlungString = sammlungString + tempNameFile;
				}
			}else{
				tempNameFile = String.valueOf(i)+"-"+String.valueOf(jahr);

				if (checkFile(tempNameFile)){
					sammlungString = sammlungString + tempNameFile;
				}
			}
			if (grenzeDatum.equals(tempNameFile)){
				i = 13; 
				stop =true;
			}
		}
		if (!stop){
			i=1;
			jahr ++;
			if (seitImmer){
counter ++;			//  ###########################################################################################################################
if (counter > 10){  //  ## diese nummer stellt fest wie viele jahre die programme kann unbenutzt bleiben und noch die function Datensuchen haben ##
stop = true;	//  ###########################################################################################################################
}
}
}
} // stop!!


if(sammlungString.length() > 7){
	arrMass = Byte.valueOf(String.valueOf(sammlungString.length() / 7));

	String arrFiles[] = new String[arrMass];
	char etwas[] = sammlungString.toCharArray();
	counter = 0;
	arrFiles[0]="";
	int flow=7;
	byte a = 0;
	String tempVar = "";
	do{
//	System.out.println(" counter!! "+counter);	
		do{
			if (a < sammlungString.length()){
				tempVar = tempVar + etwas[a];
			}
			a++;		
		}while(a < flow);

		arrFiles[counter] = tempVar;
//System.out.println(arrFiles[counter] +"  "+ flow +" "+a);	
		tempVar = "";
		flow = flow + 7;
		counter++;

	}while(counter < arrMass);

	return arrFiles;

}else{
	String arrFiles[] = {sammlungString};
	return arrFiles;
}
}



public static void goDatenSuche(){
	frage();
	setWasGenau();

	if (datenZuSuchen.equals("Datum")){
		wennDatum();
	}else{
		suche();
	}
}




//-------------------------------------------- TEST 		 TEST  		TEST  		TEST  		TEST :::----------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------

public static void main(String[] args) {
	frage();
	setWasGenau();
//erleichterung();

//System.out.println(	wieVieleFile(false,"11-2015","12-2016")[0]);
	if (datenZuSuchen.equals("Datum")){
		wennDatum();
	}else{



//suchen(wasGenau,"11-2015");
		suche();
	}
}
}

