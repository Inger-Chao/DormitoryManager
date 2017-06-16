package view.supervisor;


import model.user.Admin;
import funcation.insert.InsertAdmin;
import util.JFrameUtilKt;
import util.SetColorKt;
import util.StackFrame;

import javax.swing.*;

/**
 *
 * @author Joki
 */
public class InsertAdminInfoFrame extends StackFrame {

    /**
     * Creates new form InsertAdminFrame
     */
    public InsertAdminInfoFrame() {
        super("");
        initComponents();
        JFrameUtilKt.init(this,370,460);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        adminNoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        adminNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        adminTelTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apartNoTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_Insert = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();

        SetColorKt.setWhite(bt_back,bt_Insert);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adminNoTextField.setFont(new java.awt.Font("新宋体", 0, 15)); // NOI18N

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("工号");

        adminNameTextField.setFont(new java.awt.Font("新宋体", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("姓名");

        adminTelTextField.setFont(new java.awt.Font("新宋体", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("联系方式");

        apartNoTextField.setFont(new java.awt.Font("新宋体", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        jLabel4.setText("管理楼层");

        titleLabel.setFont(new java.awt.Font("微软雅黑", 1, 20)); // NOI18N
        titleLabel.setText("添加职工信息");

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel6.setText("注：红色为必填项");

        bt_Insert.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        bt_Insert.setText("添加");
        bt_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InsertActionPerformed(evt);
            }
        });

        bt_back.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        bt_back.setText("返回");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(bt_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(83, 83, 83)
                                                        .addComponent(bt_back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(titleLabel)
                                                        .addComponent(apartNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(adminNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adminTelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(apartNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bt_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt_back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void bt_InsertActionPerformed(java.awt.event.ActionEvent evt) {
        Admin admin = new Admin(adminNoTextField.getText(),
                adminNameTextField.getText(),null,null,
                adminTelTextField.getText(),apartNoTextField.getText(),
                null,null);
        int flag = new InsertAdmin().insert(admin);
        if (flag < 0){
            JOptionPane.showMessageDialog(InsertAdminInfoFrame.this,"插入失败");
        }else{
            JOptionPane.showMessageDialog(InsertAdminInfoFrame.this,"插入成功");
            adminNoTextField.setText(null);
            adminNameTextField.setText(null);
            adminTelTextField.setText(null);
            apartNoTextField.setText(null);
        }
    }

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {
        int flag = 0;
        flag = JOptionPane.showConfirmDialog(InsertAdminInfoFrame.this,
                "你确认信息已经提交吗？","提示",JOptionPane.YES_NO_OPTION);
        if (flag == JOptionPane.YES_OPTION){
            InsertAdminInfoFrame.this.dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InsertAdminInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertAdminInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertAdminInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertAdminInfoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertAdminInfoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField adminNameTextField;
    private javax.swing.JTextField adminNoTextField;
    private javax.swing.JTextField adminTelTextField;
    private javax.swing.JTextField apartNoTextField;
    private javax.swing.JButton bt_Insert;
    private javax.swing.JButton bt_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration
}