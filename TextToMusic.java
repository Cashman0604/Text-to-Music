import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class TextToMusic{

	ArrayList<Note> song = new ArrayList<Note>();
	
	public void runner(File file) throws FileNotFoundException {
		Scanner text = new Scanner(file);
		while(text.hasNext()) {
			ArrayList<String> line = new ArrayList<String>(Arrays.asList(text.next().split(" ")));
			for(int i = 0; i< line.size();i++) {
				noted(line.get(i));
			}
		}
		text.close();
	}
	
	//Determines the characteristics of the note
	public void noted(String s) {
		String note = "A";
		int octave = 1;
		int length = 1;
		String condition = "";
		
		//determine note and octave
		switch (s.substring(0, 1)) {
			case "e":
				note = "A";
				octave = 1;
				break;
			case "m":
				note = "A";
				octave = 2;
				break;
			case "w":
				note = "A";
				octave = 3;
				break;
			case "t":
				note = "B";
				octave = 1;
				break;
			case "u":
				note = "B";
				octave = 2;
				break;
			case "f":
				note = "B";
				octave = 3;
				break;
			case "a":
				note = "C";
				octave = 1;
				break;
			case "c":
				note = "C";
				octave = 2;
				break;
			case "g":
				note = "C";
				octave = 3;
				break;
			case "z":
				note = "C";
				octave = 1;
				break;
			case "o":
				note = "D";
				octave = 1;
				break;
			case "l":
				note = "D";
				octave = 2;
				break;
			case "y":
				note = "D";
				octave = 3;
				break;
			case "q":
				note = "D";
				octave = 1;
				break;
			case "i":
				note = "E";
				octave = 1;
				break;
			case "d":
				note = "E";
				octave = 2;
				break;
			case "p":
				note = "E";
				octave = 3;
				break;
			case "x":
				note = "E";
				octave = 1;
				break;
			case "n":
				note = "F";
				octave = 1;
				break;
			case "r":
				note = "F";
				octave = 2;
				break;
			case "b":
				note = "F";
				octave = 3;
				break;
			case "j":
				note = "F";
				octave = 1;
				break;
			case "s":
				note = "G";
				octave = 1;
				break;
			case "h":
				note = "F";
				octave = 2;
				break;
			case "v":
				note = "F";
				octave = 3;
				break;
			case "k":
				note = "F";
				octave = 1;
				break;
		}
		

		// Convert above to switch statement
		// switch (s.substring(0,1)) {
		
		//determine condition
		if(s.length()>1) {
			switch (s.substring(1, 2)) {
				case "a":
				case "c":
				case "d":
				case "e":
				case "g":
				case "h":
				case "q":
				case "z":
				case "i":
					condition = "";
					break;
				case "r":
				case "l":
				case "u":
				case "w":
				case "p":
				case "v":
				case "j":
					condition = "#";
					break;
				case "m":
				case "f":
				case "y":
				case "b":
				case "k":
				case "x":
					condition = "b";
					break;
			}				
		}

		// Adjust sharp notes to their flat counterparts
		if (condition.equals("#")) {
			switch (note) {
				case "A":
					note = "B";
					break;
				case "B":
					note = "C";
					break;
				case "C":
					note = "D";
					break;
				case "D":
					note = "E";
					break;
				case "E":
					note = "F";
					break;
				case "F":
					note = "G";
					break;
				case "G":
					note = "A";
					break;
			}
			condition = "b";
		}
		
		//determines length
		int size = 0;
		char[] splitWord = s.toCharArray();
		for(char c:splitWord) {
			size += c;
		}
		size /= splitWord.length;
		if(size<103) {
			length = 1;
		}else if(size<109) {
			length = 2;
		}else if(size<115) {
			length = 3;
		}else {
			length = 4;
		}
		song.add(new Note(length, octave, note, condition));
		
		//adds necessary rests
		switch (s.substring(s.length() - 1)) {
			case ".":
				song.add(new Note(1));
				break;
			case ",":
				song.add(new Note(2));
				break;
			case "?":
				song.add(new Note(3));
				break;
			case "!":
				song.add(new Note(4));
				break;
		}		
	}
	
	//returns the song array
	public ArrayList<Note> getSong(){
		return song;
	}
	
	public String toString() {
		String output = "";
		for(Note s: song) {
			output += s.toString()+"\n";
		}
		return output;
	}
}