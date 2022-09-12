public class Note {
	//determined by word length
	private int length;
	//determined by first letter
	private int octave;
	private String note;
	//determined by second letter. If none, it's natural
	private String condition;
	public Note(int l) {
		length = l;
		octave = 1;
		note = "R";
		condition = "natural";
	}
	public Note(int l,int o,String n, String c) {
		length = l;
		octave = o;
		note = n;
		condition = c;
	}
	public int getLength() {
		return length;
	}
	public int getOctave() {
		return octave;
	}
	public String getNote() {
		return note;
	}
	public String getCondition() {
		return condition;
	}
	public String toString() {
		return note+octave+" "+condition+" "+length; 
	}
}
