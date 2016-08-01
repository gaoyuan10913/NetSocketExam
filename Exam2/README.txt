运行步骤：
1.在工程目录下打开命令行
2.使用mvn clean compile编译
3.使用mvn exec:java -Dexec.mainClass="com.hand.Server" -Dexec.args="arg0 arg1 arg2"开启服务器端
4.在工程目录下打开另一个命令行
5.使用mvn exec:java -Dexec.mainClass="com.hand.Client" -Dexec.args="arg0 arg1 arg2"开启客户端
6.在弹窗“用户已连接到12345端口”中点击确定即可
