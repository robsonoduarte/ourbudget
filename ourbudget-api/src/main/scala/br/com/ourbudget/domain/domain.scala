package br.com.ourbudget.domain

import scala.collection.mutable.ArrayBuffer


case class Revenue(name: String, value: Double, received: Boolean = false, index: Int = 0)
case class Expenditure(name: String, value: Double, category: String, liquidated: Boolean = false, index: Int = 0)


// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String, balance: Double = 0.0,  closed: Boolean = false, revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def :+(rev: Revenue) = copy(balance = balance + rev.value, revenues = revenues :+ _copy(rev))
  def :-(rev: Revenue) = copy( balance = --(rev),  revenues = remove(rev))
  def +(exp: Expenditure) = copy(balance = balance - exp.value,  expenditures = expenditures :+ _copy(exp) )
  def -(exp: Expenditure) = copy(balance = ++(exp), expenditures = remove(exp))
  def +(user: User) = copy(users = users :+ user.id)


  private def _copy(rev: Revenue) = rev.copy(name = rev.name, value = rev.value, index = revenues.length)
  private def _copy(exp: Expenditure) = exp.copy(name = exp.name, value = exp.value, category = exp.category, index = expenditures.length)

  private def --(rev: Revenue) = if(revenues.contains(rev)) balance - rev.value else balance
  private def ++(exp: Expenditure) = if(expenditures.contains(exp)) balance + exp.value else balance


  private def remove(rev: Revenue) = {
    val revs = revenues.filter(! _.equals(rev))
    revs.map(r => r.copy(index = (revs.indexOf(r)))).toArray
  }
  
  private def remove(exp: Expenditure) = {
	val exps = expenditures.filter(! _.equals(exp))
	exps.map(e => e.copy(index = (exps.indexOf(e)))).toArray
  }
}


case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(budgets = budgets :+ budget.id)
}



