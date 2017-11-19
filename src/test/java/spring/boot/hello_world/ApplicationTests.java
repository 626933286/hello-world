package spring.boot.hello_world;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.hello_world.mvc.domain.DepartRespository;
import spring.boot.hello_world.mvc.domain.Department;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(Application1.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private DepartRespository departRepository;;

   /* @Before
    public void before() {
        Department department = new Department();
        department.setDeptCode("OMS");
        department.setDeptName("订单项目组");
        department.setDeptTelephone("18785356452");
        department.setNum(Long.valueOf(20));
        department.setLeader("张三");
        departRepository.save(department);
    }*/

    @Test
    public void test() throws Exception {
        Department u1 = departRepository.findByDeptCode("OMS");
        System.out.println("第一次查询：" + u1.getDeptName());

        Department u2 = departRepository.findByDeptCode("OMS");
        System.out.println("第二次查询：" + u2.getDeptName());
    }

}
