package com.certificatic.practica2.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CalculaMediaBeanLocal {

	double calculaMediaAritmetica(List<Double> datos);
	
}
