/* Note.java
 * Creates a note of a certain length, octave, note, and condition
 * Note: A rest is a note with note = "R"
 * Contains getters, toString, and compareTo
 */
public class Note implements Comparable<Note> {
	//determined by word length
	private int length;
	//determined by first letter
	private int octave;
	private String note;
	// determined by second letter. If none, it's natural
	// 'b' = flat, '#' = sharp, '' = natural (# should never occur)
	private String condition;

	// Default constructor
	public Note(int l) {
		// Default note is a rest
		length = l;
		octave = 1;
		note = "R";
		condition = "";
	}

	// Constructor for a note
	public Note(int l,int o,String n, String c) {
		length = l;
		octave = o;
		note = n;
		condition = c;
	}

	// Getters
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

	/* Compares 2 notes based on how high or low they are
	 * If this note is higher, returns 1
	 * If this note is lower, returns -1
	 * If they are the same, returns 0
	 */
	public int compareTo(Note n) {
		if (this.octave != n.octave) {
			return this.octave - n.octave;
		} else if (this.note.equals("R")) {
			return -1;
		} else if (n.note.equals("R")) {
			return 1;
		} else if (this.note.equals(n.note)) {
			if (this.condition.equals(n.condition)) {
				return 1;
			} else {
				return -this.condition.compareTo(n.condition);
			}
		} else {
			return 1;
		}
	}
}
