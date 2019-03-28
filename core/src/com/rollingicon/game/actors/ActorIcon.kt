package com.rollingicon.game.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor

class ActorIcon: Actor() {

    var texture: Texture = Texture("ic_cho.png")

    override fun act(delta: Float) {

    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch!!.draw(texture, x, y)
    }
}