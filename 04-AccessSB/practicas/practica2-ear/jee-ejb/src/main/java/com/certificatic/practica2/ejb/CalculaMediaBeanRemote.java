package com.certificatic.practica2.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CalculaMediaBeanRemote {

	double calculaMediaAritmetica(List<Double> datos);

	
}
