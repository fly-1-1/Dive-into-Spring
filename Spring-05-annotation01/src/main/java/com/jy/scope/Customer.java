package com.jy.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope("singleton")
public class Customer {
}
