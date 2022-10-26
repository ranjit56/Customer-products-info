package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.entity.Product;
import com.user.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value ={ "/", "/welcome" })
	public String home(Model model) {
		List<Product> listProduct = productService.getAllProducts();
		model.addAttribute("listProduct", listProduct);
		return "welcome";
	}

	@GetMapping(value ="/showNewProductForm")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "create_product";
	}

	@PostMapping(value ="/saveproduct")
	public String saveproducts(@ModelAttribute("product") Product product) {
		productService.createProduct(product);
		return "redirect:/";
	}

	@GetMapping(value ="/edit")
	public String editProductForm(@RequestParam long id,Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);

		return "modify_product";
	}

	@GetMapping(value ="/delete")
	public String deleteProductForm(@RequestParam long id) {
		productService.deleteProductById(id);
		return "redirect:/";
	}

	@GetMapping(value ="/search")
	public String search(@RequestParam String keyword,Model model) {
		List<Product> result = productService.search(keyword);
		model.addAttribute("result", result);

		return "search";
	}

}
