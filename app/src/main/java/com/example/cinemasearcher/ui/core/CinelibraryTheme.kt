package com.example.cinemasearcher.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinemasearcher.R

@Composable
fun CLBTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCLBExtraColors provides clbExtraColors,
        LocalCLBExtraTypography provides clbExtraTypography,
    ) {
        MaterialTheme(
            colors = CLBColors,
            typography = CLBTypography,
            shapes = CLBShapes,
            content = content
        )
    }
}

object CLBTheme {
    val colors: CLBExtraColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCLBExtraColors.current

    val typography: CLBExtraTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCLBExtraTypography.current
}

val LocalCLBExtraColors = staticCompositionLocalOf {
    CLBExtraColors()
}

@Immutable
data class CLBExtraColors(
    val Dark: Color = Color.Unspecified,
    val Soft: Color = Color.Unspecified,
    val BlueAccent: Color = Color.Unspecified,
    val Green: Color = Color.Unspecified,
    val Orange: Color = Color.Unspecified,
    val Red: Color = Color.Unspecified,
    val Black: Color = Color.Unspecified,
    val DarkGray: Color = Color.Unspecified,
    val Gray: Color = Color.Unspecified,
    val WhiteGray: Color = Color.Unspecified,
    val Whiter: Color = Color.Unspecified,
    val LineDark: Color = Color.Unspecified,
)

val LocalCLBExtraTypography = staticCompositionLocalOf {
    CLBExtraTypography()
}

@Immutable
data class CLBExtraTypography(
    val buttonSmall: TextStyle = TextStyle.Default,
    val numpad: TextStyle = TextStyle.Default,
)

val CLBColors: Colors
    @Composable
    @ReadOnlyComposable
    get() = clbtLightColors

val clbtLightColors = lightColors(
    primary =           Color(0xFF007CBA),
    onPrimary =         Color.White,
    primaryVariant =    Color(0xFF397ED0),
    background =        Color(0xFFF6F6F6),
    onBackground =      Color.Black,
    surface =           Color.White,
    onSurface =         Color.Black,
    error =             Color(0xFFFF0000),
    onError =           Color.White,
)

val clbExtraColors: CLBExtraColors
    @Composable
    @ReadOnlyComposable
    get() = clbLightExtraColors

val clbLightExtraColors = CLBExtraColors(
    Dark  =                 Color(0xFF1F1D2B),
    Soft =              Color(0xFF252836),
    BlueAccent =             Color(0xFF12CDD9),
    Green =              Color(0xFF22B07D),
    Orange =             Color(0xFFFF8700),
    Red =             Color(0xFFFF7256),
    Black =               Color(0xFF171725),
    DarkGray =             Color(0xFF696974),
    Gray =               Color(0xFF92929D),
    WhiteGray =             Color(0xFFF1F1F5),
    Whiter =               Color(0xFFFFFFFF),
    LineDark = Color(0xFFEAEAEA),
)

val montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold)
)

val baseTextStyle: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = TextStyle(
        color = CLBColors.onSurface,
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal
    )

val CLBTypography: Typography
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.copy(
        h1 = baseTextStyle.copy(
            fontSize = 28.sp, lineHeight = 32.sp, fontWeight = FontWeight.Bold,
        ),
        h2 = baseTextStyle.copy(
            fontSize = 24.sp, lineHeight = 28.sp, fontWeight = FontWeight.Medium
        ),
        h3 = baseTextStyle.copy(
            fontSize = 18.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium,
        ),
        h4 = baseTextStyle.copy(
            fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium, color = Color.White
        ),
        h5 = baseTextStyle.copy(
            fontSize = 14.sp, lineHeight = 18.sp, fontWeight = FontWeight.Medium,
        ),
        body1 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.SemiBold
        ),
        body2 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium, color = Color.White
        ),
        subtitle1 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp
        ),
        subtitle2 = baseTextStyle.copy(
            fontSize = 10.sp, lineHeight = 14.sp, fontWeight = FontWeight.Medium, color = LocalCLBExtraColors.current.Gray
        ),
        button = baseTextStyle.copy(
            fontSize = 16.sp, lineHeight = 21.sp, fontWeight = FontWeight.Medium
        ),
        caption = baseTextStyle.copy(
            fontSize = 13.sp, lineHeight = 16.sp
        )
    )

val clbExtraTypography: CLBExtraTypography
    @Composable
    @ReadOnlyComposable
    get() = CLBExtraTypography(
        buttonSmall = baseTextStyle.copy(
            fontSize = 14.sp, lineHeight = 17.sp, fontWeight = FontWeight.Bold
        ),
        numpad = baseTextStyle.copy(
            fontSize = 38.sp, lineHeight = 46.sp, fontWeight = FontWeight.Medium
        )
    )

val CLBShapes: Shapes
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.copy(
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp),
    )