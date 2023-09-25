	package com.example.demo.controller;

	import java.time.LocalDateTime;
	import java.util.List;
	import java.util.Optional;

	import com.example.demo.entity.Belt;
	import com.example.demo.service.Belt_Service;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Pageable;
	import org.springframework.security.access.annotation.Secured;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.annotation.AuthenticationPrincipal;
	import org.springframework.security.core.parameters.P;
	import org.springframework.security.oauth2.core.user.OAuth2User;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.*;

	import com.example.demo.auth.PrincipalDetails;
	import com.example.demo.dto.Test;
	import com.example.demo.entity.User_Entity;
	import com.example.demo.repository.PromissionUseRepository;
	import com.example.demo.repository.UserRepository;
	import com.example.demo.security.SecurityConfig;

	import lombok.RequiredArgsConstructor;

	@Controller
	@RequestMapping("/")
	@RequiredArgsConstructor
	public class Link_Controller {

		private final Belt_Service service;

		private final UserRepository user_repository;

		private final PromissionUseRepository PromissionUseRepository;

		@GetMapping("")
		public String root(Model model){
	//		List<Belt> entity = service.Category_item_All("belt");

	//		model.addAttribute("list", entity);

			return "main";
		}

		@GetMapping("/main")
		public String main(){

			return "main";
		}

		// oauth 로그인을 해도 principaldetails 타입으로 받을 수 있고
		// 기본 로그인을 해도 principaldatails 타입으로 받을 수 있다.
		@GetMapping("/user")
		public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails){

			return principalDetails.getUser().toString();
		}


		@PostMapping("/create")
		public String create_add(Test test){

			User_Entity user = user_repository.findByEmailAndProvider("zks8684@naver.com2", "naver");

			user.setEmail(test.get게시판제목());

			user_repository.save(user);

			return "create";
		}

		@GetMapping("/create")
		public String create(){

			return "create";
		}

		@GetMapping("/admin")
		public String admin(){

			return "admin";
		}

		@GetMapping("/manager")
		public String manager(){

			return "manager";
		}


		@GetMapping("/joinForm")
		public String joinForm(){

			return "joinForm";
		}


		@GetMapping("/loginForm")
		public String loginForm(){

			return "loginForm";
		}


		@GetMapping("/test/login")
		public @ResponseBody String testlogin(Authentication authentication, @AuthenticationPrincipal PrincipalDetails userDetails){

			try {
				PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();

				System.out.println(principalDetails.getUser());


			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return "세선졍보확인하기";
		}
		@GetMapping("shipping")
		public String shippingA(){
			return "/shipping";
		}


		@GetMapping("/test/oauth2/{id}")
		public @ResponseBody String aouth2(Authentication authentication,@AuthenticationPrincipal OAuth2User user){

			try {
				OAuth2User principalDetails = (OAuth2User) authentication.getPrincipal();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return "세선졍보확인하기";
		}
		/*
			@GetMapping("/index")
			public String index(Model model){
				List<Category_Entity> entity = service.Category_Find_All();

				model.addAttribute("list", entity);

				return "index";
			}
		*/

		@PostMapping("/join")
		public String join(User_Entity user){

			User_Entity user_join = user_repository.findByEmailAndProvider(user.getEmail(),"client");

			if(user_join == null) {
				user.setProvider("client");
				user.setRole("USER");
				user.setPassword(SecurityConfig.incoding_password().encode(user.getPassword()));
				user.setDatetime(LocalDateTime.now());
				user_repository.save(user);

				return "redirect:/loginForm";
			}
			else {
				return "redirect:/loginForm";
			}
		}

		@Secured("ADMIN") //파라미터로 어드민을 때리면 무조껀 가능<객체확인을 굳이 할 필요가 없다.
		@GetMapping("/info")
		public String info() {

			return "info";
		}
		//벨트 제품 리스트로 맵핑belt
		@GetMapping(value = "/product/{id}")
		public String belt(Model model, @PathVariable("id") String id){
			List<Belt> entity = service.Category_item_All(id);
			model.addAttribute("list" ,entity);
			return "product";
		}


		@GetMapping(value = "/beltdetail/{itemcount}")
		public String beltdetail(Belt belt, Model model){
			System.out.println(belt.getItemcount());
			Optional<Belt> belt1 = service.SelectONE(belt.getItemcount());
			model.addAttribute("List", belt1.get());
			//주입하면 명칭을 알수가 없다.

			return "/beltdetail";
		}

	//	상품 html로 넣어놓기 폼
		@GetMapping("/addproduct")
		public String addproduct(){
			return "/addproduct";
		}


		//반품 주의 사항
		@GetMapping("/recalls")
		public String recall(){
			return "/recalls";
		}
		//카트
		@GetMapping("/cart")
		public String cart(){

			return "/cart";
		}

		@GetMapping("/cartagain")
		public String cartA(){
			return "/cartagain";
		}

	}
