package br.com.ourbudget.persistence.mongo

import scala.collection.JavaConverters.seqAsJavaListConverter

import org.mongodb.morphia.Morphia
import org.mongodb.morphia.annotations.Entity

import com.mongodb.MongoClient

import br.com.ourbudget.domain.Budget
import br.com.ourbudget.domain.Revenue


object Morphia extends App {




	dataStore save(List(budget).asJava)


	val budgets =   dataStore.createQuery(classOf[Budget]).asList()

	print(budgets)




	/*
	 * Stop the test with Morphia because I don't like Something:
	 *
	 * 1 - We need put default constructor in class of domain, polluting the class...
	 *
	 * 2 - The save method of DataStore have some problems of compilation with Scala ( I don't know exactly what is the problem )...
	 *
	 *
	 */



























  def dataStore = new Morphia createDatastore(mongoClient, "ourbudget")

  def mongoClient = new MongoClient("192.168.99.100")

  def budget = new Budget("Travel", Array(new Revenue("Hotel", 100.00)))

}