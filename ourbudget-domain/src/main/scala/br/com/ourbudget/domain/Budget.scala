package br.com.ourbudget.domain



class Budget(val name: String, val revenues: List[Revenue] = List()) {

  def addRevenue(revenue: Revenue): Budget = {
    val copy = new Budget(name, revenues.::(revenue) )
    copy
  }

}