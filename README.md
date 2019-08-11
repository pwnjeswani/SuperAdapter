# SuperAdaper

A Super simple library can be used for inserting elements in between RecyclerView's elements.

# Gradle Dependency


#### Repository

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

#### Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	...
	implementation 'com.github.pwnjeswani:SuperAdaper:0.1'
	}
}
```

---

# Basic Usage

#### Like Button XML

To use this like button in your layout simply copy and paste the xml below. This provides the default heart button. 

```xml
<com.like.LikeButton
            app:icon_type="heart"
            app:icon_size="25dp"
            android:id="@+id/star_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
```


# Inspiration

This library was made by possible based on code and design inspiration from these sources:

https://github.com/frogermcs/LikeAnimation

https://github.com/lightsmeki/android_twitter_heart_animation_button

https://dribbble.com/shots/2416983-Twitter-Heart-Animation



# Contribution


Please fork repository and contribute using pull requests.

Any contributions, large or small, major features, bug fixes, additional language translations, unit/integration tests are welcomed and appreciated but will be thoroughly reviewed and discussed.


# License

    Copyright 2016 pawan jeswani

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
