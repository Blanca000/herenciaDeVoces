package com.example.herenciadevoces.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herenciadevoces.ui.theme.Orange

@Composable
fun Header(title: String) {
    Box( modifier = Modifier
        .height(100.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
        .background(Orange),
        contentAlignment = Alignment.Center
    ){
        //Spacer(modifier = Modifier.width(40.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 30.dp),
            color = Color.White
        )
    }
}