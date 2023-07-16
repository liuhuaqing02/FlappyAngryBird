import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Login {

    private JFrame frame;
    private JPasswordField zhanghao;
    private JPasswordField mima;
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String filepath = "assets//Ari-Pulkkinen-Title-Theme.wav";
                    MusicStuff musicObject = new MusicStuff();
                    musicObject.playMusic(filepath);
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() throws InterruptedException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws InterruptedException {
        frame = new JFrame();
        frame.setTitle("FlappyAngryBird");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("assets//bird.png"));
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel t0 = new JLabel("欢迎游玩FlappyAngryBird!");
        t0.setFont(new Font("宋体", Font.PLAIN, 20));
        t0.setBounds(125, 61, 264, 33);
        frame.getContentPane().add(t0);

        JLabel t1 = new JLabel("账号：");
        t1.setFont(new Font("宋体", Font.PLAIN, 20));
        t1.setBounds(50, 157, 72, 38);
        frame.getContentPane().add(t1);

        JLabel t2 = new JLabel("密码：");
        t2.setFont(new Font("宋体", Font.PLAIN, 20));
        t2.setBounds(50, 269, 72, 38);
        frame.getContentPane().add(t2);

        zhanghao = new JPasswordField();
        zhanghao.setBounds(132, 160, 264, 38);
        frame.getContentPane().add(zhanghao);

        mima = new JPasswordField();
        mima.setBounds(132, 272, 264, 38);
        frame.getContentPane().add(mima);

        JButton b1 = new JButton("登录");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zhanghao.getText().trim().equals("liu") && mima.getText().trim().equals("123456")) {//trim是去掉前后空格
                    frame.setVisible(false);
                    Main ins = new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或密码错误");
                }
            }
        });
        b1.setFont(new Font("宋体", Font.PLAIN, 20));
        b1.setBounds(80, 383, 97, 38);
        frame.getContentPane().add(b1);

        JButton b2 = new JButton("重置");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zhanghao.setText("");
                mima.setText("");
            }
        });
        b2.setFont(new Font("宋体", Font.PLAIN, 20));
        b2.setBounds(200, 383, 97, 38);
        frame.getContentPane().add(b2);

        JButton b3 = new JButton("查分");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Integer> list = new ArrayList<Integer>();

                    BufferedReader buf;        // 声明对象
                    buf = new BufferedReader(new FileReader(new File("assets//Score.txt")));

                    String line;
                    try {
                        while ((line = buf.readLine()) != null) {
                            list.add(Integer.valueOf(line));
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    Collections.sort(list);
                    Collections.reverse(list);
                    JOptionPane.showMessageDialog(null, "你的最高得分是" + list.get(0));
                } catch (Exception e1) {
                    // TODO: handle exception
                }
            }
        });
        b3.setFont(new Font("宋体", Font.PLAIN, 20));
        b3.setBounds(320, 383, 97, 38);
        frame.getContentPane().add(b3);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("assets//background.png"));
        lblNewLabel.setBounds(0, 0, 505, 482);
        frame.getContentPane().add(lblNewLabel);

    }
}