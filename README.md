# freemarker
freemarker是一个java模板引擎,基于模板生成文本输出的工具.
为便于各种数据格式使用,定义了各种标签,便于字符,序列,hash操作;同时还可以自定义标签,
便于数据类型扩展;
官方文档:https://freemarker.apache.org/docs/dgui_datamodel.html

缺点:
值必须初始化,否则报错;
key必须是String类型;


### thymeleaf优点：
静态html嵌入标签属性，浏览器可以直接打开模板文件，便于前后端联调。
springboot官方推荐方案。

### thymeleaf缺点：
模板必须符合xml规范，就这一点就可以判死刑！太不方便了！
js脚本必须加入/*<![CDATA[*/标识，否则一个&符号就会导致后台模板合成抛异常，而且错误信息巨不友好，害得我调试了好几个小时才明白是怎么回事。js里面还好办，这样是在html里面含有&等符号，还需要转义


使用:

	maven配置:
	<dependency>
		<groupId>freemarker</groupId>
		<artifactId>freemarker</artifactId>
		<version>2.3.9</version>
	</dependency>
	
	定义ftl模板
	
	定义绑定对象
	
	合并模板和对象
		Configuration conf = new Configuration();
		// ftl == freemarker template .html .java .txt .xml properties
		String property = System.getProperty("user.dir");
		String dir = property + "\\ftl\\";
		// 设置模板所在文件夹 目录
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 读取目录中文件
		Template template = conf.getTemplate("freemarker.html");

		Map root = new HashMap();
		root.put("world", "世界你好!");
		// 输出流
		Writer out = new FileWriter(new File(dir + "hello.html"));
		// 加入数据模型
		template.process(root, out);
	
	