package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;

import java.util.List;

public interface OrderDetailService {

    public OrderDetailsEntity selectOidOrderDetail(int oid);

    public OrderDetailsEntity selectDidOrderDetail(int did);

    public List<OrderDetailsEntity> selectOidOrderDetails(int oid);

    public List<OrderDetailsEntity> selectDidOrderDetails(int did);

    public boolean updateOrderDetail(OrderDetailsEntity orderDetail);

    public boolean insertOrderDetail(OrderDetailsEntity orderDetail);

    public boolean deleteOrderDetail(OrderDetailsEntity orderDetail);
}
