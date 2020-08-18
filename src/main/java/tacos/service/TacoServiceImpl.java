package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tacos.Order;
import tacos.Taco;
import tacos.User;
import tacos.data.TacoRepository;
import tacos.web.OrderProps;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TacoServiceImpl implements TacoService{

    @Autowired
    private OrderProps props;

    @Autowired
    TacoRepository tacoRepository;

    @Autowired
    OrderService orderService;

    @Override
    public Taco saveTaco(Taco taco) {
        return tacoRepository.save(taco);
    }

    @Override
    //todo: Optional правильно обработать
    public Taco getTaco(long tacoId) {
        Optional<Taco> optionalTaco = tacoRepository.findById(tacoId);
        return optionalTaco.orElseGet(() -> optionalTaco.orElseThrow(RuntimeException::new));
    }

    @Override
    public Page<Taco> getTacosByUser(User user, int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        List<Order> orderPage = orderService.getOrdersByUser(user);
        List<Taco> userTacos = orderPage.stream()
                .map(Order::getTacos)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > userTacos.size() ? userTacos.size() : (start + pageable.getPageSize());

        Page<Taco> tacoPage = new PageImpl<Taco>(userTacos.subList(start, end), pageable, userTacos.size());

        return tacoPage;
    }
}
