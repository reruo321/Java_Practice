package myPackage.practice01;

public class Car {
    private String carname;
    private String carno;
    private long distance;
    private Engine engine;

    public Car() {
        this("", "", 0, 0);
    }

    public Car(String carname, String carno, long distance, int speed) {
        this.carname = carname;
        this.carno = carno;
        this.distance = distance;
        this.engine = new Engine(speed);
    }

    public void drive(int dt) {
        distance += dt;
    }

    public long getDistanace() {
        return distance;
    }
    public String toString(){
        return String.format("차번호: %s\n차이름: %s\n주행거리: %d\n속도: %d", carno, carname, distance, engine.getSpeed());
    }
}
