
import javax.swing.*;
import java.awt.*;

public class PanelHanoi extends JPanel {
    private int nbDisks;
    private int mouv=1;
    private Disques leftTower, middleTower, rightTower;
    int max;

    public PanelHanoi(int nbDisks) {
        setBounds(0,200,900,100+nbDisks*Disque.HEIGHT);
        setBackground(new Color(255,255,204));
        this.nbDisks = nbDisks;
        leftTower=new Disques(0);
        rightTower=new Disques(0);
        middleTower=new Disques(0);

        int disdwidth=(Disque.MAX_WIDTH-Disque.MIN_WIDTH)/nbDisks;
        int width=Disque.MAX_WIDTH;
        for(int i=0;i<nbDisks;++i,width-=disdwidth){
            push(new Disque(width,i),leftTower);
        }

        max=(int)Math.pow(2,nbDisks)-1;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawTower(leftTower, g, new Point(50, 200));
        drawTower(middleTower, g, new Point(250, 200));
        drawTower(rightTower, g, new Point(450, 200));
    }


    public void drawTower(Disques tower, Graphics g, Point position) {
        int xCenter = position.x + Disque.MAX_WIDTH / 2;
        int yBottom = position.y + nbDisks * Disque.HEIGHT;
        g.setColor(new Color(183,133,0));
        g.fillRect(xCenter, position.y-70, 5, yBottom-position.y+70);
        g.fillRect(position.x-5, yBottom,  Disque.MAX_WIDTH+10, 10);

        // Les disques
        int dY = yBottom - Disque.HEIGHT;
        for (Disque d : tower.getListeDeDisques()) {
            Color currentColor = g.getColor();
            g.setColor(d.getColor());
            g.fillRect(xCenter - d.getWidth() / 2, dY, d.getWidth(),
                    Disque.HEIGHT);
            g.setColor(currentColor);
            dY -= Disque.HEIGHT;
        }


    }
    public void moveDisksBetweenTwoPoles(int src,int dest){
        Disque d1=getTower(src).pop();
        Disque d2=getTower(dest).pop();

        if(d1==null){
            push(d2,getTower(src));
        }
        else if(d2==null){
           push(d1,getTower(dest));

          }
        else if(d1.getNumber()<d2.getNumber()){

                push(d1, getTower(src));
                push(d2, getTower(src));



        }
        else {

                push(d2,getTower(dest));

                push(d1,getTower(dest));


        }
    }


    private Disques getTower(int tp) {
        switch (tp) {
            case 0:
                return leftTower;
            case 1:
                return middleTower;
            case 2:
                return rightTower;
            default:
                return null;
        }
    }

    public void previousMovement() {

    }

    public boolean isFull(Disques x){
        return (x.getsize()==nbDisks);
    }
    public boolean isEmpty(Disques x){
        return (x.getsize()==0);
    }
    public void push(Disque disque,Disques x){
        if(isFull(x)){
            return;
        }
        else {
            x.push(disque,x);

        }
    }

    public void nextMovement() {
        if(mouv>max){
            JOptionPane.showMessageDialog(null,"JEU TERMINE ! ");
            System.exit(0);
        }
        else {

           if (mouv % 3 == 1 || mouv%3==-1) {
                if(nbDisks%2==0)    moveDisksBetweenTwoPoles(0, 1);

                else moveDisksBetweenTwoPoles(0, 2);
            } else if (mouv % 3 == 2) {
                if(nbDisks%2==0)    moveDisksBetweenTwoPoles(0, 2);

                else  moveDisksBetweenTwoPoles(0, 1);
            } else if (mouv % 3 == 0) {

                moveDisksBetweenTwoPoles(1, 2);
            }
        }

        mouv++;
    }
}

