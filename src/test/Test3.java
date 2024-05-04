package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3{

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        // 设置界面的宽高
        jFrame.setSize(603, 680);
        // 设置界面标题
        jFrame.setTitle("事件演示");
        // 界面置顶设置
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中放置
        jFrame.setLayout(null);

        JButton jtb = new JButton("单击");  // 创建组件对象
        jtb.setBounds(0, 0, 100, 50);

        // 添加动作监听
        jtb.addActionListener(new ActionListener(){
            int cnt = 1;
            @Override
            public void actionPerformed(ActionEvent e){

                System.out.println(cnt);
                cnt += 1;
            }
        }); // 参数表示被点击后执行的代码

        // 把按钮添加到界面中
        jFrame.getContentPane().add(jtb);

        jFrame.setVisible(true);
    }
}
