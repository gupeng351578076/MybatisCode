package cn.alexander.entity;

import java.io.Serializable;

public class Dept implements Serializable {
    private Integer deptno;
    private String deptname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String deptname) {
        this.deptno = deptno;
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
