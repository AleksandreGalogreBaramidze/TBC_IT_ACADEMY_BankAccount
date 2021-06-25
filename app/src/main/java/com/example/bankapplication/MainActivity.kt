package com.example.bankapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.bankapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var checkPassword = false
    private var numbers = ""
    private var numbersChecker = ""

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
    private fun checkers(){
        when(numbers.length){
            1 -> binding.indicator1.setImageResource(R.drawable.circle)
            2 -> binding.indicator2.setImageResource(R.drawable.circle)
            3 -> binding.indicator3.setImageResource(R.drawable.circle)
            4 -> {binding.indicator4.setImageResource(R.drawable.circle)
                checkPassword= true
                Toast.makeText(this, "შეიყვანეთ იგივე პაროლი", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun onClick(view: View){
        if(!checkPassword){
            val number = (view as Button).text.toString()
            numbers += number
            Toast.makeText(this, number, Toast.LENGTH_SHORT).show()
        }else{
            val number = (view as Button).text.toString()
            numbersChecker += number
            if(numbersChecker.length == 4){
                if(numbersChecker == numbers){
                    Toast.makeText(this, "თქვენ პაროლი შეიყვანეთ სწორედ", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "თქვენ პაროლი შეგეშალათ", Toast.LENGTH_SHORT).show()
                    setIndicatorBackgrounds(R.drawable.red_circle)
                }
            }
        }
        checkers()
    }
    fun onClear(view: View){
        numbers = ""
        numbersChecker = ""
        Toast.makeText(this, "წაიშალა ციფრები", Toast.LENGTH_SHORT).show()
        setIndicatorBackgrounds(R.drawable.grey_circle)
        checkPassword= false
    }

    fun setIndicatorBackgrounds(int: Int){
        binding.indicator1.setImageResource(int)
        binding.indicator2.setImageResource(int)
        binding.indicator3.setImageResource(int)
        binding.indicator4.setImageResource(int)
        checkPassword= false
    }
}