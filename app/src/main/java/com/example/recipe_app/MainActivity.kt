package com.example.recipe_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipe_app.ui.theme.Recipe_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Recipe_appTheme {
                RecipeCard()
            }
        }
    }
}

@Composable
fun RecipeCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Delicious Spaghetti Bolognese",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Image(
                painter = painterResource(id = R.drawable.spaghetti),
                contentDescription = "Recipe image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            ) {
                IngredientRow("200g spaghetti")
                IngredientRow("100g minced meat")
                IngredientRow("400g canned tomatoes")
                IngredientRow("Salt and pepper")
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            Text(
                text = "Instructions",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = """
                1. Cook the spaghetti according to package instructions.
                2. Cook minced meat
                3. Add canned tomatoes, salt, and pepper.
                4. Cook for 10 minutes
                5. Serve the sauce over the spaghetti.
                """.trimIndent(),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun IngredientRow(ingredient: String) {
    Row(modifier = Modifier.padding(bottom = 4.dp)) {
        Text(text = "• ", fontWeight = FontWeight.Bold)
        Text(text = ingredient)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeCard() {
    Recipe_appTheme {
        RecipeCard()
    }
}
