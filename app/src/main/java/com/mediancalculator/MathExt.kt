package com.mediancalculator

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}

fun List<Float>.median(): Double {
    val numbers = this.sortedDescending()
    val size = numbers.size;

    return if (size % 2 != 0) {
        numbers[size / 2].toDouble().round(1)
    } else {
        ((numbers[(size - 1) / 2] + numbers[size / 2]) / 2.0).round(1)
    }
}

