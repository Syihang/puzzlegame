package test;
// 鼠标监听
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.module.ModuleFinder;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jButton1 = new JButton("单击");

    public MyJFrame2(){
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

        jButton1.setBounds(0, 0, 100, 50);
        // 设置
        jButton1.addMouseListener(this);

        this.getContentPane().add(jButton1);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("滑入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("滑出");
    }
}
