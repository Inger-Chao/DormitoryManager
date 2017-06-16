package view.student

import util.StackFrame
import funcation.select.SelectAdminInfo
import funcation.select.SelectLives
import util.*
import view.menu.StudentMenu
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
 * Created by Joki on 2017/6/8.
 */
class ShowAdminInfoFrame() : StackFrame("Administrator Information"), ActionListener {


    val infoPanel = AdminInfoRender(SelectAdminInfo().select(SelectLives().selectApart(UserService.getInstance().currentUser.no).managerNo))

    val bottomLabel = JLabel()
    var topLabel = JLabel()
    var btBack = JButton("返回")

    init {
        layout = BorderLayout()
        init(400,300)

        topLabel.preferredSize = Dimension(super.getWidth(),50)
        bottomLabel.preferredSize= Dimension(super.getWidth(),50)
        btBack.setBounds(0,15,80,35)
        btBack.addActionListener(this)
        setWhite(btBack)

        topLabel.add(btBack)
        add(infoPanel,BorderLayout.CENTER)
        add(topLabel,BorderLayout.NORTH)
        add(bottomLabel,BorderLayout.SOUTH)

        defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
    }

    override fun actionPerformed(e: ActionEvent) {
        if (e.source == btBack){
            this.dispose()
        }
    }

}