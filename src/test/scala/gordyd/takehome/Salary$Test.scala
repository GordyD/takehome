package gordyd.takehome

import java.util.Locale

class Salary$Test extends UnitSpec {

  it should "equal 10000 gross when 10000 net" in {
    val s = new Salary(10000, Locale.UK)
    s.net should be (10000)
    s.ni should be (245.28000000000003)
    s.tax should be (0.0)
    s.gross should be (9754.72)
  }

  it should "equal 9788.72 gross when 10050 net" in {
    val s = new Salary(10050, Locale.UK)
    s.net should be (10050)
    s.gross should be (9788.72)
    s.ni should be (251.28000000000003)
    s.tax should be (10.0)
  }

  it should "equal 24034.72 gross when 31000 net" in {
    val s = new Salary(31000, Locale.UK)
    s.net should be (31000)
    s.gross should be (24034.72)
    s.ni should be (2765.2799999999997)
    s.tax should be (4200)
  }

  it should "equal 26788.72 gross when 35050 net" in {
    val s = new Salary(35050, Locale.UK)
    s.net should be (35050)
    s.gross should be (26788.72)
    s.ni should be (3251.2799999999997)
    s.tax should be (5010)
  }

  it should "equal 26788.72 gross when 45050 net" in {
    val s = new Salary(45050, Locale.UK)
    s.net should be (45050)
    s.gross should be (33284.2)
    s.ni should be (4131.8)
    s.tax should be (7634)
  }

  it should "equal 52514.62 gross when 78230 net" in {
    val s = new Salary(78230, Locale.UK)
    s.net should be (78230)
    s.gross should be (52528.6)
    s.ni should be (4795.4)
    s.tax should be (20906)
  }
}
