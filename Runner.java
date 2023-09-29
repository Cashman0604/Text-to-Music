import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Runner {
	public static void main(String[]args) throws IOException {
		// Remove any finalSong.mp3 files if there are any
		File f = new File(".\\finalSong.aiff");
		if (f.exists()) {
			f.delete();
		}

		// Get the file from the user or default to text.txt
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to use the default file of text.txt? (y/n) ");
		String answer = sc.nextLine();
		String answer2 = "n";
		if (!answer.equals("y")) { 
			System.out.print("Would you like to see instructions on how to input a file? (y/n) ");
			answer2 = sc.nextLine();
		}

		// Get the tempo
		System.out.print("Enter the tempo of the song (in bpm). Nothing for default (60 bpm): ");
		String tempo;
		do {
			tempo = sc.nextLine();
			if (tempo.length() == 0 || isInteger(tempo)) {
				break;
			} else {
				System.out.print("Please enter a valid integer: ");
			}
		} while (true);

		if (tempo.length() == 0) {
			tempo = "60";
		}

		int tempoInt = Integer.parseInt(tempo);

		// Run program logic
		File file = getUserFile(answer.equals("y"), answer2.equals("y"));

		// Close scanner if it's open
		if (sc != null) {
			sc.close();
		}
		TextToMusic run = new TextToMusic();
		run.runner(file);
		
		SongConst test = new SongConst(run.getSong(), tempoInt, 100);
		test.fileBuilder(file.getName());
		
	}

	/* Get a file from the user. If defaultFile is true, then use the default 
	 * file of text.txt
	 * If defaultFile is false, then ask the user for a file name and make sure
	 * it exists in the directory
	 */
	private static File getUserFile(boolean defaultFile, boolean instructions) {
		if (defaultFile) {
			return new File(".\\text.txt");
		}
		Scanner sc = new Scanner(System.in);

		if (instructions) {
			// Instructions for users to input file name
			System.out.println("Enter the name of the file you want to convert to music. ");
			System.out.println("If the file is in the same directory as this program, " + 
								"then just enter the file name. ");
			System.out.println("If the file is in a different directory, then enter the " +
								"file path. (Can be in format .\\text.txt or C:\\Users\\... " + 
								"[For Mac users, the / file path should work])");
			System.out.println("If you do not enter a file name, then the default file " +
								"of text.txt will be used. ");
		}
		System.out.print("\nEnter file name: ");


		File file;
		String fileName;
		do {
			fileName = sc.nextLine();
			if (fileName.length() == 0) {
				file = new File(".\\text.txt");
			} else if (fileName.substring(0, 1).equals(".")) {
				file = new File(fileName);
			} else if (fileName.substring(1, 2).equals(":")) {
				file = new File(fileName);
			} else if (fileName.substring(0, 1).equals("/")) {
				file = new File(fileName);
				System.out.println("Either you're using a Mac or you're trying to " +
									"break my program. Either way, you're wrong.");
			} else {
				file = new File(".\\" + fileName);
			}
			
			if (!file.exists()) {
				System.out.print("File does not exist. Please enter a valid " + 
									"file name in the directory: ");
			}
		} while (!file.exists());

		sc.close();
		return file;
	}

	static private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
