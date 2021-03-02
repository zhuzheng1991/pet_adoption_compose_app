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
            DogInfo(
                "Bernie",
                "Bernese Mountain Dog",
                4,
                42.0,
                "AnimalHusbandryAndGuardDogs,CompanionDog",
                "Switzerland",
                "The Bernese Mountain Dog is an excellent and popular breed. It is one of the four existing Swiss mountain dogs. In the early days, the Bernese Mountain Dog was a breed that was gradually developed in the Berne region of Switzerland for sourcing, cheese manufacturing, and weaving shops. Has black, white, and yellow colors and long legs. Features: self-confident, focused, vigilant, brave, loyal to the owner, strong sense of self-preservation and calm in the face of strangers; medium temperament, easy to train. Character: average The grown-up Bernese Mountain Dog is a very gentle, polite, and decent dog breed. Sometimes when the puppy is a puppy, they will be very curious and lively, but they are always not annoying. There are many grown-up Bernese Mountain Dogs that will Become very quiet, will ignore strangers, but will be very excited about people you know, and will often climb on the laps of others. The characteristic of the Bernese Mountain Dog is that it is very gentle to children and other animals, so that He has become a master at caring for children and other animals. They are very sensitive to human nature, so they are also a perfect family dog. Bernese Mountain is loyal to the owner, and will stand firmly in the same place when facing strangers. Calmness is the best working dog. The difference between Bernese Mountain Dogs and other dog breeds is that they have a strong desire to communicate with their owners. Although there are similar dog breeds in other dog breeds, in Bernese Mountain Dog breeds Inside, almost every Bernese Mountain Dog has a strong sense of this aspect. Therefore, the Bernese Mountain Dog is regarded as a dog with a unique style and a high degree of intelligence.",
                R.drawable.bernese_mountain_dog
            ),
            DogInfo(
                "Purple",
                "Pomeranian",
                3,
                2.0,
                "PlayingDog,CompanionDog",
                "Germany",
                "The Pomeranian, also known as the Hadoli Pomeranian (commonly known as the English Pomeranian). It is a kind of German Fox Terrier, native to Germany. It is a compact, short-backed, active toy-like pet dog. It has a soft, Thick undercoat and rough coat. The base of the tail is high, and the thickly decorated tail is placed flat on the back. It has a vigilant character, a clever expression, a brisk manner and a curious nature. Pomeranian's steps Proud, dignified and lively. The temperament and actions are healthy. This dog is a hard-working and enthusiastic dog breed. It is one of the most highly evaluated breeds in the world. The dog is a pointed-mouthed dog breed and its ancestor is Arctic The sled dog, therefore, the dog is closely related to the Dutch Keeshond and the Norwegian Miti. According to the original record of the dog, the dog came from the Pomeranian area at the border of Poland and Germany. At that time, these dogs were used as guards Sheep. In 1750, the Pomeranian spread to European countries, including Italy. When Queen Victoria visited Italy, the people of Florence presented the Queen with a Pomeranian, and this dog was also loved by the Queen. Early Pomeranian The dogs are large and mostly white. Since the 19th century, they have been selected and bred to become small dogs with fluffy and soft coats and bright colors.",
                R.drawable.pomeranian
            ),
            DogInfo(
                "GiantHammer",
                "Dogue de Bordeaux",
                2,
                35.0,
                "WorkDog",
                "France",
                "Alias French Mastiff, Bordeaux Bulldog. There are many theories about its origin. Some people think it is a descendant of ancient Greek and Roman mastiffs, and some people think it is a descendant of a certain Spanish mastiff. Bordeaux is a short, short and chubby mastiff. Dog, a very powerful dog breed. Its huge and heavy head (probably the largest head of all dogs in the world), wide forehead, and wrinkled face are important characteristics for distinguishing this dog breed. The lower jaw is protruding and very powerful. The upper lip hangs on both sides to wrap the lower jaw. The nostrils are open. The length of the muzzle is about one-third of the length of the head, and it is black or red. The skin of the neck is loose, forming obvious throat droplets. The ears are hanging down behind the head. The body is thick and short, the back is flat, and the abdomen is slightly retracted. The front legs are strong and straight, and the hind limbs are very powerful. The tail root is thick and the tail tip is thin. The skin is thick, the fur is short and soft, and the color varies. Brown (red-brown to light yellow), with red or black patches on the face. White patches sometimes appear on the feet and chest, but white in other parts is considered a disadvantage. For a century, the Bordeaux region of France was ruled by the British. The local big hunting dog was crossed with the English mastiff and Spanish dogs to produce this powerful and ferocious mastiff. Recently bred cattle mastiffs are more similar to this ancient breed than the ancient English mastiff. Bordeaux mastiff was originally in France The southern part was used to hunt wild boars and bears, and later to herd cattle. Because of its bravery, the Bordeaux was used to lure animals and fighting dogs. Until 1989, it appeared on American screens with Tom Hanks.. .",
                R.drawable.dogue_de_bordeaux
            ),
            DogInfo(
                "Porter",
                "Boston Terrier",
                4,
                5.0,
                "CompanionDog,Terrier",
                "Boston, USA",
                "The joints of the body are short and wide, with strong limbs and flexible rotation. The tail is short and not very important, so it is slightly protruding, and the proportion is very important. He gives the impression of being bold, powerful, and active. His style shows a high sense of order, and his posture is calm and elegant. The joining method and proportion of \" color and white \" are very distinctive and representative. \"Symmetry, expression, color and markings\" are the first details that need to be considered, which determine the score of {overall appearance}. The Boston Terrier is one of the few dog breeds bred in the UK. This dog is a smart, lively, and brave small breed. Although there is nothing special, it can be an excellent guard or companion dog.",
                R.drawable.boston_terrier
            ),
            DogInfo(
                "Bath",
                "Basset Hound",
                5,
                19.4,
                "CompanionDog,HuntingHound,ScentHound",
                "Britain",
                "Bajdo is docile, smart, intelligent and loyal, and has a keen sense of smell. He is second only to the bloodhound and is the best dog among dogs. Bajido is often compared to the role of a clown because of its appearance and expression. In fact, Bajido Ji Du is a very sensitive, intelligent, and loyal family member. Ba Ji Du has a gentle personality, likes to play with children, and is easy to get along with other paparazzi. Ba Ji Du likes to wander and needs a lot of daily needs. They have their own opinions about the amount of exercise they have. Their IQ is relatively high. Proper training can make them very compliant.",
                R.drawable.basset_hound
            ),
            DogInfo(
                "Kira",
                "Akita",
                2,
                16.4,
                "CompanionDog,HuntingHound,WorkDog",
                "Japanese",
                "Akita Inu, the Japanese Akita Inu (Japanese: Akita Inu/あきたいぬ/アキタイヌ Akita Inu*) is a Japanese national dog. Its ancestor is called a mountain hunting dog. The Akita dog originated in the 17th century and was originally produced in In Japan, large dogs do not exist in Japanese dogs. This is also mentioned on Taogou.com! Akita is a medium-sized bear hound. In addition to assisting bear hunting, it is also used to catch deer and wild boar. During the long period of celebration (around 1630), in order to cultivate the fighting spirit of the feudal clansmen to raise fighting dogs, the hunting dogs were bred with the native dogs of the Akita area. This dog breed became the original breed of the Akita dog. It was officially recognized as a Japanese in 1931. National precious animal, local time on February 8, 2014, at Bocharov Ruchey, the holiday home of the head of state in Sochi, Russia. Putin holding the Akita dog Yume in hand met with Japanese Prime Minister Shinzo Abe",
                R.drawable.akita
            ),
            DogInfo(
                "BiBi",
                "Boxer",
                5,
                26.4,
                "CompanionDog,AnimalHusbandryAndGuardDogs",
                "Germany",
                "The boxer dog, from Germany, has a beautiful and strong appearance. The head and body are very commensurate. The nose is big and black, and the nostrils are large. The ears grow in a higher position, and the tips of the ears are often cut off manually. The eyes are black. The neck is cylindrical and strong and full of muscles. , No sagging skin. The body is square, the tail is short and always held high. The forelegs are upright and parallel. Loyal and not holding grudges. Especially for children, it is affectionate and easy to train. It can be used as a fire alarm, guard dog, personal guard dog, and can also be used for Guide dog. Because of its good obedience, it is also a good companion dog. After long-term scientific breeding, this beloved German dog not only retains its original good quality, but also its appearance has changed. It was exported to Germany. In fact, the origin of the boxer dog is described on Taogou. Although the appearance of the boxer dog is very fierce, but the nature is unexpectedly gentle, and the body is also very slender. This dog stands on its hind feet when fighting a dog. , Stretched his forefoot forward like a boxing, so he was named Boxer Dog",
                R.drawable.boxer
            ),
            DogInfo(
                "Andrew",
                "Bull Terrier",
                3,
                28.2,
                "Terrier,Watchdog,GuardDog",
                "Britain",
                "Bullhead Terrier, height: 48-56 cm, weight: about 18-22 kg, the country of origin, England, originated in the nineteenth century. This dog is divided into two types of standard and mini type due to different body types. People use bulldogs and A fighting dog bred by mating and mixing old English terriers. The Bullhead Terrier has a round and powerful body, a thick chest and neck, a short and straight back, a slightly longer head, no obvious bridge of the nose, a strong snout, and small and pointed ears. Type, with triangular eyes and black or brown eyes. Bull Terriers are relatively docile, smart and obedient, loyal to the owner and obedient, especially kind and friendly to children, kind and patient, and can become loyal if properly taken care of Family guard dog.",
                R.drawable.bull_terrier
            ),
            DogInfo(
                "CC",
                "Chow Chow",
                4,
                22.2,
                "CompanionDog,GuardDog",
                "China",
                "The Chow Chow is an ancient dog breed native to China. It has a history of at least two thousand years. It can also be seen in some unearthed Han Dynasty pottery. It appeared and improved in Britain at the end of the 19th century. This is related to Taogou.com Chow Chow was regarded as the enemy of evil spirits in ancient times, and was always used to guard temples and drag carts. Chow Chow is a working dog and can perform tasks such as hunting, guarding, and towing. Chow Chow is strong and muscular Developed, strong bones, a keen sense of smell, a keen sense of hunting, good at hunting Mongolian chickens, partridges, hunters praised the Chow Chow for fast pace and abundant energy. Chow Chow is beautiful, noble and natural One, with a unique blue tongue, sad expression and unique footwork. The cute appearance of the Chow Chow has been regarded as an ideal household pet, and now it is mainly used as a companion dog",
                R.drawable.chow_chow
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
