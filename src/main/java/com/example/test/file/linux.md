jps -lmv	查看pid
jstat -gcutil [pid] 60000 根据pid打印参数信息
df -h	
Linux中df命令的功能是用来检查Linux服务器的文件系统的磁盘空间占用情况  可以利用该命令来获取硬盘被占用了多少空间 
目前还剩多少空间等
du -sh * 查看当前文件夹下文件大小

Top 查看虚拟机内存 此内存为实际分配内存 与项目占用内存

Linux查询CPU信息
 cat /proc/cpuinfo