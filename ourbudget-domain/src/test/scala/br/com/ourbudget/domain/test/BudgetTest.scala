package br.com.ourbudget.domain.test

import br.com.ourbudget.domain.Budget
import org.scalatest.exceptions.TestFailedException
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by Thiago Pereira on 7/24/15.
 */
class BudgetTest extends FlatSpec with Matchers {

  val fixture = new {
    val budget = Budget("test", 2.22)
  }

  "A Budget" should "be comparable" in {
    fixture.budget.name shouldBe "test"
    fixture.budget.value shouldBe 2.22
  }

  it should "producer Exception when value is different" in {
    intercept[TestFailedException] {
      fixture.budget.name shouldBe "abc"
    }
  }
}