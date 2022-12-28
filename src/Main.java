
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame object = new JFrame(); //this is the class to create the window frame from
        GameP gamep = new GameP();
        object.setBounds(10,10,600,600);
        object.setTitle("this is my game");
        object.setResizable(false);
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        object.add(gamep);


    }
}
