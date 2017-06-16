package view;

import model.user.Supervisor;
import base.DBService;
import funcation.select.SelectAdminInfo;
import funcation.select.SelectStudentsInfo;
import util.JFrameUtilKt;
import util.StackFrame;
import util.UserService;
import view.menu.AdminMenu;
import view.menu.StudentMenu;
import view.menu.SupervisorMenu;
import view.supervisor.SupervisorBaseServiceFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by Joki on 2017/6/7.
 */
public class SingInFrame extends StackFrame {


    private final int userType;

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private JPanel jPanelCenter = new JPanel(null);
    private JButton enter,back;
    private JLabel student_label,admin_label,supervisor_label,password_label, top_label,bottom_label;
    private JTextField userNo = new JTextField();
    private JPasswordField password = new JPasswordField();


    public SingInFrame(int userType){
        super("Sing In");
        this.userType = userType;


        initCenter();
        initListener();
        setLayout(new BorderLayout());

        top_label = new JLabel();
        bottom_label = new JLabel();


        add(jPanelCenter,BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrameUtilKt.quit(SingInFrame.this);
            }
        });


        JFrameUtilKt.init(this,330,230);
    }
    private void initCenter() {
        jPanelCenter.setOpaque(false);

        student_label = new JLabel("学号");
        admin_label = new JLabel("工号");
        supervisor_label = new JLabel("账号");
        password_label = new JLabel("密码");


        enter = new JButton("登陆");
        back = new JButton("返回");


        student_label.setBounds(40,15,80,20);
        admin_label.setBounds(40,15,80,20);
        supervisor_label.setBounds(40,15,60,20);
        password_label.setBounds(40,55,60,20);
        userNo.setBounds(100,10,150,30);
        userNo.setEditable(true);
        password.setBounds(100,50,150,30);


        back.setBounds(190,120,70,30);
        back.setBackground(Color.WHITE);
        enter.setBounds(40,120,70,30);
        enter.setBackground(Color.WHITE);

        if (userType == UserService.TYPE_STUDENT){
            jPanelCenter.add(student_label);
        }
        if (userType == UserService.TYPE_ADMIN){
            jPanelCenter.add(admin_label);
        }
        if (userType == UserService.TYPE_SUPERVISOR){
            jPanelCenter.add(supervisor_label);
        }
        jPanelCenter.add(password_label);
        jPanelCenter.add(userNo);
        jPanelCenter.add(password);
        jPanelCenter.add(enter);
        jPanelCenter.add(back);
    }

    private void initListener() {
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signIn(userType);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ChooseFrame();
            }
        });
    }

    private void signIn(int userType) {

        String no = String.valueOf(userNo.getText());
        String pass = String.valueOf(password.getPassword());

        String tablename = "" , noName = "";
        String sql = "";

        switch (userType){
            case UserService.TYPE_STUDENT:
                tablename = "student";
                noName = "SNo";
                break;
            case UserService.TYPE_ADMIN:
                tablename = "administrator";
                noName = "AdminNo";
                break;
            case UserService.TYPE_SUPERVISOR:
                tablename = "supervisor";
                noName = "id";
                break;
        }

        if (no == null || pass == null){
            JOptionPane.showMessageDialog(this,
                    "请输入用户名和密码" ,"提示" ,JOptionPane.INFORMATION_MESSAGE);
        }else {
            try {
                sql = "select password from "+ tablename +" where " + noName + "='" + no +"'" ;
                mDBMS.connect();
                mStatement = mDBMS.getStatement();
                ResultSet resultSet = mStatement.executeQuery(sql);
                if (resultSet.next()){
                    if (pass.equals(resultSet.getString(1))){
                        switch (userType){
                            case UserService.TYPE_STUDENT:
                                UserService.getInstance().signIn(new SelectStudentsInfo().select(no));//设置当前登陆用户为
                                new StudentMenu();
                                break;
                            case UserService.TYPE_ADMIN:
                                UserService.getInstance().signIn(new SelectAdminInfo().select(no));
                                new AdminMenu();
                                break;
                            case UserService.TYPE_SUPERVISOR:
                                new SupervisorBaseServiceFrame();
                                UserService.getInstance().signIn(new Supervisor("nucnuc"));
                                break;
                        }
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(this,
                                "用户名或密码错误，请重新输入","提示",JOptionPane.INFORMATION_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(this,"不存在此用户");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
