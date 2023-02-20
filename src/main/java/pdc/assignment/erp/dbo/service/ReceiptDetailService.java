package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;

import java.util.List;

public interface ReceiptDetailService {

    public ReceiptDetailsEntity selectDidReceiptDetail(int rdid);

    public ReceiptDetailsEntity selectRidReceiptDetail(int rid);

    public List<ReceiptDetailsEntity> selectDidReceiptDetails(int rdid);

    public List<ReceiptDetailsEntity> selectRidReceiptDetails(int rid);

    public boolean updateReceiptDetail(ReceiptDetailsEntity receiptDetails);

    public boolean insertReceiptDetail(ReceiptDetailsEntity receiptDetails);

    public boolean deleteReceiptDetail(ReceiptDetailsEntity receiptDetails);
}
