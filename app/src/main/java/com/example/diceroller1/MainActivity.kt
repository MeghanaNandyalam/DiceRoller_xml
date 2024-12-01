package com.example.diceroller1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView /*lateinit promises kotlin compiler
    that the variable will be initialized before calling any operations on it.
    will not be left as null*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"
        rollButton.setOnClickListener {
            //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image) //setting it up to a value
    }

    private fun rollDice() {
        val randomInt = java.util.Random().nextInt(6) + 1 //generating a random number
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //val diceImage: ImageView = findViewById(R.id.dice_image) - not doing this because everytime the findViewById method searches the whole hierarchy and this is costly operation.
        diceImage.setImageResource(drawableResource)
    }
}
