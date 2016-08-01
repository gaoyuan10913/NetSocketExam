运行步骤：
1.将工程拷贝在系统的某个文件夹下；
2.用命令行切换到工程的根目录下；
3.使用 mvn clean compile编译工程；
4.编译成功后使用mvn exec:java -Dexec.mainClass="com.hand.App" -Dexec.args="arg0 arg1 arg2"。
