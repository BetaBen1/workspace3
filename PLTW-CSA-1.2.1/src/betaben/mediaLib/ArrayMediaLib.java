package betaben.mediaLib;

public class ArrayMediaLib {

	public static void main(String[] args) {
		
		String[] sharingFriends = {new String("Douglas"),
								   new String("Patricia"),
								   new String("Harrison"),
								   new String("Ben"),
								   new String("Brandon"),
								   new String("Adam")
		};
		
		for (int i=0; i<sharingFriends.length; i++)
		{
		    System.out.println(sharingFriends[i]);
		}
		
		int[] daysBtwnPurchase = {2, 5, 1, 2, 4, 2, 1, 3};

		int total = 0;
		
		for(int i=0; i<daysBtwnPurchase.length; i++){
			total+=daysBtwnPurchase[i];
		}
		
		int average = total/daysBtwnPurchase.length;
		System.out.println("Average days between purchase: " + average);
		
		Song[] topTenSongs = {new Song("The Twist"),
                new Song("Smooth"),
                new Song("Mack the Knife"),
                new Song("How Do I Live"),
                new Song("Party Rock Anthem"),
                new Song("I Gotta Feeling"),
                new Song("Macarena (Bayside Boys Remix)"),
                new Song("Physical"),
                new Song("You Light Up My Life"),
                new Song("Hey Jude"),
                };
		
		/*for (Song songs: topTenSongs)
		{
		    System.out.println(songs.getName());
		}
		
		System.out.println("\n—BEFORE--");
        for (Song changeSong : topTenSongs) { 
            System.out.println(changeSong.getName());
        	changeSong.setName("test");
        }
        
        for (Song changeSong: topTenSongs) {
            changeSong = new Song("test");
            System.out.println(changeSong.getName());
        }
        
        // show the array
		
		for(int i=0; i < topTenSongs.length; i++) {
			topTenSongs[i].setPrice(2.99);
		}
		
		for(int i=0; i < topTenSongs.length; i+=3) {
			topTenSongs[i].setPrice(topTenSongs[i].getPrice()-.99);
		}
		
        //System.out.println("\n—AFTER--");
        for (Song showSong : topTenSongs) {
            System.out.println(showSong.getName() + "; " + showSong.getPrice());
        }
        
        for(int i=0; i < topTenSongs.length/2; i++){
        	System.out.println(topTenSongs[i].getName());
        }*/
		
        int index = SongFinder.findTitle(topTenSongs, "Smooth");
        if (index >= 0) {
            System.out.println("Found " + topTenSongs[index].getName());
        }
        else {
            System.out.println("Song not found!");
        }
		
		
	}

}
