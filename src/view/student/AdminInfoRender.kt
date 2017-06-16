package view.student

import model.user.Admin
import javax.swing.JPanel
import javax.swing.JTextArea

/**
 * Created by Joki on 2017/6/8.
 */
class AdminInfoRender(var value : Admin) : JPanel(){

    var infoTextArea = JTextArea()

    init {

        infoTextArea.isOpaque=false
        infoTextArea.text="工号: " + value.no + "\n姓名: " + value.name +"\n联系方式: " + value.tel
        add(infoTextArea)

    }

}