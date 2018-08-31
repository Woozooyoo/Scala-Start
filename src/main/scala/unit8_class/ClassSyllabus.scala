package unit8_class

object ClassSyllabus {
  def main(args: Array[String]): Unit = {

    println("===================简单类===================")
    import scala.beans.BeanProperty
    class Dog { //class默认是public
      //@BeanProperty将scala的leg变量创造Java的Get和Set方法
      @BeanProperty var leg: Int = _ //private var leg = 4

      def shout(msg: String) = {
        println(msg)
      }
    }
    val dog = new Dog()
    dog.shout("wangwangwang~~")
    dog.setLeg(4)
    dog leg_= 10 // leg_= 是一个方法  这是scala的set方法规范
    println(dog leg)


    println("===================构造器===================")
    //    1)  主构造的参数直接放置于类名之后
    class ClassConstructor(name: String, age: Int) {
      println("语句1")
      println(name, age)

      //      name age upgrade 字段
      def myPrintln = println(name + "," + age)

      println("语句2")
    }
    val cc = new ClassConstructor("Nick", 20)
    cc.myPrintln

    //    2)  主构造器会执行类定义中的所有语句
    class ClassConstructor2(var name: String = "", private val price: Double = 0) {
      println(name, price)
    }
    val cc2 = new ClassConstructor2("aa", 20) //  (aa,20.0)元组
    val cc2_2 = new ClassConstructor2()
    cc2.name = "bb" //var才可以改变"bb"
    println(cc2.name)
    //    println(cc2.price)  //error

    println("===================辅助构造器===================")
    //主构造器中的是必须要实例化的 主构造器中是实例化必须需要的东西
    class ClassConstructorAuxiliary(name: String, age: Int) {
      def this() {
        this("", 0)
      }

      def this(name: String) {
        this()
      }

      def this(age: Int) {
        this()
      }

      def description = name + " is " + age + " years old"

    }
    println(new ClassConstructorAuxiliary().description)
    //    3)  辅助构造器名称为this，通过不同参数进行区分 协助你构造
    // 每一个辅助构造器都必须以主构造器或者已经定义的辅助构造器的调用开始
    class Person {
      private var name = ""
      private var age = 0

      def this(name: String) {
        this() //这个就是 class Person()
        this.name = name
      }

      def this(name: String, age: Int) {
        this(name)
        this.age = age
      }

      def description = name + " is " + age + " years old"
    }
    println(new Person("SarahConnor").description)
    println(new Person("Jewel", 24).description)


    println("===================单例模式===================")
    //    如果想让主构造器变成私有的，可以在()之前加上private，
    //    这样用户只能通过辅助构造器来构造对象了
    class CacheBean private() {
    }

    object CacheBean {  //伴生类对象 在这里面都是静态的
      var instance: CacheBean = _

      def apply(): CacheBean = {
        if (instance == null) {
          instance = new CacheBean
        }
        instance
      }
    }

    val cacheBean = CacheBean
    println(cacheBean)
    println(cacheBean.instance)

  }
}