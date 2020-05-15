package models.entity

import java.util.Date

import anorm.SqlParser

case class Check(
                id:Long,
                name:String,
                result:String,
                created:Date,
                modified:Date
                )
object Check {

  val checkEntityParser = {
    SqlParser.int("check.id") ~
      SqlParser.str("check.name") ~
      SqlParser.str("check.result") ~
      SqlParser.str("check.created") ~
      SqlParser.str("check.modified")
  } map {
    case id ~ name ~ result ~ created ~ modified => Check(id, name, result, created, modified)
  }
}
