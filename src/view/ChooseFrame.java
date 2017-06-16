package view;

import util.JFrameUtilKt;
import util.StackFrame;
import util.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by Joki on 2017/6/6.
 */
public class ChooseFrame extends StackFrame {


    private JPanel jPanelMain;
    private JPanel jPanelCenter = new JPanel(null);

    private JLabel jLabelTop,jLabelBottom;

    private JRadioButton rbtn_Student;
    private JRadioButton rbtn_Admin;
    private JRadioButton rbtn_Supervisor;

    private ButtonGroup buttonGroup;

    private JButton btn_enter;
    private JButton btn_exit;

    public ChooseFrame() {
        super("Welecome to ApartManager!");
        loadWindows();
    }

    public void loadWindows() {

        initCenter();

        jPanelMain = new JPanel(new BorderLayout()) {
            @Override
            public void paint(Graphics g) {
                Graphics2D graphics2D = (Graphics2D) g;
                super.paintComponents(g);
                Image image = Toolkit.getDefaultToolkit().getImage("material//choose.jpg"); //懒加载 不加载图片到内存 当拿到图片的高和宽是返回-1
                graphics2D.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };


        jLabelTop = new JLabel();
        jLabelBottom = new JLabel();

        jPanelMain.add(jLabelTop,BorderLayout.NORTH);
        jPanelMain.add(jPanelCenter, BorderLayout.CENTER);
        jPanelMain.add(jLabelBottom,BorderLayout.SOUTH);

        //通过设置两个空白面板来调整布局
        jLabelTop.setPreferredSize(new Dimension(getWidth(),280));
        jLabelBottom.setPreferredSize(new Dimension(getWidth(),100));


        JFrameUtilKt.init(this, 750, 530);//界面初始化
        setContentPane(jPanelMain);//设置为背景
        // setResizable(false);//设置为用户不可改变
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrameUtilKt.quit(ChooseFrame.this);
            }
        });

        initEvent();//点击时间的设置

    }

    private void initEvent() {

        /**
         * 匿名内部类方式 设置退出按钮的点击事件
         */
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrameUtilKt.quit(ChooseFrame.this);
            }
        });

        /**
         * 进入按钮设置点击事件
         */
        btn_enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (rbtn_Student.isSelected()){
                    UserService.getInstance().setUserType(UserService.TYPE_STUDENT);
                    new SingInFrame(UserService.getInstance().getUserType());
                    dispose();

                }
                if (rbtn_Admin.isSelected()){
                    UserService.getInstance().setUserType(UserService.TYPE_ADMIN);//设置当前用户类型
                    new SingInFrame(UserService.getInstance().getUserType());
                    dispose();
                }
                if (rbtn_Supervisor.isSelected()){
                    UserService.getInstance().setUserType(UserService.TYPE_SUPERVISOR);//设置当前用户类型
                    new SingInFrame(UserService.getInstance().getUserType());
                    dispose();
                }
                while (UserService.getInstance().getUserType() == UserService.TYPE_NONE){
                    JOptionPane.showMessageDialog(ChooseFrame.this,
                            "请选择用户类型！","提示",JOptionPane.YES_OPTION);
                }
            }
        });
    }

    private void initCenter() {
        jPanelCenter.setOpaque(false);
        rbtn_Student = new JRadioButton("学生");
        rbtn_Admin = new JRadioButton("宿舍管理员");
        rbtn_Supervisor = new JRadioButton("后勤主管");
        btn_enter = new JButton("进入");
        btn_exit = new JButton("退出");

        btn_enter.setBackground(Color.WHITE);
        btn_exit.setBackground(Color.WHITE);

        jPanelCenter.setLayout(new BorderLayout(300,150));
        Panel btn_Panel = new Panel();
        btn_Panel.setLayout(new FlowLayout());
        btn_Panel.add(btn_enter);
        btn_Panel.add(btn_exit);

        Panel rbtn_Pannel = new Panel();
        rbtn_Pannel.setLayout(new FlowLayout());
        rbtn_Pannel.add(rbtn_Student);
        rbtn_Pannel.add(rbtn_Admin);
        rbtn_Pannel.add(rbtn_Supervisor);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbtn_Student);
        buttonGroup.add(rbtn_Admin);
        buttonGroup.add(rbtn_Supervisor);

        jPanelCenter.add(btn_Panel,BorderLayout.SOUTH);
        jPanelCenter.add(rbtn_Pannel,BorderLayout.NORTH);
    }

}
