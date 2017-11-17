package spring.boot.hello_world.mvc.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department implements Serializable{
    /**
     * TODO（用一句话描述这个变量表示什么）
     */
    private static final long serialVersionUID = 5709668288987014079L;
    @Id
    @GeneratedValue
    private Long id;
    //组织编号
    private String deptCode;
    //组织名称
    private String deptName;
    //组织负责人
    private String leader;
    //联系电话
    private String deptTelephone;
    // 部门员工数
    private Long num;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDeptCode() {
        return deptCode;
    }
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getDeptTelephone() {
        return deptTelephone;
    }
    public void setDeptTelephone(String deptTelephone) {
        this.deptTelephone = deptTelephone;
    }
    public Long getNum() {
        return num;
    }
    public void setNum(Long num) {
        this.num = num;
    }
    
}
