package br.com.ourbudget.domain


case class Revenue(name: String, value: Double)
case class Expenditure(name: String, value: Double)


// TODO: Study some way to allow create the Budget only with name...
case class Budget(id : String = "", name: String = "", balance: Double = 0.0,  revenues: Array[Revenue] = Array(), expenditures: Array[Expenditure] = Array(), users : Array[String] = Array()){
  def +(rev: Revenue) = copy(balance = balance + rev.value, revenues = revenues :+ rev)
  def +(exp: Expenditure) = copy(balance = balance - exp.value,  expenditures = expenditures :+ exp )
  def +(user: User) = copy(users = users :+ user.id)
}


case class User(id: String = "", name: String = "", budgets: Array[String] = Array()){
  def +(budget: Budget) = copy(budgets = budgets :+ budget.id)
}


// TODO: add date in Budget + Revenue + Expenditure
// TODO: add close to Budget
// TODO: Revenue Received
// TODO: Expenditure liquidated
