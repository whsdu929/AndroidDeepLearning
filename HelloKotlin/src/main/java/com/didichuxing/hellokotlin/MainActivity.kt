package com.didichuxing.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import java.util.*

// 从 Any 隐式继承, Kotlin 中所有类都继承该 Any 类，它是所有类的超类
class MainActivity : AppCompatActivity() {
    // 延迟初始化的两种方式:
    // lateinit只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型
    private lateinit var view: View
    // by lazy要求属性声明为val，真正做到了延迟初始化
    private val name: Int by lazy { 1 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test(Int.MAX_VALUE, "what?")
    }

    // 抽象类                 abstract
    // 类不可继承，默认属性      final
    // 枚举类                  enum
    // 类可继承，类默认是final的  open
    // 注解类                  annotation
    // 如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去getter和setter方法，val不允许设置setter函数，因为它是只读的。
    open class Fruit(name : String) {
        open fun buy() {
            //允许子类重写
        }
    }
    interface SuperMarket {
        fun sale()
    }
    class Apple(name : String, price : Float?) : Fruit(name), SuperMarket {
        override fun sale() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    class Banana : Fruit{
        constructor(name : String) : super(name)
        override fun buy() {
            super.buy()
        }
    }

    //后面加?表示str可以为null，:号既表示返回值，又表示继承/实现
    fun test(num: Int, str: String?): Int {
        //类型转换
        var longNum: Long = num.toLong()
        //指定类型
        var floatNum: Float
        //常量
        val CONST_NUM: Int = 8
        //自动推断类型
        var a = Math.sqrt(3.0)

        //"""，被一对三引号包裹的内容是原样字符串，不支持转义字符，其中的内容被定义成什么样，输出的时候就是什么样
        var tmpStr: String = """\n\123$#@?"""
        var tmpStr2 = "f**k"
        var flag: Boolean = tmpStr == tmpStr2
        //第二个参数表示是否忽略大小写
        var flag2: Boolean = tmpStr.equals(tmpStr2, true)

        //相当于switch
        var result = when (a) {
            1.0 -> a++
            else -> a--
        }
        //表示我们声明了一个闭区间数组，其中包含的数值为1-100。 .. 表示闭区间
        var arr1: IntRange = 1..100
        //前闭后开区间，取值 1-99。util表示前闭后开区间
        var arr2 = 1 until 100
        for (tmpInt in arr2 step 7) {
            var a = tmpInt;
            a++
        }
        //数组内容反转
        var arr4 = arr1.reversed()
        //声明List时主要是通过 listOf()实现
        var list1 = listOf(1, 2.0, "")
        //withIndex() 方法，index 接收索引，value 接收对应的值
        for ((inde, valu) in list1.withIndex()) {

        }
        var map1 = TreeMap<Double, String>()
        map1[4.0] = "lbj"
        print(map1[2.0])

        return CONST_NUM
    }

    fun sum1(a: Int, b: Int): Int {
        return a + b
    }
    //函数的简化
    fun sum2(a: Int, b: Int) = a + b
    fun sum3(a: Int, b: Int): Int = sum4(a, b)
    //函数也可以通过var声明
    var sum3 = { x: Int, y: Int -> x + y }
    //var声明的第2种方式
    var sum4: (Int, Int) -> Int = { x, y -> x + y }

    val PI: Float = 3.1415f
    //函数参数赋予默认值，这样可以调用该方法时不传这个
    fun getRoundArea(pi: Float = PI, radius: Float) = pi * radius * radius
    //表明传入的参数是传给哪个变量的
    var b = getRoundArea(radius = 5.0f)
    var c = b.toInt()

    //val l: Int = if (str != null) str.length else -1
    //等价于
    //val l = str?.length ?: -1

    fun main(arr: Array<String>) {
        var a = readLine()
        var b = readLine()
        //readLine(）得到的可能是null，所以此处通过 !! 断言输入不为null
        var num = a!!.toInt()
        try {
        } catch (e: Exception) {
        }
    }

}
