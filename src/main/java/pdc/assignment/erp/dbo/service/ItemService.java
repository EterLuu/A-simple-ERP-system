package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.ItemsEntity;

import java.util.List;

public interface ItemService {

    public ItemsEntity selectItem(int iid);

    public ItemsEntity selectItem(String name);

    public List<ItemsEntity> selectItems();

    public List<ItemsEntity> selectItems(String name);

    public boolean updateItem(ItemsEntity item);

    public boolean insertItem(ItemsEntity item);

    public boolean deleteItem(ItemsEntity item);
}
