package view.student

import model.user.Student
import javax.swing.JPanel
import javax.swing.JTextArea

/**
 * Created by Joki on 2017/6/8.
 */
class StudentInfoRender(var value : Student) : JPanel(){

    var infoTextArea = JTextArea()


    init {
        infoTextArea.isEditable=false
        infoTextArea.text=value.toString()

        add(infoTextArea)
    }

}