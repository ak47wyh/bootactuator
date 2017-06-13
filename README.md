spring ingegration提供了基于spring的EIP(Enterprise Intergration Patterns)企业集成模式的实现
，主要解决系统间的交互问题，通过异步消息驱动达到系统交互时系统间松耦合。

spring热部署
spring.thymeleaf.cache=false
spring.freemarker.cache=false
spring.groovy.template.cache=false
spring.velocity.cache=false
关闭模板引擎，实现页面热部署

2.spring loaded实现热部署
下载后在vm arguments中配置
-javagent:springloaded-1.2.RELEASE.jar -noverify

3.JRebel插件安装实现热部署

4.spring-boot-devtools依赖实现热部署


运行
java -jar XX.jar

注册为linux服务
1.修改pom文件重新打包
<bulid>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
        <executable>true</executable>
      </configuration>
    </plugin>
  </plugins>
</bulid>

2.安装jdk
rpm -ivh jdk-8u51-linux-x64.rpm
3.注册服务基于init.d部署
sudo ln -s /var/apps/xx.jar /etc/init.d/ch01
4.启动停止服务
service ch01 start
service ch01 stop
开机启动
chkconfig ch01 on 




spring监控

1.actuator查看所有端点

2.shutdown端点默认是关闭的，在application.properties中开启
endpoints.shutdown.enabled=true

3.
定制端点
endpoints.beans.id=mybeans
开启端点
endpoints.shutdown.enabled=true
关闭端点
endpoints.beans.enabled=false
4.
开启指定端点，先关闭所有端点，然后开启指定端点
endpoints.enabled=false
endpoints.beans.enabled=true
5.
定制端点访问路径
management.context-path=/manage
6.
定制端点访问端口
management.port=9091
7.
关闭http端点
management.port=-1



