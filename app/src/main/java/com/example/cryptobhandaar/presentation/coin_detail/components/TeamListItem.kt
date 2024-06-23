package com.example.cryptobhandaar.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.cryptobhandaar.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember:TeamMember,
    modifier: Modifier=Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember. name,
            style = androidx.compose.material.MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = androidx.compose.material.MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}