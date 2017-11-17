package spring.boot.hello_world.mvc.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysRole implements Serializable{
    
    private static final long serialVersionUID = 2179977087270889525L;
	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
