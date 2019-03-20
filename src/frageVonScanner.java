

import java.util.Scanner;

class frageVonScanner {

private Scanner input = new Scanner(System.in);
private String frage;
private byte antwort;
private boolean pass= false;

public frageVonScanner(String frage){
		this.frage = frage;

}

public void antwortBekommen(){
	System.out.println(frage);
	antwort = input.nextByte();

	if (antwort == 1 || antwort == 2 || antwort == 3 || antwort == 4 || antwort == 5){
		pass = true;
	}

}

public byte getAntwort(){
	return antwort;
}

public Boolean fallsPass(){
	return pass;
}

}