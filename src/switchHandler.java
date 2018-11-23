
import java.util.Scanner;


class switchHandler {

	byte möglichkeitGewählt;
	byte möglichkeitSwitch;
	Scanner s;

	public switchHandler(byte möglichkeitGewählt){
		this.möglichkeitGewählt = möglichkeitGewählt;
	}

	public void möglichkeit(){

		switch (möglichkeitGewählt){

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