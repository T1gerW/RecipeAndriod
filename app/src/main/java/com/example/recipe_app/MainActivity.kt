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
                // Display the recipe card on a single screen
                RecipeCard()
            }
        }
    }
}

@Composable
fun RecipeCard() {
    // A Card to hold the entire recipe content
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        // Column organizes recipe sections vertically
        Column(
            modifier = Modifier
                .background(Color(0xFFF5F5F5))      // Light background for the card content
                .padding(16.dp)
        ) {
            // Box to center the title
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

            // A divider below the title
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )

            // Display the recipe image
            Image(
                painter = painterResource(id = R.drawable.spaghetti), // Replace with your drawable
                contentDescription = "Recipe image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            // Another divider below the image
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )

            // Ingredients section
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Column(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            ) {
                // Use a Row for each ingredient
                IngredientRow("200g spaghetti")
                IngredientRow("100g minced meat")
                IngredientRow("1 onion, chopped")
                IngredientRow("2 cloves garlic, minced")
                IngredientRow("400g canned tomatoes")
                IngredientRow("Salt and pepper")
            }

            // Divider before instructions
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )

            // Cooking instructions
            Text(
                text = "Instructions",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = """
                1. Cook the spaghetti according to package instructions.
                2. In a pan, sauté onions and garlic until fragrant.
                3. Add the minced meat and cook until browned.
                4. Add canned tomatoes, salt, and pepper.
                5. Let it simmer for 15 minutes.
                6. Serve the sauce over the spaghetti.
                """.trimIndent(),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun IngredientRow(ingredient: String) {
    // A Row to display a bullet and the ingredient text
    Row(modifier = Modifier.padding(bottom = 4.dp)) {
        Text(text = "• ", fontWeight = FontWeight.Bold)
        Text(text = ingredient)
    }
}

// Preview in Android Studio
@Preview(showBackground = true)
@Composable
fun PreviewRecipeCard() {
    Recipe_appTheme {
        RecipeCard()
    }
}
