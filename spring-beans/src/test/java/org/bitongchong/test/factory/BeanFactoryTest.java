package org.bitongchong.test.factory;

import org.bitongchong.test.xml.TestObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author liuyuehe
 * @date 2021/8/11
 */
public class BeanFactoryTest {
	@Test
	public void testGetBean() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		Resource resource = new ClassPathResource("learning-xml.xml", getClass());
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		TestObject bean = factory.getBean(TestObject.class);
		System.out.println(bean);
	}
}
