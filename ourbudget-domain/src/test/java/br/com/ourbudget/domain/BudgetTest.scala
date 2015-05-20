package br.com.ourbudget.domain

import org.scalatest._
import org.scalatest.Matchers

class BugdetTest extends FlatSpec with Matchers  {

  "one test" should "for exmple" in {
      var bugdet = new Bugdet("test", 2.22)
      
      bugdet.name should be ("test")
      bugdet.value should be (2.22)
       
  }

  
}