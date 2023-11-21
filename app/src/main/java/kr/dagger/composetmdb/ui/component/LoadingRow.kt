package kr.dagger.composetmdb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingRow(modifier: Modifier = Modifier) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.padding(8.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
		verticalAlignment = Alignment.CenterVertically
	) {
		CircularProgressIndicator(modifier = Modifier.size(40.dp), color = Color.White)
	}
}

@Preview
@Composable
fun LoadingRowPreview() {
	LoadingRow()
}