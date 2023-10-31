package com.minphone.assignment2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.minphone.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


      private val foodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            binding.btnAddFood.setOnClickListener {
                  if (binding.etAddFood.text.isEmpty()) {
                        Toast.makeText(this, "Please enter a food", Toast.LENGTH_SHORT).show()
                  }
                  val newFood = binding.etAddFood.text.toString()
                  foodList.add(newFood)
                  binding.etAddFood.text.clear()
                  println(foodList)
                  Toast.makeText(this, "Added $newFood", Toast.LENGTH_SHORT).show()
            }
            binding.btnDecide.setOnClickListener {
                  val random = java.util.Random()
                  val randomFood = random.nextInt(foodList.count())
                  binding.tvDinner.text = foodList[randomFood]
            }
            setContentView(view)

      }
}