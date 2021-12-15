package Ch06.Pr01;

public class VideoStoreMain {
    public static void main(String [] args) {
        Video [] videoList = new Video[3];
        videoList[0] = new Video("정어리게임", 10, "서바이벌");
        videoList[1] = new Video("천국", 100, "스릴러");
        videoList[2] = new Video("여름왕국", 1000, "판타지");
        VideoStore store = new VideoStore(videoList);
        while (true) {
            String isEnd;
            isEnd = store.rent();
            if (isEnd.equals("END")) {
                System.out.println("대여 시스템을 종료합니다.");
                return;
            }
        }

    }
}
