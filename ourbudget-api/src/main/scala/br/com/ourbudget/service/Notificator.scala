package br.com.ourbudget.service

import scalaj.http.Http



class Notificator {

	private val app_id = ""
	private val api_key = ""


// TODO: get object message
  def notify(msg: String) = {


	  // TODO: filter the notification by user of budget
    val rsp =  Http("https://onesignal.com/api/v1/notifications")
      .postData(json(msg))
      .header("content-type", "application/json; charset=UTF-8")
      .header("Authorization", s"Basic $api_key")
      .asString


      rsp.body

  }



	// TODO: generate the json by json4s
	 private def json(msg:String) = {
	   val s =  s"""{"app_id": "$app_id","included_segments": ["All"], "data": $msg, "contents": {"en": "Novo Item"}}"""
	   print(s)
	   s
	 }

}

object Notificator {
  def apply() = new Notificator()
}