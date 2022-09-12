import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;

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
	
	//parses through Note list and adds the appropriate note to an mp3 file
	public void appender() throws IOException {
		//imports all the notes
		FileInputStream a1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\A1.mp3");
		FileInputStream a2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\A2.mp3");
		FileInputStream a3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\A3.mp3");
		FileInputStream ab1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Ab1.mp3");
		FileInputStream ab2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Ab2.mp3");
		FileInputStream ab3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Ab3.mp3");
		FileInputStream b1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B1.mp3");
		FileInputStream b2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B2.mp3");
		FileInputStream b3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B3.mp3");
		FileInputStream bb1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Bb1.mp3");
		FileInputStream bb2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Bb2.mp3");
		FileInputStream bb3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Bb3.mp3");
		FileInputStream c1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\C1.mp3");
		FileInputStream c2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\C2.mp3");
		FileInputStream c3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\C3.mp3");
		FileInputStream cb1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B1.mp3");
		FileInputStream cb2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B2.mp3");
		FileInputStream cb3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\B3.mp3");
		FileInputStream d1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\D1.mp3");
		FileInputStream d2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\D2.mp3");
		FileInputStream d3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\D3.mp3");
		FileInputStream db1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Db1.mp3");
		FileInputStream db2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Db2.mp3");
		FileInputStream db3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Db3.mp3");
		FileInputStream e1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E1.mp3");
		FileInputStream e2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E2.mp3");
		FileInputStream e3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E3.mp3");
		FileInputStream eb1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Eb1.mp3");
		FileInputStream eb2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Eb2.mp3");
		FileInputStream eb3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Eb3.mp3");
		FileInputStream f1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\F1.mp3");
		FileInputStream f2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\F2.mp3");
		FileInputStream f3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\F3.mp3");
		FileInputStream fb1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E1.mp3");
		FileInputStream fb2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E2.mp3");
		FileInputStream fb3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\E3.mp3");
		FileInputStream g1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\G1.mp3");
		FileInputStream g2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\G2.mp3");
		FileInputStream g3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\G3.mp3");
		FileInputStream gb1 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Gb1.mp3");
		FileInputStream gb2 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Gb2.mp3");
		FileInputStream gb3 = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\Gb3.mp3");
		FileInputStream rest = new FileInputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\piano-mp3\\2-seconds-of-silence.mp3");

		//I don't really know how to describe the rest
		FileOutputStream fostream = new FileOutputStream("C:\\Users\\belkn\\eclipse-workspace\\TextToMusic\\src\\finalSong.mp3");
		
		// add a rest
		//appendmp3file(fostream, rest);
		
		//assign fistream to the note
		for(Note n:song) {
			for(int i = n.getLength();i>0;i--) {
			if(n.getNote().equals("A")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, a1, n);
			}else if(n.getNote().equals("A")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, a2, n);
			}else if(n.getNote().equals("A")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, a3, n);
			}else if(n.getNote().equals("B")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, b1, n);
			}else if(n.getNote().equals("B")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, b2, n);
			}else if(n.getNote().equals("B")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, b3, n);
			}else if(n.getNote().equals("C")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, c1, n);
			}else if(n.getNote().equals("C")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, c2, n);
			}else if(n.getNote().equals("C")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, c3, n);
			}else if(n.getNote().equals("D")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, d1, n);
			}else if(n.getNote().equals("D")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, d2, n);
			}else if(n.getNote().equals("D")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, d3, n);
			}else if(n.getNote().equals("E")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, e1, n);
			}else if(n.getNote().equals("E")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, e2, n);
			}else if(n.getNote().equals("E")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, e3, n);
			}else if(n.getNote().equals("F")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, f1, n);
			}else if(n.getNote().equals("F")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, f2, n);
			}else if(n.getNote().equals("F")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, f3, n);
			}else if(n.getNote().equals("G")&&n.getCondition().equals("natural")&&n.getOctave()==1) {
				appendmp3file(fostream, g1, n);
			}else if(n.getNote().equals("G")&&n.getCondition().equals("natural")&&n.getOctave()==2) {
				appendmp3file(fostream, g2, n);
			}else if(n.getNote().equals("G")&&n.getCondition().equals("natural")&&n.getOctave()==3) {
				appendmp3file(fostream, g3, n);
			}else if((n.getNote().equals("A")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("G")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, ab1, n);
			}else if((n.getNote().equals("A")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("G")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, ab2, n);
			}else if((n.getNote().equals("A")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("G")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, ab3, n);
			}else if((n.getNote().equals("B")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("A")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, bb1, n);
			}else if((n.getNote().equals("B")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("A")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, bb2, n);
			}else if((n.getNote().equals("B")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("A")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, bb3, n);
			}else if((n.getNote().equals("C")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("B")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, cb1, n);
			}else if((n.getNote().equals("C")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("B")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, cb2, n);
			}else if((n.getNote().equals("C")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("B")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, cb3, n);
			}else if((n.getNote().equals("D")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("C")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, db1, n);
			}else if((n.getNote().equals("D")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("C")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, db2, n);
			}else if((n.getNote().equals("D")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("C")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, db3, n);
			}else if((n.getNote().equals("E")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("D")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, eb1, n);
			}else if((n.getNote().equals("E")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("D")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, eb2, n);
			}else if((n.getNote().equals("E")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("D")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, eb3, n);
			}else if((n.getNote().equals("F")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("E")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, fb1, n);
			}else if((n.getNote().equals("F")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("E")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, fb2, n);
			}else if((n.getNote().equals("F")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("E")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, fb3, n);
			}else if((n.getNote().equals("G")&&n.getCondition().equals("flat")&&n.getOctave()==1) || (n.getNote().equals("F")&&n.getCondition().equals("sharp")&&n.getOctave()==1)) {
				appendmp3file(fostream, gb1, n);
			}else if((n.getNote().equals("G")&&n.getCondition().equals("flat")&&n.getOctave()==2) || (n.getNote().equals("F")&&n.getCondition().equals("sharp")&&n.getOctave()==2)) {
				appendmp3file(fostream, gb2, n);
			}else if((n.getNote().equals("G")&&n.getCondition().equals("flat")&&n.getOctave()==3) || (n.getNote().equals("F")&&n.getCondition().equals("sharp")&&n.getOctave()==3)) {
				appendmp3file(fostream, gb3, n);
			}else {
				appendmp3file(fostream, rest, n);
			}
			}
			
			//appends new note
			//temp = sistream;
		}
		

		
		
		fostream.close();

		a1.close();
		a2.close();
		a3.close();
		ab1.close();
		ab2.close();
		ab3.close();
		b1.close();
		b2.close();
		b3.close();
		bb1.close();
		bb2.close();
		bb3.close();
		c1.close();
		c2.close();
		c3.close();
		cb1.close();
		cb2.close();
		cb3.close();
		d1.close();
		d2.close();
		d3.close();
		db1.close();
		db2.close();
		db3.close();
		e1.close();
		e2.close();
		e3.close();
		eb1.close();
		eb2.close();
		eb3.close();
		f1.close();
		f2.close();
		f3.close();
		fb1.close();
		fb2.close();
		fb3.close();
		g1.close();
		g2.close();
		g3.close();
		gb1.close();
		gb2.close();
		gb3.close();
		rest.close();
		

		
	}
	
	  private void appendmp3file(FileOutputStream fos,InputStream fis, Note n ) {
			
		    int bytes_read;
		    byte[] buffer = new byte[4096];
		 
			try {
			while ((bytes_read = fis.read()) != -1) { 

				fos.write(bytes_read);
			}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
//		  	try {
//				fis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		  }
	
}