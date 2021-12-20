package Ch07.Ex07;

import java.util.EnumSet;

enum FourSeason{
    SPRING(" 봄", "개나리"), SUMMER(" 여름", "백일홍"), AUTUMN(" 가을", "코스모스"), WINTER(" 겨울", "포인세치아");
    private final String season;
    private final String flower;
    FourSeason(String season, String flower) {
        this.season = season;
        this.flower = flower;
    }
    public String getSeason(){
        return season;
    }
    public String getFlower(){
        return flower;
    }
}

public class SeasonTest {
    public static void main(String [] args){
        System.out.println("[계절의 꽃]");
        for(FourSeason s : FourSeason.values())
            System.out.printf("%-7s-%-5s-%-20s\n", s, s.getSeason(), s.getFlower());

        System.out.println("[여름 ~ 겨울]");
        for(FourSeason s : EnumSet.range(FourSeason.SUMMER, FourSeason.WINTER))
            System.out.printf("%-5s-%-20s\n", s.getSeason(), s.getFlower());
    }
}
