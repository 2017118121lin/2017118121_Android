作业目录
========
#第1次作业：HelloWorld

内容：创建一个HelloWorld项目


第2次作业：Activity

内容：做两个helloworld活动，分别是helloworld1和helloworld2要求此两个活动之间能切换


第3次作业：Activity2

内容：创建三个活动，分别使用四个模式，实现堆栈，出栈


第4次作业：Intent

内容：用隐式intent召唤浏览器，地图和拨号


第5次作业：RecyclerViewTest

内容：用RecyclerView做一个增删改的程序


第6次作业：Thread

内容：用多线程编程，做一个在一定秒数自加，自加后可回溯的程序


第7次作业：AsyncTask

内容：利用AsyncTask的异步消息处理机制，实现虚拟下载任务


第8次作业：ServiceBestPractice

内容：创建service，实现完整版的下载服务







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
