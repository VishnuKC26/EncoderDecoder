package com.example.encoderdecoder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EncoderDecoderApp() {
    var inputEncode by remember { mutableStateOf("") }
    var encodedResult by remember { mutableStateOf("") }
    var inputDecode by remember { mutableStateOf("") }
    var decodedResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "Encoder/Decoder App",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 60.dp, bottom = 16.dp)
        )

        // Encoder Section
        OutlinedTextField(
            value = inputEncode,
            onValueChange = { inputEncode = it },
            label = { Text("Enter a String to Encode") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { encodedResult = encode(inputEncode) }) {
            Text("Encode")
        }

        if (encodedResult.isNotEmpty()) {
            SelectionContainer {
                Text(
                    text = "Encoded: $encodedResult",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Decoder Section
        OutlinedTextField(
            value = inputDecode,
            onValueChange = { inputDecode = it },
            label = { Text("Enter a String to Decode") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { decodedResult = decode(inputDecode) }) {
            Text("Decode")
        }

        if (decodedResult.isNotEmpty()) {
            SelectionContainer {
                Text(
                    text = "Decoded: $decodedResult",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(Modifier.height(5.dp))

        Button(onClick = {
            inputEncode = ""
            encodedResult = ""
            inputDecode = ""
            decodedResult = ""
        }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            elevation = ButtonDefaults.elevatedButtonElevation(10.dp),
            modifier = Modifier.fillMaxWidth()) {
            Text("Clear All")
        }
    }
}

// Encode function
fun encode(input: String): String {
    return input.map { char -> (char.code + 2).toChar() }.joinToString("")
}

// Decode function
fun decode(input: String): String {
    return input.map { char -> (char.code - 2).toChar() }.joinToString("")
}
