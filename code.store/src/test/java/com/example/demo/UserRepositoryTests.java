package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateTestUser() {
		User user =new User();
		user.setMail("neel@sap.com");
		user.setName("Neel patel");
		user.setNumber("9239312234");
		user.setPassword("neel@123");
		
		User saveUser= repo.save(user);
		
		User existUser = entityManager.find(User.class, saveUser.getId());
		
		assertThat(existUser.getMail()).isEqualTo(user.getMail());
				
		
		
	}
	
	@Test
	public void testFindUserByMail() {
		String mail="asdasdj@dsf.coam";
		User user= repo.findByMail(mail);
		
		assertThat(user).isNotNull();
	}
}
