
################################### 1、fastDFS 分布式文件系统的配置说明    start  ##############################################
#tracker服务器的IP+端口号，默认22122
tracker_server = 192.168.200.1:22122

#连接超时时间
connect_timeout = 60

#网络超时时间
network_timeout = 60

#字符集编码
charset = UTF-8

#客户端请求的默认80端口
http.tracker_http_port = 8888
http.anti_steal_token = no
#http.secret_key = 123456
################################### 1、fastDFS 分布式文件系统的配置说明    end  ##############################################
