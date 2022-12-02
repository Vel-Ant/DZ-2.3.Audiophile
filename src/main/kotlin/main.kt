package ru.netology

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val itemPrice = 100
    val discount100 = 100
    val discount5Percent = 0.05
    val discount100Range = (1_001.. 10_000)
    val discount5PercentStart = 10_001
    val additionalDiscount = 0.01
    var i = 0
    var regularCustomer = (i >= 0)

    println("ВНИМАНИЕ!!! ДЕМОНСТРАЦИЯ РАБОТЫ КОДА!")

    while (true) {
        if (i == 0) println("Введите количество композиций для приобретения или нажмите 'end' для выхода")
        else println("\nПланируете продолжить покупки? Введите количество или нажмите 'end' для выхода")

        val input = scanner.nextLine()
        if (input == "end") break

        val itemCount = input.toInt()
        val estimation = itemPrice * itemCount  // предварительный подсчет

        i++

        val amount = if (estimation in discount100Range) estimation - discount100
        else if (estimation >= discount5PercentStart) (estimation - (estimation * discount5Percent)).toInt()
        else estimation

        regularCustomer = (i >= 3)
        if (i == 3) println("Поздравляем Вас, Вы стали нашим постоянным клиентом и поэтому мы дарим Вам пожизненную дополнительную скидку в 1%!!!")
        val finalAmount = if (regularCustomer == true) (amount - (amount * additionalDiscount)).toInt()
        else amount

        val finalDiscount = estimation - finalAmount    // расчет окончательной скидки

        println("Вы приобрели $itemCount композиций.\nОбщая сумма покупок составляет: $finalAmount руб., с учетом максимальной скидки $finalDiscount руб.")
    }
    println("До скорых встреч!")
}