package br.com.ourbudget.domain

import org.scalatest.FlatSpec
import org.scalatest.Matchers




class BudgetSpec extends FlatSpec with Matchers {


 val budget = Budget(name = "Travel")


 // REVENUES TESTS TO + METHOD

 "it" should "return one new copy of Budget when add new Revenue" in {
     val copy = budget :+ Revenue("Salary", 100.0)
     copy should not be theSameInstanceAs(budget)
  }

   "it" should "return one new copy of Budget with a new Revenues in List of Revenues" in {
     val copy = budget :+ Revenue("Salary", 100.0)
     copy.revenues should have length 1
   }


   "it" should "return one new copy of Budget with the new Revenues with index" in {
	    val copy = budget :+ Revenue("Salary", 100.0) :+ Revenue("Investiments", 100.0)
	    copy.revenues(0).index should be(0)
	    copy.revenues(1).index should be(1)
   }


   "it" should "add the Revenues in balance of the Budget" in {
	    val copy = budget :+ Revenue("Salary", 100.0) :+ Revenue("Investiments", 100.0)
	    copy.balance should be (200.0)
   }



   // REVENUES TESTS TO - METHOD

   "it" should "return one new copy of Budget when remove one Revenue" in {
	    val copy = budget :- Revenue("Hotel", 100.0)
	    copy should not be theSameInstanceAs(budget)
    }

	
/*   "it" should "return one new copy of Budget without Revenue when remove the Revenue" in {
	   val copy = budget + Revenue("Hotel", 100.0) + Revenue("Salary", 100.0) + Revenue("Hotel", 100.0) - Revenue("Salary", 100.0, false , 1) // need pass complete object to remove
	   copy.revenues.length should be(2)
	   copy.revenues should contain(Revenue("Hotel", 100.0, false, 0))
	   copy.revenues should contain(Revenue("Hotel", 100.0, false, 1))
	   copy.revenues should not contain(Revenue("Salary", 100.0, false, 1))
   }*/


/*   "it" should "return one new copy of Budget without Revenue and reorganize the index" in {
	   val copy = budget + Revenue("Hotel", 100.0) + Revenue("Salary", 100.0) + Revenue("Hotel", 100.0) - Revenue("Salary", 100.0, false, 1)
	   copy.revenues(0).index should be(0)
	   copy.revenues(1).index should be(1)
   }

   "it" should "subtract the Revenues in balance of the Budget" in {
	     val copy = budget + Revenue("Hotel", 100.0) + Revenue("Salary", 100.0) + Revenue("Hotel", 100.0) - Revenue("Salary", 100.0, false, 1)
			 copy.balance should be (200.0)
   }
   
   "it" should "ignore the remove of Revenues when Budget don't have it" in {
	   val copy = budget + Revenue("Salary", 100.0) - Revenue("Salary", 100.0, false, 0) - Revenue("Salary", 100.0, false, 1)
	   copy.revenues.length should be(0)
   }


   "it" should "ignore the subtract of Revenues when Budget don't have it" in {
	   val copy = budget + Revenue("Salary", 100.0) - Revenue("Salary", 100.0, false, 0) - Revenue("Salary", 100.0, false, 1)
	   copy.balance should be(0.0)
   }*/









   // EXPENDITURE + METHOD TESTS

   "it" should "return one new copy of Budget when add new Expenditure" in {
	val copy = budget + Expenditure("Hotel", 100.0, "Travel")
	copy should not be theSameInstanceAs(budget)
   }


   "it" should "return one new copy of Budget with new Expenditure in List of Expenditures " in {
	   val copy = budget + Expenditure("Hotel", 100.0, "Travel")
	   copy.expenditures should have length 1
   }


   "it" should "return one new copy of Budget with the new Expenditure with index" in {
	   val copy = budget + Expenditure("Hotel", 100.0, "Travel") + Expenditure("Airplane", 100.0, "Travel")
	   copy.expenditures(0).index should be(0)
	   copy.expenditures(1).index should be(1)
   }



  "it" should "subtracting the Expenditure in balance of the Budget" in {
	   val copy = budget + Expenditure("Hotel", 100.0, "Travel" ) + Expenditure("Airplane", 100.0, "Travel")
	   copy.balance should be (-200.0)
   }



  
     // EXPENDITURE TESTS TO - METHOD

/*   "it" should "return one new copy of Budget when remove one Expenditure" in {
	    val copy = budget - Expenditure("Hotel", 100.0, "Travel")
	    copy should not be theSameInstanceAs(budget)
    }

	
   "it" should "return one new copy of Budget without Expenditure when remove the Expenditure" in {
	   val copy = budget + Expenditure("Hotel", 100.0, "Travel") + Expenditure("Car", 100.0, "Travel") + Expenditure("Restaurant", 100.0, "Travel") - Expenditure("Car", 100.0,"Travel", false , 1) // need pass complete object to remove
	   copy.expenditures.length should be(2)
	   copy.expenditures should contain(Expenditure("Hotel", 100.0, "Travel", false, 0))
	   copy.expenditures should contain(Expenditure("Restaurant", 100.0, "Travel", false, 1))
	   copy.expenditures should not contain(Expenditure("Car", 100.0, "Travel", false, 1))
   }
   
  
    "it" should "remove the Expenditure in balance of the Budget" in {
	   val copy = budget :+ Revenue("Salary", 400.0) + Expenditure("Hotel", 100.0, "Travel") + Expenditure("Hotel", 100.0, "Travel") - Expenditure("Hotel", 100.0, "Travel", false, 1)
	   copy.balance should be (300.0)
   }
   
   
   

   "it" should "ignore the remove of Expenditure when Budget don't have it" in {
	   val copy = budget :+ Revenue("Salary", 100.0) + Expenditure("Hotel", 100.0, "Travel") - Expenditure("Hotel", 100.0, "Travel", false, 0) - Expenditure("Hotel", 100.0, "Travel", false, 0)
	   copy.expenditures.length should be(0)
	   copy.balance should be(100.0)
   }*/

   
   


   // USER TESTS

   "it" should "return on new copy of Budget with the id of User " in {
     val user = new User(id = "id", name= "Robson")
	   val copy = budget +  user
	   copy.users should contain("id")
   }



}
