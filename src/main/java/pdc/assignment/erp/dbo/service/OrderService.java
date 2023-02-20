package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.OrdersEntity;

import java.util.List;

public interface OrderService {

    public OrdersEntity selectOidOrder(int oid);

    public OrdersEntity selectCidOrder(int cid);

    public OrdersEntity selectUidOrder(int uid);

    public List<OrdersEntity> selectOrders();

    public List<OrdersEntity> selectOidOrders(int oid);

    public List<OrdersEntity> selectCidOrders(int cid);

    public List<OrdersEntity> selectUidOrders(int uid);

    public boolean updateOrder(OrdersEntity order);

    public int insertOrder(OrdersEntity order);

    public boolean deleteOrder(OrdersEntity order);
}
