package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jButton1 = new JButton("按钮1");
    JButton jButton2 = new JButton("按钮2");

    public MyJFrame(){
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
        jButton2.setBounds(300, 300, 50, 50);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);

        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);

        this.setVisible(true);
    }

    int flag = 0;
    @Override
    public void actionPerformed(ActionEvent e){
        // 对当前的按钮进行判断

        Object source = e.getSource();

        if (source == jButton1){
            if (flag % 2 == 0) jButton1.setSize(200, 200);
            else jButton1.setSize(20, 20);

            flag ++;
        }
        else if(source == jButton2){
            Random r = new Random();
            jButton2.setBounds(r.nextInt(500), r.nextInt(500), r.nextInt(200), r.nextInt(200));
        }
    }
}
