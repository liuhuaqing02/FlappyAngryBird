import javax.swing.*;
import java.awt.*;

public class Main {
    //创建窗口属性
    public static int WIDTH = 500;
    public static int HEIGHT = 500;


    public Main(){

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);//不可调整窗体大小
        frame.setTitle("FlappyAngryBird");
        Toolkit tool=frame.getToolkit(); //得到一个Toolkit对象
        Image myimage=tool.getImage("assets//bird.png"); //由tool获取图像
        frame.setIconImage(myimage);


        Keyboard SpaceKey = Keyboard.getSample();
        frame.addKeyListener(SpaceKey);

        Panel panel = new Panel();
        frame.add(panel);
    }
}

