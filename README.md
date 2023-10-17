# Text-to-Music
This program takes a .txt file, either from the User or from the default text.txt, and turns it into a .aiff file.
The User can specify a file path for the input file and can change the tempo of the song.

To achieve this, the program uses an algorithm to determine the note letter, octave, length, and if it's flat or natural.
(There are no sharps, so any that would be sharp are converted to corresponding flats/naturals)
It then takes this note data and uses Audio Input Streams to create the .aiff file out of the many piano note files in
the piano-aiff directory. 

Known Issues:
- No Mac Support: I use Windows and I'm too lazy to implement it for Mac systems, so L
- Popping Between Notes: Literally have no idea why this is happening. ChatGPT can't fix this mess

Credits:
- AIFF sound files provided by https://theremin.music.uiowa.edu/MISpiano.html
