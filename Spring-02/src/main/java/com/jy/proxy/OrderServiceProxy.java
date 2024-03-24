package com.jy.proxy;

public class OrderServiceProxy implements OrderService {
    private OrderService orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("----log----");
        orderService.showOrder();
    }
}
