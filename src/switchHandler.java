

import java.util.Scanner;

class switchHandler {

	byte moeglichkeitGewaehlt;
	byte moeglichkeitSwitch;
	Scanner s;

	public switchHandler(byte moeglichkeitGewaehlt){
		this.moeglichkeitGewaehlt = moeglichkeitGewaehlt;
	}

	public void moeglichkeit(){

		switch (moeglichkeitGewaehlt){

		case 1:  
			datenIn di = new datenIn();
			di.datenRein();

			System.out.println("die obere angegebene daten (des Tages) " + di.getDatum() +" einschreiben? [ja -- nein]");

			s = new Scanner(System.in);
			String antwort = s.nextLine(); 			

			if (antwort.equals("ja") || antwort.equals("j")){

				di.umtausch(di.getDatum(),'/','-');
				di.fileCheck(di.getDatumZuNameFile()+".txt");
			}else{
				System.out.println("	Nix geschrieben..");
			}
			break;   

		case 2:
			Datensuche ds = new Datensuche();
			ds.goDatenSuche();
		break;  ////////////////////////////////////////////

		default:
		System.out.println(System.getProperty("user.dir"));

		break;
		}

}


}