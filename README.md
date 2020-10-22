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
        implementation 'com.github.lany192:ClearEditText:latest'
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

## attribute 

|Attributes|format|describe
|---|---|---|
|clear_drawable| reference|清除按钮的图标，没设置显示默认的
|clear_size| dimension|清除按钮的大小
|left_drawable| reference|左边图标，默认没有左边图标
|left_size| dimension|左边图标的大小

# Preview
![image](https://github.com/lany192/ClearEditText/raw/master/preview/pic.png)