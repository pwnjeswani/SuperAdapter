# SuperAdapter
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html) 
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Super%20Adapter-green.svg?style=flat-square)](https://android-arsenal.com/details/1/7858)

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

# Usage

To use this library simply add dependency in your project and follow the steps --

##### STEP 1 -> 

	Create your adapter and extend SuperAdapter like this,(Refer sample module) 
	We have created useradapter which is used 
	for displaying users in RecyclerView.
	
```kotlin

class UserAdapter : SuperAdapter {
    constructor(context: Context){
        createOtherItemList()
    }
    ....
  }
```

##### STEP 2 -> 

	We want to have ad banners (or any other banner) on specfic positions in the useradapter,
	for that we are adding dummyobjects (see class DummyObject) 
	which takes itemViewType and position as parameters in the constructor 
	
```kotlin

override fun createOtherItemList() {
        var dummyObject = DummyObject(1, 1)
	var dummyObject2 = DummyObject(1, 3)
        super.otherViewPositions.add(dummyObject)
	super.otherViewPositions.add(dummyObject2)
    }

```

##### STEP 3 -> 
	After adding the dummy objects, we have to override getItemViewType function 
	
```kotlin

	override fun getItemViewType(position: Int): Int {
        val itemViewType = super.getItemViewType(position)
        return if (itemViewType != -1) {
		//it's dummy object hence returning the actual viewtype 
		//which was mentioned while creating other item list
            itemViewType
        } else {
		//it's item from your list (i.e, useritem) hence returning viewtype 0(User position)
            0
        }
    }
    
```
    
##### STEP 4 -> 
	Here is the createViewHolder and 
	onBindViewHolder function's code for your reference. 
	
```kotlin

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_view, parent, false)
                return UserViewHolder(view)

            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.ad_item_view, parent, false)
                return AdViewHolder(view)
            }
        }
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                val holderr = holder as UserViewHolder
                var user = super.baseList[position] as User
                holderr.tv_user_id.text = user.id.toString()
                holderr.tv_user_name.text = user.name
                holderr.tv_user_phone.text = user.phoneNo.toString()

            }
            1 -> {
	    //write your own logic here
            }
        }
    }
    
```

##### STEP 5 -> Using this adapter in your activity/fragment 
	
```kotlin
var userAdapter = UserAdapter(this)
userAdapter.setUserList(usersList)
var llm = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
rv_useres.layoutManager = llm
rv_useres.adapter = userAdapter
```

# Inspiration

In our company, we had frequent requirement of inserting elements in various lists. 
Earlier we were doing all tasks in the adapter itself, but that was getting frustating & 
also error prone code which requires long hours to fix and this cycle was repeating every week. 
To solve this problem Mr.CTO [Avneesh Kumar](https://www.linkedin.com/in/avneesh-kumar-992a3a46/) 
seeded the idea of creating SuperAdapter.  


[![LinkedIn](https://img.shields.io/badge/say%20Hi%20on%20%F0%9F%91%8B%20-LinkedIn%20%20-blue)](https://www.linkedin.com/in/pawan-jeswani-62784b125/)

# Contribution


Please fork repository and contribute using pull requests.

Any contributions, large or small, major features, bug fixes, 
additional language translations, unit/integration tests are welcomed 
and appreciated but will be thoroughly reviewed and discussed.


# License

   Copyright 2019 pwnjeswani

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
