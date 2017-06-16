package view.menu;

import util.JFrameUtilKt;
import util.SetColorKt;
import util.StackFrame;
import view.ChooseFrame;
import view.admin.AdminBaseManageFrame;
import view.admin.AdminManageSelfFrame;
import view.admin.AdminSeeAdviceFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Joki on 2017/6/7.
 */
public class AdminMenu extends StackFrame implements ActionListener {
    private JButton bt_back,bt_alterInfo, bt_liveManage, bt_serviceManage;
    private JPanel jPanelCenter = new JPanel(null);
    private JLabel top_label,bottom_label;


    public AdminMenu() {
        super("Administrator Menu");

        initCenter();

        setLayout(new BorderLayout());

        //通过设置两个空白面板来调整布局
        top_label.setPreferredSize(new Dimension(getWidth(),100));
        bottom_label.setPreferredSize(new Dimension(getWidth(),100));

        add(top_label,BorderLayout.NORTH);
        add(bottom_label,BorderLayout.SOUTH);
        add(jPanelCenter,BorderLayout.CENTER);
        JFrameUtilKt.init(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrameUtilKt.quit(AdminMenu.this);
            }
        });

    }

    /**
     * 初始化jPanelCenter和里面的控件
     */
    private void initCenter() {
        jPanelCenter.setOpaque(false);
        bt_alterInfo = new JButton("个人信息管理");
        bt_liveManage = new JButton("公寓住宿管理");
        bt_serviceManage = new JButton("公寓服务管理");
        bt_back = new JButton("返回");
        top_label = new JLabel();
        bottom_label = new JLabel();

        SetColorKt.setWhite(bt_back,bt_alterInfo, bt_liveManage, bt_serviceManage);

        // jPanelCenter.setLayout(new FlowLayout());

        bt_alterInfo.setBounds(200,0,300,35);
        bt_alterInfo.addActionListener(this);
        bt_liveManage.setBounds(200,80,300,35);
        bt_liveManage.addActionListener(this);
        bt_serviceManage.setBounds(200,160,300,35);
        bt_serviceManage.addActionListener(this);
        bt_back.setBounds(300,240,100,35);
        bt_back.addActionListener(this);

        jPanelCenter.add(bt_alterInfo);
        jPanelCenter.add(bt_liveManage);
        jPanelCenter.add(bt_serviceManage);
        jPanelCenter.add(bt_back);

    }
    /**
     * 设置点击事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_alterInfo){

            new AdminManageSelfFrame();
        }
        if (e.getSource() == bt_liveManage){
            new AdminBaseManageFrame();
        }
        if (e.getSource() == bt_serviceManage){

            new AdminSeeAdviceFrame();
        }
        if (e.getSource() == bt_back){
            dispose();
            new ChooseFrame();
        }
    }
}
