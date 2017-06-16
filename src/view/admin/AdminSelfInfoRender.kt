package view.admin

import model.user.Admin
import javax.swing.JPanel
import javax.swing.JTextArea

/**
 * Created by Joki on 2017/6/11.
 */
class AdminSelfInfoRender(var admin:Admin) : JPanel() {

    var infoTextArea = JTextArea()


    init {
        infoTextArea.isEditable=false
        infoTextArea.text=admin.toString()

        add(infoTextArea)
    }

}