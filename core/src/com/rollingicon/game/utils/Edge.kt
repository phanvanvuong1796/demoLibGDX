package com.rollingicon.game.utils

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.World

object Edge {
    fun createEdge(world: World, x: Float, y: Float, width: Float, height: Float) {
        val edgeBodyDef = BodyDef()
        edgeBodyDef.position.set(Vector2(x, y))
        edgeBodyDef.type = BodyDef.BodyType.StaticBody
        val edgeBody = world.createBody(edgeBodyDef)
        val edgeBox = PolygonShape()
        edgeBox.setAsBox(width, height)
        edgeBody.createFixture(edgeBox, 1f)
        edgeBox.dispose()
    }
}