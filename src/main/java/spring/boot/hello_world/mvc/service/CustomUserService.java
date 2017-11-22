package spring.boot.hello_world.mvc.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.boot.hello_world.mvc.domain.SysUser;
import spring.boot.hello_world.mvc.domain.SysUserRepository;

@Service
public class CustomUserService implements UserDetailsService{
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    SysUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		logger.info("开始查询用户信息");
        SysUser user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("s:"+s);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
