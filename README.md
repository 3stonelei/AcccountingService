# AcccountingService

## Springboot 开发四大步
- 添加相应依赖
- 添加相应注解
- 编写代码
- 添加相应配置


## 步骤
### 1. 创建Maven项目

- < modelVersion > :POM model版本 (总是4.0.0).
- < groupId >:项目所属组或组织。通常表示为倒置的域名
- < artifactId >:提供给项目的库项目的名称 (例如, 其 jar 或 war 文件的名称)
- < version >:正在生成项目的版本
- < packaging >:应如何打包项目。默认为 jar ，代表项目文件打包成jar包。使用 "war" 代表打包成war 包
### 2. 创建相应目录结构

- config：配置相关
- controller：控制层，前端交互
- converter：写转换器如model三层数据模型之间的转换
- dao :持久化层：于数据库交互
    - mapper:mapper映射接口包，编写数据库交互方法
- exception ：异常处理的相关操作
- external ：调用别的服务，外部的
- manager : 业务层
- model :三层数据模型
    - common ：对应manager层    
    - persistence：对应持久化，与数据库表一一对应
    - service：对应Controller层使用