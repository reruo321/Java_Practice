package Ch12.Pr01;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static java.lang.Thread.sleep;

public class OvalDrawThreadExample extends JFrame implements Runnable {
    int num;
    Color color;
    Random r = new Random();
    int x, y;
    public OvalDrawThreadExample(int n, Color col){
        /* TODO: Constructor */
        super("OvalDrawThread Demo");
        setSize(300, 200);
        setVisible(true);
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, 20, 10);
    }
    public void update(Graphics g){
        paint(g);
    }
    public void run(){
        /* TODO: run() */
        while(true) {
            x = r.nextInt(300);
            y = r.nextInt(200);
            paint(getGraphics());
            try{
                sleep(1000);
            } catch(InterruptedException e){ e.printStackTrace(); }
        }
    }
    public static void main(String [] args){
        OvalDrawThreadExample odt = new OvalDrawThreadExample(10, Color.green);
        Thread t = new Thread(odt);
        t.start();
    }
}
