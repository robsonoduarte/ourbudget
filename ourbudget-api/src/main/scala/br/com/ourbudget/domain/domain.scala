package br.com.ourbudget.domain

import scala.collection.mutable.ArrayBuffer


case class Revenue(name: String, value: Double, received: Boolean = false, index: Int = 0)
case class Expenditure(name: String, value: Double, tags: Array[String] = Array(), liquidated: Boolean = false)


// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String = "", balance: Double = 0.0,  closed: Boolean = false, revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def +(rev: Revenue) = copy(balance = balance + rev.value, revenues = revenues :+ rev.copy(name = rev.name, value = rev.value, index = revenues.length))
  def +(exp: Expenditure) = copy(balance = balance - exp.value,  expenditures = expenditures :+ exp )
  def +(user: User) = copy(users = users :+ user.id)
}


case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(budgets = budgets :+ budget.id)
}


