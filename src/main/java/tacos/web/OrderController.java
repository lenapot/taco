package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.User;
import tacos.service.OrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController() {
    }

    @GetMapping("current")
    public String orderForm(Model model){
        return  "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        order.setName(user.getFullname());
        order.setStatus(Order.Status.PROCCESSING);

        orderService.saveOrder(order);

        sessionStatus.setComplete();
        //log.info("Order submitted: " + order);

        return "thankyou";
    }

    @GetMapping(value = {"/{page}", ""})
    public String showOrdersForUser(@PathVariable(name = "page", required = false) Optional<Integer> page,
                                @AuthenticationPrincipal User user,
                                Model model) {
        int pageNum = page.isPresent() ? page.get() : 1;
        Page<Order> orderPage = orderService.getOrdersByUser(user, pageNum);

        int totalPages = orderPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("orders", orderPage.getContent());
        model.addAttribute("statuses", Order.Status.values());

        return "/orders";
    }

}
