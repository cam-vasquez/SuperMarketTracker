package com.test.supermarkettracker.data.model

val name01 = "Brutto"
val location01 = "Bambu, Bulevar Del Hipodromo, San Salvador"

val name02 = "Sucrée"
val location02 ="Bulevar Del Hipodromo No. 406, San Salvador"

var markets = mutableListOf(
    MarketModel(name01, location01),
    MarketModel(name02, location02)
)