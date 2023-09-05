package com.example.kotlinbasics

fun main() {
    val planets = mutableListOf(PlanetMars(), PlanetVenus(), PlanetJupiter(), PlanetSaturn())
    val visitor = NameVisitor()
    planets.forEach {
        it.accept(visitor)
        println(visitor.name)
    }
}

interface PlanetVisitor {
    fun visit(planet: PlanetMars)
    fun visit(planet: PlanetVenus)
    fun visit(planet: PlanetJupiter)
    fun visit(planet: PlanetSaturn)
}

interface Planet {
    fun accept(visitor: PlanetVisitor)
}

class PlanetMars : Planet {
    override fun accept(visitor: PlanetVisitor) = visitor.visit(planet = this)
}

class PlanetVenus : Planet {
    override fun accept(visitor: PlanetVisitor) = visitor.visit(planet = this)
}

class PlanetJupiter : Planet {
    override fun accept(visitor: PlanetVisitor) = visitor.visit(planet = this)
}

class PlanetSaturn : Planet {
    override fun accept(visitor: PlanetVisitor) = visitor.visit(planet = this)
}

class NameVisitor(var name: String = "") : PlanetVisitor {
    override fun visit(planet: PlanetMars) {
        name = "Mars"
    }

    override fun visit(planet: PlanetVenus) {
        name = "Venus"
    }

    override fun visit(planet: PlanetJupiter) {
        name = "Jupiter"
    }

    override fun visit(planet: PlanetSaturn) {
        name = "Saturn"
    }
}