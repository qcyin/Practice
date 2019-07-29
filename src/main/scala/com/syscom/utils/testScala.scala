package com.syscom.utils

object testScala {

  def main(args: Array[String]): Unit = {

    var x = List(1)

    x = 2+:x
    println(x)

    x = 3::x
    println(x)

    x = x.+:(4)
    println(x)

    x = x.::(5)
    println(x)

    println(x.reverse)
    println(x.reverse.reverse==x)

//    val site1 = "Runoob" :: "Google" :: "Baidu" :: Nil
//
//    val site2 = "Facebook" :: "Taobao" :: Nil
//
//    var site3 = site1++site2
//    println(site3)
//
//    site3 = site1:::site2
//    println(site3)
//
//    site3 = List.concat(site1, site2)
//    println(site3)

//    var arrayStr = scala.collection.mutable.LinkedList[String]("123")
//    var a = arrayStr.flatMap(elem=>{
//      var array = Array[Int]()
//      for(i<-elem){
//        array = array:+(i*1)
//      }
//      array
//    })
//
//    println(a)


//    var list = scala.collection.mutable.LinkedList[Int](1,2,3,4,5,6,7,8,9,10,11)
//    var index = 0
//    list = list.map(elem=>{
//      index+=1
//      if(index%2!=0){
//        elem*2
//      }else{
//        elem
//      }
//    }).flatMap(elem=>{
//      Array(elem,elem)
//    })
//    println(list)
  }

  //  def main(args: Array[String]): Unit = {
  //    val list = scala.collection.mutable.LinkedList[Int](1,2,3,4,5,6,7,8,9,10)
  //    var currentList = list
  //    while(currentList!=Nil){
  //      currentList.elem = currentList.elem*2
  //      currentList = currentList.next
  //    }
  //    println(list)
  //  }

  //  def main(args: Array[String]) {
  //    println(triple(3*_))
  //    println(triple((num:Int)=>num*num))
  //  }

  def triple(func:(Int)=>Int)={func(3)}

}
