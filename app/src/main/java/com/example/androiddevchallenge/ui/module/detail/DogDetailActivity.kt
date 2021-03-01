/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.module.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.DogInfo
import com.example.androiddevchallenge.ui.theme.MyTheme

class DogDetailActivity : AppCompatActivity() {

    private val DogInfo by lazy {
        checkNotNull(intent.getParcelableExtra<DogInfo>("Dog"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DogDetail(info = DogInfo) }
    }
}

@Composable
fun DogDetail(info: DogInfo) {
    MyTheme {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.Top),
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            item {
                Card(
                    elevation = 8.dp,
                    shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp))
                ) {
                    Image(
                        painter = painterResource(id = info.imageRes),
                        modifier = Modifier.fillMaxWidth(),
                        contentDescription = info.species,
                        contentScale = ContentScale.FillWidth
                    )
                }
            }

            item { BuildItemRow("species", info.species) }
            item { BuildItemRow("age", "${info.age} years old") }
            item { BuildItemRow("weight", "${info.weight}kg") }
            item { BuildItemRow("feature", info.feature) }
            item { BuildItemRow("location", info.location) }
            item { BuildItemRow("description", info.description) }
        }
    }
}

@Composable
fun BuildItemRow(title: String, content: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("$title:")
            }
            append(content)
        }
    )
}
