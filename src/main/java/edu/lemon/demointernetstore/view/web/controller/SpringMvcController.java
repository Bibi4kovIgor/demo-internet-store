package edu.lemon.demointernetstore.view.web.controller;

import edu.lemon.demointernetstore.controller.service.impl.ProductService;
import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;


@Controller("SpringMvcController")
@RequestMapping("/internet-store")
public class SpringMvcController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public String greetings(){
    return "/index";
  }

  @GetMapping({"/get-products-by-qty/{qty}", "/get-products-by-qty"})
  public ModelAndView getProductsByQty(
      @PathVariable(name = "qty", required = false) Integer qty){
    qty = Objects.isNull(qty) ? 0 : qty;
    List<ProductDto> productsList = productService.getByQuantity(qty);
    ModelMap products = new ModelMap().addAttribute("products", productsList);
    return new ModelAndView("/products", products);

  }

}
