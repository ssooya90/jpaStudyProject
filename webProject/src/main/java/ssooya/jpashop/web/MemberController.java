package ssooya.jpashop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ssooya.jpashop.domain.Address;
import ssooya.jpashop.domain.Member;
import ssooya.jpashop.service.ItemService;
import ssooya.jpashop.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/members/new", method = RequestMethod.GET)
	public String createForm() {
		return "members/createMemberForm";
	}

	@RequestMapping(value = "/members/new", method = RequestMethod.POST)
	public String create(Member member, String city, String street, String zipcode) {

		Address address = new Address(city, street, zipcode);
		member.setAddress(address);
		memberService.join(member);
		return "redirect:/";
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String list(Model model) {

		List<Member> members = memberService.findMember();
		model.addAttribute("members", members);
		return "members/memberList";
	}

}