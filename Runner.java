import java.io.IOException;

public class Runner {
	public static void main(String[]args) throws IOException {
		TextToMusic run = new TextToMusic();
		run.runner();
		
		SongConst test = new SongConst(run.getSong());
		test.appender();
		
	}
}
