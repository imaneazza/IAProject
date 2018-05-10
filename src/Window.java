import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private PanelHanoi hanoiPanel;
    private JButton next;
    private JPanel panel;
    private JLabel label;
    private JButton restart;
    private int step=0;
    private JTextField text;
    private int number;

    public Window(int nbDisk)  {
        number=nbDisk;
        setTitle("HANOI TOURS GAME ");
        hanoiPanel = new PanelHanoi(nbDisk);
        panel=new JPanel();
        panel. setBackground(new Color(102,0,0));
        setSize(800,300+nbDisk*Disque.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialiseButtons();
        initialiseText();

        JSplitPane  container=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        container.setDividerLocation(150);
        container.setDividerSize(2);
        container.add(panel);
        container.add(hanoiPanel);
        this.getContentPane().add(container);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }



    public void initialiseText(){
    JLabel j=new JLabel("");
    j.setPreferredSize(new Dimension(100,30));
    panel.add(j);

    label=new JLabel(" STEP  ");
    label.setPreferredSize(new Dimension(80,40));
    label.setForeground(new Color(254,254,0));
    label.setFont(new Font("Algerian", Font.BOLD, 18));

    text=new JTextField();
    text.setEditable(false);
    text.setBackground(Color.white);
    text.setPreferredSize(new Dimension(80,30));
    text.setFont(new Font("Queen", Font.BOLD, 24));
    text.setText("0");
    text.setHorizontalAlignment(JTextField.CENTER);
    panel.add(label);
    panel.add(text);
}

    public void initialiseButtons (){
        JLabel j=new JLabel("");
        j.setPreferredSize(new Dimension(100,30));
        panel.add(j);
        restart=new JButton("RESTART");
        restart.setBackground(new Color(102,0,0));
        restart.setForeground(new Color(254,254,0));
        restart.setFocusable(false);
        restart.setBorder(null);
        restart.setPreferredSize(new Dimension(100, 30));
        restart.setHorizontalTextPosition(SwingConstants.CENTER);
        restart.setFont(new Font("Algerian", Font.BOLD, 18));
        restart.addActionListener(this);
        restart.setContentAreaFilled(false);
        panel.add(restart);



        next=new JButton("NEXT");
        next.setBackground(new Color(102,0,0));
        next.setForeground(new Color(254,254,0));
        next.setFocusable(false);
        next.setBorder(null);
        next.setPreferredSize(new Dimension(100, 30));
        next.setHorizontalTextPosition(SwingConstants.CENTER);
        next.setFont(new Font("Algerian", Font.BOLD, 18));
        next.addActionListener(this);
        next.setContentAreaFilled(false);
        panel.add(next);


    }
    public void restart(){
        new Window(number);
        this.setVisible(false);

    }
    public static void main(String[] args) {
        String numDisk ="";
        do{
           numDisk= JOptionPane.showInputDialog(null,
                    "Please type the number of disks ");
            if(numDisk==null)return ;
        }while ( numDisk.trim().equals(""));

        int n;
        try {
            n = Integer.parseInt(numDisk);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid Number !");
            return;
        }

        try {
            // On lance l'interface
            new Window(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(next)){
            hanoiPanel.nextMovement();
        step++;
        }

               if (e.getSource().equals(restart)){
            restart();
         }
           if(step>=0) text.setText(Integer.toString(step));
        else step=0;

        this.repaint();
    }
}
