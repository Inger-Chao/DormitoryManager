package funcation

import model.user.Admin
import funcation.select.SelectAdminInfo
import java.util.*
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

/**
 * Created by Joki on 2017/6/10.
 */

fun JTable.fillTable(admins : Vector<Admin>){

    var tableModel = this.model as DefaultTableModel

    tableModel.rowCount = 0

    for (r : Admin in admins){
        var str = Array<String>(4,{""})

        str[0] = r.no
        str[1] = r.name
        str[2] = r.apartNo+""
        str[3] = r.tel

        tableModel.addRow(str)
    }

    this.invalidate()
}

fun JTable.getAdminInfo() : Admin{

    var tableModel = this.model as DefaultTableModel

    return SelectAdminInfo().select(tableModel.getValueAt(selectedRow,0) as String)
}