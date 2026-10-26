package edu.iau.cshj.csc402.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingCard()
                }
            }
        }
    }
}

@Composable
fun GreetingCard(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }

    val navy = Color(0xFF0B2545)
    val androidGreen = Color(0xFF3DDC84)
    val screenBackground = Color(0xFFF4F7FA)
    val cardWhite = Color(0xFFFFFFFF)
    val textGrey = Color(0xFF6B7A8F)
    val dividerColor = Color(0xFFDDE3EC)
    val chipGreenBg = Color(0xFFDDF6E8)
    val chipGreenFg = Color(0xFF1E9E5A)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(screenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(navy)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(text = "CSC 402 Lab 2", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Task 9 - Greeting Card", color = Color(0xFFB8C4D6), fontSize = 12.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(androidGreen)
        )

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Your name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = cardWhite,
                    unfocusedContainerColor = cardWhite,
                    focusedTextColor = navy,
                    unfocusedTextColor = navy,
                    focusedBorderColor = androidGreen,
                    unfocusedBorderColor = dividerColor,
                    focusedLabelColor = chipGreenFg,
                    unfocusedLabelColor = textGrey,
                    cursorColor = navy
                )
            )

            Button(
                onClick = { submittedName = name.trim() },
                enabled = name.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidGreen,
                    contentColor = navy,
                    disabledContainerColor = chipGreenBg.copy(alpha = 0.5f),
                    disabledContentColor = navy.copy(alpha = 0.35f)
                )
            ) {
                Text("Show greeting", fontWeight = FontWeight.Bold)
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (submittedName.isEmpty()) {
                        Text(
                            text = "Type your name above\nto see the greeting.",
                            color = textGrey,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center
                        )
                    } else {
                        Text(
                            text = "Marhaba, $submittedName!",
                            color = navy,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Your name has ${submittedName.count { it.isLetter() }} letters.",
                            color = textGrey,
                            fontSize = 14.sp
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(chipGreenBg)
                                .padding(horizontal = 12.dp, vertical = 5.dp)
                        ) {
                            Text(
                                text = "CSC 402 - Lab 2",
                                color = chipGreenFg,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}