package br.com.ourbudget.persistence.mongo



import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.com.ourbudget.domain.Budget



class RepositorySpec extends FlatSpec with Matchers {


	val repository = new Repository


  // simple test

  "it" should "save the object" in {
    repository save(new Budget("test"))
  }



  "it" should "find object by id" in {
		val budget = repository find("572405504c7439ab86008716", classOf[Budget])

		budget shouldBe a [Budget]
  }









}