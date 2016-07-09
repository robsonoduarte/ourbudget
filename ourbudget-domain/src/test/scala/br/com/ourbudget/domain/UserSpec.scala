package br.com.ourbudget.domain



import org.scalatest.FlatSpec
import org.scalatest.Matchers




class UserSpec extends FlatSpec with Matchers {



    val user = User("Robson")




    "it" should "return one new copy of User when addd new Budget" in{
       val copy =  user + Budget()
       copy should not be theSameInstanceAs(user)
     }






}