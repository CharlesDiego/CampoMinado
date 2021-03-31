package testador;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import modelo.Campo;

public class teste {
   
	public Campo campo = new Campo (3,3);
	
   // Apos inumeros teste so conseguir instanciar campo colocando todos metodos Publico,
	// diferente do professor que deixou default. 

 @Test 
 void testeAbrirminadoMarcado() {
	 campo.alternarMarcacao();
	 campo.minar();
	 assertFalse(campo.abrir());
 }
 }