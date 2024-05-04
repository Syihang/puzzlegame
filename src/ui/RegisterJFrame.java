package ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {


    public RegisterJFrame(){

        this.setSize(488, 500);

        // 设置界面标题
        this.setTitle("拼图 注册");
        // 界面置顶设置
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}
