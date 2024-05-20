package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),        //atribuímos códigos manualmente para os objetos
	PAID(2),                   //OrderStatus, caso contrário, o java faria isso de 
	SHIPPED(3),                //forma a induzir erros futuros
	DELIVERED(4),
	CANCELLED(5);
	
	private int code;       //com isso, é preciso declarar esse código como atributo 
	
	private OrderStatus(int code) {    //e passá-lo no construtor
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {         //esse método recebe o código do orderStratus e 
		for(OrderStatus value : OrderStatus.values()) {   //retorna o objeto OrderStatus correspondente
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
