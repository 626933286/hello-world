package spring.boot.hello_world.mvc.cache;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.hello_world.framework.cache.RedisManager;
import spring.boot.hello_world.mvc.domain.DepartRespository;
import spring.boot.hello_world.mvc.domain.Department;

@Service
public class DepartmentCache {
    
    @Resource
    private RedisManager<Department> redisManager;
    
    @Autowired
    private DepartRespository departRepository;
    
    /**
     * <p>TODO(方法详细描述说明、方法参数的具体涵义)</p> 
     * @author 337084
     * @date 2017年11月21日 下午4:01:04
     * @param deptCode
     * @return
     * @see
     */
    public Department getDeparByCode(String deptCode) {
        Department department = redisManager.get(deptCode, Department.class);
        
        if( department == null ) {
            department = departRepository.findByDeptCode(deptCode);
            redisManager.set(deptCode, department, Department.class);
        }
        return department;
    }

}
