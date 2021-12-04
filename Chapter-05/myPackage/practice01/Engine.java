/* Problem 02: Include an myPackage.practice01.Engine to a myPackage.practice01.Car, and increase its speed by 2. */
package myPackage.practice01;

public class Engine {
    int speed;
    Engine(){
        this(0);
    }
    Engine(int speed){
        this.speed = speed;
    }
    void speedUp(){
        speed++;
    }
    void speedDown(){
        speed--;
    }
    void stop(){
        speed = 0;
    }
    int getSpeed(){
        return speed;
    }
}
