
public class klasseVersuch{

public static void main(String[] args) {

	platz platz = new platz ();
	platz.mp();
	//////ramen ////////
	for (byte i = 0; i<20 ; i++){
		System.out.print("-:-:-:-:");
	}
	//////// ramen /////
	
	//////////////gruess///////////
	platz.mp();
	platz.mp();
	gruss g = new gruss("wilkommen in den neuen vervaltungsprogramm");
	System.out.println(g.mach());
	platz.mp();
	////////---fertig gruess-----///
	/*  *schauen ob es iemanden scon gibt  
		* name enter,
		* lesen die namen
		*schauen in den file wo die namen sind um zu sehen ob der user schon das programm benutzt hat
	*/
	frage niegewesen = new frage();
	niegewesen.fragestellen();
	platz.mp();
		
	platz.mp();

	autentifizierung l = new autentifizierung(niegewesen.getvorname(),niegewesen.getfamilienname());
	/////////////////////////  name suche ////////////////////////
		l.filereiercounter(); // das brauch man um dem array in autentifizierung classe, method arrayvonfile eine vorzustand gestalten
		l.fileOeffnen();
		l.namesuchen();
		l.fileschliessen(); // verbessern das wenn meh mit gleiche name in dem file sind etwas muss genau werden
	platz.mp();  
	/*name kann rein, hinzugefugt werden*/
 	////////////////////// FRAGE NACH DEM SICH RE INSCHREIBEN /////// 
 	// fragen vas zu machen.. ein file mit daten oder exit oder alle die namen zeigen

	//pierdole();

	if (l.sperre()){ 

		frageVonScanner fvs = new frageVonScanner("Datensteuerung moglich. Was mochten Sie jetzt machen?\n 1) Neue Daten einschreiben\n 2) Daten suchen\n 3) Daten Ändern \n 4) Daten Loschen \n 5) Exit\n Nummer eingeben als Antwort:");
		fvs.antwortBekommen();

		if (fvs.fallsPass()){

			switchHandler sh = new switchHandler(fvs.getAntwort());
			sh.moeglichkeit();

 			/// Object o = Integer.valueOf( 42 );

		}else if (!fvs.fallsPass()){
		System.out.println("\n       :...Antwort nicht gueltig...:\n ");
		}
	} 		// von if (l.sperre())

 }   //// MAIN !!! MAIN   MAIN    MAIN    MAIN     MAIN   M A I N      <------


}// end class
