import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class SongConst {
	int tempo;
	ArrayList<Note> song;
	BufferedInputStream bif;
	
	//Constructors
	public SongConst() {
		tempo = 100;
		song = null;
	}
	public SongConst(ArrayList<Note> s) {
		tempo = 100;
		song = s;
	}
	public SongConst(ArrayList<Note> s, int t) {
		tempo = t;
		song = s;
	}

	/* Parse through the Note list in the song and add the appropriate note to 
	 * an mp3 file
	 */ 
	public void fileBuilder(String fileName) {
		// TODO: switch files to wav format

		// Create the output stream for the final file
		FileOutputStream fostream = null;
		try {
			fostream = new FileOutputStream(".\\finalSong.mp3");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Loops through notes and adds them to the fostream
		for (Note n : song) {
			for (int i = n.getLength(); i > 0; i--) {
				// Make note file name
				String fName = ("" + n.getNote() + n.getCondition() 
									+ n.getOctave() + ".mp3");
				File f = new File(".\\piano-mp3\\" + fName);
				// Check if file exists
				if (!f.exists()) {
					System.out.println("Error: Note file does not exist. " +
								"Skipping and continuing with rest of song.");
					continue;
				}
				// Append the note to the final file
				try {
					appendmp3file(fostream, new FileInputStream(f));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		// Close all the streams
		try {
			fostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Append the given fis to the mp3 file. 
	 * fis will be a note audio file
	 */
	private void appendmp3file(FileOutputStream fos, InputStream fis) {
		// Write the file to the output stream
		try {
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, read);
			}
			fos.flush();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}