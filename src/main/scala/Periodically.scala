import de._
object Periodically extends App {
  var global = 0;
  def periodically(duration: Long, f: => Unit): Unit = {
    val worker = new Thread {
        val currentThread = Thread.currentThread()
        while (true){
        //println("Hola! Han pasado " + global+" segundos")
        f
        Thread.sleep(duration)
        }
    }
    worker.setName("Worker")
    worker.setDaemon(true) //para evitar que lo mate su padre
    worker.start()
  }
  periodically (1000,{println("ha pasado 1 segundo")})
}
