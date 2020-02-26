package MergeSort
import de._
object mSort {
  def msort[T](less: (T,T) => Boolean)(xs: List[T]): List[T] = {
    def merge (xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x::xs1, y::ys1) =>
          if (less(x,y)) x::merge(xs1,ys) else y::merge(xs, ys1)
      }
    }
    val n = xs.length / 2
    if (n==0) xs
    else {
      val (ys, zs) = xs splitAt n
      var mitad1 : List[T]= null
      var mitad2 : List[T]=  null
      val threadA = thread {
        mitad1 =msort(less)(ys)
      }
      val threadB = thread {
       mitad2= msort(less)(zs)
      }
      threadA.join()
      threadB.join()
      merge (mitad1, mitad2)
    }
  }
  def msort1[T](less: (T,T) => Boolean)(xs: List[T]): List[T] = {
    def merge1 (xs: List[T], ys: List[T]): List[T] = {
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x::xs1, y::ys1) =>
          if (less(x,y)) x::merge1(xs1,ys) else y::merge1(xs, ys1)
      }
    }
    val n = xs.length / 2
    if (n==0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge1 (msort(less)(ys), msort(less)(zs))
    }
  }

}
