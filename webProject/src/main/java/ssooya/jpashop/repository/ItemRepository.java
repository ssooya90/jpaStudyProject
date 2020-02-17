package ssooya.jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssooya.jpashop.domain.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-14
 * Github : http://github.com/ssooya90
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

//	@PersistenceContext
//	EntityManager em;
//
//	public void save(Item item){
//		if( item.getId() == null){
//			em.persist(item);
//		}else{
//			em.merge(item);
//		}
//	}
//
//	public Item findOne(Long id){
//		return em.find(Item.class, id);
//	}
//
//	public List<Item> findAll(){
//		return em.createQuery("select i from Item i", Item.class).getResultList();
//	}

}
