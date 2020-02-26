package MergeSort
import  mSort.msort
import mSort.msort1
object Main extends App {
  var n = 50
  var lista = for (i <-0 until n) yield scala.util.Random.nextInt(1000)
  println("<------------Con concurrencia------------------->")
  var t0 = System.currentTimeMillis()
  var intSort = msort ((x:Int, y:Int)=> x < y) _
  println(intSort(lista.toList))
  var t1 = System.currentTimeMillis()
  println("Elapsed time: " + (t1 - t0) + "ms")
  lista = for (i <-0 until n) yield scala.util.Random.nextInt(1000)
  println("<------------Sin concurrencia------------------->")

  intSort = msort1 ((x:Int, y:Int)=> x < y) _
  t0 = System.currentTimeMillis()
  println(intSort(lista.toList))
  t1 = System.currentTimeMillis()
  println("Elapsed time: " + (t1 - t0) + "ms")


}
