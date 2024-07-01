package com.palmerodev.model

abstract class FighterEntity(
        val name: String,
        var health: Int,
        var alive: Boolean,
) {
    abstract fun getDamage(): Int
    abstract fun receiveAttack(damage: Int)
    fun isAlive(): Boolean = alive
}

open class WarriorEntity(
        name: String,
        private val strength: Int,
        health: Int,
        private val attack: Int,
        alive: Boolean = true,
) : FighterEntity(name, health, alive) {
    override fun getDamage(): Int = strength * attack
    override fun receiveAttack(damage: Int) {
        health = if (health - damage < 0) 0 else health - damage
        alive = health > 0
    }
}

open class MagicianEntity(
        name: String,
        private val intelligence: Int,
        health: Int,
        private val magic: Int,
        alive: Boolean = true,
) : FighterEntity(name, health, alive) {
    override fun getDamage(): Int = intelligence * magic
    override fun receiveAttack(damage: Int) {
        health = if (health - damage < 0) 0 else health - damage
        alive = health > 0
    }
}

open class ThiefEntity(
        name: String,
        private val agility: Int,
        health: Int,
        private val steal: Int,
        alive: Boolean = true,
) : FighterEntity(name, health, alive) {
    override fun getDamage(): Int = agility * steal
    override fun receiveAttack(damage: Int) {
        health = if (health - damage < 0) 0 else health - damage
        alive = health > 0
    }
}

open class FinalBossEntity(
        name: String,
        private val strength: Int,
        private val intelligence: Int,
        private val agility: Int,
        private val magic: Int,
        private val steal: Int,
        health: Int,
        alive: Boolean = true,
) : FighterEntity(name, health, alive) {
    override fun getDamage(): Int = strength * intelligence * agility * magic * steal
    override fun receiveAttack(damage: Int) {
        health = if (health - damage < 0) 0 else health - damage
        alive = health > 0
    }
}