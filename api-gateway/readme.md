API Gateway Zuul
====

API 网关，对外暴露服务，我们需要一个负载均衡器，就是本项目Zuul了。

Zuul可以读取eureka里的客户端列表，通过ribbon来负载转发到不同的实例。

demo:  http://localhost:8070/provider-demo/api/v1/users/ 

就可以访问到provider-demo的服务的实例的一个，多试几次，查看admin的trace可以发现几个实例
都有请求，即实现了负载均衡。
