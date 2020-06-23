package com.effort.transitions.content

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.effort.transitions.R

class SharedElementTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_transition)

        findViewById<Button>(R.id.shared_button).setOnClickListener {
            finishAfterTransition()
        }
    }

    companion object {
        fun start(activity: Activity, sharedElementView: View) {
            activity.startActivity(
                Intent(activity, SharedElementTransitionActivity::class.java),
                ActivityOptions.makeSceneTransitionAnimation(
                    activity,
                    sharedElementView,
                    "shared_button"
                ).toBundle()
            )
        }
    }
}