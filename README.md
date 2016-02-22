#第十一届齐鲁大学生软件设计大赛命题
分布式网络资源检索 

##一.题目背景
目前，网络上存在大量的资源共享服务器。这些服务器存储了一定量的资源，并以web服务的方式供用户和其它服务器访问。现存的问题是不同服务器的资源组织方式往往不同，有的是通过数据库，有的是通过一些描述文件（如XML），而且数据库的种类和结构也有很大的差别，这就导致不同服务器之间资源共享和资源发现都十分困难。因此，用户如果想访问这些资源，就要登陆每一个服务器去检索和下载需要的资源。由于服务器的分布广泛，数量众多，用户显然难以检索到自己需要的资源。而分布式的资源检索策略则可以有效的解决这一问题。该策略的思想是当用户登陆任何一台服务器的时候，这个服务器除了要检索自己本地的资源以外，还可以作为一个客户端，自动地去连接其它服务器，发出检索请求，并将检索的结果进行合并和汇总，返回给用户。这样，用户只需要登陆任意一台服务器，就可以检索到大量所需资源，尽管这些资源来自于不同的服务器，但检索的过程对用户来说是透明的，用户检索和获取这些资源就如同检索和获取所请求的服务器上的资源一样。
再进一步，目前移动设备已经成为了信息传递的主要手段之一。尤其是近年来手机技术的不断完善和功能的增加，利用手机上网也以成为一种获取信息资源的主流方式，移动和互联网融合的发展趋势注定了移动搜索是未来的发展方向，从而实现终端移动设备的资源检索成了本命题的一大亮点，即移动检索。移动搜索是指以移动设备为终端，进行对服务器资源的搜索，从而实现高速、准确的获取信息资源。
在此命题的开发中，用到web开发技术、信息服务器技术、移动客户端开发技术，如java、c#、xml、android、objective-c等，这都是目前流行的IT开发技术。通过该命题，选手在此开发过程中可了解和掌握这些技术，从而自身得到全面的提高。

##二.功能与设计要求
在网络环境下（也可以是一个局域网），每一台机器是一个Web服务器，并且在服务器上按照一定方式保存了大量资源，这些资源的信息保存在一个test.xml文档中，存放在服务器根目录下。要求参赛者：
###（一）基本功能
1．设计一种资源检索系统，用户只需要登陆任意一台服务器，就可以检索到该xml所描述的所有资源，并以友好方式呈现,另外需要提供查询花费的时间。
2．对于其中特定格式的资源，如动画、视频等能够直接播放。
3．对于word或PPT文档，能够预览其中的部分内容。

###（二）扩展功能
     通过无线路由器构建局域网，设计移动客户端或构建WAP网站，利用移动设备（手机、平板电脑）完成资源检索。
另外，选手可充分发挥自身的想象力，在如下方面拓展功能：
1）语义检索，语义检索可以作为一个拓展的方面，以返回该资源域内最符合用户需要的资源。
2）分词技术，可以对用户提交的字符串进行分词处理，以检索到合适的资源。
3）网络拓扑，对于一个资源域，我们可以假定有一个注册发布的主服务器，其他资源服务器都是通过这个服务器获得其他资源服务器的信息，通过这个服务器可以构造不同的分布式检索拓扑结构，好的网络拓扑结构可以提高检索的效率。
4）资源服务器动态的加入和退出，资源服务器可能会动态得开启或关闭服务器，一旦服务器关闭，如何在检索时自动去掉这个服务器，当这个服务器开启时，在检索中自动的加入这个服务器。
5）全文检索，通过对资源文件进行预处理（如果建立索引），支持多关键字的全文检索功能。

##三． test.xml文档的格式
<?xml version="1.0" encoding="UTF-8"?>
<allresource>
        <resourceitem> 
                <title>07各地高考作文题</title>   
                <keywords>作文，高考</keywords> 
                <kind>doc</kind> 
                <describe>07各地高考作文题</describe> 
                <date>2007-12-1 8:50:43</date>   
                <url>http://192.168.0.122:8080/Query/source/07各地高考作文题.doc< /url>   
                <author>李明</author>  
                <publisher>山东师大</publisher>   
        </resourceitem>　
<resourceitem>
…
</resourceitem>
   </allresource>

##四．常见问题分析
自大赛开始以来，收到很多同学提出的问题，现将常见问题总结如下：
1．XML文件（资源描述文件）是否由自己创建？是否需要根据资源的变化修改？
xml文件不需要自己创建。我们知道，每个资源都有其自己的描述信息，这种描述信息是资源检索的依据，而资源的描述信息的提取和保存是一个非常复杂的过程。本题目不要求参赛者自己提取和保存资源的描述信息，资源的描述信息以一个xml文档的形式提供。每个资源服务器上的xml文件保存了这个服务器上所有资源的描述信息，它充当了一个数据库的角色。由于每台资源服务器上的资源是确定的，所以这个xml文档也是确定的，不需要由参赛者创建或修改。
2．视频文件的格式和播放问题？
视频文件包括多种格式：avi，wmv，swf, rm ,asf，只要求调用相应的嵌入式播放器播放即可。
3．xml文档和资源的位置和名字问题？
xml文档放在服务器的根目录上，名字是test.xml。例如在tomcat服务器中，test.xml会放在webapps文件夹下，资源文件会放在webapps文件夹之下的resources子文件夹下。
4．关于测试资源的数目问题？
测试资源的数目一般是3-5个资源服务器，每台服务器上大约有200-500个资源项。
5．Word、ppt的预览问题？预览的比例问题？
Word、ppt的预览是指预览该文档的一部分内容，比例自定。
6．题目有哪些可以拓展的地方？
1）语义检索，语义检索可以作为一个拓展的方面，以返回该资源域内最符合用户需要的资源。
2）分词技术，可以对用户提交的字符串进行分词处理，以检索到合适的资源。
3）网络拓扑，对于一个资源域，我们可以假定有一个注册发布的主服务器，其他资源服务器都是通过这个服务器获得其他资源服务器的信息，通过这个服务器可以构造不同的分布式检索拓扑结构，好的网络拓扑结构可以提高检索的效率。
4）资源服务器动态的加入和退出，资源服务器可能会动态得开启或关闭服务器，一旦服务器关闭，如何在检索时自动去掉这个服务器，当这个服务器开启时，在检索中自动的加入这个服务器。
5）全文检索，通过对资源文件进行预处理（如果建立索引），支持多关键字的全文检索功能。
7．大赛的测试环境
JAVA默认运行环境:
操作系统:windows xp
JDK:jdk1.6
TOMCAT:apache-tomcat-6.0.16
端口:8080
test.xml文件位置: %TOMCAT_HOME%\webapps\test.xml
资源文件位置:%TOMCAT_HOME%\webapps\resources
.NET默认运行环境:
操作系统:windows xp
IIS:IIS 6.0
.FRAMEWORK:.net framework 2.0/1.1
test.xml文件位置:c:\inetpub\wwwroot\test.xml
如需要其他环境或不同的软件版本，请在提交作品时声明，并附带安装软件。
##五．注意事项
结合近两年的参赛情况，将在评审中遇到的问题总结如下，希望引起各参赛队的注意：
1．软件运行太依赖于环境
    在近两年的评审中，我们发现有不少作品的安装过程过于繁琐，有很多作品的运行需要更改大量的配置文件，指定或建立需要的文件，其运行太过于依赖环境。
2．软件是集中式检索方式
以往的参赛队中，存在将test.xml文件传输到一个服务器上，再进行集中式检索的情况，其本质上仍为集中式检索方式，不符合分布式检索的基本要求。
3．抄袭以往参赛队作品
    对于抄袭严重的作品，一经发现，不予评审。
4．组播技术要慎用
以往大赛提交的作品中有不少参赛队都使用了组播技术，但组播技术容易引起网络流量问题，使用环境只能在局域网环境下，如果使用不当，易引起频繁更换主服务器等问题。
5．作品的提交
    作品的提交要严格按大赛组委会的规定进行，特别强调，提交的作品要说明运行环境，要能够运行，否则不予评审。
