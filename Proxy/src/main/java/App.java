

public class App {

    public static void main(String[] args) {
        VideoDownloader naiveDownloader = new VideoDownloader(new LibraryVideoClass());
        VideoDownloader smartDownloader = new VideoDownloader(new VideoCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Время, сэкономленное за счет кэширования прокси-сервера " + (naive - smart) + "ms");

    }

    private static long test(VideoDownloader downloader) {
        long startTime = System.currentTimeMillis();

        downloader.renderPopularVideos();
        downloader.renderVideoPage("123");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("video 1");

        downloader.renderVideoPage("345");
        downloader.renderVideoPage("video 2");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Время, прошедшее: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}