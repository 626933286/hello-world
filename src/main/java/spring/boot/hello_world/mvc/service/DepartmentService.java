package spring.boot.hello_world.mvc.service;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.hello_world.mvc.cache.DepartmentCache;
import spring.boot.hello_world.mvc.domain.Department;

@Service
public class DepartmentService {
    
    @Resource
    DepartmentCache departmentCache;
    
    public Department findByDeptCode(String deptCode) {
        return departmentCache.getDeparByCode(deptCode);
    }

}
