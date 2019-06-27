# tata
塔塔网站后台

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
