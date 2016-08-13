package br.com.ourbudget.domain


case class Revenue(name: String, value: Double)
case class Expenditure(name: String, value: Double)


// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String = "", balance: Double = 0.0,  revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def +(revenue: Revenue) = copy(id, name, balance + revenue.value, revenues :+ revenue, expenditures)
  def +(expenditure: Expenditure) = copy(id, name, balance - expenditure.value, revenues, expenditures :+ expenditure )
  def +(user: User) = copy(id, name, balance, revenues, expenditures, users :+ user.id)
}


case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(id, name, budgets :+ budget.id)
}


