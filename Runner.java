import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Runner {
	public static void main(String[]args) throws IOException {
		// Remove any finalSong.mp3 files if there are any
		File f = new File(".\\finalSong.mp3");
		if (f.exists()) {
			f.delete();
		}

		String fileName = "text.txt";
		File file = getUserFile(true);
		TextToMusic run = new TextToMusic();
		run.runner(file);
		
		SongConst test = new SongConst(run.getSong());
		test.fileBuilder(fileName);
		
	}

	// Get a file from the user. If defaultFile is true, then use the default 
	// file of text.txt
	// If defaultFile is false, then ask the user for a file name and make sure
	// it exists
	private static File getUserFile(boolean defaultFile) {
		if (defaultFile) {
			return new File(".\\text.txt");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file you want to convert to music: ");
		String fileName = sc.nextLine();
		File file = new File(".\\" + fileName);
		while (!file.exists()) {
			System.out.println("File does not exist. Please enter a valid " + 
								"file name in the directory: ");
			fileName = sc.nextLine();
			file = new File(".\\" + fileName);
		}
		sc.close();
		return file;
	}
}
