import java.util.HashMap;

public class LibraryVideoClass implements LibraryInterface {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String idVideo) {
        connectToServer("http://www.youtube.com/" + idVideo);
        return getSomeVideo(idVideo);
    }


    private void  networkLatency() {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.println("Подключение " + server + "... ");
        networkLatency();
        System.out.println("Подключено!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading populars... ");
        networkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("123", new Video("1", "123.avi"));
        hmap.put("324", new Video("2", "ghcfgh.mp4"));
        hmap.put("456", new Video("3", "fhgf.mpq"));
        hmap.put("567", new Video("4", "fghfgh.mov"));
        hmap.put("789", new Video("5", "fghjgfhj.avi"));

        return hmap;
    }

    private Video getSomeVideo(String idVideo) {
        System.out.print("Загрузка видео... ");

        networkLatency();
        Video video = new Video(idVideo, "Sdgffg");

        return video;
    }

}