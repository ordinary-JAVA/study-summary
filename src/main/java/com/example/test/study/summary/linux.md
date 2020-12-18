jps -lmv	查看pid
jstat -gcutil [pid] 60000 根据pid打印参数信息
df -h	
Linux中df命令的功能是用来检查Linux服务器的文件系统的磁盘空间占用情况  可以利用该命令来获取硬盘被占用了多少空间 
目前还剩多少空间等
du -sh * 查看当前文件夹下文件大小

Top 查看虚拟机内存 此内存为实际分配内存 与项目占用内存

Linux查询CPU信息
 cat /proc/cpuinfo
 
 ps -ef |grep '服务名' 查询进程号
 
 netstat -plnt |grep ‘进程号’
 
 	p显示建立链接的程序名
 	l 仅列出正在监听的服务状态
 	n转换为数字
 	t tcp相关
 
 lsof -i:端口号
 
 du -sh ./* 查看当前文件夹下所有文件文件大小
 cat /dev/null > file.name 清空当前文件
 根据进程号查询 查询程序位置
 cd /proc/进程号  查看cwd 的引用 
 
 
 
 K8s
 springcloud ->docker>k8s
 
 当springcloud将业务细粒度划分时 出现了大量服务需要部署 
 docker 镜像仓库 将服务打成镜像后 部署启动 但不易于编排 管理 调度
 k8s 可以实现容器集群的自动化部署 自动扩容维护等
 k8s集群包含两种节点，一个是master节点 包括 api server、scheduler、 controller manager
api server整个系统的对外接口 供其他组件及客户端调用
scheduler 调度集群内部资源
controller manager 负责控制管理
etcd 存储

用户执行kubectl 像 apiserver发起一个命令 认证通过后 由调度系统获得一个node apiserver会请求node相关
的kubelet 然后将pod运行起来 将信息持久化到etcd  然后由controller manager管理pod的生命周期 异常重启 扩容
然后通过kube-proxy 将端口暴露在当前node上 以供外服务调用












 
 