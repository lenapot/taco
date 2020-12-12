package tacos.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tacos.Order;
import tacos.OrderVo;
import tacos.service.OrderService;

import javax.xml.ws.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/orders/{page}", "/orders"})
    public String showAllByPage(@PathVariable(name = "page", required = false) Optional<Integer> page,
                                Model model) {
        int pageNum = page.orElse(1);
        Page<OrderVo> orderPage = orderService.getAllOrders(pageNum);
        int totalPages = orderPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("orders", orderPage.getContent());
        model.addAttribute("statuses", Order.Status.values());

        return "admin/orders";
    }

    @PostMapping(value = {"/orders/update"})
    public String updateOrder(Order order, Model model) {
        try {
            orderService.updateOrderStatus(order);
            return "redirect:/admin/orders";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            log.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
            return "contact-edit";
        }
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Order findOne(@RequestParam(name = "id") long id) {
        Order order = orderService.getOrder(id);
        return order;
    }

}