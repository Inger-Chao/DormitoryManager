package funcation

import model.user.Student
import funcation.select.SelectStudentsInfo
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/10.
 */

fun JTable.fillTable(students : Vector<Student>){

    var tableModel = this.model as DefaultTableModel

    tableModel.rowCount = 0

    for (r : Student in students){
        var str = Array<String>(3,{""})

        str[0] = r.no
        str[1] = r.name
        str[2] = r.tel

        tableModel.addRow(str)
    }

    this.invalidate()
}

/**
 * 得到该学生的实例
 */
fun JTable.getStudentInfo() : Student {

    var tableModel = this.model as DefaultTableModel

    return SelectStudentsInfo().select(tableModel.getValueAt(selectedRow,0) as String)
}