# 2017118121_Android
创建HelloWorld程序中所遇到的问题

1、将项目与远程仓库关联,需要进行如下操作：
a、AndroidStudio中配置git，可以setting–>Version Control–>Git中查看是否已配置
![Image text](https://github.com/2017118121lin/2017118121_Android/raw/master/README%E5%9B%BE%E7%89%87/%E5%9B%BE%E7%89%871.png)

b、创建本地仓库，进入VCS,点击Import into Version Control中的CreatGitRepository
![Image text](https://github.com/2017118121lin/2017118121_Android/raw/master/README%E5%9B%BE%E7%89%87/%E5%9B%BE%E7%89%872.png)

c、将项目与远程仓库关联，进入VCS,点击Git中的Remotes，然后将要关联的仓库链接填入

![Image text](https://github.com/2017118121lin/2017118121_Android/raw/master/README%E5%9B%BE%E7%89%87/%E5%9B%BE%E7%89%873.png)
![Image text](https://github.com/2017118121lin/2017118121_Android/raw/master/README%E5%9B%BE%E7%89%87/%E5%9B%BE%E7%89%874.png)

d、然后在sourcestree添加本地仓库即可

![Image text](https://github.com/2017118121lin/2017118121_Android/raw/master/README%E5%9B%BE%E7%89%87/%E5%9B%BE%E7%89%875.PNG)



2、解决导入HelloWorld程序过程中遇到的问题
a、导入的程序存在版本兼容问题，需要将gradle-wrapper.properties中的
distributionUrl=https\://services.gradle.org/distributions/gradle-3.3-all.zip
修改成自己的版本
distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip


b、要将build.gradle的 
dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
}
修改成
dependencies {
        classpath 'com.android.tools.build:gradle:3.5.0'    
}

c、在 repositories中加入  google()
