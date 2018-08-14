package cn.alexander.test;
import cn.alexander.dao.IDeptDao;
import cn.alexander.dao.IDeptDaoImpl;
import cn.alexander.entity.Dept;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestDept20180814 {
    Logger logger = Logger.getLogger(TestDept20180814.class);
    @Test
    public void findAll(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        List<Dept> list = iDeptDao.findAll();
        logger.debug(list);
    }
    @Test
    public void addDept(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        Dept dept = new Dept();
        dept.setDeptname("后勤部");
        iDeptDao.addDept(dept);
    }
    @Test
    public void updateDept(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        Dept dept = new Dept(3,"总工办");
        iDeptDao.updateDept(dept);
    }
    @Test
    public void deleteDept(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        iDeptDao.deleteDept(5);
    }
    //map集合查询有问题
//    @Test
//    public void findAllByMap(){
//        IDeptDao iDeptDao = new IDeptDaoImpl();
//        Map<String,Object> map = iDeptDao.findAllByMap();
//        logger.debug(map);
//    }

    @Test
    public void findLike(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        List<Dept> list = iDeptDao.findLike("部");
        logger.debug(list);
    }

    @Test
    public void findAllByMap(){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        Map<String, Long> map = iDeptDao.findAllByMap();
        logger.debug(map);
    }


}
