package com.packt.moviecatalog.moviecatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.packt.moviecatalog.web.DirectorController;
import com.packt.moviecatalog.web.MovieController;
import com.packt.moviecatalog.web.ReviewController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MoviecatalogApplicationTests {

	@Autowired
	private DirectorController directorController;

	@Autowired
	private MovieController movieController;

	@Autowired
	private ReviewController reviewController;

	//smoke tests for controllers

	@Test
	public void directorControllerLoads() throws Exception {

		assertThat(directorController).isNotNull();

	}

	@Test
	public void movieControllerLoads() throws Exception {

		assertThat(movieController).isNotNull();

	}

	@Test
	public void reviewControllerLoads() throws Exception {

		assertThat(reviewController).isNotNull();

	}

}
