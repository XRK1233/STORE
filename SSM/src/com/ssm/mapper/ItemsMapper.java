package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.Items;

public interface ItemsMapper {
	//��ȡ���е���Ʒ��Ϣ
	List<Items> getAllItems();
	//����id��ѯĳ����Ʒ������
	Items getItemsById(int id);
}
