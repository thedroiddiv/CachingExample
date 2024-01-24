package com.thedroiddiv.cachingsample.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.thedroiddiv.cachingsample.domain.models.Beer
import com.thedroiddiv.cachingsample.ui.theme.CachingSampleTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(Modifier.weight(3f)) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.description,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.firstBrewed,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}

@Preview
@Composable
fun BeerItemPrev() {
    CachingSampleTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Beer",
                tagline = "Cool beer",
                firstBrewed = "25th Jan 1970",
                description = "With all the rich tropical flavour you'd expect from Australia's Galaxy, this beer backs up a strong citrus aroma and flavour with a mellow undercurrent of passion fruit and mango. Zingy and sweet but not too sweet, Galaxy has a soft and inviting fruity hop character",
                imageUrl = ""
            )
        )
    }
}