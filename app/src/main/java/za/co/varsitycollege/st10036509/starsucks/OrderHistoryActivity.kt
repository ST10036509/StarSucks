package za.co.varsitycollege.st10036509.starsucks

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import za.co.varsitycollege.st10036509.starsucks.databinding.ActivityMainWithNavDrawerBinding
import za.co.varsitycollege.st10036509.starsucks.databinding.ActivityOrderHistoryBinding
import za.co.varsitycollege.st10036509.starsucks.ui.theme.StarSucksTheme

class OrderHistoryActivity : AppCompatActivity() {
    val database = Firebase.firestore

    private lateinit var binding: ActivityOrderHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //read from the database
        database.collection("orders")
            .orderBy("orderDate", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->

                var list = mutableListOf<Order>()

                //iterate over the children in the list
                for (document in result) {
                    Log.d("Order History", "${document.id} => ${document.data}")
                    list.add(document.toObject<Order>())
                }

                //create the adapter to display the items
                var orderAdapter = ArrayAdapter(this@OrderHistoryActivity,
                    android.R.layout.simple_list_item_1, list)
                binding.lstvOrderHistory.adapter = orderAdapter
            }
            .addOnFailureListener { exception ->
                Log.w("Order History", "Error getting documents.", exception)
            }
    }
}
