package spring.boot.hello_world.mvc.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRespository extends JpaRepository<Department, Long>{
    
    Department findByDeptCode(String deptCode);
    
    @SuppressWarnings({"unchecked"})
    Department save(Department department);
    
}
