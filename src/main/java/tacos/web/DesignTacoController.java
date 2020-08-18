package tacos.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Order;
import tacos.Taco;
import tacos.service.IngredientService;
import tacos.service.TacoService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @Autowired
    TacoService tacoService;

    @Autowired
    IngredientService ingredientService;


    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.addAll(ingredientService.findAll());

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design,
                                Errors errors,
                                @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);
        Taco saved = tacoService.saveTaco(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    @PostMapping(value = {"/add/{tacoId}"})
    public String addDesign(@PathVariable(name = "tacoId") Optional<Long> tacoId,
                            @RequestParam(name = "tacoCount") Optional<Integer> tacoCount,
                                @ModelAttribute Order order) {
        long id = tacoId.orElseGet(() -> tacoId.orElseThrow(RuntimeException::new));
        int tacoCountVal = tacoCount.orElseGet(() -> tacoCount.orElseThrow(RuntimeException::new));

        log.info("Adding existing taco with id : " + id);
        Taco existing = tacoService.getTaco(id);
        order.addDesign(existing, tacoCountVal);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
