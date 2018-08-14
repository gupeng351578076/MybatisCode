package cn.alexander.dao;

import cn.alexander.entity.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptDao {
    //查询所有部门
    public List<Dept> findAll();
    //添加部门
    public void addDept(Dept dept);
    //修改某个部门
    public void updateDept(Dept dept);
    //删除某个部门
    public void deleteDept(Integer deptno);
    //模糊查询
    public List<Dept> findLike(String name);
    //查询所有返回map集合
    public Map<String, Long> findAllByMap();
}
