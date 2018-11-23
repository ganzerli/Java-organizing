
import java.util.Scanner;

public class frage {

	private String name;
	private String vorname;
	private String familienname;
	Scanner input;

	public frage (){

	}

	public void fragestellen (){
		// bitte name enter
		System.out.println("Bitte Vorname und Familienname eingeben");

		input = new Scanner(System.in);

		name = input.nextLine();

		String [] nameGetrennt = name.split(" "); // trennt wörter beim " "
		
		if(nameGetrennt.length == 1){
		vorname = nameGetrennt[0];
		}
		if (nameGetrennt.length==2){
		vorname = nameGetrennt[0];
		familienname = nameGetrennt[1];
		}

		//--------------------------//
		// bitte passwort enter
	}

	public String getvorname(){
		return this.vorname;
	}
	public String getfamilienname(){
		return this.familienname;
	}
}
