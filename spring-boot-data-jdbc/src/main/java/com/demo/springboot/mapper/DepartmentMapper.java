package com.demo.springboot.mapper;

import com.demo.springboot.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author - Jianghj
 * @since - 2019-12-11 15:37
 * 注解方式：使用 Mybatis 操作数据层
 */
@Mapper
public interface DepartmentMapper {

	/**
	 * 通过 @Options 注解，获取插入记录的自增主键，注入到入参 department 实例中。
	 * 通过 keyProperty 指定将主键和入参 department 实例中哪个属性进行绑定
	 */
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into department (dept_name) value(#{deptName})")
	int insertDept(Department department);

	@Delete("delete from department where id=#{id}")
	int deleteDeptById(Long id);

	@Update("update department set dept_name=#{deptName} where id=#{id}")
	int updateDeptById(Department department);

	@Select("select id,dept_name from department where id = #{id}")
	Department selectDeptById(Long id);

}
