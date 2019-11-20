# tata
塔塔 AR 社区论坛系统是一个讨论 AR 热点话题和其他新兴技术的论坛交流平台。（注：本仓库存放的是项目的后台代码，前端代码往下拉即可找到链接地址）
# 界面展示：
1. 网站首页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191120215154213.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FiZWxfTGl1amlucXVhbg==,size_16,color_FFFFFF,t_70)
2. 论坛界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191120215337238.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FiZWxfTGl1amlucXVhbg==,size_16,color_FFFFFF,t_70)
3. 登录界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191120221800122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0FiZWxfTGl1amlucXVhbg==,size_16,color_FFFFFF,t_70)
前端代码获取链接：https://github.com/Caijunbin/TATA.git
# 后台
### 一、关于Mybatis使用：
项目已经集成了Mybatis，使用步骤示例：
```
@Mapper
public interface BlockRepository {

	/**
	 * 获取所有栏目分类（名字 + 图标url）
	 * @return
	 */
	@Results({
		@Result(column = "name",property = "name"),
		@Result(column = "imgUrl",property = "imgUrl")
	})
	@Select("select * from bbs_class where enabled = 1")
	List<BlockAndUrl> listBlocks();
}
```
在自定义的Repository前加注解@Mapper，然后使用如下注解进行数据库操作：
@Select  查询
@Update  更新
@Insert  插入
@Delete  删除
### 二、关于Mongodb使用：
项目已经实现了Mongodb的图片和文件存储接口，实现方法在com.hita.tata.common.mongodb.dao下的MongoServiceImp类中，类中还提供了返回图片/文件的访问链接的方法。
