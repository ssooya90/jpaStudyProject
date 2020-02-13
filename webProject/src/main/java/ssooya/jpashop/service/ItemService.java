package ssooya.jpashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssooya.jpashop.domain.item.Item;
import ssooya.jpashop.repository.ItemRepository;

import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-14
 * Github : http://github.com/ssooya90
 */

@Service
@Transactional
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public void saveItem(Item item){
		itemRepository.save(item);
	}

	public List<Item> findItem(){
		return itemRepository.findAll();
	}

	public Item findOne(Long itemId){
		return itemRepository.findOne(itemId);
	}

}
