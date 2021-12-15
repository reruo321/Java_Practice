package Ch06.Pr01;

public final class Video {
    public String title;
    public long charge;
    public String category;
    public Video(String title, long charge, String category){
        this.title = title;
        this.charge = charge;
        this.category = category;
    }
    public String rent(String findingTitle){
        return findingTitle;
    }
}
