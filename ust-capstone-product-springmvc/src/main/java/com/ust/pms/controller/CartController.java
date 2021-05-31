package com.ust.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.pms.model.Cart;
import com.ust.pms.model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;
import com.ust.pms.util.UserUtil;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	ProductService productService;

	@Autowired
	private JavaMailSender mailSender;

	SimpleMailMessage msg = new SimpleMailMessage();

	@RequestMapping("/saveCart/{productId}")
	public String saveCart(@PathVariable("productId") int productId, Model model) {

		model.addAttribute("username", UserUtil.getUserName());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("productList");

		List<Cart> cartList1 = cartService.getCartDetails();

		if (cartList1.size() < 10) {

			if (cartService.isCartExist(productId)) {
				Cart product = cartService.getCart(productId);
				Product pp = productService.getProduct(productId);
				if (pp.getQuantityOnHand() > 0) {

					Cart cart = new Cart();
					cart.setProductId(product.getProductId());
					cart.setProductName(product.getProductName());
					cart.setPrice(product.getPrice());
					int quantity = (product.getQuantityOnHand()) + 1;
					cart.setQuantityOnHand(quantity);

					cartService.updateCart(cart);

					msg.setFrom("shekharbandari@gmail.com");
					msg.setTo("shekarbandari@gmail.com");
					msg.setSubject("One Product hasbeen added to your Cart ");
					msg.setText("Product : " + cart.getProductName() + "Price :" + cart.getPrice()
							+ "  has been added to your Cart");
					mailSender.send(msg);

					Product p = new Product();
					p.setProductId(pp.getProductId());
					p.setProductName(pp.getProductName());
					p.setPrice(pp.getPrice());
					p.setQuantityOnHand((pp.getQuantityOnHand()) - 1);

					productService.updateProduct(p);
				}

			} else {
				Product product = productService.getProduct(productId);
				Cart cart = new Cart();
				cart.setProductId(product.getProductId());
				cart.setProductName(product.getProductName());
				cart.setPrice(product.getPrice());
				// int q=1;
				cart.setQuantityOnHand(1);

				cartService.saveCart(cart);

				msg.setFrom("shekharbandari@gmail.com");
				msg.setTo("shekarbandari@gmail.com");
				msg.setSubject("One Product hasbeen added to your Cart ");
				msg.setText("Product : " + cart.getProductName() + "Price :" + cart.getPrice()
						+ "  has been added to your Cart");
				mailSender.send(msg);
				Product p = new Product();
				p.setProductId(product.getProductId());
				p.setProductName(product.getProductName());
				p.setPrice(product.getPrice());
				int q = (product.getQuantityOnHand()) - 1;
				p.setQuantityOnHand(q);

				productService.updateProduct(p);

			}
		}
		return "redirect:/productList";
	}

	@RequestMapping("/cartList")
	public ModelAndView checkProductList(Model model, Product products) {

		model.addAttribute("username", UserUtil.getUserName());
		model.addAttribute("command", products);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart");

		List<Cart> cartList = cartService.getCartDetails();
		mav.addObject("cartList", cartList);

		return mav;

	}

	@RequestMapping("/deleteCart/{productId}")
	public String deleteCart(@PathVariable("productId") int productId, Model model) {

		Cart cart = cartService.getCart(productId);

		Product p = productService.getProduct(productId);
	
		
		Product product = new Product();
		product.setProductId(p.getProductId());
		product.setProductName(p.getProductName());
		product.setQuantityOnHand((p.getQuantityOnHand()) + cart.getQuantityOnHand());
		product.setPrice(p.getPrice());
		productService.updateProduct(product);

		cartService.deleteCart(cart);

		return "redirect:/cartList";
	}

}
