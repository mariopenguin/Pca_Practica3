import de._
object ThreadsMain extends App{
  class MyThread extends Thread{
     override def run(): Unit ={
        println("Hilo nuevo en ejecución")
    }
  }
  val t = new MyThread
  t.start()
  t.join()
  println("Hilo nuevo haciendo el join")
  println("<-----------------Parte 2------------------->")
  val g = thread{
    log("Segundo hilo ejecutandose")
    Thread.sleep(1000)
    log("Completado")
    Thread.sleep(1000)
  }
  g.join()
  log("El nuevo hilo ha hecho join al principal")
  println("<-----------------Parte 3 (No determinismo)------------------->")
  val p = thread{
    log("Hilo h  ejecutandose")
    for (i <- 0 to 10){
      log("Soy:")
    }
  }
  val q = thread{
    log("Hilo h  ejecutandose")
    for (i <- 0 to 10){
      log("Soy:")
    }
  }
  log("...")
  log("...")
  p.join()
  q.join()
  log("Los hilos p y q ha hecho el join")
}
