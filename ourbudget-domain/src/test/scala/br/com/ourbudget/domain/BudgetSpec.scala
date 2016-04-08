package br.com.ourbudget.domain

import org.scalatest.FlatSpec
import org.scalatest.Matchers


class BudgetTest extends FlatSpec with Matchers {



  //budget revenue expenditure


    def fixture = new {
        val budget = new Budget("Travel")
    }






    "it" should "return one new copy of Budget" in {

      val copy = fixture.budget.addRevenue(new Revenue("Hotel", 100.0))

      copy should not equal fixture.budget
    }






   "it" should "return one new copy of Budget with new Revenues in List of Revenues " in {

    	val copy = fixture.budget.addRevenue(new Revenue("Hotel", 100.0))

      val revenues =  copy revenues

    	revenues should have length 1
   }






















}