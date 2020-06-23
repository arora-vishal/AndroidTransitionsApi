package com.effort.transitions

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.effort.transitions.content.SharedElementTransitionActivity
import com.effort.transitions.content.TransitionStartActivity
import com.effort.transitions.scene.SceneTransitionActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_scene_transition).setOnClickListener {
            SceneTransitionActivity.start(this)
        }

        findViewById<Button>(R.id.btn_delayed_transition).setOnClickListener {
            DelayedTransitionActivity.start(this)
        }

        findViewById<Button>(R.id.start_activity_with_transition).setOnClickListener {
            TransitionStartActivity.start(this)
        }

        findViewById<Button>(R.id.shared_element_transition).setOnClickListener {
            SharedElementTransitionActivity.start(this, it)
        }
    }
}