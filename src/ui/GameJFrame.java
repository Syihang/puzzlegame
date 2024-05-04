package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

public class GameJFrame extends JFrame implements MouseListener, KeyListener{

    // 记录图片大小
    int IMG_WIDTH = 105;
    int IMG_HEIGHT = 105;
    // 创建二维数组
    int [][] data = new int[4][4];

    // 图片保存位置
    String filepath = "image\\animal\\animal3\\";
    // 记录空白方块的位置
    int x0 = 0, y0 = 0;

    // 获胜的条件
    int[][] win =new int[][]{
            {1, 2 ,3 ,4},
            {5, 6, 7, 8},
            {9,10,11,12},
            {13,14,15,0}
    };

    // 统计步数
    int step = 0;

    public GameJFrame(){

        // 初始化界面
        initJframe();

        // 初始化菜单
        initJMenuBar();

        // 初始化数据
        initData();
        // 初始化图片
        initImage();

        // 显示界面
        this.setVisible(true);

    }

    private void initData() {
        int [] tempArr = {0 , 1, 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10, 11, 12, 13, 14, 15};

        // 打乱数组顺序
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);

            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

//        for (int x:tempArr) {
//            System.out.print(x + " ");
//        }

        // 创建二维数组


        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
            if (tempArr[i] == 0){
                x0 = i / 4;
                y0 = i % 4;
            }
        }

//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                System.out.print(data[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    // 初始化界面
    private void initJframe() {
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

        // 添加键盘监听
        this.addKeyListener(this);

        // 为主界面添加鼠标监听
        this.addMouseListener(this);
    }

    // 初始菜单
    private void initJMenuBar() {
        // 初始化菜单
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上的两个选项的对象
        JMenu functionJMnu = new JMenu("功能");
        JMenu aboutJMnu = new JMenu("关于我们");

        // 创建选项下面的条目对象
        JMenuItem replapTtem = new JMenuItem("重新游戏");
        JMenuItem reLoginTtem = new JMenuItem("重新登录");
        JMenuItem closeTtem = new JMenuItem("关闭游戏");

        JMenuItem accountTtem = new JMenuItem("微信号");

        // 将每一个选项的条目添加到选项中
        functionJMnu.add(replapTtem);
        functionJMnu.add(reLoginTtem);
        functionJMnu.add(closeTtem);

        // 重新开始游戏
        replapTtem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 初始化数据
                initData();
                // 初始化步数
                step = 0;
                // 初始化图片
                initImage();
            }
        });

        // 重新登录 lambda函数
        reLoginTtem.addActionListener(e -> {
            // 关闭当前界面
            this.setVisible(false);
            // 打开登录界面
            new LoginJFrame();
        });

        // 关闭游戏
        closeTtem.addActionListener(e -> {
            // 直接关闭虚拟机
            System.exit(0);
        });

        // 关于我们
        accountTtem.addActionListener(e -> {

            // 创建一个弹窗对象
            JDialog jDialog = new JDialog();
            // 创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("image\\suyihang(1).jpg"));
            // 设置位置和宽高
            jLabel.setBounds(0, 0, 313, 427);
            // 将图片添加到弹窗
            jDialog.getContentPane().add(jLabel);
            // 设置弹窗大小
            jDialog.setSize(350, 450);
            // 设置弹窗置顶
            jDialog.setAlwaysOnTop(true);
            // 让弹窗居中
            jDialog.setLocationRelativeTo(null);
            // 弹窗不关闭则无法操作下面的内容
            jDialog.setModal(true);
            // 让弹窗显示出来
            jDialog.setVisible(true);
        });

        // 将菜单里面两个选项添加到菜单选项中
        aboutJMnu.add(accountTtem);

        jMenuBar.add(functionJMnu);
        jMenuBar.add(aboutJMnu);

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    // 初始化图片
    private void initImage() {

        // 删除已经出现的所有图片
        this.getContentPane().removeAll();


        if (isAlike()){
            // 胜利！
            ImageIcon winJLabel = new ImageIcon("image\\win.png");
            JLabel background = new JLabel(winJLabel);
            background.setBounds(203, 283, 197, 73);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }

        // 显示步数
        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        // 添加打乱后的图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon(filepath + data[i][j] + ".jpg"));
                // 设置图片位置
                jLabel.setBounds(IMG_WIDTH * j + 83, IMG_HEIGHT * i + 134, IMG_WIDTH, IMG_HEIGHT);
                // 给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED)); // RAISED == 0 (凹陷的边框)  LOWERED == 1(凸起的边框)

//                // 添加图片点击事件
//                jLabel.addMouseListener(this);
//                this.getContentPane().add(jLabel);

                // 添加到窗口中
                this.getContentPane().add(jLabel);

            }
        }

        // 添加背景图片
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel background = new JLabel(bg);
        // 设置位置
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        // 刷新图片
        this.getContentPane().repaint();

/*
        // 创建一个ImageIcon对象
        ImageIcon icon = new ImageIcon("D:\\Java\\JavaProject01_Jigsaw_puzzle\\image\\animal\\animal3\\1.jpg");
        // 创建一个JLabel的对象(管理容器)
        JLabel jLabel1 = new JLabel(icon);
        // 指定图片的位置
        jLabel1.setBounds(0, 0, IMG_WIDTH, IMG_HEIGHT);

        // 添加后续图片
        JLabel jLabel2 = new JLabel(new ImageIcon("D:\\Java\\JavaProject01_Jigsaw_puzzle\\image\\animal\\animal3\\2.jpg"));
        jLabel2.setBounds(IMG_WIDTH, 0, IMG_WIDTH, IMG_WIDTH);

        JLabel jLabel3 = new JLabel(new ImageIcon("D:\\Java\\JavaProject01_Jigsaw_puzzle\\image\\animal\\animal3\\3.jpg"));
        jLabel3.setBounds(IMG_WIDTH * 2, 0, IMG_WIDTH , IMG_HEIGHT);

        JLabel jLabel4 = new JLabel(new ImageIcon("D:\\Java\\JavaProject01_Jigsaw_puzzle\\image\\animal\\animal3\\4.jpg"));
        jLabel4.setBounds(IMG_WIDTH * 3, 0, IMG_WIDTH , IMG_HEIGHT);
        // 把容器添加到界面
        //this.add(jLabel);

        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel4);

 */
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    // 鼠标控制
    @Override
    public void mouseReleased(MouseEvent e) {
        if (isAlike()) return;
        // IMG_WIDTH * j + 93, IMG_HEIGHT * i + 190
        int j = ((e.getX() - 93) / IMG_WIDTH);
        int i = ((e.getY() - 190) / IMG_HEIGHT);
//        System.out.println("i = " +  i +  " j = " + j);

        if (i < 0 || i > 3 || j < 0 || j > 3) return;
        //向左移动
        if (j < 3 && data[i][j + 1] == 0){
            data[i][j + 1] = data[i][j];
            data[i][j] = 0;
            step ++;
            initImage();
            x0 = i;
            y0 = j;
//            System.out.println(x0 + " " + y0);
        }

        // 向右移动
        if (j > 0 && data[i][j - 1] == 0){
            data[i][j - 1] = data[i][j];
            data[i][j] = 0;
            step ++;
            initImage();
            x0 = i;
            y0 = j;
        }

        // 向上移动
        if (i > 0 && data[i - 1][j] == 0){
            data[i - 1][j] = data[i][j];
            data[i][j] = 0;
            step ++;
            initImage();
            x0 = i;
            y0 = j;
        }

        // 向上移动
        if (i < 3 && data[i + 1][j] == 0){
            data[i + 1][j] = data[i][j];
            data[i][j] = 0;
            step ++;
            initImage();
            x0 = i;
            y0 = j;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isAlike()) return;
        if (e.getKeyCode() == 32){
            // 清空原有图片
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(filepath + "all.jpg"));
            // 设置完整图片
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            // 添加背景图片
            ImageIcon bg = new ImageIcon("image\\background.png");
            JLabel background = new JLabel(bg);
            // 设置位置
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            // 刷新界面
            this.getContentPane().repaint();
        }
    }

    // 键盘控制
    @Override
    public void keyReleased(KeyEvent e) {
        if (isAlike()) return;
        // 获取键盘读入数据
        // 上:38 下:40 左:37 右:39
        int code = e.getKeyCode();
        if (code == 37 && y0 < 3){
            data[x0][y0] = data[x0][y0 + 1];
            data[x0][y0 + 1] = 0;
            y0 ++;
            step ++;
        } else if (code == 38 && x0 < 3){
            data[x0][y0] = data[x0 + 1][y0];
            data[x0 + 1][y0] = 0;
            x0 ++;
            step ++;
        } else if (code == 39 && y0 > 0){
            data[x0][y0] = data[x0][y0 - 1];
            data[x0][y0 - 1] = 0;
            y0 --;
            step ++;
        } else if (code == 40 && x0 > 0){
            data[x0][y0] = data[x0 - 1][y0];
            data[x0 - 1][y0] = 0;
            x0 --;
            step ++;
        }else if (code == 87){
            data = new int[][]{
                    {1, 2 ,3 ,4},
                    {5, 6, 7, 8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x0 = 3;
            y0 = 3;
        }
        initImage();

    }

    public boolean isAlike(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) return false;
            }
        }
        return true;
    }

}
