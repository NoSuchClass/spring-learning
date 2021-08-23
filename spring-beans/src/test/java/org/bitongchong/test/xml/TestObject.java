package org.bitongchong.test.xml;

/**
 * @author liuyuehe
 * @date 2021/8/7
 */
public class TestObject {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestObject{" +
				"name='" + name + '\'' +
				'}';
	}
}
