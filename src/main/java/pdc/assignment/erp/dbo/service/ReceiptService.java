package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.ReceiptsEntity;

import java.util.List;

public interface ReceiptService {

    public ReceiptsEntity selectRidReceipt(int rid);

    public ReceiptsEntity selectCidReceipt(int cid);

    public List<ReceiptsEntity> selectReceipts();

    public List<ReceiptsEntity> selectRidReceipts(int rid);

    public List<ReceiptsEntity> selectCidReceipts(int cid);

    public boolean updateReceipt(ReceiptsEntity receipt);

    public int insertReceipt(ReceiptsEntity receipt);

    public boolean deleteReceipt(ReceiptsEntity receipt);
}
