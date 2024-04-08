package com.example.product.controller;

import com.example.product.model.Customer;
import com.example.product.model.dto.CustomerDTO;
import com.example.product.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    IPhoneService phoneService;

    @GetMapping("/")
    public String showHome(Model model, @RequestParam(defaultValue = "",required = false) String valueSearch,
                           @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Customer> customerList = customerService.findCustomerByNameContaining(valueSearch,pageable);
        model.addAttribute("customerList",customerList);
        model.addAttribute("valueSearch",valueSearch);
        return "home";
    }
    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("phoneList", phoneService.findAll());
        model.addAttribute("customer", new CustomerDTO());
        return "create";
    }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("phoneList", phoneService.findAll());
            return "create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.add(customer);
        redirectAttributes.addFlashAttribute("msg", "Thành Công");
        return "redirect:/";
    }
    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model) {
        model.addAttribute("phoneList",phoneService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "update";
    }
    @PostMapping("update/{id}")
    public String update(@Valid @ModelAttribute("customer") CustomerDTO customerDTO,BindingResult bindingResult,@PathVariable int id,
                      Model model,
                      RedirectAttributes redirectAttributes) {
        customerDTO.setId(id);
         if(bindingResult.hasErrors()) {
             model.addAttribute("customer",customerDTO);
             model.addAttribute("phoneList", phoneService.findAll());
            return "create";
         }
         Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        customerService.update(customer);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật thành Công");
        return "redirect:/";
    }
    @PostMapping("delete")
    public String delete(@RequestParam("deleteId") int id,RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/";
    }

}
