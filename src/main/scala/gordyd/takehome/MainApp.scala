package gordyd.takehome

import java.util.Locale

object MainApp extends App {

  val locale = args(1) match {
    case "uk" => Locale.UK
    case "us" => Locale.US
    case x => {
      println(x)
      throw new Exception("Locale not catered for")
    }
  }

  val salary = new Salary(args(0).toDouble, locale)
  val formatter = java.text.NumberFormat.getCurrencyInstance(locale)
  val percentFmt = java.text.NumberFormat.getPercentInstance(locale)

  println(" ***** Breakdown *****")
  println(s" Percentage: ${percentFmt.format(salary.grossPercent)}")
  println(s" Annual: ${formatter.format(salary.net)} -> ${formatter.format(salary.gross)}" )
  println(s" Monthly: ${formatter.format(salary.net/12)} -> ${formatter.format(salary.gross/12)}" )
  println(s" Weekly: ${formatter.format(salary.net/52)}  -> ${formatter.format(salary.gross/52)}" )

}

class Salary(val net: Double, val locale: Locale) {

  def grossPercent = (2-(net/gross))

  def gross = locale match {
    case Locale.UK => {
      if (net <= 10000) {
        net
      } else if (net <= 31865) {
        10000 + (((net-10000)/100)*80)
      } else if (net <= 150000) {
        10000 + (((31865-10000)/100)*80) + (((net-31865)/100)*60)
      } else {
        10000 + (((31865-10000)/100)*80) + (((150000-31865)/100)*60) + (((net-150000)/100)*45)
      }
    }
    case _ => net
  }
}
