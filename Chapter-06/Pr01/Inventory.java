package Ch06.Pr01;

public class Inventory {
    public Video [] videoList;
    public Inventory(Video [] videoList){
        this.videoList = videoList;
    }
    public String rent(String findingTitle){
        /* Suppose that each video has infinite numbers of copy... */
        for (int i=0; i<videoList.length; i++) {
            if (videoList[i].title.equals(findingTitle)) {
                return Integer.toString(i);
            }
        }
        return "";
    }
}
