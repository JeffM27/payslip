import java.math.RoundingMode
import kotlin.toBigDecimal

fun main() {
    println("Pay Slip Printer")
    printSlip()
}

fun printSlip() {
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
    val grossPay = calculateGrossPay(hours, rate, overtimeHours)

    println("=============================")
    println("\t\t\tPAYSLIP")
    println("=============================")
    println("Employee ID\t\t : $employeeId")
    getFullName(firstName, surname, employeeId)
    println("Job / Dept\t\t : $jobTitle ($department)")
    println("-----------------------------")
    println("Hourly Rate\t\t : $rate")
    println("Hours Worked\t : $hours")
    println("Overtime Hours\t : $overtimeHours")
    println("-----------------------------")
    println("Normal Pay\t\t : €" + calculateNormalPay(hours, rate))
    println("Overtime Pay\t : €" + calculateOvertimePay(overtimeHours, rate))
    println("Gross Pay\t\t : €${calculateGrossPay(hours, rate, overtimeHours)}")
    println("Bonus\t\t\t : €${calculateBonus(grossPay, bonusPercentage)}")
    println("Tax Deduction\t : €${calculateTax(grossPay, taxRatePercentage)}")
    println("Pension Deduction: €${calculatePension(grossPay, pensionContribution)}")
    println("Net Pay\t\t\t : €${calculateNetPay(grossPay, taxRatePercentage, pensionContribution, bonusPercentage)}")
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