package br.com.ourbudget.persistence.mongo



import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.com.ourbudget.domain.Budget



class RepositorySpec extends FlatSpec with Matchers {


	val budget = new Budget(null,"repository-test")
	val repository = new Repository



  "it" should "save the object and add id" in {
    repository save(budget)
    budget.id should not be(null)
  }


	"it" should "update the object when it have id" in {
	  val id = budget.id
    repository save(budget)
    budget.id should be(id) // don't change the id
  }


  "it" should "find object by id" in {
		val b = repository find(budget.id, classOf[Budget])
		b.id should be (budget.id)
  }



  "it" should "list all objects in one collection" in {
	  val budgets = repository list(classOf[Budget])
		/*budgets should  have size(2) */// FIXME: resolver the problem with integration db.
  }


  "it" should "list all Budgets to the user" in {
	  val budgets = repository listToUser("57a51db034e53360137542aa")
		/*budgets should  have size(2) */// FIXME: resolver the problem with integration db.
  }












}