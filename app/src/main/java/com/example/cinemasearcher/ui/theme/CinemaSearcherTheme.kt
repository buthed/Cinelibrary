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
fun CSTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCSExtraColors provides csExtraColors,
        LocalCSExtraTypography provides csExtraTypography,
    ) {
        MaterialTheme(
            colors = CSColors,
            typography = CSTypography,
            shapes = CSShapes,
            content = content
        )
    }
}

object CSTheme {
    val colors: CSExtraColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCSExtraColors.current

    val typography: CSExtraTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCSExtraTypography.current
}

val LocalCSExtraColors = staticCompositionLocalOf {
    CSExtraColors()
}

@Immutable
data class CSExtraColors(
    val Dark: Color = Color.Unspecified,
    val Soft: Color = Color.Unspecified,
    val BlueAccent: Color = Color.Unspecified,
    val Green: Color = Color.Unspecified,
    val Orange: Color = Color.Unspecified,
    val Red: Color = Color.Unspecified,
    val Black: Color = Color.Unspecified,
    val DarkGrey: Color = Color.Unspecified,
    val Grey: Color = Color.Unspecified,
    val WhiteGrey: Color = Color.Unspecified,
    val Whiter: Color = Color.Unspecified,
    val LineDark: Color = Color.Unspecified,
)

val LocalCSExtraTypography = staticCompositionLocalOf {
    CSExtraTypography()
}

@Immutable
data class CSExtraTypography(
    val buttonSmall: TextStyle = TextStyle.Default,
    val numpad: TextStyle = TextStyle.Default,
)

val CSColors: Colors
    @Composable
    @ReadOnlyComposable
    get() = cstLightColors

val cstLightColors = lightColors(
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

val csExtraColors: CSExtraColors
    @Composable
    @ReadOnlyComposable
    get() = csLightExtraColors

val csLightExtraColors = CSExtraColors(
    Dark  =                 Color(0xFF34C759),
    Soft =              Color(0xFFF7F8FA),
    BlueAccent =             Color(0xFFD6D6D6),
    Green =              Color(0xFFA6A6AE),
    Orange =             Color(0xFFDDDDDF),
    Red =             Color(0xFFDDDDDF),
    Black =               Color(0x14212114),
    DarkGrey =             Color(0xFFDDDDDF),
    Grey =               Color(0x14212114),
    WhiteGrey =             Color(0xFFDDDDDF),
    Whiter =               Color(0x14212114),
    LineDark = Color(0x14212114),
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
        color = CSColors.onSurface,
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal
    )

val CSTypography: Typography
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.copy(
        h1 = baseTextStyle.copy(
            fontSize = 28.sp, lineHeight = 32.sp, fontWeight = FontWeight.Bold
        ),
        h2 = baseTextStyle.copy(
            fontSize = 24.sp, lineHeight = 28.sp, fontWeight = FontWeight.Medium
        ),
        h3 = baseTextStyle.copy(
            fontSize = 18.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium,
        ),
        h4 = baseTextStyle.copy(
            fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium,
        ),
        h5 = baseTextStyle.copy(
            fontSize = 14.sp, lineHeight = 18.sp, fontWeight = FontWeight.Medium,
        ),
        body1 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.SemiBold
        ),
        body2 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium
        ),
        subtitle1 = baseTextStyle.copy(
            fontSize = 12.sp, lineHeight = 16.sp
        ),
        subtitle2 = baseTextStyle.copy(
            fontSize = 10.sp, lineHeight = 14.sp, fontWeight = FontWeight.Medium
        ),
        button = baseTextStyle.copy(
            fontSize = 16.sp, lineHeight = 21.sp, fontWeight = FontWeight.Medium
        ),
        caption = baseTextStyle.copy(
            fontSize = 13.sp, lineHeight = 16.sp
        )
    )

val csExtraTypography: CSExtraTypography
    @Composable
    @ReadOnlyComposable
    get() = CSExtraTypography(
        buttonSmall = baseTextStyle.copy(
            fontSize = 14.sp, lineHeight = 17.sp, fontWeight = FontWeight.Bold
        ),
        numpad = baseTextStyle.copy(
            fontSize = 38.sp, lineHeight = 46.sp, fontWeight = FontWeight.Medium
        )
    )

val CSShapes: Shapes
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.copy(
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp),
    )