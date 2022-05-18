* 效果长这样：

<img src="https://yaoblog.obs.cn-east-3.myhuaweicloud.com/code_demo.gif" width="45%"/>
<img src="https://yaoblog.obs.cn-east-3.myhuaweicloud.com/code_demo2.gif" width="45%"/>

#### 一、直接使用

【注】方式1、2任选一即可

##### 方式1：引入gjylibrary在线依赖（无需关心代码逻辑

1.添加jitpack作为仓库
>如果你的gradle <7.0，直接在项目根目录build.gradle中添加：
```
    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
```
>如果gradle >=7.0，需要在settings.gradle中添加，不要build.gradle中加，否则报错
```
    maven { url 'https://www.jitpack.io' }
```
2.implement我的gjyedittext（在app的build.gradle里），以下两个二选一即可，分别是GitHub和gitee的library __(注意这是2.0版本，3.0更新了只支持纯数字输入，因为有的人反映输入法在字母和数字之间来回横跳体验不好，所以更新了3.0版本)__
```
    dependencies {
        implementation 'com.github.gjygit:editext:2.0' //3.0只支持纯数字，根据需要选择
    }

    dependencies {
        implementation 'com.gitee.gongjingyao:gjyedittext:2.0' //3.0只支持纯数字，根据需要选择
    }
```
<!-- more -->
3.使用

1.xml布局文件中:（code_number代表框格数量，自己调整，大于8时自动两行显示，最大不要超过20）
```
    <com.example.gjylibrary.GjySerialnumberLayout
        android:id="@+id/verification_code"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="83dp"
        android:layout_marginRight="20dp"
        app:code_number="8" />
```
2.java代码中实现监听输入的返回值
```
    GjySerialnumberLayout verificationCode=findViewById(R.id.verification_code);
    verificationCode.setOnInputListener(new GjySerialnumberLayout.OnInputListener() {
        @Override
        public void onSucess(String code) {
                System.out.println("内容是:"+code);
        }
    });
```
    
##### 方式2：引入gjylibrary本地aar包依赖（无需关心代码逻辑
1.1.下载[gjylibrary.aar](https://yaoblog.obs.cn-east-3.myhuaweicloud.com/gjylibrary.aar)（支持字母数字混合输入）
1.2.下载[gjylibrarynumber.aar](https://yaoblog.obs.cn-east-3.myhuaweicloud.com:443/gjylibrarynumber.aar)（只支持数字输入、二者根据需要选一即可）

2.将其粘贴到项目的libs下

3.app的build.gradle中直接引入
```
    implementation files('libs\\gjylibrary.aar')
```
* （众所周知，jar包只包含class文件，而aar可以包括布局xml等，因此aar引入方式和引入本地jar包相同）
