package br.com.ourbudget.domain

import scala.collection.mutable.ArrayBuffer




object Temp2 extends App {


  val array = ArrayBuffer( 'a', 'b', 'c', 'd')


 // val x = array -= ('a')

 // print(x)


  val y = array.update(array.indexOf('a'), 'c')

  print(y)

}