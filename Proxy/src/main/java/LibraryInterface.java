import java.util.HashMap;

public interface LibraryInterface {
    HashMap<String, Video> popularVideos();
    Video getVideo(String videoId);
}
