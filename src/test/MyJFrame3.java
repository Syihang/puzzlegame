package test;
// 键盘监听
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener{
    public MyJFrame3(){
        // 设置界面的宽高
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("拼图游戏测试版 v1.0");
        // 界面置顶设置
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置
        this.setLayout(null);

        // 给整个窗体添加键盘监听
        this.addKeyListener(this);

        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        System.out.println((char)e.getKeyCode());
    }
}
