package com.example.restoapps.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

//size
val nol = 0.dp
val tiny = 4.dp
val sml = 8.dp
val std = 16.dp
val med = 48.dp
val big = 72.dp
val large = 128.dp
val huge = 200.dp

//fraction
const val fSml = 0.24f
const val fStd = 0.32f
const val fBig = 0.48f
const val fHug = 0.72f

val shapes = Shapes(
   extraSmall = RoundedCornerShape(4.dp),
   small = RoundedCornerShape(8.dp),
   medium = RoundedCornerShape(16.dp),
   large = RoundedCornerShape(24.dp),
   extraLarge = RoundedCornerShape(32.dp)
)