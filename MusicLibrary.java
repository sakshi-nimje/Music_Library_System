import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private List<Song> songs;
    private List<Playlist> playlists;

    public MusicLibrary() {
        this.songs = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void removePlaylist(String playlistName) {
        playlists.removeIf(playlist -> playlist.getName().equals(playlistName));
    }

    public Playlist getPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                return playlist;
            }
        }
        return null;
    }

    public Song getSongById(String id) {
        for (Song song : songs) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    public List<Song> searchSongsByTitle(String title) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> searchSongsByArtist(String artist) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().toLowerCase().contains(artist.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }

    public void displayAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the library.");
        } else {
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    public void displayAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists in the library.");
        } else {
            for (Playlist playlist : playlists) {
                System.out.println(playlist);
            }
        }
    }
}
