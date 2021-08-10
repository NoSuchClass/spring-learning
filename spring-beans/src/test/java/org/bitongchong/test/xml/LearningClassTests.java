package org.bitongchong.test.xml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

/**
 * @author liuyuehe
 * @date 2021/8/7
 */
public class LearningClassTests {
	@Test
	public void initContext() {
		SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		Resource resource = new ClassPathResource("pg/learning-xml.xml", getClass());
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
//		reader.setValidationMode(2);
		System.out.println(reader.loadBeanDefinitions(resource));
		BeanDefinition testObject = registry.getBeanDefinition("tom");
		String beanClassName = testObject.getBeanClassName();
		System.out.println(beanClassName);
	}
}
