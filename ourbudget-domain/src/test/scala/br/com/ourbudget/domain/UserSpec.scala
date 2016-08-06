package br.com.ourbudget.domain



import org.scalatest.FlatSpec
import org.scalatest.Matchers




class UserSpec extends FlatSpec with Matchers {



     val user = User(id = "id-user", name = "Robson")
     val budget =  Budget("id-budget")
     
     


    "it" should "return one new copy of User when addd new Budget" in{
       val copy =  user +  budget    
       
       copy should not be theSameInstanceAs(user)
       copy.budgets should contain("id-budget")
                 
     }



     





}