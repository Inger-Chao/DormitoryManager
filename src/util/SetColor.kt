package util

import java.awt.Color
import java.awt.Label
import javax.swing.JButton
import javax.swing.JLabel

/**
 * 设置btn背景为白色
 * Created by Joki on 2017/6/8.
 */

fun setWhite(vararg btns : JButton){
    var btn : JButton
    for (btn in btns){
        btn.background = Color.WHITE
    }
}

/**
 * 设置Label背景为白色
 */
fun setBackWhite(vararg labels: JLabel){
    var label : JLabel
    for (label in labels){
        label.background = Color.WHITE
    }
}