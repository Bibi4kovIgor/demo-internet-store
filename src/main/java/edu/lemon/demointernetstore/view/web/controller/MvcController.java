package edu.lemon.demointernetstore.view.web.controller;

import edu.lemon.demointernetstore.controller.service.CrudService;
import edu.lemon.demointernetstore.view.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class MvcController {

  private final CrudService<ProductDto, Long> service;

  public MvcController(
      @Qualifier("ProductService") CrudService<ProductDto, Long> productsService) {
    this.service = productsService;
  }
  @GetMapping
  public ModelAndView products(){
    ModelMap products = new ModelMap()
        .addAttribute("products", service.getAll())
        .addAttribute("productType", ProductDto.builder().build());
    return new ModelAndView("pages/products", products);
  }
  @GetMapping({"/get-products-by-qty/{qty}", "/get-products-by-qty"})
  public ModelAndView getProductsByQty(
      @PathVariable(name = "qty", required = false) Integer qty){
    qty = Objects.isNull(qty) ? 0 : qty;
    List<ProductDto> productsList = service.getByQuantity(qty);
    ModelMap products = new ModelMap().addAttribute("products", productsList);
    return new ModelAndView("pages/products", products);
  }

  @PostMapping(path = "/add-product", consumes = "application/x-www-form-urlencoded")
  public RedirectView create(ProductDto product) {
    service.create(product);
    return new RedirectView("/");
  }



}
