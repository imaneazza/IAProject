

import java.awt.*;
import java.util.Random;

public class Disque {
    private Color color = null;
    private int width;
    public static final int MAX_WIDTH = 150;
    public static final int MIN_WIDTH = 50;
    public static final int HEIGHT = 20;
    private int number;
    public Disque(int w,int n) {
        this.number=n;
        width = w;
        Random rnd = new Random();
       color= new Color(rnd.nextInt(255),rnd.nextInt(255), rnd.nextInt(255));
    }
    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }
}
