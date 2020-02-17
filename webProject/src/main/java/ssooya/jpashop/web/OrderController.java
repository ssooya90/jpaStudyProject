package ssooya.jpashop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssooya.jpashop.domain.Member;
import ssooya.jpashop.domain.Order;
import ssooya.jpashop.domain.OrderSearch;
import ssooya.jpashop.domain.item.Item;
import ssooya.jpashop.service.ItemService;
import ssooya.jpashop.service.MemberService;
import ssooya.jpashop.service.OrderService;

import java.util.List;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	MemberService memberService;
	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String createForm(Model model) {

		List<Member> members = memberService.findMember();
		List<Item> items = itemService.findItem();

		model.addAttribute("members", members);
		model.addAttribute("items", items);

		return "order/orderForm";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {

		orderService.order(memberId, itemId, count);
		return "redirect:/orders";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

		List<Order> orders = orderService.findOrders(orderSearch);
		model.addAttribute("orders", orders);

		return "order/orderList";
	}

	@RequestMapping(value = "/orders/{orderId}/cancel")
	public String processCancelBuy(@PathVariable("orderId") Long orderId) {

		orderService.cancelOrder(orderId);

		return "redirect:/orders";
	}
}