package view.menu;

import util.JFrameUtilKt;
import util.SetColorKt;
import util.StackFrame;
import view.ChooseFrame;
import view.student.StudentManageSelfFrame;
import view.student.ShowAdminInfoFrame;
import view.student.StudentSubmitAdvice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Joki on 2017/6/7.
 */
public class StudentMenu extends StackFrame implements ActionListener{

    private JButton bt_back,bt_alterInfo,bt_showAdmin,bt_sendAdvices;
    private JPanel jPanelCenter = new JPanel(null);
    private JLabel top_label,bottom_label;


    public StudentMenu() {
        super("Student Menu");

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
                JFrameUtilKt.quit(StudentMenu.this);
            }
        });

    }

    /**
     * 初始化jPanelCenter和里面的控件
     */
    private void initCenter() {
        jPanelCenter.setOpaque(false);
        bt_alterInfo = new JButton("个人信息管理");
        bt_showAdmin = new JButton("查看宿舍管理员信息");
        bt_sendAdvices = new JButton("意见反馈");
        bt_back = new JButton("返回");
        top_label = new JLabel();
        bottom_label = new JLabel();

        SetColorKt.setWhite(bt_back,bt_alterInfo,bt_showAdmin,bt_sendAdvices);

       // jPanelCenter.setLayout(new FlowLayout());

        bt_alterInfo.setBounds(200,0,300,35);
        bt_alterInfo.addActionListener(this);
        bt_showAdmin.setBounds(200,80,300,35);
        bt_showAdmin.addActionListener(this);
        bt_sendAdvices.setBounds(200,160,300,35);
        bt_sendAdvices.addActionListener(this);
        bt_back.setBounds(300,240,100,35);
        bt_back.addActionListener(this);

        jPanelCenter.add(bt_alterInfo);
        jPanelCenter.add(bt_showAdmin);
        jPanelCenter.add(bt_sendAdvices);
        jPanelCenter.add(bt_back);

    }
    /**
     * 设置点击事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_alterInfo){

            new StudentManageSelfFrame();
        }
        if (e.getSource() == bt_showAdmin){

            new ShowAdminInfoFrame();
        }
        if (e.getSource() == bt_sendAdvices){
            new StudentSubmitAdvice();
        }
        if (e.getSource() == bt_back){
            dispose();
            new ChooseFrame();
        }
    }
}
