import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

	// Parse through the Note list in the song and add the appropriate note to an mp3 file
	public void fileBuilder(String fileName) {

		// Loop through song notes and add the appropriate note to the mp3 file
		FileOutputStream fostream = null;
		try {
			fostream = new FileOutputStream(".\\finalSong.mp3");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO: handle note logic properly
		for (Note n : song) {
			for (int i = n.getLength(); i > 0; i--) {
				// Make map name
				String mapName = ("" + n.getNote() + n.getCondition() 
									+ n.getOctave() + ".mp3");
				File f = new File(".\\piano-mp3\\" + mapName);
				if (!f.exists()) {
					System.out.println("File does not exist");
				}
				try {
					appendmp3file(fostream, new FileInputStream(f), n);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// Close all the streams
		try {
			fostream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Append the given note to the mp3 file
	private void appendmp3file(FileOutputStream fos, InputStream fis, Note n) {
		// TODO Auto-generated method stub
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