package com.example.restoapps.ui.component

import android.graphics.Paint
import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow
import kotlin.math.roundToInt

@Composable
fun Graph(
   modifier : Modifier,
   title: String = "Graph Title",
   xValues: List<String>,
   data: List<Float>
) {
   val pathSegment = xValues.size - 2
   val density = LocalDensity.current
   val textPaint = remember(density) {
      Paint().apply {
         color = android.graphics.Color.BLACK
         textAlign = Paint.Align.CENTER
         textSize = density.run { 12.sp.toPx() }
      }
   }

   val controlPoints1 = mutableListOf<PointF>()
   val controlPoints2 = mutableListOf<PointF>()
   val coordinates = mutableListOf<PointF>()

   val xMax = data.maxOf{ it.roundToInt() }
   val powFactor = xMax.toString().length
   val factor = when (xMax.toString().substring(0, 1).toInt()) {
      in 0 until 2 -> 0.5f
      in 2 until 5 -> 1.0f
      in 5 until 8 -> 2.0f
      in 8 until 11 -> 2.5f
      else -> 5f
   }

   Column(
      horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Text(modifier = Modifier.padding(8.dp), text = title)
      Box(
         modifier = modifier.padding(8.dp).background(Color.Transparent),
         contentAlignment = Center
      ) {
         Canvas(
            modifier = Modifier.fillMaxSize(),
         ) {
            val xAxisSpace = (size.width - 4.dp.toPx()) / xValues.size
            val yAxisSpace = size.height / 5

            drawLine(
               color = Color.Black,
               start = Offset( 90f, 0f),
               end = Offset(90f, size.height),
            )
            /** create x axis */
            for (i in xValues.indices) {
               drawContext.canvas.nativeCanvas.drawText(
                  xValues[i], xAxisSpace * ( i + 1 ), size.height - 30, textPaint
               )
            }
            /** create y axis */
            for (i in 0..4) {
               val yValue = (i * factor)
               val text = when((powFactor-1)){
                  in 3..5 -> "${yValue * 10.0.pow(powFactor-4)}K"
                  in 6..8 -> "${yValue * 10.0.pow(powFactor-7)}M"
                  in 9..11 -> "${yValue * 10.0.pow(powFactor-10)}B"
                  in 12..14 -> "${yValue * 10.0.pow(powFactor-13)}T"
                  else -> "$yValue"
               }
               drawContext.canvas.nativeCanvas.drawText(
                  text, 30f, size.height - (yAxisSpace * i) - 60, textPaint
               )
               drawLine(
                  color = Color.Black,
                  start = Offset( 90f, size.height - (yAxisSpace * i) - 70),
                  end = Offset(size.width, size.height - (yAxisSpace * i) - 70),
               )
            }
            /** placing our x axis points */
            for (i in data.indices) {
               val y1 = size.height-(yAxisSpace*data[i]/(factor*10f.pow(powFactor-1)))-70
               val x1 = xAxisSpace * ( i + 1 )
               coordinates.add(PointF(x1,y1))
               /** drawing circles to indicate all the points */
               drawCircle(
                  color = Color.Red,
                  radius = 10f,
                  center = Offset(x1,y1)
               )
            }
            /** calculating the connection points */
            for (i in 1 until coordinates.size) {
               controlPoints1.add(
                  PointF((coordinates[i].x + coordinates[i - 1].x) / 2, coordinates[i - 1].y)
               )
               controlPoints2.add(
                  PointF((coordinates[i].x + coordinates[i - 1].x) / 2, coordinates[i].y)
               )
            }
            /** make path */
            val stroke = Path().apply {
               reset()
               moveTo(coordinates.first().x, coordinates.first().y)
               for (i in 0 .. pathSegment) {
                  cubicTo(
                     controlPoints1[i].x,controlPoints1[i].y,
                     controlPoints2[i].x,controlPoints2[i].y,
                     coordinates[i + 1].x,coordinates[i + 1].y
                  )
               }
            }
            /** make filling area under the path */
            val fillPath = android.graphics.Path(stroke.asAndroidPath())
               .asComposePath()
               .apply {
                  lineTo(xAxisSpace * xValues.count(), size.height - 70)
                  lineTo(xAxisSpace, size.height - 70)
                  close()
               }
            /** draw filling area*/
            drawPath(
               path = fillPath,
               brush = Brush.verticalGradient(
                  colors = listOf(Color.Cyan, Color.Transparent),
                  endY = size.height - 70
               ),
            )
            /** draw path*/
            drawPath(
               path = stroke,
               color = Color.Black,
               style = Stroke(width = 5f, cap = StrokeCap.Round)
            )
            /** drawing points as circle*/
            coordinates.forEach {
               drawCircle(
                  color = Color.Red,
                  radius = 10f,
                  center = Offset(it.x,it.y)
               )
            }
         }
      }
   }
}

@Preview
@Composable
fun PreviewGraph(){
   val xVal = (0..3).map { "x$it" }
   val data = listOf(590500.5f, 995090.0f, 1057000.0f, 405000.5f)
   Scaffold {
      Column(
         modifier = Modifier.padding(it).fillMaxSize()
      ) {
         Box(
            modifier = Modifier.fillMaxSize().background(Color.White)
         ) {
            Graph(
               modifier = Modifier.fillMaxWidth().height(500.dp),
               xValues = xVal,
               data = data,
            )
         }
      }
   }
}