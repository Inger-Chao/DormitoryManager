package view.supervisor;
import com.sun.deploy.uitoolkit.*;
import com.sun.deploy.uitoolkit.Window;
import funcation.update.UpdateDorm;
import model.Dorm;
import base.DBService;
import funcation.DormTableKt;
import funcation.select.SelectDorms;
import util.SetColorKt;
import util.StackFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.WindowConstants;

/**
 * Created by Lenovo on 2017/6/12.
 */
public class EditDormFrame extends StackFrame{
    private Dorm dorm = null;
    private JLabel wb1=new JLabel("修改宿舍信息");
    private JLabel ApartNoLabe=new JLabel("公寓号：");
    private JLabel DormNoLabe=new JLabel("宿舍号：");
    private JLabel BedNumLabe=new JLabel("床  位：");
    private JLabel BedInLabe=new JLabel("已住人数：");
    private JLabel ManagerNoLabe=new JLabel("寝室长：");

    JTextField ApartNoTextFiled=new JTextField(10);
    JTextField DormNoTextFiled=new JTextField(10);
    JTextField BedInTextFiled=new JTextField(10);
    JTextField BedNumTextFiled=new JTextField(10);
    JTextField ManagerNoTextFiled=new JTextField(10);

    JButton DormUpdate=new JButton("确定");
    JButton CloseDormUpdate=new JButton("返回");

    public EditDormFrame(Dorm dorm1){
        super("");

        dorm=dorm1;

            init();
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void init() {
        /**
         * 布局的设置
         */
        setLayout(null);

        SetColorKt.setWhite(DormUpdate,CloseDormUpdate);

        Dimension screenDimension;
        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(370,470);
        setLocation((screenDimension.width -getWidth())/2 ,(screenDimension.height-getHeight())/2);

        JLabel ApartNo=new JLabel(dorm.getApartNo());
        JLabel DormNo=new JLabel(dorm.getDormNo());


        add(wb1);add(ApartNoLabe); add(ApartNo); add(DormNoLabe); add(DormNo);
        add(BedNumLabe); add(BedInTextFiled); add(BedInLabe);add(BedNumTextFiled);
        add(ManagerNoLabe);add(ManagerNoTextFiled);add(DormUpdate); add(CloseDormUpdate);

        wb1.setFont(new Font("微软雅黑", 1, 20));
        wb1.setBounds(120,0,300,100);
        ApartNoLabe.setForeground(Color.red);
        ApartNoLabe.setBounds(40,50,100,90);
        DormNoLabe.setForeground(Color.red);
        DormNoLabe.setBounds(40,100,100,90);
        BedNumLabe.setBounds(40,150,100,90);
        BedInLabe.setBounds(30,200,100,90);
        ManagerNoLabe.setBounds(40,250,100,90);

        ApartNo.setBounds(110,80,200,30);
        DormNo.setBounds(110,130,200,30);
        BedNumTextFiled.setBounds(110,180,200,30);
        BedInTextFiled.setBounds(110,230,200,30);
        ManagerNoTextFiled.setBounds(110,280,200,30);

        BedNumTextFiled.setText(String.valueOf(dorm.getBedNum()));
        BedInTextFiled.setText(String.valueOf(dorm.getBedIn()));
        ManagerNoTextFiled.setText(String.valueOf(dorm.getManagerNo()));

        DormUpdate.setBounds(80,370,80,30);
        CloseDormUpdate.setBounds(200,370,80,30);

        DormUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DormUpdateActionPerformed();
            }
        });
        CloseDormUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CloseDormUpdateActionPerformed();
            }
        });


    }
    private void DormUpdateActionPerformed() {

        dorm.setBedIn(Integer.valueOf(BedInTextFiled.getText())); //得到输入的床位数
        dorm.setBedNum(Integer.valueOf(BedNumTextFiled.getText()));//得到输入的人数
        dorm.setManagerNo(ManagerNoTextFiled.getText());
        int result=new UpdateDorm().update(dorm);
        if(result >= 0) {
            JOptionPane.showMessageDialog(EditDormFrame.this,
                    "修改成功！","提示",JOptionPane.INFORMATION_MESSAGE);
            EditDormFrame.this.dispose();
        }
        else JOptionPane.showMessageDialog(EditDormFrame.this,
                "修改失败！","警告",JOptionPane.WARNING_MESSAGE);
    }
    private void CloseDormUpdateActionPerformed(){
        int flag = 0;
        flag = JOptionPane.showConfirmDialog(EditDormFrame.this,
                "是否确定返回？","提示",JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION){
            EditDormFrame.this.dispose();
        }
    }

}
