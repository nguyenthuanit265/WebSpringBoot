package com.myclass.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Category;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	
//	@Autowired
//	CategoryService categoryService;
	

	@GetMapping("")
	public String index(Model model) {
		//List<Category> categories = categoryService.findAll();
		//model.addAttribute("categories", categories);
		return "category/index";
	}
	
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return "category/add";
	}
	
	
	@PostMapping("add")
	public String add(Model model, 
			@Valid @ModelAttribute("category") Category category, 
			BindingResult errors) {
		// Kiểm tra nhập liệu
		if(errors.hasErrors()) {
			return "category/add";
		}
		
		// Thêm mới Category và danh sách
		//categoryService.add(category);
		
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
	
	
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		// Gọi hàm findById lấy ra Category trùng id với id lấy từ url
		//Category category = categoryService.findById(id);
		//model.addAttribute("category", category);
		
		return "category/edit";
	}
	
	
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("category") Category category, 
			BindingResult errors) {
		// Bắt lỗi nhập liệu
		if(errors.hasErrors()) {
			return "category/edit";
		}
		
		// Cập nhật Category 
		//categoryService.update(category);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
	
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		// Xóa Category theo id
		//categoryService.removeById(id);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
}