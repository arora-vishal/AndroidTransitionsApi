package com.effort.transitions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DelayedTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delayed_transition)

        val labelText = TextView(this).apply {
            text = "Label"
            id = R.id.text
        }
        val rootView: ViewGroup = findViewById(R.id.mainLayout)
        val fade: Fade = Fade(Fade.IN)

        findViewById<Button>(R.id.add_label).setOnClickListener {
            TransitionManager.beginDelayedTransition(rootView, Slide(Gravity.END))
            rootView.addView(labelText)
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DelayedTransitionActivity::class.java))
        }
    }
}