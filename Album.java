import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs = new ArrayList<Song>();
    //private LinkedList<Song>playlists = new LinkedList<Song>();

    public Album (String name, String artist){
        this.name = name;
        this.artist = artist;
    }

    private Song findSong(String title){
        for (int i=0; i<songs.size(); i++){
            Song song = songs.get(i);
            if (song.getTitle().equals(title)){
                return song;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if (findSong(title).equals(title)){
            return false;
        }
        songs.add(new Song(title,duration));
        return true;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song song = findSong(title);
        if (!(song == null)){
            playList.add(song);
            return true;
        }
        return false;
    }

    public boolean addPlayList(int trackNumber, LinkedList<Song> playlist){
        int i = trackNumber -1;
        if ((i>=0) && (i<= songs.size())){
            Song song = songs.get(i);
            playlist.add(song);
            return true;
        }
        return false;
    }

}
