package com.rollingicon.game

import com.badlogic.gdx.Game
import com.rollingicon.game.screens.RollingIconScreen

class MainGame: Game() {


    override fun create() {
        setScreen(RollingIconScreen(this))
    }
}