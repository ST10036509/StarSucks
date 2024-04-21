package za.co.varsitycollege.st10036509.starsucks

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import za.co.varsitycollege.st10036509.starsucks.*
import za.co.varsitycollege.st10036509.starsucks.ui.theme.StarSucksTheme
import za.co.varsitycollege.st10036509.starsucks.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.imgSb1.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Soy Latte",
                Toast.LENGTH_SHORT).show()
        }
        binding.imgSb2.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Chocco Frapp",
                Toast.LENGTH_SHORT).show()
        }
        binding.imgSb3.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Bottled Americano",
                Toast.LENGTH_SHORT).show()
        }
        binding.imgSb4.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Rainbow Frapp",
                Toast.LENGTH_SHORT).show()
        }
        binding.imgSb5.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Caramel Frapp",
                Toast.LENGTH_SHORT).show()
        }
        binding.imgSb6.setOnClickListener() {
            Toast.makeText(this@MainActivity, "MMM Black Forest Frapp",
                Toast.LENGTH_SHORT).show()
        }
    }
}