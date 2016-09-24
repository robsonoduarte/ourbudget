package br.com.ourbudget.notification

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class NotificatorSpec extends FlatSpec with Matchers{


  val notificator = Notificator()




  it should "something" in {
    val result =   notificator notify """{"name": "Unit Test of NotificaatoSpec", "value": "80.00"}"""
    result should startWith ("""{"id""")
  }









}