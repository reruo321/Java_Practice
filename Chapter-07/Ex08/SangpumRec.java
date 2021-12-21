package Ch07.Ex08;

public class SangpumRec {
    private String name;
    private String date;
    private long danga;
    private int count;
    public SangpumRec(String name, String date, long danga, int count){
        this.name = name;
        this.date = date;
        this.danga = danga;
        this.count = count;
    }
    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public long getDanga(){
        return danga;
    }
    public int getCount(){
        return count;
    }
}
