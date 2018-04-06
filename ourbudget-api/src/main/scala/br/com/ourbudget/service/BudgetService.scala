package br.com.ourbudget.service

import br.com.ourbudget.domain.Budget

class BudgetService {
  def save(budget: Budget): Budget = null
}

object BudgetService{
  def apply() = new BudgetService()
}

