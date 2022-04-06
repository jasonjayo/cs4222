/*
    Jason Gill
    21304092
*/

public class PlayListDriver {
    public static void main(String[] args) {
        
        PlayList songs = new PlayList("Jason's Songs");

        /*  testing all the ways a track can be added:
                passing an instance of track class with:
                                                    4 arguments
                                                    3 arguments
                                                    2 arguments
                passing the arguments directly:
                                            4 argunents
                                            2 arguments
        */
        songs.add(new Track("Starlight", "Dave", 2022, 200));
        songs.add(new Track("Make Me Feel Good", "Belters Only Ft. Jazzy", 2022));
        songs.add(new Track("Where Are You Now", "Lost Frequencies & Calum Scott"));
        songs.add("Seventeen Going Under", "Sam Fender", 2021, 202);
        songs.add("Living In The Sun", "Sam Fender", 2019, 198);
        songs.add("House On Fire", "Mimi Weeb", 2022, 223);
        songs.add(new Track("The Motto", "Tiesto & Ava Max"));
        songs.add("Middle Of The Night", "Elley Duhe");
        songs.add("Another Love", "Tom Odell", 2020, 177);
        Track myTrack = new Track("Waves", "Animals");
        songs.add(myTrack);
        
        // should output the tracks of the playlist in a readable way
        songs.showList();

        // test setters and getters for track class
        System.out.println("Testing setters and getters for track class:"); 
        myTrack.setTitle("Heat Waves");
        System.out.printf("New title: %s\n", myTrack.getTitle());

        myTrack.setArtist("Glass Animals");
        System.out.printf("New artist: %s\n", myTrack.getArtist());

        myTrack.setDuration(230);
        System.out.printf("New duration: %d\n", myTrack.getDuration());

        myTrack.setYear(2020);
        System.out.printf("New year: %d\n", myTrack.getYear());

        // testing track's toString method
        System.out.println(myTrack);

        System.out.println("\nTesting compareTo with track with all the same details - should give 0:");
        System.out.println(myTrack.compareTo(new Track("Heat Waves", "Glass Animals", 2020, 230)));

        System.out.println("Testing compareTo with track that should come before this track - should give > 0:");
        System.out.println(myTrack.compareTo(new Track("A Beautiful World", "Ed Sheeran", 2015, 170)));

        System.out.println("Testing compareTo with track that should come before before track - should give < 0:");    
        System.out.println(myTrack.compareTo(new Track("I Run Everyday", "Ed Sheeran", 2015, 170)));

        songs.showList();

        // testing toString method of PlayList class
        System.out.println(songs);

        // test getName()
        System.out.printf("This playlist is called %s\n", songs.getName());

        // should remove 'The Motto' (case insensitive)
        if (songs.remove("the motto")) {
            System.out.println("Successfully removed 'the motto'!");
        }

        // shouldn't find any song
        if (!songs.remove("a song that doesn't exist")) {
            System.out.println("Couldn't find that song!");
        }

        songs.showList();

        System.out.println("Playing tracks in order:");
        // play all tracks in order
        songs.playAll(false);

        System.out.println("\nPlaying tracks in random order:");
        // play all tracks in random order
        songs.playAll(true);

        System.out.print("\nOrder of playlist hasn't actually changed:");    
        // order of playlist shouldn't be changed, so let's double check
        songs.showList();

        // should play only 'Seventeen Going Under' & 'Living In The Sun'
        System.out.println("\nPlaying tracks from artist containing 'fend':");
        songs.playOnly("fend");

        // should play only 'Another Love' and 'Heat Waves'
        System.out.println("\nPlaying tracks from 2020:");
        songs.playOnly(2020);

        // should give no output
        songs.playOnly("an artist that doesn't exist");

        // unnamed playlist - should be set to default name
        System.out.println("\nUnnamed playlist:");
        PlayList unnamedPlaylist = new PlayList();
        unnamedPlaylist.add("Bad Habits", "Ed Sheeran", 2022, 222);
        unnamedPlaylist.showList();

        // test setName
        unnamedPlaylist.setName("My Favourites");
        System.out.println("\nAfter renaming:");
        unnamedPlaylist.showList();
        
        // create an empty playlist
        PlayList emptyPlaylist = new PlayList();

        System.out.println("\nEmpty playlist:");
        // should output 'The list is empty'
        emptyPlaylist.showList();
        
    }
}
