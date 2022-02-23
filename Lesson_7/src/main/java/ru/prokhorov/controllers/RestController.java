package ru.prokhorov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.prokhorov.services.ProductServices;

@Controller
@RequestMapping("/products")
public class RestController {
    private ProductServices productServices;
}
