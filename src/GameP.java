import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameP extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;   //this not to make the game play on its own
    private int score=0;
    private int walls= 21; //this set the no of boxes
    private int playerjo= 250;
    private Timer time;
    private int delay=2;
    private int balposx=100;
    private int ballposy=300;
    private int balldirX=-5;
    private int balldirY=-5;
    private Map map;
    private int REDFLAG=4;
    public GameP(){
        map= new Map(4,5);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time =new Timer(delay,this);
        time.start();
    }
    public void paint (Graphics g){
        //background
        g.setColor(Color.BLUE);
        g.fillRect(1,1,692,592);
        //map drawer
        map.draw((Graphics2D) g);
        //boarders
        g.setColor(Color.WHITE);
        g.fillRect(0,0,5,600);
        g.fillRect(0,0,600,5);
        g.fillRect(580,0,5,600);

        /// the pedal
        g.setColor(Color.green);
        g.fillRect(playerjo,550,100,8);
        ////creating the ball
        g.setColor(Color.YELLOW);
        g.fillOval(balposx, ballposy , 20,20 );
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if (play){
            if(new Rectangle(balposx,ballposy,20,20).intersects(new Rectangle(playerjo,550,100,8))){
            balldirY=-balldirY;
            }
            balposx+=balldirX;
            ballposy+=balldirY;
            if(balposx<0){
                balldirX=-balldirX;
            }
            if(balposx>570){
                balldirX=-balldirX;
            }
            if (ballposy<0){
                balldirY=-balldirY;
            }
            //if (ballposy>550){
              //  balposx=100;
                //ballposy=300;
                //repaint();



            //}

            
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerjo>=500){
                playerjo=500;
            }
            else{
                moveRight();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerjo<=10){
                playerjo=10;
            }
            else{
                moveLeft();
            }

        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            play=false;
            ballposy=300;
            balposx=100;
            repaint();

        }


    }

    @Override
    public void keyPressed(KeyEvent e) {}
    public void moveRight(){
        play =true;
        playerjo+=25;
    }
    public void moveLeft(){
        play=true;
        playerjo-=25;
    }

}
