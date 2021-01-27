package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="rectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle();
	}

	@Bean(name = "PointA")
	public Point pointAObj() {
		return new Point(0, 0);
	}

	@Bean(name = "PointB")
	public Point pointBObj() {
		return new Point(0, 20);
	}

	@Bean(name = "PointC")
	public Point pointCObj() {
		return new Point(20, 20);
	}

	@Bean(name = "PointD")
	public Point pointDObj() {
		return new Point(0, 20);
	}

}
