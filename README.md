# 2017118121_Android
����HelloWorld������������������

1������Ŀ��Զ�ֿ̲����,��Ҫ�������²�����
a��AndroidStudio������git������setting�C>Version Control�C>Git�в鿴�Ƿ�������
b���������زֿ⣬����VCS,���Import into Version Control�е�CreatGitRepository
c������Ŀ��Զ�ֿ̲����������VCS,���Git�е�Remotes��Ȼ��Ҫ�����Ĳֿ���������
d��Ȼ����sourcestree��ӱ��زֿ⼴��


2���������HelloWorld�������������������
a������ĳ�����ڰ汾�������⣬��Ҫ��gradle-wrapper.properties�е�
distributionUrl=https\://services.gradle.org/distributions/gradle-3.3-all.zip
�޸ĳ��Լ��İ汾
distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip


b��Ҫ��build.gradle�� 
dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
}
�޸ĳ�
 dependencies {
        classpath 'com.android.tools.build:gradle:3.5.0'    
}

c���� repositories�м���  google()