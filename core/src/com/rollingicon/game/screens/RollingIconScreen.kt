package com.rollingicon.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
import com.rollingicon.game.MainGame
import com.badlogic.gdx.scenes.scene2d.Stage
import com.rollingicon.game.actors.ActorIcon
import com.rollingicon.game.utils.Edge

class RollingIconScreen(game: MainGame) : BaseScreen(game) {

    lateinit var world: World
    lateinit var debugRenderer: Box2DDebugRenderer
    lateinit var camera: OrthographicCamera

    lateinit var iconBody: Body
    lateinit var iconFixture: Fixture

    override fun show() {
        world = World(Vector2(0f, -9.8f), true)
        debugRenderer = Box2DDebugRenderer()
        camera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        camera.position.set(Gdx.graphics.width.toFloat()/2, Gdx.graphics.height.toFloat()/2, 0f)
        camera.update()

        iconBody = world.createBody(createIconBodyDef())

        var iconShape = PolygonShape()
        iconShape.setAsBox(60f, 60f)
        iconFixture = iconBody.createFixture(iconShape, 0f)
        iconShape.dispose()

        createEdge()
    }

    private fun createIconBodyDef():BodyDef{
        var bodyDef = BodyDef()
        bodyDef.position.set(100f, 10f)
        bodyDef.type = BodyDef.BodyType.DynamicBody
        return bodyDef
    }

    private fun createEdge(){
        Edge.createEdge(world, 0f, Gdx.graphics.height.toFloat(), (Gdx.graphics.width/2).toFloat(), 1f)
        Edge.createEdge(world, -(Gdx.graphics.width/2).toFloat(), 0f, 1f, (Gdx.graphics.height/2).toFloat())
        Edge.createEdge(world, 0f, -(Gdx.graphics.height/2).toFloat()-1f, (Gdx.graphics.width/2).toFloat(), 1f)
        Edge.createEdge(world,  (Gdx.graphics.width/2).toFloat()+1f, 0f, 1f, (Gdx.graphics.height/2).toFloat())
    }

    override fun dispose() {
        world.destroyBody(iconBody)
        world.dispose()
        debugRenderer.dispose()
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        world.step(delta, 6, 2)
        debugRenderer.render(world, camera.combined)
    }


}