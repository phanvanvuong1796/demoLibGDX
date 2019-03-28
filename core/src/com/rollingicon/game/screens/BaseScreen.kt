package com.rollingicon.game.screens

import com.badlogic.gdx.Screen
import com.rollingicon.game.MainGame

abstract class BaseScreen(game: MainGame): Screen {

    protected var game: MainGame = game

    override fun hide() {

    }

    override fun show() {

    }

    override fun render(delta: Float) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun resize(width: Int, height: Int) {

    }

    override fun dispose() {

    }
}