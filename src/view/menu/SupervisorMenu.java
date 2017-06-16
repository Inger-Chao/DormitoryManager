package view.menu;

import util.JFrameUtilKt;
import util.SetColorKt;
import util.StackFrame;
import view.ChooseFrame;
import view.supervisor.SupervisorBaseServiceFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Joki on 2017/6/7.
 */
public class SupervisorMenu extends StackFrame implements ActionListener {

    private JButton bt_Basic,bt_Services,bt_back;
    private JPanel jPanelCenter = new JPanel(null);
    private JLabel top_label,bottom_label;

    public SupervisorMenu() {
        super("SupervisorMenu");

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
                JFrameUtilKt.quit(SupervisorMenu.this);
            }
        });
    }

    private void initCenter() {
        jPanelCenter.setOpaque(false);
        bt_Basic = new JButton("基本信息管理");
        bt_Services = new JButton("服务信息管理");
        bt_back = new JButton("返回");
        top_label = new JLabel();
        bottom_label = new JLabel();

        bt_Basic.setBounds(200,50,300,35);
        bt_Basic.addActionListener(this);
        bt_Services.setBounds(200,130,300,35);
        bt_Services.addActionListener(this);
        bt_back.setBounds(300,220,100,35);
        bt_back.addActionListener(this);

        jPanelCenter.add(bt_back);
        jPanelCenter.add(bt_Basic);
        jPanelCenter.add(bt_Services);

        SetColorKt.setWhite(bt_back,bt_Basic,bt_Services);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_Basic){
            new SupervisorBaseServiceFrame();
            this.dispose();
        }
        if (e.getSource() == bt_back){
            new ChooseFrame();
            this.dispose();
        }

    }
}
