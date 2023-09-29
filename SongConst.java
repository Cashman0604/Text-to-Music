import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFileFormat;

public class SongConst {
	static String outputFileName = ".\\finalSong.aiff";
	int tempo;
	ArrayList<Note> song;
	int volume;
	
	//Constructors
	public SongConst() {
		tempo = 60;
		song = null;
		volume = 1;
	}
	public SongConst(ArrayList<Note> s, int t) {
		tempo = t;
		song = s;
		volume = 1;
	}
	public SongConst(ArrayList<Note> s, int t, int v) {
		tempo = t;
		song = s;
		volume = v/100;
	}

	/* Parse through the Note list in the song and add the appropriate note to 
	 * an mp3 file
	 */ 
	public void fileBuilder(String fileName) {
		// TODO: switch files to wav format

		// Create the output stream for the final file
		FileOutputStream fostream = null;
		try {
			fostream = new FileOutputStream(outputFileName);
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
		try {
			// Get the audio format
			AudioFormat audioFormat = ais.getFormat();
			// Get the number of bytes per frame
			int bytesPerFrame = audioFormat.getFrameSize();
			// Get number of bytes to read
			long numBytesRead = (long) (audioFormat.getFrameRate() * 
							n.getLength() * bytesPerFrame * 60 / tempo);

	
			// Read the bytes
			byte[] bytes = new byte[(int) numBytesRead];
			ais.read(bytes);
	
			// Find a zero crossing near the end of the segment
			int zeroCrossingIndex = findZeroCrossingIndex(bytes, audioFormat);
	
			// Adjust the end point to the zero crossing
			numBytesRead = zeroCrossingIndex * bytesPerFrame;
	
			// Set the volume
			for (int i = 0; i < bytes.length; i++) {
				bytes[i] = (byte) (bytes[i] * volume);
			}

			while (ais.read() != -1) {
				// Run through remaining data
			}
			ais.close();
	
			// Write the bytes to the output stream
			AudioInputStream ais2 = new AudioInputStream(new ByteArrayInputStream(bytes),
					audioFormat, numBytesRead);
			AudioSystem.write(ais2, AudioFileFormat.Type.AIFF, fos);
			fos.flush();

			while (ais2.read() != -1) {
				// Run through remaining data
			}
			ais2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Find a zero crossing index near the end of the audio data
	private int findZeroCrossingIndex(byte[] audioData, AudioFormat audioFormat) {
		int frameSize = audioFormat.getFrameSize();
		int sampleSizeInBits = audioFormat.getSampleSizeInBits();
		int channels = audioFormat.getChannels();
		int bytesPerSample = sampleSizeInBits / 8;
	
		// Calculate the number of samples
		int numSamples = audioData.length / (frameSize * channels);
	
		for (int i = numSamples - 1; i >= 0; i--) {
			int startIndex = i * frameSize * channels;
			int endIndex = (i + 1) * frameSize * channels;
	
			for (int j = startIndex; j < endIndex; j += bytesPerSample) {
				// Extract the sample value (assuming little-endian encoding)
				int sampleValue = 0;
				for (int k = 0; k < bytesPerSample; k++) {
					sampleValue |= ((int) audioData[j + k] & 0xFF) << (8 * k);
				}
	
				// Check if the sample value is close to zero
				if (Math.abs(sampleValue) < ZERO_CROSSING_THRESHOLD) {
					return i * frameSize * channels;
				}
			}
		}
	
		// If no zero crossing is found, return the end of the data
		return audioData.length;
	}
	
	// Define a threshold for zero crossings
	private static final int ZERO_CROSSING_THRESHOLD = 1000;
}