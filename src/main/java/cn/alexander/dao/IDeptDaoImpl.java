package cn.alexander.dao;

import cn.alexander.entity.Dept;
import cn.alexander.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDeptDaoImpl implements IDeptDao {

    @Override
    public List<Dept> findAll() {
        SqlSession session = null;
        List<Dept> depts = null;
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            depts = mapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return depts;
    }

    @Override
    public void addDept(Dept dept) {
        SqlSession session = null;
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            mapper.addDept(dept);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateDept(Dept dept) {
        SqlSession session = null;
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            mapper.updateDept(dept);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteDept(Integer deptno) {
        SqlSession session = null;
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            mapper.deleteDept(deptno);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Dept> findLike(String name) {
        SqlSession session = null;
        List<Dept> list = null;
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            list = mapper.findLike(name);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public Map<String, Long> findAllByMap() {
        SqlSession session = null;
        List<Map<String, Object>> regionMap = null;
        Map<String, Long> resultMap = new HashMap<String, Long>();
        try {
            session = SessionFactoryUtil.getSession();
            IDeptDao mapper = session.getMapper(IDeptDao.class);
            regionMap = (List<Map<String, Object>>) mapper.findAllByMap();
            System.out.println(regionMap);
            for (Map<String, Object> map : regionMap) {
                String region = null;
                Long id = null;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if ("NAME".equals(entry.getKey())) {
                        region = (String) entry.getValue();
                    } else if ("ID".equals(entry.getKey())) {
                        id = ((java.math.BigDecimal) entry.getValue()).longValue();
                    }
                }
                resultMap.put(region, id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return resultMap;
    }

    public static void main(String args[]){
        IDeptDao iDeptDao = new IDeptDaoImpl();
        Map map = iDeptDao.findAllByMap();
        System.out.println(map);
    }

//    //封装map
//    private Map<String, Object> getBaseMap() {
//        Map<String, BigDecimal> baseMap = new HashMap<String, BigDecimal>();
//        List<Map<String, Object>> baseList = eadTrafficBaseMapper.getBaseMap();
//        for (Map<String, Object> map:baseList     //遍历list
//                ) {
//            String base = null;
//            BigDecimal fare = null;
//            for (Map.Entry<String,Object>  entry:map.entrySet()   //遍历map的key集合 获取对应key的value
//                    ) {
//                if ("base".equals(entry.getKey())) {
//                    base =  String.valueOf(entry.getValue());
//                }else if ("traffic_fare".equals(entry.getKey())) {
//                    fare = new BigDecimal(String.valueOf(entry.getValue()));
//                }
//                baseMap.put(base,fare);
//            }
//        }
//        return baseMap;
//    }
}
