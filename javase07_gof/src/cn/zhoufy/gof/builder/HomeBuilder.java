package cn.zhoufy.gof.builder;

public interface HomeBuilder {//使用接口，主要设计！
	House buildeHouse();
	Car builderCar();
	Money builderMoney();

}
