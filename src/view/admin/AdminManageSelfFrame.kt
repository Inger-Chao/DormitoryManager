package view.admin

import util.StackFrame
import funcation.select.SelectAdminInfo
import util.*
import view.UpdatePasswordFrame
import view.menu.AdminMenu
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.WindowConstants

/**
 * Created by Joki on 2017/6/11.
 */
class AdminManageSelfFrame : StackFrame("Admin Information"),ActionListener {


    val infoPanel = AdminSelfInfoRender(SelectAdminInfo().select(UserService.getInstance().currentUser.no))
    val bottomLabel = JLabel()
    var topLabel = JLabel()
    var btBack = JButton("返回")
    var btAlterInfo = JButton("修改个人信息")
    var btAlterPass = JButton("修改密码")

    init {
        /**
         * 布局的设置
         */
        init(400,530)
        layout= BorderLayout()
        topLabel.preferredSize = Dimension(super.getWidth(),50)
        bottomLabel.preferredSize= Dimension(super.getWidth(),100)

        /**
         * 控件的设置和点击事件的设置
         */
        btBack.setBounds(0,15,80,35)
        btBack.addActionListener(this)
        btAlterPass.setBounds(0,50,200,35)
        btAlterPass.addActionListener(this)
        btAlterInfo.setBounds(0,0,200,35)
        btAlterInfo.addActionListener(this)
        setWhite(btAlterInfo,btAlterPass,btBack)

        topLabel.add(btBack)
        bottomLabel.add(btAlterInfo)
        bottomLabel.add(btAlterPass)
        add(infoPanel, BorderLayout.CENTER)
        add(bottomLabel, BorderLayout.SOUTH)
        add(topLabel, BorderLayout.NORTH)

        defaultCloseOperation= WindowConstants.DISPOSE_ON_CLOSE
    }

    override fun actionPerformed(e: ActionEvent) {

        if (e.source == btBack){
            this.dispose()
        }

        if (e.source == btAlterInfo){
            AdminEditFrame()
        }

        if (e.source == btAlterPass){
            UpdatePasswordFrame()
        }
    }



}