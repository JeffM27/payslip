import java.math.RoundingMode
import kotlin.toBigDecimal

fun main() {
    val rate = 26.87
    val hours = 39
    val overtimeHours = 4
    val bonusPercentage = 4.5
    val taxRatePercentage = 23.5
    val pensionContribution = 6.7
    val grossPay = calculateGrossPay(hours, rate, overtimeHours)
    val bonusPay = calculateBonus(grossPay, bonusPercentage)
    val pensionDeduction = calculatePension(grossPay, pensionContribution)
    val netPay = calculateNetPay(grossPay, taxRatePercentage, pensionContribution, bonusPercentage)

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> println("Hourly Rate: $rate")
            2 -> println("Hours Worked: $hours")
            3 -> println("Overtime Hours: $overtimeHours")
            4 -> println("Bonus: $bonusPay")
            5 -> println("Tax Rate: $taxRatePercentage")
            6 -> println("Pension: $pensionDeduction")
            7 -> println("Gross Pay: $grossPay")
            8 -> println("Net Pay: $netPay")
            9 -> getPayslip()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
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

fun menu() : Int {

    val employeeId = 6143
    val firstName = "Joe"
    val surname = "Soap"

    print("""
        Employee Menu for ${firstName.uppercase()} ${surname.uppercase()} ($employeeId)
        1. Hourly Rate
        2. Hours Worked
        3. Overtime Hours
        4. Bonus
        5. Tax Rate
        6. Pension
        7. Gross Pay
        8. Net Pay
        9. Full Payslip
        -1. Exit
        Enter Option: """)
    return readln().toInt()
}