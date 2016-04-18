package br.com.ourbudget.persistence.mongo



import org.scalatest.FlatSpec
import org.scalatest.Matchers
import br.com.ourbudget.domain.Budget



class RepositorySpec extends FlatSpec with Matchers {




  // simple test

  "it" should "save the object" in {
    val repository = new Repository

    repository save(new Budget("test"))
  }









}