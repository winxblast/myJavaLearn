package com.imooc.collection;

/**
 * 课程类
 * @author WXB
 *
 */
public class Course {
	
	public String id;
	
	public String name;
	
	public Course (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Course () {
		//该父类因为有含参构造器，故不会自动生成隐式无参构造器
		//这样子类ChildCourse在还没写含参构造器时就会报错
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
