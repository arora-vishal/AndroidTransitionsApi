package com.effort.transitions.scene

import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.effort.transitions.R

class SceneTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_transition)

        val sceneRoot: ViewGroup = findViewById(R.id.scene_root)
        val aScene: Scene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, this)
        val bScene: Scene = Scene.getSceneForLayout(sceneRoot, R.layout.b_scene, this)

        val fadeTransition: Transition =
            TransitionInflater.from(this)
                .inflateTransition(R.transition.fade_transition)

        var currentScene = aScene
        val buttonTransition = findViewById<Button>(R.id.btn_transition)
        buttonTransition.setOnClickListener {
            val nextScene = if (currentScene == aScene) bScene else aScene
            TransitionManager.go(nextScene, ChangeBounds())
            currentScene = nextScene
        }
    }
}