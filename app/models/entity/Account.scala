package models.entity

import java.util.Date

import anorm.SqlParser

case class Account(
                id:Long,
                mail:String,
                password:String,
                accessToken:String,
                provider:String,
                created_at:Date,
                updated_at:Date
                )

object Account {
/*
  val checkEntityParser = {
    SqlParser.int("check.id") ~
    SqlParser.str("check.mail") ~
    SqlParser.str("check.password") ~
    SqlParser.str("check.created_at") ~
    SqlParser.str("check.updated_at")
  } map {
    case id ~ mail ~ password ~ created_at ~ updated_at  => Account(id, mail, password, created_at, updated_at)
  }
 */
}
