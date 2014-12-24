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

  def tax = {
    val low = 10000
    val mid = 41865
    val high = 160000
    if (net <= low) {
      0.00
    } else if (net <= mid) {
      (((net-low)/100)*20)
    } else if (net <= high) {
      (((mid-low)/100)*20) + (((net-mid)/100)*40)
    } else {
      (((mid-low)/100)*20) + (((high-mid)/100)*40) + (((net-high)/100)*45)
    }
  }

  def ni = {
    val weekly = net/52
    val low = 153
    val high = 805
    if (weekly < low) {
      0.00
    } else if (weekly >= low && weekly <= high) {
      ((net-(low*52))/100)*12
    } else {
      ((((high-low)*52)/100)*12) + (((net-(high*52))/100)*2)
    }
  }

  def grossPercent = (2-(net/gross))

  def gross = {
    println(net, tax, ni)
    net - (tax + ni)
  }
}
