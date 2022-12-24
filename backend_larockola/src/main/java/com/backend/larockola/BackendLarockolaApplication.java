package com.backend.larockola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.backend.larockola.Models.*;
import com.backend.larockola.Dao.*;
import com.backend.larockola.Service.*;
import com.backend.larockola.Service.Implement.*;
import com.backend.larockola.Controller.*;
@SpringBootApplication
public class BackendLarockolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLarockolaApplication.class, args);
	}

}
