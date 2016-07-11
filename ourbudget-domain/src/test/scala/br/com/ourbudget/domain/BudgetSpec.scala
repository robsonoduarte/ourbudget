package br.com.ourbudget.domain

import org.scalatest.FlatSpec
import org.scalatest.Matchers




class BudgetSpec extends FlatSpec with Matchers {




	  val budget = new Budget("1", "Travel", Array(Revenue("Investment", 100.0)), Array(Expenditure("Air Plane", 100.0)))




    "it" should "return one new copy of Budget when addd new Revenue" in {
      val copy = budget + Revenue("Salary", 100.0)
      copy should not be theSameInstanceAs(budget)
    }





   "it" should "return one new copy of Budget with new Revenues in List of Revenues " in {


    	val copy = budget + Revenue("Salary", 100.0)

      val revenues =  copy revenues
      val expenditure = copy expenditures

    	revenues should have length 2
    	expenditure should have length 1
   }






   "it" should "return one new copy of Budget when addd new Expenditure" in {

		 val copy = budget + Expenditure("Hotel", 100.0)

		 copy should not be theSameInstanceAs(budget)
   }








   "it" should "return one new copy of Budget with new Expenditure in List of Expenditures " in {

	   val copy = budget + Expenditure("Hotel", 100.0)

	   val revenues =  copy revenues
	   val expenditures = copy expenditures

	   revenues should have length 1
	   expenditures should have length 2
   }




}