package com.example.springmvc;

import com.example.springmvc.dao.UserDAO;
import com.example.springmvc.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SpringmvcApplicationTests {
	Calculator calculator = new Calculator();

	@Autowired
	private UserDAO userDAO;

	@Test
	void testAddFunction() {
		// given
		int a = 10;
		int b = 20;
		int expectedResult = 30;

		//when
		int c = calculator.add(a, b);
		assertThat(c).isEqualTo(expectedResult);

	}

	@Test
	public void testAddUserDAO(){
		//given
		UserDTO user = new UserDTO();
		user.setName("Test UserDao");
		user.setAge(30);
		user.setAddress("Ha Noi");

		// when
		String result = userDAO.createUser(user);
		assertThat(result).isEqualTo("Success");
//		assertThat(result).isEqualTo("Error");

	}

	class Calculator {
		public int add(int a, int b) {
			return (a+b);
		}
	}

}
