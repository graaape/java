
# 笔记 Day 4
## Java 零基础 p31~40
### 包机制
1. 包机制语法格式为
	  ```java
	  package pkg1[.pkg2[.pkg3...]];
2. 一般用公司域名倒置做包名。
3. 为了使用某个包的成员，使用“import”语句可以导入包。
	```java
	import package1[.package2...].(classname|*);
4. 可以将包视作文件夹。
### Java Doc
1. JavaDoc用于生成自己的API文档。
2. 参数信息
	@author 作者名
	@version 版本号
	@since 指明最早使用的jdk版本
	@param 参数名
	@return 返回值情况
	@throws 异常抛出情况
### Scanner 对象
1. 在java.util中
2. 基本语法
	```java
	Scanner s=new Scanner(System.in);
3. 通过Scanner类的next()和nextLine()方法获取
- #### next()
	1. 一定要读取到有效字符后才可以结束输入。
	2. 对输入有效字符之前遇到的空白，会被自动去掉。
	3. 只有输入有效字符后才将其后面输入的空白作为分隔符或结束符。
	4. 无法得到带有空格的字符串。
			
- #### nextLine() 
	1. 以Enter为结束符，返回的是输入回车前的所有字符。
	2. 可以得到以空格分隔的字符串。
### for循环
1. 最先执行初始化步骤，可以声明一种类型，但可以初始化一个或多个循环控制变量，也可以是空语句。  
2. 检查布尔表达式的值，如果为false则结束循环。  
3. 执行一次循环后，更新循环控制变量。
 4. 快捷使用语句，例如
	```java
	100.for
