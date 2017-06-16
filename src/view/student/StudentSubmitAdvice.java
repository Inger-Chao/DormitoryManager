package view.student;

import funcation.OperatorAdvice;
import funcation.select.SelectStudentsInfo;
import model.Advice;
import model.user.Student;
import util.JFrameUtilKt;
import util.SetColorKt;
import util.StackFrame;
import util.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Joki on 2017/6/13.
 */
public class StudentSubmitAdvice extends StackFrame implements ActionListener{

    private Student currentStu = new SelectStudentsInfo().select(UserService.getInstance().getCurrentUser().getNo());

    private JButton bt_submit;
    private JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea adviceArea;

    public StudentSubmitAdvice(){
        super("");
        JFrameUtilKt.init(this,400,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adviceArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        bt_submit = new javax.swing.JButton();

        SetColorKt.setWhite(bt_submit);

        adviceArea.setColumns(20);
        adviceArea.setRows(5);
        jScrollPane1.setViewportView(adviceArea);

        jLabel1.setText("注：不能多于200字");

        bt_submit.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        bt_submit.setText("提交");
        bt_submit.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(124, 124, 124)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(bt_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1))))
                                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_submit){

            if (adviceArea.getText().length() > 200){
                JOptionPane.showMessageDialog(
                        this,"字数不能超过200！","提示",JOptionPane.WARNING_MESSAGE);
            }else if (adviceArea.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,
                        "建议不能为空！","提示",JOptionPane.WARNING_MESSAGE);
            }else {
                Date date = new Date();
                Advice advice = new Advice(currentStu.getApartNO(),adviceArea.getText(),date);
                int result = new OperatorAdvice().insertAdvice(advice);
                if (result < 0){
                    JOptionPane.showMessageDialog(this,"提交失败！");
                }else {
                    JOptionPane.showMessageDialog(this,"提交成功！");
                    adviceArea.setText("");
                }
            }

        }
    }
}
