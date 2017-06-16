package util

import java.util.*
import javax.swing.JFrame

/**
 * Created by Joki on 2017/6/6.
 *
 * 使用栈来管理Frame的状态
 */
open abstract class StackFrame : JFrame{
    /**
     * 构造函数 The primary constructor cannot contain any code
     */
    constructor(title : String) : super(title)

    /**
     * companion对象列表
     */
    companion object{
        private val sFrameStacks: Stack<StackFrame> = Stack<StackFrame>()
    }

    /**
     * 对象被实例化时执行 相当于Java构造函数 Initialization code can be placed in initializer blocks
     */
    init {
        sFrameStacks.add(this)//进栈
        onStart()
        sFrameStacks.forEach { it.onOtherStart(this) }
    }

    /**
     * 重写dispose()方法。关闭本界面，并出栈
     */
    override fun dispose(){
        sFrameStacks.pop()
        onDispose()
        sFrameStacks.forEach { it.onOtherDispose(this) }//遍历通知关闭
        super.dispose()
    }

    open fun onStart(){}

    open fun  onOtherStart(stackFrame: StackFrame){ }


    /**
     * 当自己关闭时调用
     */
    open fun onDispose(){}

    /**
     * 其他Frame关闭时调用
     */
    open fun onOtherDispose(stackFrame: StackFrame){}

    override fun hide() {
        super.hide()
        sFrameStacks.forEach { it.onOtherHide(it) }
    }

    open fun onOtherHide(stackFrame: StackFrame){}

    override fun show() {
        super.show()
        sFrameStacks.forEach { it.onOtherShow(it) }
    }

    open fun onOtherShow(stackFrame: StackFrame){}

}