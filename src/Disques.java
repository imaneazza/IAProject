

import java.util.Stack;

public class Disques {
    private Stack<Disque> listeDeDisques = new Stack<Disque>();
    private int top;

    public Stack<Disque> getListeDeDisques() {
        return listeDeDisques;
    }

    public static final int WIDTH = 10;

    Disques(int nombreDeDisques)  {
      top=nombreDeDisques-1;
    }

    public void push(Disque disque,Disques x){
        listeDeDisques.push(disque);
        top++;
    }
    public Disque pop(){
        top--;
        if(listeDeDisques.size()==0)return null;
        Disque d= listeDeDisques.pop();

        return d;

    }

    @Override
    public String toString() {
        String msg="";
        for(Disque d:listeDeDisques){
            msg+=d.getNumber()+" -- "+d.getWidth()+" \n";
        }
        return msg;}
    public int getsize(){
        return listeDeDisques.size();
    }}
