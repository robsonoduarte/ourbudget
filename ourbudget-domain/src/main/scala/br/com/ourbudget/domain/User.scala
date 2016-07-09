package br.com.ourbudget.domain

case class User(name: String, budgets: Array[Budget] = Array()){

  def +(budget: Budget) = copy(name, budgets.+:(budget))


}