/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

/**
 * Interface to be implemented by beans that need to react once all their properties
 * have been set by a {@link BeanFactory}: e.g. to perform custom initialization,
 * or merely to check that all mandatory properties have been set.
 * <p>该接口将由需要满足以下功能的 bean 实现：
 * 在所有属性都通过 {@link BeanFactory} 填充完成后进行一次 afterPropertiesSet 方法的回调。
 * <p>比如：执行自定义的初始化逻辑或者仅仅检查是否所有的属性都已经被赋值。
 *
 * <p>An alternative to implementing {@code InitializingBean} is specifying a custom
 * init method, for example in an XML bean definition. For a list of all bean
 * lifecycle methods, see the {@link BeanFactory BeanFactory javadocs}.
 * <p>另一种替代方案是：直接指定一个自定义的 init 方法，比如在 XML 文件中进行定义。
 * 但是从 {@link AbstractAutowireCapableBeanFactory#invokeInitMethods} 中可以看到，
 * 通过 XML 配置的 init-method 是在 afterPropertiesSet 方法之后执行的，同时基于反射实现，
 * 性能相较要差一些。
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see DisposableBean
 * @see org.springframework.beans.factory.config.BeanDefinition#getPropertyValues()
 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#getInitMethodName()
 */
public interface InitializingBean {

	/**
	 * Invoked by the containing {@code BeanFactory} after it has set all bean properties
	 * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
	 * <p>当包含该接口实现的 {@code BeanFactory} 赋值完所有的属性之后，
	 * 并且满足了 {@link BeanFactoryAware}, {@code ApplicationContextAware} 之后进行调用。
	 * <p>This method allows the bean instance to perform validation of its overall
	 * configuration and final initialization when all bean properties have been set.
	 * <p>该方法能够让 bean 实例在所有属性初始化完成后执行整体配置和最终的初始化。
	 * @throws Exception in the event of misconfiguration (such as failure to set an
	 * essential property) or if initialization fails for any other reason
	 * @see AbstractAutowireCapableBeanFactory#invokeInitMethods
	 */
	void afterPropertiesSet() throws Exception;

}
