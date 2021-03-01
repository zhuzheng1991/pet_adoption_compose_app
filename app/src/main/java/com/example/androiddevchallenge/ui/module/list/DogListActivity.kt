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
package com.example.androiddevchallenge.ui.module.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.DogInfo
import com.example.androiddevchallenge.ui.module.detail.DogDetailActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class DogListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dogListData = generateDogListData()
        setContent {
            DogList(dogListData) { info ->
                val intent = Intent(this, DogDetailActivity::class.java)
                    .apply {
                        putExtra("Dog", info)
                    }
                startActivity(intent)
            }
        }
    }

    private fun generateDogListData(): List<DogInfo> {
        return listOf(
            DogInfo(
                "Tony",
                "IrishWolfhound",
                3,
                30.0,
                "CompanionDog",
                "Ireland",
                "The Irish Wolfhound is a large, hairy and coarse-haired hunting dog. Because the hound is huge, its owner needs to have a large enough courtyard for the dog to shelter, so as to satisfy this kind of active nature. The hunting dog has its hunting nature. During the hunting exercise, the Irish Wolfhound gradually acquired the sharp eyesight, tall limbs, strong physique and explosive power of a hunter. Deep chest can provide it with a lot of breathing room, thereby enhancing its endurance",
                R.drawable.irish_wolf_hound
            ),
            DogInfo(
                "Edward",
                "Dandie Dinmont Terrier",
                5,
                8.0,
                "CompanionDog",
                "Britain",
                "His name is derived from the name of the dog breeder in the novel written by the Walter Envoy. This dog attracts people's attention with its unique appearance and approachable temperament. The short-legged terrier is native to Scotland and is an excellent hunting dog specializing in hunting mice, cave bears, otters, rabbits and other small cave animals. The dog has a large head, long body, short feet, a fluffy coat, and a crown of decorative fur on the top of the head. The face seems to always maintain a melancholy and angry expression, which makes people laugh. Friendly and active, he is an excellent family guard dog. This dog barks loudly. When exhibiting, attention is focused on the dense crest hairs, so it must be trimmed regularly and carefully. The head cover is wide and large, the jaw is strong and well developed, and the nose is black.",
                R.drawable.dandie_dinmont_terrier
            ),
            DogInfo(
                "Shirley",
                "Irish Setter",
                4,
                22.0,
                "GunHound,WorkDog,CompanionDog",
                "Ireland",
                "Irish Setters are long and streamlined with their unique shiny coat. Irish Setter with fringed tail horizontal",
                R.drawable.irish_setter
            ),
            DogInfo(
                "Watermelon",
                "Alaskan Malamute",
                6,
                44.0,
                "AnimalHusbandryAndGuardDogs,WorkDog,SledDog",
                "UnitedStates",
                "The Alaskan Malamute is one of the oldest sled dogs. This dog is different from other dog breeds in Alaska. It has strong limbs and is bred for endurance rather than speed, so their main purpose is to pull sleds. The Alaskan Malamute is sometimes mistaken for the Siberian Husky. This is due to the similar colors and stripes of the two, but in fact the two are completely different in size, structure, and characteristics. As pets, Alaskan Malamutes have a very quiet and elegant temperament once they mature, and they are loyal to their owners. Its name comes from the Eskimo Inuit tribe called Malamute, which lives on the shore of Kotzebue in western Alaska in North America. Before the Europeans arrived, the Russians who first discovered this place were blown to this land in northern Siberia by a storm while sailing in the Bering Strait. After the sailors returned to Russia, they told the other Russians what they were impressed here, which of course included the characteristic of this place-the Alaskan Malamute",
                R.drawable.alaskan_malamute
            ),
            DogInfo(
                "Billy",
                "Afghan Hound",
                2,
                18.0,
                "BaluchHound",
                "Afghan",
                "The Afghan Hound is a type of hunting dog and the oldest dog breed. The Afghan Hound is thick, delicate, and silky in appearance, with its tail curled in the last ring. The Afghan hound lives in Iran, in the cold mountains of eastern Afghanistan. The Afghan hound was originally used to hunt hares and gazelles. Other names for the Afghan Hound include Balkhtarzi Kutch Hound, Hound, Baluch Hound, Kabul Hound, or African Hound",
                R.drawable.afghan_hound
            ),
        )
    }
}

@Composable
fun DogListItem(info: DogInfo, onClick: ((info: DogInfo) -> Unit)? = null) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(all = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = { onClick?.invoke(info) }),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start)
        ) {
            Card(elevation = 0.dp, shape = MaterialTheme.shapes.medium.copy(CornerSize(4.dp))) {
                Image(
                    painter = painterResource(id = info.imageRes),
                    modifier = Modifier
//                    .aspectRatio(1F, true)
                        .requiredSizeIn(maxHeight = 120.dp),
                    contentDescription = info.species
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    6.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                Text(info.nickName, style = typography.h6)
                Text(info.species)
                Text("${info.age} years old")
            }
        }
    }
}

@Composable
fun DogList(dogList: List<DogInfo>, onClick: ((info: DogInfo) -> Unit)? = null) {
    MyTheme {
        LazyColumn {
            items(dogList) { message ->
                DogListItem(message, onClick)
            }
        }
    }
}

@Preview(device = Devices.NEXUS_5)
@Composable
fun PreviewDogListItem() {
    val dogInfo = DogInfo(
        "Tony",
        "IrishWolfhound",
        3,
        30.0,
        "CompanionDog",
        "Ireland",
        "The Irish Wolfhound is a large, hairy and coarse-haired hunting dog. Because the hound is huge, its owner needs to have a large enough courtyard for the dog to shelter, so as to satisfy this kind of active nature. The hunting dog has its hunting nature. During the hunting exercise, the Irish Wolfhound gradually acquired the sharp eyesight, tall limbs, strong physique and explosive power of a hunter. Deep chest can provide it with a lot of breathing room, thereby enhancing its endurance",
        R.drawable.irish_wolf_hound
    )
    Surface(color = MaterialTheme.colors.background) {
        DogListItem(info = dogInfo)
    }
}
