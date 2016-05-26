package br.com.ourbudget.persistence.mongo



import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.com.ourbudget.domain.Budget



class RepositorySpec extends FlatSpec with Matchers {


	val repository = new Repository




  "it" should "save the object" in {
    repository save(new Budget("repository-test", "repository-test"))
  }



  "it" should "find object by id" in {
		val budget = repository find("repository-test", classOf[Budget]) // FIXME: resolver the problem with integration db.
		budget shouldBe a [Budget]
  }




  "it" should "list all objects in one collection" in {
	  val budgets = repository list(classOf[Budget])
		/*budgets should  have size(2) */// FIXME: resolver the problem with integration db.
  }














}