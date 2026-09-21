import java.math.RoundingMode
import kotlin.toBigDecimal

fun main() {
    println("Pay Slip Printer")
    getPayslip()
}

fun getPayslip() {
    val employeeId = 6143
    val firstName = "Joe"
    val surname = "Soap"
    val department = "Computer Services"
    val jobTitle = "Technician"
    val rate = 26.87
    val hours = 39
    val overtimeHours = 4
    val bonusPercentage = 4.5
    val taxRatePercentage = 23.5
    val pensionContribution = 6.7
    val normalPay = calculateNormalPay(hours, rate)
    val overtimePay = calculateOvertimePay(overtimeHours, rate)
    val grossPay = calculateGrossPay(hours, rate, overtimeHours)
    val bonusPay = calculateBonus(grossPay, bonusPercentage)
    val taxDeduction = calculateTax(grossPay, taxRatePercentage)
    val pensionDeduction = calculatePension(grossPay, pensionContribution)
    val netPay = calculateNetPay(grossPay, taxRatePercentage, pensionContribution, bonusPercentage)

    val payslip = """
    =============================
    \t\t\tPAYSLIP
    =============================
    Employee ID      : $employeeId
    Employee		 : ${firstName.uppercase()} ${surname.uppercase()} ($employeeId)
    Job / Dept       : $jobTitle ($department)
    -----------------------------
    Hourly Rate      : $rate
    Hours Worked     : $hours
    Overtime Hours   : $overtimeHours
    -----------------------------
    Normal Pay       : ${money(normalPay)}
    Overtime Pay     : ${money(overtimePay)}
    Gross Pay        : ${money(grossPay)}
    Bonus            : ${money(bonusPay)}
    Tax Deduction    : ${money(taxDeduction)}
    Pension Deduction: ${money(pensionDeduction)}
    Net Pay          : ${money(netPay)}
    """.trimIndent()

    println(payslip)
}

// Where I researched the rounding: https://www.baeldung.com/kotlin/round-numbers

fun getFullName(firstName: String, surname: String, id: Int){
    println("Employee\t\t : ${firstName.uppercase()} ${surname.uppercase()} ($id)")
}

fun calculateNormalPay(a: Int, b: Double) = a*b

fun calculateOvertimePay(a: Int, b: Double) = a*(b*1.5)

fun calculateGrossPay(a: Int, b: Double, c: Int) = ((a*b)+(c*(b*1.5)))

fun calculateBonus(a: Double, b: Double) = (a*(b/100)).toBigDecimal().setScale(2, RoundingMode.UP)

fun calculateTax(a: Double, b: Double) = (a*(b/100)).toBigDecimal().setScale(2, RoundingMode.UP)

fun calculatePension(a: Double, b: Double) = (a*(b/100)).toBigDecimal().setScale(2, RoundingMode.UP)

fun calculateNetPay(a: Double, b: Double, c: Double, d: Double) = (a-(a*(b/100))-a*(c/100)+(a*(d/100))).toBigDecimal().setScale(2, RoundingMode.UP)

fun money(value: Any) = "€%.2f".format(value)