package br.com.ourbudget.domain

case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){

  def +(budget: Budget) = copy(id, name, budgets.+:(budget.id))




}