import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;

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
			fostream = new FileOutputStream(".\\finalSong.aiff");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		// Loops through notes and adds them to the fostream
		for (Note n : song) {
			// Make note file name
			String fName = ("Piano.ff." + n.getNote() + n.getCondition() 
								+ n.getOctave() + ".aiff");
			File f = new File(".\\piano-aiff\\" + fName);
			// Check if file exists
			if (!f.exists()) {
				System.out.println("Error: " + fName + " does not exist. " +
							"Skipping and continuing with rest of song.");
				continue;
			}
			// Append the note to the final file
			try {
				appendmp3file(fostream, AudioSystem.getAudioInputStream(f), n);
			} catch (Exception e) {
				e.printStackTrace();
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
	private void appendmp3file(FileOutputStream fos, AudioInputStream ais, Note n) {
		// Write the file to the output stream
		try {
			// Get the audio input stream
			AudioInputStream decompressedStream = AudioSystem.getAudioInputStream(
													AudioFormat.Encoding.PCM_SIGNED, 
													ais);
			// Get the audio format
			AudioFormat audioFormat = decompressedStream.getFormat();
			// Get the frame size
			int frameSize = audioFormat.getFrameSize();
			// Get the frame rate
			float frameRate = audioFormat.getFrameRate();
			// Frames to skip first four seconds
			long framesToSkip = (long) (frameRate * 4);
			// Number of frames to read based on the length of the note
			long framesToRead = (long) (frameRate * n.getLength());
			// Skip the first four seconds
			decompressedStream.skip(framesToSkip * frameSize);
			// Read the frames
			byte[] bytes = new byte[(int) (framesToRead * frameSize)];
			decompressedStream.read(bytes, 0, (int) (framesToRead * frameSize));
			// Write the bytes to the output stream
			fos.write(bytes);
			// Close the stream
			decompressedStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}