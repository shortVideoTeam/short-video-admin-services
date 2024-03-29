## 平台简介

基于 huomai-Vue 集成 Mybatis-Plus Lombok Hutool 等便捷开发工具 适配重写相关业务 便于开发 定期与 huomai-Vue 同步
* 前端开发框架 Vue、Element UI
* 后端开发框架 Spring Boot、Redis
* 容器框架 Undertow 基于 Netty 的高性能容器
* 权限认证框架 Spring Security、Jwt，支持多终端认证系统
* 关系数据库 MySQL 适配 8.X 
* 缓存数据库 Redis 适配 6.X
* 数据库开发框架 Mybatis-Plus 快速 CRUD 增加开发效率 插件化支持各类需求
* 网络框架 Feign、OkHttp3 接口化管理 HTTP 请求
* 工具类框架 Hutool、Lombok 减少代码冗余 增加安全性
* 监控框架 spring-boot-admin 全方位服务监控
* 校验框架 validation 增强接口安全性 严谨性
* 文档框架 knife4j 美化接口文档
* 代码生成器 一键生成前后端代码

## 修改huomai功能

### 依赖改动

* ORM框架 使用 Mybatis-Plus 简化CRUD (不支持主子表)
* Bean简化 使用 Lombok 简化 get set toString 等等
* 容器改动 Tomcat 改为 并发性能更好的 undertow
* 分页移除 pagehelper 改为 Mybatis-Plus 分页
* 升级 swagger 为 knife4j
* 集成 Hutool 5.X 并重写huomai部分功能
* 集成 Feign 接口化管理 Http 请求(如三方请求 支付,短信,推送等)
* 移除 自带服务监控 改为 spring-boot-admin 全方位监控
* 增加 demo 模块示例(给不会增加模块的小伙伴做参考)
* 增加 redisson 支持分布式锁 功能更强大

### 代码改动

* 所有原生功能使用 Mybatis-Plus 与 Lombok 重写
* 增加 IServicePlus 与 BaseMapperPlus 可自定义通用方法
* 代码生成模板 改为适配 Mybatis-Plus 的代码
* 代码生成模板 拆分出 Vo,QueryBo,AddBo,EditBo 等领域对象
* 代码生成模板 增加 文档注解 与 校验注解 简化通用操作
* 项目修改为 maven多环境配置
* 项目配置修改为 application.yml 统一管理
* 数据权限修改为 适配支持单表、多表

### 其他

* 同步升级 huomai-Vue 3.5.0
* 单模块 fast 分支 [huomai-fast](https://gitee.com/JavaLionLi/huomai/tree/fast/)
* Oracle 模块 oracle 分支 [huomai-oracle](https://gitee.com/JavaLionLi/huomai/tree/oracle/)


## 重点注意事项

若依文档对事务注解的描述 [关于事务](https://doc.huomai.vip/huomai/document/htsc.html#%E4%BA%8B%E5%8A%A1%E7%AE%A1%E7%90%86)  以下对多数据源事务做补充:
* 同一个事务下是无法切换数据源的
* 禁止 父方法使用 @Transactional 创建事务 子方法使用 @DataSource 切换数据源
* 正确用法: 子方法单独创建事务 或 父方法使用 @Transactional(propagation = Propagation.REQUIRES_NEW) 为所有子方法创建新事务

关于如何使用Tomcat
* 查看huomai-framework模块的pom.xml文件,根据注释更改依赖
* 查看huomai-admin模块中的application.yml文件,根据注释更改配置

关于如何创建新模块
* 参考huomai-demo模块
* 需要改动: 父pom 与 admin模块pom

关于树表生成
* 直接在mysql表中 添加 parentId orderNum 等字段(根据需要参考 TreeEntity类)
* 代码生成选择树表生成即可

关于数据权限
* 创建表 需预留 dept_id 字段 如需用户权限 还需预留 user_id 字段
* 支持 Mybatis-Plus 方式注入 参考 demo 模块用法(需导入 test.sql 文件)
* 支持 XML 方式注入 参考 system 模块用法

关于vue与boot整合部署  
* [前端静态资源如何整合到后端访问](https://doc.huomai.vip/huomai-vue/other/faq.html#前端静态资源如何整合到后端访问)

关于修改包名
* 将文件夹全部修改为 com.xxx
* 使用IDEA全局替换 com.huomai 替换为 com.xxx
* 严禁手动修改

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 文档地址

文档地址：http://doc.huomai.vip



sh /home/sh/huomai-admin/huomai-admin.sh huomai-admin huomai-admin:1.0.0 dev
