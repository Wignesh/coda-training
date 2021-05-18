package ga.veee.Scala

import scala.io.{BufferedSource, Source}

object CSVAuthBean {
  def main(args: Array[String]): Unit = {

    val authBeans = getAuthList("/Users/vignesh/Downloads/auth.csv")

    authBeans.foreach(authBean => println(authBean))

    val authBeansLegacy = getAuthListLegacy("/Users/vignesh/Downloads/auth.csv")

    authBeansLegacy.foreach(authBean => println(authBean))
  }

  def getAuthList(authFileURI: String): List[AuthBean] = {
    val bufferedSource: BufferedSource = Source.fromFile(authFileURI)

    val authBeans = bufferedSource.getLines().toList.drop(1).take(10).map(line => {
      val column = line.split(",").map(_.trim)
      AuthBean(column(0), column(2))
    })

    bufferedSource.close()
    authBeans
  }

  def getAuthListLegacy(authFileURI: String): List[AuthBeanLegacy] = {
    val bufferedSource: BufferedSource = Source.fromFile(authFileURI)

    val authBeans = bufferedSource.getLines().toList.drop(1).take(10).map(line => {
      val column = line.split(",").map(_.trim)
      new AuthBeanLegacy(column(0), column(2))
    })

    bufferedSource.close()
    authBeans
  }
}

case class AuthBean(authCode: String, auaCode: String)

class AuthBeanLegacy(authCode: String, auaCode: String) {
  def getAuthCode: String = {
    authCode
  }

  def getAuCode: String = {
    auaCode
  }

  override def toString = s"AuthBeanLegacy($getAuthCode, $getAuCode)"
}