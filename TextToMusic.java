import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class TextToMusic{

	File file = new File("\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\text.txt");
	ArrayList<Note> song = new ArrayList<Note>();
	
	public void runner() throws FileNotFoundException {
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
		String condition = "natural";
		
		//determine note and octave
		if(s.substring(0,1).equals("e")) {
			note ="A";
			octave = 1;
		}
		if(s.substring(0,1).equals("m")) {
			note ="A";
			octave = 2;
		}
		if(s.substring(0,1).equals("w")) {
			note ="A";
			octave = 3;
		}
		if(s.substring(0,1).equals("t")) {
			note ="B";
			octave = 1;
		}
		if(s.substring(0,1).equals("u")) {
			note ="B";
			octave = 2;
		}
		if(s.substring(0,1).equals("f")) {
			note ="B";
			octave = 3;
		}
		if(s.substring(0,1).equals("a")) {
			note ="C";
			octave = 1;
		}
		if(s.substring(0,1).equals("c")) {
			note ="C";
			octave = 2;
		}
		if(s.substring(0,1).equals("g")) {
			note ="C";
			octave = 3;
		}
		if(s.substring(0,1).equals("z")) {
			note ="C";
			octave = 1;
		}
		if(s.substring(0,1).equals("o")) {
			note ="D";
			octave = 1;
		}
		if(s.substring(0,1).equals("l")) {
			note ="D";
			octave = 2;
		}
		if(s.substring(0,1).equals("y")) {
			note ="D";
			octave = 3;
		}
		if(s.substring(0,1).equals("q")) {
			note ="D";
			octave = 1;
		}
		if(s.substring(0,1).equals("i")) {
			note ="E";
			octave = 1;
		}
		if(s.substring(0,1).equals("d")) {
			note ="E";
			octave = 2;
		}
		if(s.substring(0,1).equals("p")) {
			note ="E";
			octave = 3;
		}
		if(s.substring(0,1).equals("x")) {
			note ="E";
			octave = 1;
		}
		if(s.substring(0,1).equals("n")) {
			note ="F";
			octave = 1;
		}
		if(s.substring(0,1).equals("r")) {
			note ="F";
			octave = 2;
		}
		if(s.substring(0,1).equals("b")) {
			note ="F";
			octave = 3;
		}
		if(s.substring(0,1).equals("j")) {
			note ="F";
			octave = 1;
		}
		if(s.substring(0,1).equals("s")) {
			note ="G";
			octave = 1;
		}
		if(s.substring(0,1).equals("h")) {
			note ="F";
			octave = 2;
		}
		if(s.substring(0,1).equals("v")) {
			note ="F";
			octave = 3;
		}
		if(s.substring(0,1).equals("k")) {
			note ="F";
			octave = 1;
		}
		
		//determine condition
		if(s.length()>1) {
			if(s.substring(1,2).equals("a")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("b")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("c")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("d")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("e")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("f")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("g")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("h")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("q")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("z")) {
				condition = "natural";
			}
			if(s.substring(1,2).equals("i")) {
				condition = "natural";
			}
			
			if(s.substring(1,2).equals("r")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("l")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("u")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("w")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("g")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("p")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("v")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("j")) {
				condition = "sharp";
			}
			if(s.substring(1,2).equals("d")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("c")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("m")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("f")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("y")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("b")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("k")) {
				condition = "flat";
			}
			if(s.substring(1,2).equals("x")) {
				condition = "flat";
			}
			
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
		if(s.substring(s.length()-1,s.length()).equals(".")) {
			song.add(new Note(1));
		}
		if(s.substring(s.length()-1,s.length()).equals(",")) {
			song.add(new Note(2));
		}
		if(s.substring(s.length()-1,s.length()).equals("?")) {
			song.add(new Note(3));
		}
		if(s.substring(s.length()-1,s.length()).equals("!")) {
			song.add(new Note(4));
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