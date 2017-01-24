package betaben.mediaLib;

import java.util.ArrayList;

public class MediaController {
	
	/* 	MEDIA CONTROLLER CLASS
	 * 
	 *  - This class is designed to read and write song data from a hard drive.
	 *  - This class will write your song data from RAM to a text file
	 *    on your hard drive then read it back into RAM to display
	 *    in the console.
	 *    
	 */


	public static void main(String[] args) {
		
		// First gain access to your songs.
		// Either create songs here or create an instance of your ArrayList from MediaLib
		
		ArrayList<Song>	songs = new ArrayList<Song>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Book> books = new ArrayList<Book>();
		
		songs.add(new Song("This song", 1, 4));
		songs.add(new Song("This other song", 1, 4));
		songs.add(new Song("Another song", 1, 4));
		songs.add(new Song("Yet another song", 1, 4));
		
		movies.add(new Movie("This movie", 20, 5));
		movies.add(new Movie("This other movie", 20, 5));
		movies.add(new Movie("Another movie", 20, 5));
		
		books.add(new Book("Books", 5, 5));
		books.add(new Book("A book", 10, 5));
		
		// Create a for loop that will write your song data to "mymedia.txt"
		// Use a for loop to save the data to disk using MediaWriter.write();
		
		for(Song song : songs) {
			MediaWriter.write(song.getName() + "; " + song.getRating() + "; " + song.getPrice() + "; ");
		}
		
		for(Movie movie : movies) {
			MediaWriter.write(movie.getName() + "; " + movie.getRating() + "; " + movie.getPrice() + "; ");
		}
		
		for(Book book : books) {
			MediaWriter.write(book.getName() + "; " + book.getRating() + "; " + book.getPrice() + "; ");
		}
		
		
		// Now create a method to read the song data from "mymedia.txt" back to RAM
		// Use a for loop to read the data to a string, split it, then print the data to console.
		// Use MediaWriter.read(); to read the text file to a string.
		// The data must be parsed in the same way it was saved.
		
		String text[] = MediaWriter.read().split(";");
		
		for(int i=0; i < text.length - 1; i += 3){
			System.out.println(text[i] + ", " + text[i+1] + ", " + text[i+2]);
		}
		
		
		// DONE! :D
		
	}

}
