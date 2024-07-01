package com.palmerodev.services

import com.palmerodev.model.FighterEntity
import com.palmerodev.model.FinalBossEntity
import com.palmerodev.model.MagicianEntity
import com.palmerodev.model.WarriorEntity
import kotlin.random.Random

class ColiseumService {
    private val fighters: MutableList<FighterEntity> = mutableListOf()

    private fun addFighters(fighter: List<FighterEntity>) {
        fighters.addAll(fighter)
    }

    private fun desapearDeadFighters() {
        fighters.removeIf { ! it.alive }
    }

    fun fight(attacker: FighterEntity, defender: FighterEntity): Boolean {
        if (! attacker.alive || ! defender.alive) return false
        val attack = attacker.getDamage()
        defender.receiveAttack(attack)
        if (! defender.isAlive()) {
            desapearDeadFighters()
            if (defender is FinalBossEntity) fighters.clear()
            return true
        } else {
            return false
        }
    }

    private fun addFinalBoss() {
        fighters.add(
                FinalBossEntity(
                        name = "Final Boss",
                        health = Random.nextInt(100, 1000),
                        alive = true,
                        magic = Random.nextInt(1, 10),
                        intelligence = Random.nextInt(1, 6),
                        strength = Random.nextInt(1, 2),
                        steal = Random.nextInt(1, 8),
                        agility = Random.nextInt(1, 7),
                )
        )
    }

    fun initialize() {
        fighters.clear()
        addFinalBoss()
        val utils = ColiseumUtils()
        val random: Int = Random.nextInt(10)
        val fighters: MutableList<FighterEntity> = mutableListOf()
        for (i in 1..random) {
            fighters.add(utils.getRandomFighter())
        }
        addFighters(fighters)
        this.fighters.shuffle()
    }

}

class ColiseumUtils {
    fun getRandomFighter(): FighterEntity {
        val randomGeneratedNumber: Double = Random.nextDouble(1.0)
        return if (randomGeneratedNumber > 0.4) WarriorEntity(
                name = "Warrior",
                health = Random.nextInt(100, 1000),
                alive = true,
                attack = Random.nextInt(1, 10),
                strength = Random.nextInt(1, 5),
        ) else MagicianEntity(
                name = "Fighter",
                health = Random.nextInt(100, 1000),
                alive = true,
                magic = Random.nextInt(1, 10),
                intelligence = Random.nextInt(1, 7),
        )
    }

    fun shouldAttack(selected: Int, limit: Int?): Boolean {
        val randomGeneratedNumber = if (limit != null) Random.nextInt(limit) else Random.nextInt(10);
        return (if (randomGeneratedNumber - 5 >= 0) randomGeneratedNumber else 0) < selected && selected < randomGeneratedNumber
    }

    fun generateRandomAttackNumber(limit: Int): Int = Random.nextInt(limit)
}