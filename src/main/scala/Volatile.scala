object Volatile extends App {
  class CustomThread extends Thread {
    @volatile var flag = true
    override def run(): Unit = {
      while(flag) { }
      println("Thread terminated")
    }
  }
  val thread = new CustomThread
  thread.start()
  Thread.sleep(2000)
  thread.flag = false
  println("App terminated")
}
