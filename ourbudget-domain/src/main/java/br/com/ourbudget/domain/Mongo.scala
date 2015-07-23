package br.com.ourbudget.domain

import com.mongodb.casbah.MongoClient
import com.mongodb.casbah.commons.MongoDBObject



object Mongo extends App {

  val mongoClient = MongoClient("52.10.140.124");


  val db =  mongoClient("ourbudget");


  var coll = db("ourbudget")

  val a = MongoDBObject("1" -> new Bugdet("teste", 2.0))

  coll.insert(a)

  db.collectionNames().foreach {print(_)}


}