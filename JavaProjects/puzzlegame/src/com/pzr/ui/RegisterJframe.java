package com.pzr.ui;

import javax.swing.*;

public class RegisterJframe extends JFrame {
    public RegisterJframe(){
        InitJFrame();

    }

    private void InitJFrame() {
        this.setSize(488,500);
        //设置界面的标题
        this.setTitle("拼图注册界面");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
