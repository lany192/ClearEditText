# ClearEditText
[![](https://jitpack.io/v/lany192/ClearEditText.svg)](https://jitpack.io/#lany192/ClearEditText)
## Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    
## Step 2. Add the dependency

    dependencies {
        compile 'com.github.lany192:ClearEditText:1.0.3'
    }

## Step 3. Use in layout

    <com.github.lany192.edittext.ClearEditText
        android:id="@+id/edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp"
        app:clear_drawable="@drawable/delete_red"
        app:clear_size="20dp"
        app:left_drawable="@mipmap/ic_launcher"
        app:left_size="20dp" />
