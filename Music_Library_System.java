import java.util.List;
import java.util.Scanner;

public class Music_Library_System {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Song");
            System.out.println("2. Create Playlist");
            System.out.println("3. Add Song to Playlist");
            System.out.println("4. Remove Playlist");
            System.out.println("5. Search Songs by Title");
            System.out.println("6. Search Songs by Artist");
            System.out.println("7. Display all Songs");
            System.out.println("8. Display all Playlists");
            System.out.println("9. Exit");
            System.out.print("Choose an option (1 - 9): ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Song ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Song Artist: ");
                    String artist = sc.nextLine();
                    library.addSong(new Song(id, title, artist));
                    break;
                case 2:
                    System.out.print("Enter Playlist Name: ");
                    String playlistName = sc.nextLine();
                    library.addPlaylist(new Playlist(playlistName));
                    break;
                case 3:
                    System.out.print("Enter Playlist Name: ");
                    String plName = sc.nextLine();
                    Playlist playlist = library.getPlaylist(plName);
                    if (playlist != null) {
                        System.out.print("Enter Song ID to add: ");
                        String songId = sc.nextLine();
                        Song song = library.getSongById(songId);
                        if (song != null) {
                            playlist.addSong(song);
                        } else {
                            System.out.println("Song not found.");
                        }
                    } else {
                        System.out.println("Playlist not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Playlist Name to remove: ");
                    String removeName = sc.nextLine();
                    library.removePlaylist(removeName);
                    break;
                case 5:
                    System.out.print("Enter Song Title to Search: ");
                    String searchTitle = sc.nextLine();
                    List<Song> titleResults = library.searchSongsByTitle(searchTitle);
                    if (titleResults.isEmpty()) {
                        System.out.println("No songs found.");
                    } else {
                        for (Song s : titleResults) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter Song Artist to Search: ");
                    String searchArtist = sc.nextLine();
                    List<Song> artistResults = library.searchSongsByArtist(searchArtist);
                    if (artistResults.isEmpty()) {
                        System.out.println("No songs found.");
                    } else {
                        for (Song s : artistResults) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 7:
                    library.displayAllSongs();
                    break;
                case 8:
                    library.displayAllPlaylists();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
