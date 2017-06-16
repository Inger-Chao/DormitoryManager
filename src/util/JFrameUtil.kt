package util


import base.DBService
import java.awt.Toolkit
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.WindowConstants

/**
 * 初始化Frame的基本属性
 * Created by Joki on 2017/6/6.
 */

var JFrame.mWidth : Int
    get() = 750
    set(value) {}

var JFrame.mHeight : Int
    get() = 530
set(value) {}

fun JFrame.init(width : Int, height : Int){
    setSize(width, height)
    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    var screenDimension = Toolkit.getDefaultToolkit().screenSize //获得屏幕尺寸
    setLocation((screenDimension.width - width)/2 ,(screenDimension.height - height)/2)
    isVisible = true
}

fun JFrame.init(){
    init(mWidth , mHeight)
}

fun JFrame.quit(){
    var flag = 0
    var message = "您确定退出系统吗？"
    flag = JOptionPane.showConfirmDialog(this,message,"提示",JOptionPane.YES_NO_OPTION)
    if (flag == JOptionPane.YES_OPTION){
        DBService.getInstance().close()
        System.exit(0)
    }

}
