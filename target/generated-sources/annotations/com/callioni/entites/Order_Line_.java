package com.callioni.entites;

import com.callioni.entites.Car;
import com.callioni.entites.EOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-26T17:24:52")
@StaticMetamodel(Order_Line.class)
public class Order_Line_ { 

    public static volatile SingularAttribute<Order_Line, Integer> quantity;
    public static volatile SingularAttribute<Order_Line, EOrder> eorder;
    public static volatile SingularAttribute<Order_Line, Car> car;
    public static volatile SingularAttribute<Order_Line, Double> price;
    public static volatile SingularAttribute<Order_Line, Long> id;

}