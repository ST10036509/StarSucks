package za.co.varsitycollege.st10036509.starsucks

import android.os.Bundle
import androidx.activity.ComponentActivity
import za.co.varsitycollege.st10036509.starsucks.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : ComponentActivity() {

    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get the name of the ordered product from the intent
        order.productName = intent.getStringExtra("order").toString()

        //set the product name on the text view
        binding.tvPlaceOrder.text = order.productName

        when(order.productName) {
            "Soy Latte" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb1)
            "Chocco Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb2)
            "Bottled Americano" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb3)
            "Rainbow Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb4)
            "Caramel Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb5)
            "Black Forest Frapp" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb6)
        }

        binding.btOrder.setOnClickListener() {
            shareIntent(applicationContext, order.productName)
        }
    }
}
