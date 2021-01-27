package com.au.spring;

import java.util.HashSet;
import java.util.List;

public class Triangle {

private HashSet<Point> points;

	public HashSet<Point> getPoints() {
		return points;
	}

	public void setPoints(HashSet<Point> points) {
		this.points = points;
	}

	public void draw() {
		for (Point point : points) {
			System.out.println("Point X : " + point.getX() + " Point Y : " + point.getY());
		}
	}

}
