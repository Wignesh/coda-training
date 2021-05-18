package ga.veee
package sandbox


abstract class Employee {
  def doWork: Unit
}

case class Engineer(name: String) extends Employee {
  override def doWork: Unit = {
    println("Fixing a bug")
  }
}

case class NullEmployee(name: String) extends Employee {
  override def doWork: Unit = {
    println("😴")
  }
}

object EmployeeRepo {
  final val employees = List("Employee1", "Employee2")

  def getEngineer(name: String): Employee = {
    if (employees.contains(name)) Engineer(name)
    else NullEmployee(name)
  }
}

object NullObject {

  def main(args: Array[String]): Unit = {
    EmployeeRepo.
      getEngineer("Employee1").
      doWork
    EmployeeRepo.
      getEngineer("Employee5").
      doWork
  }

}
