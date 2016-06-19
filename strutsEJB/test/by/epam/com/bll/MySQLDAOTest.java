package by.epam.com.bll;

import org.mockito.InjectMocks;
import org.mockito.Mock;


import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MySQLDAOTest {

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testTest(){
		int b=5;
		int c=5;
		assertThat(b,is(c));
	}
}
