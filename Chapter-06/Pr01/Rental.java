package Ch06.Pr01;

import java.util.Arrays;

public final class Rental {
    public Video [] videoList;
    public String date;
    public long price;
    public Rental(String date){
        videoList = new Video[0];
        this.date = date;
    }
    public void add(Video video){
        Video [] new_videoList = Arrays.copyOf(videoList, videoList.length + 1);
        new_videoList[videoList.length] = video;
        videoList = new_videoList;

        price = 0;
        for(Video v : videoList)
            price += v.charge;
    }
}
