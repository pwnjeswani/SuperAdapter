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
