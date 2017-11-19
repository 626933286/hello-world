package spring.boot.hello_world.mvc.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "department")
public interface DepartRespository extends JpaRepository<Department, Long>{
    
    @Cacheable
    Department findByDeptCode(String deptCode);
    
//    @CachePut(key = "#p0.name")
    Department save(Department department);
    
}
