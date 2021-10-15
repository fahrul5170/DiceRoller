package id.fahrulrazi.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
         rollDice()
        }
    }

    /**
     * Gulung dadu dan perbarui layar dengan hasilnya.
     */

    private fun rollDice() {
        // Buat objek Dadu baru dengan 6 sisi dan lempar dadu
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Temukan ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Temukan ImageView di layout
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Perbarui ImageView dengan ID sumber daya yang dapat digambar dengan benar
        diceImage.setImageResource(drawableResource)

        // Perbarui deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
