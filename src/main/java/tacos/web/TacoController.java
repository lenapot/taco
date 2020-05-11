package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.Taco;
import tacos.User;
import tacos.service.OrderService;
import tacos.service.TacoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
@RequestMapping("/tacos")
public class TacoController {

    @Autowired
    private TacoService tacoService;

    public TacoController() {
    }

    @GetMapping(value = {"/{page}", ""})
    public String getTacosForUser(@PathVariable(name = "page", required = false) Optional<Integer> page,
                                  @AuthenticationPrincipal User user,
                                  Model model) {

        int pageNum = page.isPresent() ? page.get() : 1;
        Page<Taco> tacoPage = tacoService.getTacosByUser(user, pageNum);
        model.addAttribute("userTacos", tacoPage.getContent());
        List<Integer> pageNumbers = IntStream.rangeClosed(1, tacoPage.getTotalPages())
                .boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        return "tacos";
    }

}
