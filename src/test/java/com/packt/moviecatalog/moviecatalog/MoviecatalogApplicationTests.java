package com.packt.moviecatalog.moviecatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.packt.moviecatalog.domain.AppUserRepository;
import com.packt.moviecatalog.domain.DirectorRepository;
import com.packt.moviecatalog.domain.MovieRepository;
import com.packt.moviecatalog.domain.ReviewRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MoviecatalogApplicationTests {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private DirectorRepository directorRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	//smoke tests for repositories

	@Test
	public void appUserRepositoryLoads() throws Exception {

		assertThat(appUserRepository).isNotNull();

	}

	@Test
	public void directorRepositoryLoads() throws Exception {

		assertThat(directorRepository).isNotNull();

	}

	@Test
	public void movieRepositoryLoads() throws Exception {

		assertThat(movieRepository).isNotNull();

	}

	@Test
	public void reviewRepositoryLoads() throws Exception {

		assertThat(reviewRepository).isNotNull();

	}

}
