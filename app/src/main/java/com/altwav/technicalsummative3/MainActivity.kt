package com.altwav.technicalsummative3

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var msgTotal = ""
        var totalPrice = 0.0

        var itemText = arrayOf("Shoe 1", "Shoe 2", "Shoe 3", "Shoe 4", "Shoe 5", "Shoe 6", "Shoe 7", "Shoe 8", "Shoe 9", "Shoe 10")
        var itemDescription = arrayOf("White", "Black", "Brown", "Gray", "Red", "Blue", "Yellow", "Pink", "Green", "Cyan")
        var itemPrice = arrayOf(2500.00, 1500.00, 1480.00, 3500.00, 2200.00, 1100.00, 2700.00, 5300.00, 5500.00, 7500.00)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_logout.setOnClickListener {
            finish()
            Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show()
        }

        val tv_listOfItems = findViewById<TextView>(R.id.tv_listOfItems)
        val tv_totalPrice = findViewById<TextView>(R.id.tv_totalPrice)
        tv_addToCart.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)
            val shoesArray = arrayOf(
                "Jordan III - White/Cement (2500.00)",
                "Jordan 1 - Black/Royal (1500.00)",
                "Adidas Hamburg - Brown (1480.00)",
                "Adidas Samba - Ftwr White (3500.00)",
                "Zig Kinetica - Solar Green (2200.00)",
                "Awake Club C 85 - Sandtrap (1100.00)",
                "Digital Terrain Chuck 70 - Yellow (2700.00)",
                "Digi Camo Chuck 70 - Pink (5300.00)",
                "Nike Air Zoom Alphafly - Green (5500.00)",
                "Nike Air Max 90 NS SE - Cyan (7500.00)")
            val checkedShoesArray = booleanArrayOf(
                false, // 1
                false, // 2
                false, // 3
                false, // 4
                false, // 5
                false, // 6
                false, // 7
                false, // 8
                false, // 9
                false  //10
            )
            val shoesList = Arrays.asList(*shoesArray)
            builder.setTitle("Select Shoes")
            builder.setMultiChoiceItems(shoesArray, checkedShoesArray) { dialog, which, isChecked ->
                checkedShoesArray[which] = isChecked
                val currentItem = shoesList[which]
            }
            builder.setPositiveButton("OK") { dialog, which ->
                tv_listOfItems.text = "\n"
                for (i in checkedShoesArray.indices) {
                    val checked = checkedShoesArray[i]
                    if (checked) {
                        totalPrice += itemPrice[i]
                        msgTotal = msgTotal + tv_listOfItems.text.toString() + shoesList[i] + "\n"
                    }
                }
                tv_listOfItems.text = msgTotal
                tv_totalPrice.text = "₱${totalPrice.toString()}"
            }
            builder.setNeutralButton("Cancel") { dialog, which ->
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}