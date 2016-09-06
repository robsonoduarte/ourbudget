package br.com.ourbudget.domain

import org.scalatest.FlatSpec
import org.scalatest.Matchers




class BudgetSpec extends FlatSpec with Matchers {


	  val budget = new Budget(name = "Travel")



	  // REVENUES TESTS

		"it" should "return one new copy of Budget when addd new Revenue" in {
		  val copy = budget + Revenue("Salary", 100.0)
		  copy should not be theSameInstanceAs(budget)
	  }


   "it" should "return one new copy of Budget with a new Revenues in List of Revenues" in {
    	val copy = budget + Revenue("Salary", 100.0)
      copy.revenues should have length 1
   }


   "it" should "add the Revenues in balance of the Budget" in {
	   val copy = budget + Revenue("Salary", 100.0)
	   copy.balance should be (100.0)
   }




   // EXPENDITURE TESTS

   "it" should "return one new copy of Budget when addd new Expenditure" in {
		 val copy = budget + Expenditure("Hotel", 100.0)
		 copy should not be theSameInstanceAs(budget)
   }


   "it" should "return one new copy of Budget with new Expenditure in List of Expenditures " in {
	   val copy = budget + Expenditure("Hotel", 100.0)
	   copy.expenditures should have length 1
   }

   //

   "it" should "subtracting the Expenditure in balance of the Budget" in {
	   val copy = budget + Expenditure("Hotel", 100.0)
	   copy.balance should be (-100.0)
   }






   // USER TESTS

   "it" should "return on new copy of Budget with the id of User " in {
     val user = new User(id = "id", name= "Robson")
	   val copy = budget +  user
	   copy.users should contain("id")
   }





}