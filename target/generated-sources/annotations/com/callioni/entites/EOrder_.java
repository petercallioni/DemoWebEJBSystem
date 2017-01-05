package com.callioni.entites;

import com.callioni.entites.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-26T17:24:52")
@StaticMetamodel(EOrder.class)
public class EOrder_ { 

    public static volatile SingularAttribute<EOrder, Date> dateOfPurchase;
    public static volatile SingularAttribute<EOrder, Long> id;
    public static volatile SingularAttribute<EOrder, Customer> customer;

}