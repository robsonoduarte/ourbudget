package br.com.ourbudget.domain


case class Revenue(name: String, value: Double)
case class Expenditure(name: String, value: Double)


// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String = "", balance: Double = 0.0,  revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def +(revenue: Revenue) = copy(balance = balance + revenue.value, revenues = revenues :+ revenue)
  def +(expenditure: Expenditure) = copy(balance = balance - expenditure.value,  expenditures = expenditures :+ expenditure )
  def +(user: User) = copy(users = users :+ user.id)
}


case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(budgets = budgets :+ budget.id)
}


