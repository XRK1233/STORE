package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Items;

public interface ItemsService {
	//��ȡ���е���Ʒ��Ϣ
	List<Items> getAllItems();
	//����id��ѯĳ����Ʒ������
	Items getItemsById(int id);
}
