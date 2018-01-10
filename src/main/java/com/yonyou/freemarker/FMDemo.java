package com.yonyou.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FMDemo {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		// ftl == freemarker template .html .java .txt .xml properties
		String property = System.getProperty("user.dir");
		String dir = property + "\\src\\main\\resources";
		// 设置模板所在文件夹 目录
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 读取目录中文件
		Template template = conf.getTemplate("freemarker.html");

		Map root = new HashMap();
		root.put("world", "世界你好!");
		// 输出流
		Writer out = new FileWriter(new File(property + "\\target\\hello.html"));
		// 加入数据模型
		template.process(root, out);

		System.out.println("生成完毕");
	}

}
