/*
    Jason Gill
    21304092
*/
import java.util.ArrayList;
import java.util.Arrays;

public class PlayList {

    private String name;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public PlayList() {
        this("Unnamed Playlist");
    }

    public PlayList(String playListName) {
        this.name = playListName;
    }

    public String toString() {
        // make use of inbuilt to array list toString method 
        return tracks.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void add(String title, String artist) {
        this.tracks.add(new Track(title, artist));
    }

    public void add(String title, String artist, int year, int duration) {
        this.tracks.add(new Track(title, artist, year, duration));
    }

    public void add(Track t) {
        this.tracks.add(t);
    }

    public boolean remove(String title) {

        // removes only first with given title
        for(Track t: this.tracks) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                this.tracks.remove(t);
                return true;
            }
        }
        return false;

    }
    
    public void showList() {

        if (tracks.size() > 0) {

            System.out.printf("\nLISTING TRACKS IN PLAYLIST '%s':\n", name);
            for(Track t: tracks) {
                System.out.println(t);
            }
            System.out.println("------\n");

        } else {
            System.out.println("The list is empty");
        }

    }

    public void playAll(boolean random) {

        // inefficient to create a shuffled copy of the entire playlist, so instead will create
        // a smaller array just storing the indexes.
        int[] tracksIndexes = new int[tracks.size()];

        if (random) {
            
            /* 
                trackIndexes stores the indexes of the tracks to be played.
                tracksUsed records the tracks whose indexes have already been added to the trackIndexes array
                to ensure each track is played exactly once.
                filled records how many track indexes have been added to the trackIndexes array so far.
            */
            int filled = 0;
            int[] tracksUsed = new int[tracks.size()];

            while (filled < tracks.size()) {
                int i = (int) (Math.random() * tracks.size()); // select random track
                if (tracksUsed[i] != 1) {           // don't want duplicates, so ensure track hasn't already been used
                    tracksIndexes[filled++] = i;    // add to track indexes & increment filled by 1
                    tracksUsed[i] = 1;              // mark track as used
                }
            }

        } else {
            // just play tracks in their current order
            for (int i = 0; i < tracks.size(); i++) {
                tracksIndexes[i] = i;
            }
        }

        // send off to helper method to actually 'play' the tracks
        playTracks(tracksIndexes);
        
    }

    public void playOnly(String artist) {

        int[] trackIndexes = new int[tracks.size()];
        int filled = 0; // used to record how many spaces in the trackIndexes array are actually filled

        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getArtist().toLowerCase().indexOf(artist.toLowerCase()) != -1) {
                trackIndexes[filled++] = i; // found a match - add index of track to trackIndexes
            }
        }   

        // trim the array & send off to helper method to actually 'play' the tracks
        playTracks(Arrays.copyOf(trackIndexes, filled));

    }

    public void playOnly(int year) {

        int[] trackIndexes = new int[tracks.size()];
        int filled = 0; // used to record how many spaces in the trackIndexes array are actually filled

        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getYear() == year) {
                trackIndexes[filled++] = i; // found a match - add index of track to trackIndexes
            }
        }

        // trim the array & send off to helper method to actually 'play' the tracks
        playTracks(Arrays.copyOf(trackIndexes, filled));

    }

    // Helper methods
    private void playTrack(Track t) {
        System.out.printf("Now playing: %s\n", t);
    }

    private void playTracks(int[] indexes) {
        for(int i: indexes) {
            playTrack(tracks.get(i));
        }
    }

}