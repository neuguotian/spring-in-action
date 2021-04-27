package com.example.springinaction.controller;

import com.example.springinaction.entity.Ingredient;
import com.example.springinaction.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("A", " Flout Q", Ingredient.Type.WRAP),
                new Ingredient("B", "Flour ZZ", Ingredient.Type.WRAP),
                new Ingredient("C", " Tortilla", Ingredient.Type.WRAP),
                new Ingredient("D", "UU Tortilla", Ingredient.Type.WRAP),
                new Ingredient("E", "JJ Tortilla", Ingredient.Type.WRAP)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design"; // 请求转发到 design.html 视图
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
//        List<Ingredient> res = new ArrayList<>();
//        for(Ingredient ingredient : ingredients) {
//            if (ingredient.getType() == type) {
//                res.add(ingredient);
//            }
//        }
//        return res;
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());

    }
}
